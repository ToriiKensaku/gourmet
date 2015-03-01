package com.tsukuba.gourmet;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends Activity {

    TextView text1;
    TextView text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = (TextView)findViewById(R.id.text1);
        text2 = (TextView)findViewById(R.id.text2);
    }

    public void all(View v){                             //なんでもいいから全部のとき
        Intent intent = new Intent(getApplicationContext(),MapsActivity.class);
        intent.putExtra("key","all");                 //第一引数に渡したいキー。これはStrのみ。第二引数に渡したい値。
        startActivity(intent);
    }

    /*public void ramen(View v){                           //ラーメンのとき
        Intent intent = new Intent(getApplicationContext(),MapsActivity.class);
        intent.putExtra("key","ramen");
        startActivity(intent);
    }

    public void wasyoku(View v){                         //和食のとき
        Intent intent = new Intent(getApplicationContext(),MapsActivity.class);
        intent.putExtra("key","wasyoku");
        startActivity(intent);
    }

    public void italy(View v){                           //イタリアンのとき
        Intent intent = new Intent(getApplicationContext(),MapsActivity.class);
        intent.putExtra("key","italy");
        startActivity(intent);
    }

    public void china(View v){                           //中華のとき
        Intent intent = new Intent(getApplicationContext(),MapsActivity.class);
        intent.putExtra("key","china");
        startActivity(intent);
    }

    public void drink(View v){                           //寿司のとき
        Intent intent = new Intent(getApplicationContext(),MapsActivity.class);
        intent.putExtra("key","drink");
        startActivity(intent);
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}


