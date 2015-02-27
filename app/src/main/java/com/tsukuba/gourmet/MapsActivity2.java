package com.tsukuba.gourmet;
import com.google.android.gms.maps.GoogleMap;
import android.location.Location;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import android.support.v4.app.FragmentManager;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.tsukuba.gourmet.R;

public class MapsActivity2 extends FragmentActivity {

    private GoogleMap mMap2;
    LatLng ramen1 = new LatLng(36.102036, 140.143936);             //ごう家
    LatLng ramen2 = new LatLng(36.107029, 140.064285);             //大笑軒響
    LatLng ramen3 = new LatLng(36.112577, 140.086944);             //おび屋
    LatLng ramen4 = new LatLng(36.081506, 140.112350);             //むつみ屋
    LatLng ramen5 = new LatLng(36.074292, 140.098617);             //丸源
    LatLng ramen6 = new LatLng(36.072072, 140.081451);             //ゆきむら亭
    LatLng ramen7 = new LatLng(36.047648, 140.124710);             //がんこ屋
    LatLng ramen8 = new LatLng(36.038765, 140.086258);             //大勝軒
    LatLng ramen9 = new LatLng(36.049869, 140.085571);             //五右衛門

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //ここらへんを変えればいけそう
        setContentView(R.layout.activity_maps2);
        setUpMapIfNeeded();
        FragmentManager manager = getSupportFragmentManager();     //フラグメントマネージャー
        SupportMapFragment fragment = (SupportMapFragment)manager.findFragmentById(R.id.map2);   //activity_maps2.xmlを使ってるけど大丈夫なのか
        GoogleMap mMap2 = fragment.getMap();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    private void setUpMapIfNeeded() {
        if (mMap2 == null) {
            mMap2 = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map2))
                    .getMap();
            mMap2.getUiSettings().setZoomControlsEnabled(true);            //ズームボタンの追加をはじめに行う。
            if (mMap2 != null) {
                setUpMap();                                                //マップを取得したあとは下のに示す。
            }
        }
    }

    private void setUpMap(){
        mMap2.setMapType(GoogleMap.MAP_TYPE_HYBRID);                       // マップをハイブリッド表示にする
        mMap2.setIndoorEnabled(false);                                     // 屋内マップ表示を無効にする（標準は true）
        mMap2.setMyLocationEnabled(true);                                  // 現在地表示ボタンを有効にする
        mMap2.getUiSettings().setMyLocationButtonEnabled(true);
        //以下、ゴリ押しで進めていく。お店の追加をしてマーカーで表示する。

        MarkerOptions gouya = new MarkerOptions();
        gouya.position(ramen1);
        gouya.title("ごう家");
        mMap2.addMarker(gouya);      //これが方法１。まとめると以下のようになる。for文で回しても同じ

        mMap2.addMarker(new MarkerOptions().position(ramen2).title("大笑軒響"));
        mMap2.addMarker(new MarkerOptions().position(ramen3).title("おび屋"));
        mMap2.addMarker(new MarkerOptions().position(ramen4).title("むつみ屋"));
        mMap2.addMarker(new MarkerOptions().position(ramen5).title("丸源"));
        mMap2.addMarker(new MarkerOptions().position(ramen6).title("ゆきむら亭"));
        mMap2.addMarker(new MarkerOptions().position(ramen7).title("がんこ屋"));
        mMap2.addMarker(new MarkerOptions().position(ramen8).title("大勝軒"));
        mMap2.addMarker(new MarkerOptions().position(ramen9).title("五右衛門"));
    }
}