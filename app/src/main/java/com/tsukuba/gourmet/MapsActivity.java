package com.tsukuba.gourmet;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import com.google.android.gms.maps.SupportMapFragment;
import android.support.v4.app.FragmentManager;

import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import java.util.Calendar;

public class MapsActivity extends FragmentActivity {

    private GoogleMap mMap;         //mapの取得

    //現在時刻の取得
    Calendar cal = Calendar.getInstance();
    int year = cal.get(Calendar.YEAR);
    int month = cal.get(Calendar.MONTH);     // 0 - 11だから+1しなくてはならない。
    int day = cal.get(Calendar.DAY_OF_MONTH);
    int hour = cal.get(Calendar.HOUR_OF_DAY);
    int minute = cal.get(Calendar.MINUTE);

    //場所の指定。緯度経度
    LatLng ramen1 = new LatLng(36.102036, 140.143936);             //ごう家
    LatLng ramen2 = new LatLng(36.107029, 140.064285);             //大笑軒響
    LatLng ramen3 = new LatLng(36.112577, 140.086944);             //おび屋
    LatLng ramen4 = new LatLng(36.081506, 140.112350);             //むつみ屋
    LatLng ramen5 = new LatLng(36.074292, 140.098617);             //丸源
    LatLng ramen6 = new LatLng(36.072072, 140.081451);             //ゆきむら亭
    LatLng ramen7 = new LatLng(36.047648, 140.124710);             //がんこ屋
    LatLng ramen8 = new LatLng(36.038765, 140.086258);             //大勝軒
    LatLng ramen9 = new LatLng(36.049869, 140.085571);             //五右衛門
    LatLng cafe1 = new LatLng(36.114241, 140.103424);              //らんぷ
    //LatLng cafe2 = new LatLng();             //らんぷ


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();
        FragmentManager manager = getSupportFragmentManager();      //Fragment Maneger
        SupportMapFragment fragment = (SupportMapFragment) manager.findFragmentById(R.id.map);      //フラグメントをactivity_maps
        GoogleMap mMap = fragment.getMap();
        }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    private void setUpMapIfNeeded() {
        if (mMap == null) {
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            mMap.getUiSettings().setZoomControlsEnabled(true);        //ズームボタンの追加をはじめに行う。
        }
        if (mMap != null) {
                setUpMap();                                           //マップを取得したあとは下に示す。
            }
        }

    private void setUpMap(){
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);                       // マップをハイブリッド表示にする
        mMap.setIndoorEnabled(false);                                     // 屋内マップ表示を無効にする（標準は true）
        mMap.setMyLocationEnabled(true);                                  // 現在地を有効にする
        mMap.getUiSettings().setMyLocationButtonEnabled(true);            // 現在地表示ボタンを有効にする
        UiSettings settings = mMap.getUiSettings();                       // Settingのインポート
        settings.setCompassEnabled(true);                                 // コンパスonにする

        //つくば付近にいく。別で現在地もあるけどw
        CameraPosition tsukuba = new CameraPosition.Builder()
                .target(new LatLng(36.083486, 140.076642)).zoom(10.5f)
                .bearing(0).tilt(25).build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(tsukuba));

        //以下、ゴリ押しで進めていく。お店の追加をしてマーカーで表示する。if文回す
        if(hour > 17 && hour < 24) {
            MarkerOptions gouya = new MarkerOptions();
            gouya.position(ramen1);
            gouya.title("ごう家");
            gouya.snippet("17時〜24時");
            mMap.addMarker(gouya);     //これが方法１。まとめると以下のようになる。for文で回しても同じ
        }
        if(hour > 11 && hour < 24) {
            mMap.addMarker(new MarkerOptions().position(ramen2).title("大笑軒響").snippet("11時〜24時"));      //snippetはコメント挿入
        }
            mMap.addMarker(new MarkerOptions().position(ramen3).title("おび屋"));
            mMap.addMarker(new MarkerOptions().position(ramen4).title("むつみ屋"));
            mMap.addMarker(new MarkerOptions().position(ramen5).title("丸源"));
            mMap.addMarker(new MarkerOptions().position(ramen6).title("ゆきむら亭"));
            mMap.addMarker(new MarkerOptions().position(ramen7).title("がんこ屋"));
            mMap.addMarker(new MarkerOptions().position(ramen8).title("大勝軒"));
        if(hour > 11 && hour < 24 || hour < 2) {
            mMap.addMarker(new MarkerOptions().position(ramen9).title("五右衛門").snippet("11時〜02時"));
        }
            mMap.addMarker(new MarkerOptions().position(cafe1).title("らんぷ"));
    }
}
