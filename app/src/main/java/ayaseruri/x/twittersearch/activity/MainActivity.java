package ayaseruri.x.twittersearch.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.arlib.floatingsearchview.FloatingSearchView;
import com.arlib.floatingsearchview.suggestions.model.SearchSuggestion;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.sharedpreferences.Pref;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import ayaseruri.x.twittersearch.R;
import ayaseruri.x.twittersearch.adapter.SearchListAdaptar;
import ayaseruri.x.twittersearch.db.BearerPrefs_;
import ayaseruri.x.twittersearch.db.SearchParamsPrefs_;
import ayaseruri.x.twittersearch.global.Constant;
import ayaseruri.x.twittersearch.network.RetrofitClient;
import ayaseruri.x.twittersearch.objectholder.SearchResultInfo;
import ayaseruri.x.twittersearch.objectholder.TokenInfo;
import ayaseruri.x.twittersearch.view.SearchConditionDialog;
import cn.pedant.SweetAlert.SweetAlertDialog;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "debug";
    private static final String GRANT_TYPE = "client_credentials";
    private static final String TOKEN_TYPE = "bearer";

    @ViewById(R.id.toolbar)
    Toolbar mToolbar;
    @ViewById(R.id.search_view)
    FloatingSearchView mSearchView;
    @ViewById(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;
    @ViewById(R.id.search_recycler)
    RecyclerView searchRecycler;

    @Pref
    BearerPrefs_ bearerPrefs_;
    @Pref
    SearchParamsPrefs_ searchParamsPrefs_;

    private SweetAlertDialog onGetBearerProgressDialog;
    private String bearer;
    private String lang, geocode;

    @AfterViews
    void init(){
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        initBearer();

        swipeRefresh.setColorSchemeColors(getResources().getIntArray(R.array.google_colors));
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                search(mSearchView.getQuery());
            }
        });

        searchRecycler.setLayoutManager(new LinearLayoutManager(this));

        mSearchView.setOnSearchListener(new FloatingSearchView.OnSearchListener() {
            @Override
            public void onSuggestionClicked(SearchSuggestion searchSuggestion) {

            }

            @Override
            public void onSearchAction(String query) {
                String searchKey = mSearchView.getQuery();
                if (!"".equals(searchKey)) {
                    search(searchKey);
                } else {
                    YoYo.with(Techniques.Shake).playOn(mSearchView);
                }
            }
        });

        mSearchView.setOnMenuItemClickListener(new FloatingSearchView.OnMenuItemClickListener() {
            @Override
            public void onActionMenuItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.menu_condition:
                        new SearchConditionDialog(MainActivity.this, new SearchConditionDialog.IOnSCDialogItemClick() {
                            @Override
                            public void onItemClick() {
                                search(mSearchView.getQuery());
                            }
                        }).show();
                        break;
                    default:
                        break;
                }
            }
        });
    }

    private void search(String key){
        if(null == bearer || "".equals(bearer)){
            initBearer();
        }else if(!"".equals(key)){
            lang = searchParamsPrefs_.lang().get();
            Log.d(TAG, "lang = " + lang);
            geocode = searchParamsPrefs_.location().get();
            Log.d(TAG, "geocode = " + geocode);

            RetrofitClient.apiService.getSearchResult("Bearer " + bearer, key, lang, geocode)
                    .subscribeOn(Schedulers.from(Constant.executor))
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<SearchResultInfo>() {
                        @Override
                        public void onCompleted() {
                            if(swipeRefresh.isRefreshing()){
                                swipeRefresh.setRefreshing(false);
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            Toast.makeText(MainActivity.this, "搜索失败", Toast.LENGTH_LONG).show();
                            swipeRefresh.setRefreshing(false);
                        }

                        @Override
                        public void onNext(SearchResultInfo searchResultInfo) {
                            SearchListAdaptar searchListAdaptar = new SearchListAdaptar(MainActivity.this
                                    , searchResultInfo
                                    , new SearchListAdaptar.ItemClick() {
                                @Override
                                public void onSearchItemClick(int postion, SearchResultInfo.StatusesEntity statusesEntity) {
                                    Toast.makeText(MainActivity.this
                                            , "Item:" + postion + "clicked"
                                            , Toast.LENGTH_LONG).show();
                                }
                            });
                            searchRecycler.setAdapter(searchListAdaptar);
                        }

                        @Override
                        public void onStart() {
                            if(!swipeRefresh.isRefreshing()){
                                swipeRefresh.setRefreshing(true);
                            }
                            searchRecycler.setAdapter(null);
                        }
                    });
        }
    }

    private void initBearer(){
        bearer = bearerPrefs_.bearer().get();
        if("".equals(bearer)){
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
                                    bearer = tokenInfo.getAccess_token();
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
}
