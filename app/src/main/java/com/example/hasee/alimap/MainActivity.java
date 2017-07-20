package com.example.hasee.alimap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.LocationSource;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.UiSettings;
import com.amap.api.maps2d.model.BitmapDescriptor;
import com.amap.api.maps2d.model.MyLocationStyle;

public class MainActivity extends AppCompatActivity {
    private UiSettings uiSettings;
    MyLocationStyle myLocationStyle;
    MapView mapView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapView = (MapView)findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        AMap aMap = null;
        if (aMap == null) {
            aMap = mapView.getMap();
        }
        uiSettings.setMyLocationButtonEnabled(true);
        aMap.setMyLocationEnabled(true);
        myLocationStyle = new MyLocationStyle();
        myLocationStyle.interval(2000);
        aMap.setMyLocationStyle(myLocationStyle);
        aMap.setMyLocationEnabled(true);
        aMap.getUiSettings().setMyLocationButtonEnabled(true);

        myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATE) ;
        uiSettings = aMap.getUiSettings();
//        是否允许显示缩放按钮
        uiSettings.setZoomControlsEnabled(true);
//        设置缩放按钮的位置
//        uiSettings.setZoomPosition();
        uiSettings.setCompassEnabled(true);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }
}
