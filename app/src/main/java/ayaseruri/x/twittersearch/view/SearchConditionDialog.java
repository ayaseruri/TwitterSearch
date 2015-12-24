package ayaseruri.x.twittersearch.view;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ayaseruri.x.twittersearch.R;
import ayaseruri.x.twittersearch.db.SearchParamsPrefs_;
import ayaseruri.x.twittersearch.util.LocalDisplay;

/**
 * Created by ayaseruri on 15/12/24.
 */
public class SearchConditionDialog extends Dialog {

    private List<SearchConditionItem_> searchConditionItems;
    private IOnSCDialogItemClick iOnSCDialogItemClick;
    private SearchParamsPrefs_ searchParamsPrefs_;
    private LocationManager locationManager;
    private String locationStr;

    public SearchConditionDialog(final Context context, final IOnSCDialogItemClick iOnSCDialogItemClick) {
        super(context);
        this.iOnSCDialogItemClick = iOnSCDialogItemClick;
        searchParamsPrefs_ = new SearchParamsPrefs_(context);

        searchConditionItems = new ArrayList<>();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View contentView = layoutInflater.inflate(R.layout.dialog_search_condition, null);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setContentView(contentView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        LinearLayout contentRoot = (LinearLayout) contentView.findViewById(R.id.dialog_root);
        for (int i = 0; i < contentRoot.getChildCount(); i++) {
            View tempView = contentRoot.getChildAt(i);
            if (tempView instanceof SearchConditionItem_) {
                SearchConditionItem_ searchConditionItem = (SearchConditionItem_) tempView;
                searchConditionItems.add(searchConditionItem);
            }
        }

        for (int j = 0; j < searchConditionItems.size(); j++) {
            String lang = searchParamsPrefs_.lang().get();
            locationStr = searchParamsPrefs_.location().get();
            final SearchConditionItem currentItem = searchConditionItems.get(j);

            if ("".equals(lang) && currentItem.getId() == R.id.lang_all) {
                currentItem.setChecked(true);
            } else if ("zh".equals(lang) && currentItem.getId() == R.id.lang_cn) {
                currentItem.setChecked(true);
            } else if ("en".equals(lang) && currentItem.getId() == R.id.lang_en) {
                currentItem.setChecked(true);
            }

            if (currentItem.getId() == R.id.loaction_near) {
                currentItem.setClickable(false);
                currentItem.setChecked(false);
                final TextView textView = currentItem.getTextView();

                if (ActivityCompat.checkSelfPermission(context
                        , Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                        && ActivityCompat.checkSelfPermission(context
                        , Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    textView.setText(textView.getText() + "(没有定位权限)");
                    locationStr = "";
                    searchParamsPrefs_.location().put(locationStr);
                }else {
                    locationManager = (LocationManager)context.getSystemService(context.LOCATION_SERVICE);
                    Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                    if(null != location){
                        currentItem.setClickable(true);
                        textView.setText(String.format(context.getResources().getString(R.string.near)
                                , location.getLongitude()
                                , location.getLatitude()));
                        locationStr = location.getLongitude() + "," + location.getLatitude() + ",1km";
                        searchParamsPrefs_.location().put(locationStr);
                    }else {
                        textView.setText(textView.getText() + "(正在定位…)");
                    }
                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 10, new LocationListener() {
                        @Override
                        public void onLocationChanged(Location location) {
                            currentItem.setClickable(true);
                            textView.setText(String.format(context.getResources().getString(R.string.near)
                                    , location.getLongitude()
                                    , location.getLatitude()));
                            locationStr = location.getLongitude() + "," + location.getLatitude() + ",1km";
                            searchParamsPrefs_.location().put(locationStr);
                        }

                        @Override
                        public void onStatusChanged(String provider, int status, Bundle extras) {

                        }

                        @Override
                        public void onProviderEnabled(String provider) {

                        }

                        @Override
                        public void onProviderDisabled(String provider) {

                        }
                    });
                }
            }

            if ("".equals(locationStr) && currentItem.getId() == R.id.loaction_all) {
                currentItem.setChecked(true);
            } else if (!"".equals(locationStr) && currentItem.getId() == R.id.loaction_near) {
                currentItem.setChecked(true);
            }

            currentItem.setItemClick(new SearchConditionItem.IOnSearchConditionItemClick() {
                        @Override
                        public void onItemClick(SearchConditionItem item) {
                            switch (item.getId()){
                                case R.id.lang_all:
                                    searchParamsPrefs_.lang().put("");
                                    break;
                                case R.id.lang_cn:
                                    searchParamsPrefs_.lang().put("zh");
                                    break;
                                case R.id.lang_en:
                                    searchParamsPrefs_.lang().put("en");
                                    break;
                                case R.id.loaction_all:
                                    searchParamsPrefs_.location().put("");
                                    break;
                                case R.id.loaction_near:
                                    searchParamsPrefs_.location().put(locationStr);
                                    break;
                                default:
                                    break;
                            }
                            iOnSCDialogItemClick.onItemClick();
                        }
                    });

            List<SearchConditionItem> rbGroupLangs = new ArrayList<>();
            for(int p = 0; p < 3 && p < searchConditionItems.size(); p++){
                rbGroupLangs.add(searchConditionItems.get(p));
            }
            new RadioButtonGroup(rbGroupLangs);

            List<SearchConditionItem> rbGroupLocations = new ArrayList<>();
            for(int q = 3; q < 5 && q < searchConditionItems.size(); q++){
                rbGroupLocations.add(searchConditionItems.get(q));
            }
            new RadioButtonGroup(rbGroupLocations);
        }
    }

    @Override
    public void show() {
        super.show();
        WindowManager.LayoutParams lp = this.getWindow().getAttributes();
        lp.width = LocalDisplay.SCREEN_WIDTH_PIXELS;
        lp.gravity = Gravity.BOTTOM;
        this.getWindow().setAttributes(lp);
    }

    public interface IOnSCDialogItemClick{
        void onItemClick();
    }

    public static class RadioButtonGroup{
        private List<SearchConditionItem> searchConditionItems;

        public RadioButtonGroup(final List<SearchConditionItem> searchConditionItems) {
            this.searchConditionItems = searchConditionItems;
            for(final SearchConditionItem item : searchConditionItems){
                item.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        for(SearchConditionItem scItem : searchConditionItems){
                            if(scItem.getId() != item.getId()){
                                scItem.setChecked(false);
                            }
                        }
                    }
                });
            }
        }
    }
}
