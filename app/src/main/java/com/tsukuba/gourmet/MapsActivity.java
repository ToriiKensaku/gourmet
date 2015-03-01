package com.tsukuba.gourmet;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import com.google.android.gms.maps.SupportMapFragment;
import android.support.v4.app.FragmentManager;

import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import java.util.Calendar;

public class MapsActivity extends FragmentActivity {

    private GoogleMap mMap;         //mapの取得
    String category;
    Intent intent;

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

    LatLng wasyoku1 = new LatLng(36.095448, 140.11184);             //とんとことん
    LatLng wasyoku2 = new LatLng(36.07704, 140.110668);             //とんQ
    LatLng wasyoku3 = new LatLng(36.086472, 140.083867);            //大戸屋
    LatLng wasyoku4 = new LatLng(36.109153, 140.119555);            //ふくすけ
    LatLng wasyoku5 = new LatLng(36.096859, 140.097774);            //夢屋
    /*LatLng wasyoku6 = new LatLng();            //クラレット
    LatLng wasyoku7 = new LatLng();            //おかだ
    LatLng wasyoku8 = new LatLng();            //ジャンク亭
    LatLng wasyoku9 = new LatLng(36.095668,140.097141);            //らんらん
    LatLng wasyoku10 = new LatLng();            //ZEYO
    LatLng wasyoku11 = new LatLng();            //くら寿司
    LatLng wasyoku12 = new LatLng();            //はま寿司
    LatLng wasyoku13 = new LatLng();            //魚米
    LatLng wasyoku14 = new LatLng();            //かねき
    LatLng wasyoku15 = new LatLng();            //くい亭
    LatLng wasyoku16 = new LatLng();            //とんQ　イーアス店*/

    LatLng italy1 = new LatLng(36.098512, 140.10749);            //ばらえてい
    LatLng italy2 = new LatLng(36.097387, 140.110937);           //エルトリート
    LatLng italy3 = new LatLng(36.110616, 140.10947);            //ココス　桜
    LatLng italy4 = new LatLng(36.096961, 140.111033);           //ココス　天久保
    LatLng italy5 = new LatLng(36.062989, 140.121884);           //ウエストハウス

    LatLng china1 = new LatLng(36.110905, 140.110739);            //えんや
    LatLng china2 = new LatLng(36.097612, 140.091872);            //百香亭　本店
    LatLng china3 = new LatLng(36.08152, 140.111037);             //ろうがいろう
    LatLng china4 = new LatLng(36.048502, 140.130234);            //大阪王将
    LatLng china5 = new LatLng(36.106701, 140.103342);            //シーアン
    LatLng china6 = new LatLng(36.09619, 140.106718);             //北方えん
    LatLng china7 = new LatLng(36.081653, 140.111716);            //王期厨房


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        setUpMapIfNeeded();
        FragmentManager manager = getSupportFragmentManager();      //Fragment Maneger
        SupportMapFragment fragment = (SupportMapFragment) manager.findFragmentById(R.id.map);      //フラグメントをactivity_maps
        GoogleMap mMap = fragment.getMap();

        // intentの値の受け取りをする。
        intent = getIntent();
        category = intent.getStringExtra("key");
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
            if (mMap != null) {
                setUpMap();                                           //マップを取得した後の場合分けはこの下。
            }
        }
    }

    private void setUpMap() {
        mMap.getUiSettings().setZoomControlsEnabled(true);                //ズームボタンの追加をはじめに行う。
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);                       // マップをハイブリッド表示にする
        mMap.setIndoorEnabled(false);                                     // 屋内マップ表示を無効にする（標準は true）
        mMap.setMyLocationEnabled(true);                                  // 現在地を有効にする
        mMap.getUiSettings().setMyLocationButtonEnabled(true);            // 現在地表示ボタンを有効にする
        UiSettings settings = mMap.getUiSettings();                       // Settingのインポート
        settings.setCompassEnabled(true);                                 // コンパスonにする

        LocationManager locman = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        Location loc = locman.getLastKnownLocation("gps");                // LocationManagerを使う

        double currentLat = loc.getLatitude();                            // 現在地の緯度
        double currentLong = loc.getLongitude();                          // 現在地の経度

        CircleOptions circleOptions = new CircleOptions()                 // 円のoption
                .center(new LatLng(currentLat, currentLong))              // 中心。緯度経度
                .radius(2000);                                            // 半径。m
        Circle circle = mMap.addCircle(circleOptions);                    // 円の追加.このままだと円が黒色.見にくい

        circle.setStrokeColor(Color.argb(0x99, 0x33, 0x99, 0xFF));        // 円の線の色。alpha,red,green,blue
        circle.setStrokeWidth(10.0f);                                     // 円の線の太さ
        circle.setFillColor(Color.argb(0x22, 0x33, 0x99, 0xFF));          // 円の塗りつぶしの色

        BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.drawable.s_ramen2);     //アイコンの変更.Bitmapに変える.sizeに注意
        BitmapDescriptor icon2 = BitmapDescriptorFactory.fromResource(R.drawable.s_wasyoku1);     //アイコンの変更.Bitmapに変える.sizeに注意
        BitmapDescriptor icon3 = BitmapDescriptorFactory.fromResource(R.drawable.s_pasta1);     //アイコンの変更.Bitmapに変える.sizeに注意
        BitmapDescriptor icon4 = BitmapDescriptorFactory.fromResource(R.drawable.s_chinese1);     //アイコンの変更.Bitmapに変える.sizeに注意

        //つくば付近にいく。別で現在地もあるけどw
        CameraPosition tsukuba = new CameraPosition.Builder()
                .target(new LatLng(36.083486, 140.076642)).zoom(10.5f)
                .bearing(0).tilt(25).build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(tsukuba));

        //以下、ゴリ押しで進めていく。お店の追加をしてマーカーで表示する。if文回す
        if (category.equals("all") || category.equals("ramen")) {
            if (hour > 17 && hour < 24) {
                MarkerOptions gouya = new MarkerOptions();
                gouya.position(ramen1);
                gouya.title("ごう家");
                gouya.snippet("17時〜24時");
                gouya.icon(icon);
                mMap.addMarker(gouya);     //これが方法１。まとめると以下のようになる。for文で回しても同じ
            }
            if (hour > 11 && hour < 24) {
                mMap.addMarker(new MarkerOptions().position(ramen2).title("大笑軒響").snippet("11時〜24時").icon(icon));      //snippetはコメント挿入
            }
            mMap.addMarker(new MarkerOptions().position(ramen3).title("おび屋").icon(icon));
            mMap.addMarker(new MarkerOptions().position(ramen4).title("むつみ屋").icon(icon));
            mMap.addMarker(new MarkerOptions().position(ramen5).title("丸源").icon(icon));
            mMap.addMarker(new MarkerOptions().position(ramen6).title("ゆきむら亭").icon(icon));
            mMap.addMarker(new MarkerOptions().position(ramen7).title("がんこ屋").icon(icon));
            mMap.addMarker(new MarkerOptions().position(ramen8).title("大勝軒").icon(icon));
            if (hour > 11 && hour < 24 || hour < 2) {
                mMap.addMarker(new MarkerOptions().position(ramen9).title("五右衛門").snippet("11時〜02時").icon(icon));
            }
        }

        /*if(category.equals("all")||category.equals("wasyoku")){
            mMap.addMarker(new MarkerOptions().position(wasyoku1).title("とんとこ豚").icon(icon2));
            mMap.addMarker(new MarkerOptions().position(wasyoku2).title("とんQ").icon(icon2));
            mMap.addMarker(new MarkerOptions().position(wasyoku3).title("大戸屋").icon(icon2));
            mMap.addMarker(new MarkerOptions().position(wasyoku4).title("ふくすけ").icon(icon2));
            mMap.addMarker(new MarkerOptions().position(wasyoku5).title("夢屋").icon(icon2));
            mMap.addMarker(new MarkerOptions().position(wasyoku6).title("ランラン").icon(icon2));
        }

        if(category.equals("all")||category.equals("italy")){
            mMap.addMarker(new MarkerOptions().position(italy1).title("ばらえてい").icon(icon3));
            mMap.addMarker(new MarkerOptions().position(italy2).title("エルトリート").icon(icon3));
            mMap.addMarker(new MarkerOptions().position(italy3).title("ココス　桜店").icon(icon3));
            mMap.addMarker(new MarkerOptions().position(italy4).title("ココス　天久保店").icon(icon3));
            mMap.addMarker(new MarkerOptions().position(italy5).title("ウエストハウス").icon(icon3));
        }

        if(category.equals("all")||category.equals("china")){
            mMap.addMarker(new MarkerOptions().position(china1).title("えんや").icon(icon4));
            mMap.addMarker(new MarkerOptions().position(china2).title("百香亭").icon(icon4));
            mMap.addMarker(new MarkerOptions().position(china3).title("樓外樓").icon(icon4));
            mMap.addMarker(new MarkerOptions().position(china4).title("大阪王将").icon(icon4));
            mMap.addMarker(new MarkerOptions().position(china5).title("シーアン").icon(icon4));
            mMap.addMarker(new MarkerOptions().position(china6).title("北方園").icon(icon4));
            mMap.addMarker(new MarkerOptions().position(china7).title("王記厨房 つくばクレオスクエア店").icon(icon4));
        }*/
    }
}

