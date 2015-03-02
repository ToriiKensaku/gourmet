package com.tsukuba.gourmet;

import com.google.android.gms.internal.as;
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
    //現在時刻の取得
    Calendar cal = Calendar.getInstance();
    int week = cal.get(Calendar.DAY_OF_WEEK);
    int hour = cal.get(Calendar.HOUR_OF_DAY);
    int minute = cal.get(Calendar.MINUTE);
    int hourtime = hour * 100 + minute;                                  //何時何分

    String category;
    String category2;
    String category3;
    String category4;
    String category5;

    Intent intent;
    Intent intent2;
    Intent intent3;
    Intent intent4;
    Intent intent5;

    //場所の指定。緯度経度
    LatLng ramen1 = new LatLng(36.097468, 140.110217);             //ごう家
    LatLng ramen2 = new LatLng(36.103577, 140.067609);             //大笑軒響
    LatLng ramen3 = new LatLng(36.103325, 140.084206);             //おび屋
    LatLng ramen4 = new LatLng(36.075204, 140.102571);             //丸源
    LatLng ramen5 = new LatLng(36.045744, 140.122832);             //がんこ屋
    LatLng ramen6 = new LatLng(36.038036, 140.084976);             //大勝軒
    LatLng ramen7 = new LatLng(36.038036, 140.084976);             //五右衛門
    LatLng ramen8 = new LatLng(36.0403, 140.096192);               //角藤
    LatLng ramen9 = new LatLng(36.119224, 140.113724);             //はりけん
    LatLng ramen10 = new LatLng(36.047346, 140.084559);            //山水
    LatLng ramen11 = new LatLng(36.137343, 140.081535);            //油虎
    LatLng ramen12 = new LatLng(36.083798, 140.081284);            //喜元門　本店
    LatLng ramen13 = new LatLng(36.07103, 140.118645);             //清六屋　本店
    LatLng ramen14 = new LatLng(36.077898, 140.118237);            //蒼
    LatLng ramen15 = new LatLng(36.098298, 140.108348);            //いちかわ
    LatLng ramen16 = new LatLng(36.096776, 140.109867);            //とりどり
    LatLng ramen17 = new LatLng(36.048826, 140.085381);            //喜元門　サイエンス大通り店
    LatLng ramen18 = new LatLng(36.089091, 140.11029);             //龍郎
    LatLng ramen19 = new LatLng(36.109153, 140.119555);            //武蒼

    LatLng wasyoku1 = new LatLng(36.095448, 140.11184);             //とんとことん
    LatLng wasyoku2 = new LatLng(36.07704, 140.110668);             //とんQ
    LatLng wasyoku3 = new LatLng(36.086472, 140.083867);            //大戸屋
    LatLng wasyoku4 = new LatLng(36.109153, 140.119555);            //ふくすけ
    LatLng wasyoku5 = new LatLng(36.096859, 140.097774);            //夢屋
    LatLng wasyoku6 = new LatLng(36.106814, 140.103512);            //クラレット
    LatLng wasyoku7 = new LatLng(36.089022, 140.127905);            //おかだ
    LatLng wasyoku8 = new LatLng(36.095132, 140.107393);            //ジャンク亭
    LatLng wasyoku9 = new LatLng(36.095668, 140.097141);            //らんらん
    LatLng wasyoku10 = new LatLng(36.098109, 140.106118);            //ZEYO
    LatLng wasyoku11 = new LatLng(36.080053, 140.094166);            //くら寿司
    LatLng wasyoku12 = new LatLng(36.075981, 140.102774);            //はま寿司
    LatLng wasyoku13 = new LatLng(36.084101, 140.084839);            //魚米
    LatLng wasyoku14 = new LatLng(36.112805, 140.115325);            //かねき
    LatLng wasyoku15 = new LatLng(36.115255, 140.112272);            //くい亭
    LatLng wasyoku16 = new LatLng(36.086472, 140.083867);            //とんQ　イーアス店

    LatLng italy1 = new LatLng(36.098512, 140.10749);            //ばらえてい
    LatLng italy2 = new LatLng(36.097387, 140.110937);           //エルトリート
    LatLng italy3 = new LatLng(36.110616, 140.10947);            //ココス　桜
    LatLng italy4 = new LatLng(36.096961, 140.111033);           //ココス　天久保
    LatLng italy5 = new LatLng(36.062989, 140.121884);           //ウエストハウス
    LatLng italy6 = new LatLng(36.095007, 140.099054);           //フライパン
    LatLng italy7 = new LatLng(36.086472, 140.083867);           //神戸元町ドリア　イーアス店
    LatLng italy8 = new LatLng(36.086472, 140.083867);           //バケット　イーアス店
    LatLng italy9 = new LatLng(36.083842, 140.105096);           //デニーズ　学園店
    LatLng italy10 = new LatLng(36.110677, 140.110397);           //サイゼリヤ　桜店
    LatLng italy11 = new LatLng(36.081653, 140.111716);           //サイゼリヤ　キュート店

    LatLng china1 = new LatLng(36.110905, 140.110739);            //えんや
    LatLng china2 = new LatLng(36.097612, 140.091872);            //百香亭　本店
    LatLng china3 = new LatLng(36.08152, 140.111037);             //ろうがいろう
    LatLng china4 = new LatLng(36.048502, 140.130234);            //大阪王将
    LatLng china5 = new LatLng(36.106701, 140.103342);            //シーアン
    LatLng china6 = new LatLng(36.09619, 140.106718);             //北方えん
    LatLng china7 = new LatLng(36.081653, 140.111716);            //王期厨房
    LatLng china8 = new LatLng(36.081653, 140.111716);            //珍来　桜店
    LatLng china9 = new LatLng(36.088944, 140.091758);            //ホワイト餃子
    LatLng china10 = new LatLng(36.107144, 140.105312);            //百香亭　筑波大学店


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
            if (mMap != null) {
                setUpMap();                                           //マップを取得した後の場合分けはこの下。
            }
        }
    }

    private void setUpMap() {
        // intentの値の受け取りをする。
        intent = getIntent();
        category = intent.getStringExtra("key");
        intent2 = getIntent();
        category2 = intent2.getStringExtra("key2");
        intent3 = getIntent();
        category3 = intent3.getStringExtra("key3");
        intent4 = getIntent();
        category4 = intent4.getStringExtra("key4");
        intent5 = getIntent();
        category5 = intent5.getStringExtra("key5");

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

        if (category.equals("all") || category2.equals("ramen")) {
            if (hour >= 17 && hour < 24) {
                MarkerOptions gouya = new MarkerOptions();
                gouya.position(ramen1);
                gouya.title("ごう家");
                gouya.snippet("17時〜24時");
                gouya.icon(icon);
                mMap.addMarker(gouya);     //これが方法１。まとめると以下のようになる。for文で回しても同じ
            }
            if (hour >= 11 && hour < 24) {
                mMap.addMarker(new MarkerOptions().position(ramen2).title("大笑軒響").snippet("11時〜24時").icon(icon));      //snippetはコメント挿入
                mMap.addMarker(new MarkerOptions().position(ramen6).title("大勝軒").snippet("11:00～24:00").icon(icon));
            }
            if (hourtime >= 1130 && hourtime <= 1500 && hourtime >= 1730 && hourtime <= 2200) {
                mMap.addMarker(new MarkerOptions().position(ramen3).title("おび屋").snippet("11：30～15：00(L.O) 17：30～22：00(L.O)").icon(icon));
            }
            if (hour >= 11 && hour <= 24) {
                mMap.addMarker(new MarkerOptions().position(ramen4).title("丸源").snippet("11：00～25:00").icon(icon));
            }
            if (hour >= 11 && hour < 23) {
                mMap.addMarker(new MarkerOptions().position(ramen5).title("がんこ屋").snippet("11:00～23:00").icon(icon));
                mMap.addMarker(new MarkerOptions().position(ramen13).title("清六屋　本店").snippet("11：00～23：00").icon(icon));
            }
            if (hour >= 11 && hour < 2) {
                mMap.addMarker(new MarkerOptions().position(ramen7).title("五右衛門").snippet("11時〜02時").icon(icon));
            }
            if (hour >= 11 && hour < 3) {
                mMap.addMarker(new MarkerOptions().position(ramen8).title("角藤").snippet("11:00～3：00").icon(icon));
            }
            if (hourtime >= 1130 && hourtime <= 1430 && hourtime >= 1730 && hourtime <= 2130) {
                mMap.addMarker(new MarkerOptions().position(ramen9).title("はりけん").snippet("11:30～14:30 17:30～21:30").icon(icon));
            }
            if (hour >= 11 && hour < 4) {
                mMap.addMarker(new MarkerOptions().position(ramen10).title("山水").snippet("11:00～4:00").icon(icon));
            }
            if (hourtime >= 1130 && hour <= 1430 && hourtime >= 1730 && hourtime >= 2200) {
                mMap.addMarker(new MarkerOptions().position(ramen11).title("油虎").snippet("11:30～14:30 17:30～22:00").icon(icon));
                mMap.addMarker(new MarkerOptions().position(ramen18).title("龍郎").snippet("11:30～14:30 17:30～22:00").icon(icon));
            }
            if (hourtime >= 1130 && hourtime < 1400 && hourtime >= 1730 && hourtime <= 2100) {
                mMap.addMarker(new MarkerOptions().position(ramen12).title("喜元門　本店").snippet("11:30～14:00　17:30～21:00").icon(icon));
            }
            if (hourtime >= 1130 && hourtime <= 1430 && hourtime >= 1730 && hourtime <= 2100) {
                mMap.addMarker(new MarkerOptions().position(ramen14).title("蒼").snippet("11:30～14:30 17:30～21:00").icon(icon));
            }
            if (hourtime >= 1130 && hourtime <= 1400) {
                mMap.addMarker(new MarkerOptions().position(ramen15).title("いちかわ").snippet("11:30～14:00").icon(icon));
            }
            if (hourtime >= 1130 && hourtime <= 1430 && hourtime >= 1800 && hourtime <= 2300) {
                mMap.addMarker(new MarkerOptions().position(ramen16).title("とりどり").snippet("11:30～14:30 18:00～23:00").icon(icon));
            }
            if (hourtime >= 1130 && hourtime <= 1430 && hourtime >= 1700 && hourtime <= 2100) {
                mMap.addMarker(new MarkerOptions().position(ramen17).title("喜元門　サイエンス大通り店").snippet("11：30～14：30(LO) 17：00～21：00").icon(icon));
            }
            if (hourtime >= 1130 && hourtime <= 1430 && hourtime >= 1730 && hourtime <= 2030) {
                mMap.addMarker(new MarkerOptions().position(ramen19).title("武蒼").snippet("11:30-14:30 17:30-20:30").icon(icon));
            }
        }

        if (category.equals("all") || category3.equals("wasyoku")) {
            if (hour >= 11 && hour < 15) {
                mMap.addMarker(new MarkerOptions().position(wasyoku1).title("とんとこ豚").snippet("\"[平日]11:00～15:00（L.O14:30)　17:00～21：00\n" +
                        "[金、土、日、祝]11:00～15:00（L.O14:30)　17:00～22：00\"").icon(icon2));
            }
            if (hour >= 11 && hour < 22) {
                mMap.addMarker(new MarkerOptions().position(wasyoku2).title("とんQ　本店").snippet("11:00～22:00").icon(icon2));
                mMap.addMarker(new MarkerOptions().position(wasyoku3).title("大戸屋").snippet("11:00～22:00").icon(icon2));
                mMap.addMarker(new MarkerOptions().position(wasyoku8).title("ジャンク亭").snippet("11:00～22:00(L.O 21:30)").icon(icon2));
            }
            if (week >= 2 && week <= 6) {
                if (hourtime >= 1130 && hourtime <= 1350 && hourtime >= 1700 && hourtime <= 2030) {
                    mMap.addMarker(new MarkerOptions().position(wasyoku4).title("ふくすけ").snippet("\"[月～金] 11:00～13:50 17:00～20:30\n" +
                            "[土] 11:30～13:50\"").icon(icon2));
                }
            }
            if (week == 7) {
                if (hourtime >= 1130 && hourtime <= 1350) {
                    mMap.addMarker(new MarkerOptions().position(wasyoku4).title("ふくすけ").snippet("\"[月～金] 11:00～13:50 17:00～20:30\n" +
                            "[土] 11:30～13:50\"").icon(icon2));
                }
            }
            if (hourtime >= 1130 && hourtime <= 2315) {
                mMap.addMarker(new MarkerOptions().position(wasyoku9).title("ランラン").snippet("17:00～23:15（ＬＯ）").icon(icon2));
            }
            if (week >= 2) {
                if (hourtime >= 1130 && hourtime <= 1345 && hourtime >= 1800 && hourtime <= 2200) {
                    mMap.addMarker(new MarkerOptions().position(wasyoku5).title("夢屋").snippet("\"［月～土］11:30～13:45 18:00～22:00\n" +
                            "［日・祝］18:00～21:00\"").icon(icon2));
                }
            }
            if (week == 1) {
                if (hourtime >= 1800 && hourtime <= 2100) {
                    mMap.addMarker(new MarkerOptions().position(wasyoku5).title("夢屋").snippet("\"［月～土］11:30～13:45 18:00～22:00\n" +
                            "［日・祝］18:00～21:00\"").icon(icon2));
                }
            }
            if (hourtime >= 1730 && hourtime <= 2230) {
                mMap.addMarker(new MarkerOptions().position(wasyoku6).title("クラレット").snippet("17:30～22:30").icon(icon2));
            }
            if (hourtime >= 1100 && hourtime <= 1500 && hourtime >= 1730 && hourtime <= 2030) {
                mMap.addMarker(new MarkerOptions().position(wasyoku7).title("おかだ").snippet("\"11:00～15:00 (L.O. 14:30)\n" +
                        "17:30～20:30 (L.O. 20:15)\"").icon(icon2));
            }
            if (hourtime >= 1130 && hourtime <= 2200) {
                mMap.addMarker(new MarkerOptions().position(wasyoku10).title("ZEYO").snippet("11:30～14:30 18:00～23:30").icon(icon2));
            }

            if (hour >= 11 && hour < 23) {
                mMap.addMarker(new MarkerOptions().position(wasyoku11).title("くら寿司").snippet("11：00～23：00 (L.O 22：30)").icon(icon2));
                mMap.addMarker(new MarkerOptions().position(wasyoku12).title("はま寿司").snippet("11：00～23：00 (L.O 22：30)").icon(icon2));
                mMap.addMarker(new MarkerOptions().position(wasyoku13).title("魚べい").snippet("11：00～23：00 (L.O 22：30)").icon(icon2));
            }
            if (hourtime >= 1130 && hourtime <= 2200) {
                mMap.addMarker(new MarkerOptions().position(wasyoku14).title("かねき").snippet("11:30～22:00").icon(icon2));
            }
            if (hour >= 11 && hour < 14 && hour >= 17 && hour < 20) {
                mMap.addMarker(new MarkerOptions().position(wasyoku15).title("くい亭").snippet("11:00-14:00 17:00-20:00").icon(icon2));
            }
            if (hour >= 11 && hour < 21) {
                mMap.addMarker(new MarkerOptions().position(wasyoku16).title("とんQ　イーアス店").snippet("11:00～21:00（L.O）").icon(icon2));
            }
        }

        if (category.equals("all") || category4.equals("italy")) {
            if (hourtime >= 1130 && hourtime < 1500 && hourtime >= 1730 && hourtime <= 2230) {
                mMap.addMarker(new MarkerOptions().position(italy1).title("ばらえてい").snippet("\"11:30～15:00(L.O.14:00)\n" +
                        "17:30～22:30(L.O.21:30)\"").icon(icon3));
            }
            if (hour >= 11 && hour < 2) {
                mMap.addMarker(new MarkerOptions().position(italy2).title("エルトリート").snippet("11:00～02:00").icon(icon3));
            }
            if (hour >= 10 && hour < 2) {
                mMap.addMarker(new MarkerOptions().position(italy3).title("ココス　桜店").snippet("10:00～02:00").icon(icon3));
            }
            if (hour >= 7 && hour < 5) {
                mMap.addMarker(new MarkerOptions().position(italy4).title("ココス　天久保店").snippet("07:00～05:00").icon(icon3));
            }
            if (week >= 2) {
                if (hour >= 11 && hour < 23) {
                    mMap.addMarker(new MarkerOptions().position(italy5).title("ウエストハウス").snippet("\"[月～土]11:00～23:00（L.O.22:00）\n" +
                            "[日・祝日]11:00～22:30（L.O.21:20）\"").icon(icon3));
                }
            }
            if (week == 1) {
                if (hourtime >= 1100 && hourtime < 2230) {
                    mMap.addMarker(new MarkerOptions().position(italy5).title("ウエストハウス").snippet("\"[月～土]11:00～23:00（L.O.22:00）\n" +
                            "[日・祝日]11:00～22:30（L.O.21:20）\"").icon(icon3));
                }
            }
            if (week >= 2 && week < 7) {
                if (hour >= 11 && hour < 15 && hour >= 17 && hour < 22) {
                    mMap.addMarker(new MarkerOptions().position(italy6).title("フライパン").snippet("\"[月～金]11：00～15：00 17：00～22：00\n" +
                            "[土・日・祝]11：00～22：00\"").icon(icon3));
                }
            }
            if (week == 1 && week == 7) {
                if (hour >= 11 && hour < 22) {
                    mMap.addMarker(new MarkerOptions().position(italy6).title("フライパン").snippet("\"[月～金]11：00～15：00 17：00～22：00\n" +
                            "[土・日・祝]11：00～22：00\"").icon(icon3));
                }
            }
            if (hour >= 11 && hour < 21) {
                mMap.addMarker(new MarkerOptions().position(italy7).title("神戸元町ドリア　イーアス店").snippet("11:00～21:00（L.O）").icon(icon3));
                mMap.addMarker(new MarkerOptions().position(italy8).title("バケット　イーアス店").snippet("11:00～21:00（L.O）").icon(icon3));
            }

            mMap.addMarker(new MarkerOptions().position(italy9).title("デニーズ　学園店").snippet("24時間営業").icon(icon3));

            if (hour >= 11 && hour < 2) {
                mMap.addMarker(new MarkerOptions().position(italy10).title("サイゼリヤ　桜店").snippet("11:00～02:00").icon(icon3));
            }
            if (hour >= 11 && hour < 23) {
                mMap.addMarker(new MarkerOptions().position(italy11).title("サイゼリヤ　キュート店").snippet("11:00～23:00").icon(icon3));
            }
        }

        if (category.equals("all") || category5.equals("china")) {
            if (hourtime >= 1130) {
                mMap.addMarker(new MarkerOptions().position(china1).title("えんや").snippet("11:30～24:00").icon(icon4));
            }
            if (hour >= 11 && hour < 23) {
                mMap.addMarker(new MarkerOptions().position(china2).title("百香亭").snippet("11:00～15:30(L.O.15:00) 17:00～23:00(L.O.22:00)").icon(icon4));
                mMap.addMarker(new MarkerOptions().position(china10).title("百香亭 筑波大学店").snippet("11:00～15:30(L.O.15:00) 17:00～23:00(L.O.22:00)").icon(icon4));
            }
            if (hourtime >= 1130 && hourtime < 2200) {
                mMap.addMarker(new MarkerOptions().position(china3).title("樓外樓").snippet("11:30～22:00").icon(icon4));
            }
            if (hour >= 11) {
                mMap.addMarker(new MarkerOptions().position(china4).title("大阪王将").snippet("11：00～24：00").icon(icon4));
            }
            if (hourtime >= 1100 && hourtime <= 1430 && hourtime >= 1700 && hourtime <= 2400) {
                mMap.addMarker(new MarkerOptions().position(china5).title("シーアン").snippet("11：00～14：30 17：00～24：00").icon(icon4));
            }
            if (hour >= 10 && hour < 15 && hour > 17) {
                mMap.addMarker(new MarkerOptions().position(china6).title("北方園").snippet("10:00～15:00 17:00～24:00").icon(icon4));
            }
            if (hour >= 11 && hour < 20) {
                mMap.addMarker(new MarkerOptions().position(china7).title("王記厨房 つくばクレオスクエア店").snippet("10:00～20:00").icon(icon4));
                mMap.addMarker(new MarkerOptions().position(china8).title("珍来 テクノパーク桜店").snippet("10:00～20:00").icon(icon4));
            }
            mMap.addMarker(new MarkerOptions().position(china9).title("ホワイト餃子つくば学園店").snippet("不明").icon(icon4));
        }
    }
}
