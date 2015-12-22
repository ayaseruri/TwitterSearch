package ayaseruri.x.twittersearch.activity;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.widget.Toast;

import com.arlib.floatingsearchview.FloatingSearchView;
import com.arlib.floatingsearchview.suggestions.model.SearchSuggestion;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.sharedpreferences.Pref;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import ayaseruri.x.twittersearch.R;
import ayaseruri.x.twittersearch.constant.Constant;
import ayaseruri.x.twittersearch.db.BearerPrefs_;
import ayaseruri.x.twittersearch.network.RetrofitClient;
import ayaseruri.x.twittersearch.objectholder.TokenInfo;
import cn.pedant.SweetAlert.SweetAlertDialog;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {
    private static final String GRANT_TYPE = "client_credentials";
    private static final String TOKEN_TYPE = "bearer";

    @ViewById(R.id.toolbar)
    Toolbar mToolbar;
    @ViewById(R.id.search_view)
    FloatingSearchView mSearchView;

    @Pref
    BearerPrefs_ bearerPrefs_;

    private SweetAlertDialog onGetBearerProgressDialog;

    @AfterViews
    void init(){
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        initBearer();
        mSearchView.setOnQueryChangeListener(new FloatingSearchView.OnQueryChangeListener() {
            @Override
            public void onSearchTextChanged(String oldQuery, final String newQuery) {

                SearchSuggestion searchSuggestion = new SearchSuggestion() {
                    @Override
                    public String getBody() {
                        return null;
                    }

                    @Override
                    public Creator getCreator() {
                        return null;
                    }

                    @Override
                    public int describeContents() {
                        return 0;
                    }

                    @Override
                    public void writeToParcel(Parcel dest, int flags) {

                    }
                }

                //pass them on to the search view
                mSearchView.swapSuggestions(newSuggestions);
            }
        });

        mSearchView.setOnSearchListener(new FloatingSearchView.OnSearchListener() {
            @Override
            public void onSuggestionClicked(SearchSuggestion searchSuggestion) {

            }

            @Override
            public void onSearchAction() {
                mSearchView.sw
            }
        });
    }

    private void search(String key){

    }

    private void initBearer(){
        String encodeApiKey = null;
        String encodeApiSecret = null;
        try {
            encodeApiKey = URLEncoder.encode(Constant.API_KEY, "UTF-8");
            encodeApiSecret = URLEncoder.encode(Constant.API_SECRET, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            Toast.makeText(this, "转码失败", Toast.LENGTH_LONG).show();
        }

        if(null != encodeApiKey && null != encodeApiSecret){
            RetrofitClient.apiService.getTokenInfo("Basic "
                    + Base64.encodeToString((encodeApiKey + ":" + encodeApiSecret).getBytes(), Base64.NO_WRAP)
                    , GRANT_TYPE)
                    .subscribeOn(Schedulers.from(Constant.executor))
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<TokenInfo>() {
                        @Override
                        public void onCompleted() {
                            if(null != onGetBearerProgressDialog){
                                onGetBearerProgressDialog.dismiss();
                                onGetBearerProgressDialog = null;
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            if(null != onGetBearerProgressDialog){
                                onGetBearerProgressDialog.changeAlertType(SweetAlertDialog.ERROR_TYPE);
                                onGetBearerProgressDialog.setTitleText("获取TOKEN失败");
                                onGetBearerProgressDialog.setContentText("");
                                onGetBearerProgressDialog.setCancelText("退出");
                                onGetBearerProgressDialog.setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                    @Override
                                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                                        MainActivity.this.finish();
                                    }
                                });

                                onGetBearerProgressDialog.setConfirmText("重试");
                                onGetBearerProgressDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                    @Override
                                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                                        initBearer();
                                    }
                                });
                            }
                        }

                        @Override
                        public void onNext(TokenInfo tokenInfo) {
                            if(TOKEN_TYPE.equals(tokenInfo.getToken_type())){
                                bearerPrefs_.bearer().put(tokenInfo.getAccess_token());
                            }else {
                                onError(new IllegalArgumentException());
                            }
                        }

                        @Override
                        public void onStart() {
                            if(null == onGetBearerProgressDialog){
                                onGetBearerProgressDialog = new SweetAlertDialog(MainActivity.this);
                            }
                            onGetBearerProgressDialog.changeAlertType(SweetAlertDialog.PROGRESS_TYPE);
                            onGetBearerProgressDialog.setTitleText("首次使用");
                            onGetBearerProgressDialog.setContentText("正在获取API TOKEN…");
                            onGetBearerProgressDialog.showCancelButton(false);
                            onGetBearerProgressDialog.setCancelable(false);
                            if(!onGetBearerProgressDialog.isShowing()){
                                onGetBearerProgressDialog.show();
                            }
                        }
                    });
        }
    }
}
