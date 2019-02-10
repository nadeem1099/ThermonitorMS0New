package com.example.thermonitorbeta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Main2Activity extends AppCompatActivity {

    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listView = (ListView)findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(Main2Activity.this, android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.Static_list));


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent int2 = new Intent(Main2Activity.this, Main3Activity.class);
                int2.putExtra("OStype",listView.getItemAtPosition(position).toString());
                startActivity(int2);
            }
        });

        listView.setAdapter(adapter);
    }
}
