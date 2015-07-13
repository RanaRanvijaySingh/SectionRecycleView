package com.sectionrecycleview;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private String jsonData = "{\"status\":\"200\",\"message\":\"success\",\"data\":[\n" +
            "{\"startDate\":1000001,\"endDate\":1000002,\"workshops\":\n" +
            "[{\"date\":1000001,\"time\":\"2:30pm - 7:30pm\",\"location\":\"Koregaon Park\",\"city\":\"Pune\",\"builderCount\":12,\"registeredBuyerCount\":120,\"isRegistered\":true},{\"date\":1000001,\"time\":\"2:30pm - 7:30pm\",\"location\":\"Koregaon Park\",\"city\":\"Pune\",\"builderCount\":12,\"registeredBuyerCount\":120,\"isRegistered\":true},{\"date\":1000001,\"time\":\"2:30pm - 7:30pm\",\"location\":\"Koregaon Park\",\"city\":\"Pune\",\"builderCount\":12,\"registeredBuyerCount\":120,\"isRegistered\":true},{\"date\":1000001,\"time\":\"2:30pm - 7:30pm\",\"location\":\"Koregaon Park\",\"city\":\"Pune\",\"builderCount\":12,\"registeredBuyerCount\":120,\"isRegistered\":true}]},{\"startDate\":1000001,\"endDate\":1000002,\"workshops\":\n" +
            "[{\"date\":1000001,\"time\":\"2:30pm - 7:30pm\",\"location\":\"Koregaon Park\",\"city\":\"Pune\",\"builderCount\":12,\"registeredBuyerCount\":120,\"isRegistered\":false}]},\n" +
            "{\"startDate\":1000001,\"endDate\":1000002,\"workshops\":\n" +
            "[{\"date\":1000001,\"time\":\"2:30pm - 7:30pm\",\"location\":\"Koregaon Park\",\"city\":\"Pune\",\"builderCount\":12,\"registeredBuyerCount\":120,\"isRegistered\":true},{\"date\":1000001,\"time\":\"2:30pm - 7:30pm\",\"location\":\"Koregaon Park\",\"city\":\"Pune\",\"builderCount\":12,\"registeredBuyerCount\":120,\"isRegistered\":true}]},{\"startDate\":1000001,\"endDate\":1000002,\"workshops\":\n" +
            "[{\"date\":1000001,\"time\":\"2:30pm - 7:30pm\",\"location\":\"Koregaon Park\",\"city\":\"Pune\",\"builderCount\":12,\"registeredBuyerCount\":120,\"isRegistered\":false}]}]}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeComponents();
    }

    private void initializeComponents() {
        JsonDataModel jsonDataModel = new Gson().fromJson(jsonData,JsonDataModel.class);
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager =  new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        MyRecycleViewAdapter adapter = new MyRecycleViewAdapter(this,jsonDataModel.getData());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }
}
