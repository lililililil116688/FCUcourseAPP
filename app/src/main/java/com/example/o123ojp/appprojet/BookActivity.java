package com.example.o123ojp.appprojet;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class BookActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private EditText etName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        etName = (EditText)findViewById(R.id.etName);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.book, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.sidebar_course_alert) {
            Intent intent = new Intent();
            intent.setClass(this, CheckActivity.class);
            startActivity(intent);
        } else if (id == R.id.sidebar_course_book) {
            Intent intent = new Intent();
            intent.setClass(this, BookActivity.class);
            startActivity(intent);
        } else if (id == R.id.sidebar_course_search) {
            Intent intent = new Intent();
            intent.setClass(this, SearchActivity.class);
            startActivity(intent);
        } else if (id == R.id.sidebar_donate) {
            Intent intent = new Intent();
            intent.setClass(this, DonateActivity.class);
            startActivity(intent);
        } else if (id == R.id.sidebar_qa) {
            Intent intent = new Intent();
            intent.setClass(this, QaActivity.class);
            startActivity(intent);

        } else if (id == R.id.sidebar_main  ) {
            Intent intent = new Intent();
            intent.setClass(this, MainActivity.class);
            startActivity(intent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void turnSearchName(View v){
        String teaName = etName.getText().toString();
        AlertDialog.Builder ad = new AlertDialog.Builder(this);
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface di, int i) {
            }
        };
        switch(teaName){
            case "陳錫民":
                ad.setTitle("陳錫民");
                ad.setMessage("[物件導向設計]教概念，不難，可以學到東西，不要想躺著過");
                break;
            case "黃溪春":
                ad.setTitle("黃溪春");
                ad.setMessage("上很快，以為全班程度都很高\n有點枯燥，但教的還不錯，分數分明");
                break;
            default:
                ad.setTitle("查詢失敗");
                ad.setMessage("輸入錯誤 or 無資料");
                break;
        }
        ad.setPositiveButton("確定",listener);
        ad.show();
    }

    public void turnBookWeb(View v){
        Uri uri = Uri.parse("http://shakemylife.pixnet.net/blog/post/27321371");
        Intent intent = new Intent();
        intent.setAction(intent.ACTION_VIEW);
        intent.setData(uri);
        startActivity(intent);
    }
}
