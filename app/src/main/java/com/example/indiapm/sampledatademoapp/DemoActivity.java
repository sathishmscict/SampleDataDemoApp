package com.example.indiapm.sampledatademoapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Button;


import com.example.indiapm.sampledatademoapp.adapter.DemoAdapter;
import com.example.indiapm.sampledatademoapp.model.NotificationsData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import butterknife.BindView;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class DemoActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rvDemo)
    RecyclerView mRvDemo;
    @BindView(R.id.btnExams)
    Button btnExams;
    private DemoAdapter mAdatpter;
    private String TAG = DemoActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRvDemo.setLayoutManager(linearLayoutManager);

        loadJSONFromAsset();


        try {
            String dateStr = "2018-07-19 09:01:00 AM";//Jul 19, 2018 05:26 AM
            SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss a");
            df.setTimeZone(TimeZone.getTimeZone("UTC"));
            Date date = df.parse(dateStr);
            df.setTimeZone(TimeZone.getDefault());
            String formattedDate = df.format(date);
            if (BuildConfig.DEBUG) {

                Log.d(TAG, formattedDate);
            }

           /* SimpleDateFormat FORMATTING_PATTERN = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            FORMATTING_PATTERN.setTimeZone(TimeZone.getTimeZone("UTC"));
            Date UTCdate = FORMATTING_PATTERN.parse(mWsNotification.getOnDateTime());
            FORMATTING_PATTERN.setTimeZone(TimeZone.getDefault());
            String formattedDate = FORMATTING_PATTERN.format(UTCdate);
            Date Localdate = FORMATTING_PATTERN.parse(formattedDate);
            String strDate = TimeAgo.using(Localdate.getTime());
            mWsNotification.setStrDate(strDate);
            temp.add(mWsNotification);
            AppGlobal.printLog(TAG ,"Beautiful date" + strDate);*/


        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("notifications.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
            Gson gson = new GsonBuilder().create();
            NotificationsData notificationsData = gson.fromJson(json, NotificationsData.class);
            mAdatpter = new DemoAdapter(this, notificationsData.getMemberNotifications());
            mRvDemo.setAdapter(mAdatpter);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    @OnClick(R.id.btnExams)
    public void onViewClicked() {

    }
}
