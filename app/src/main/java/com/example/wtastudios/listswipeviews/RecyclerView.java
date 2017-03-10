package com.example.wtastudios.listswipeviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.tubb.smrv.SwipeMenuRecyclerView;

import java.util.ArrayList;

public class RecyclerView extends AppCompatActivity {
    EditText etAddItems;
    Button btnAdd;
    ArrayList<String> listData = new ArrayList<>();
    String name = "";
    RecyclerAdapter adapter;
    protected SwipeMenuRecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        etAddItems = (EditText) findViewById(R.id.etAddItem);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        mRecyclerView = (SwipeMenuRecyclerView) findViewById(R.id.listView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerAdapter(this, listData, mRecyclerView);
        mRecyclerView.setAdapter(adapter);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = etAddItems.getText().toString();
                if (name.length() != 0) {
                    listData.add(name);
                    etAddItems.setText("");
//                Toast.makeText(RecyclerView.this, "updated  -  "+name, Toast.LENGTH_SHORT).show();
                    adapter.notifyData(listData);
                }
            }
        });
    }


}
