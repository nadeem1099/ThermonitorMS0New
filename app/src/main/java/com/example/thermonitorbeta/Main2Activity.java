package com.example.thermonitorbeta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;



public class Main2Activity extends AppCompatActivity {

    ListView listView;

    int[] Images = {R.drawable.iphone, R.drawable.blackberry, R.drawable.linux, R.drawable.android, R.drawable.windows};

    String[] Name = {"iPhone", "BlackBerry", "Linux", "Android", "Windows"};

        CustomAdapter customAdapter = new CustomAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(customAdapter);



        ArrayAdapter<String> adapter = new ArrayAdapter<>(Main2Activity.this, android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.Static_list));


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent int2 = new Intent(Main2Activity.this, Main3Activity.class);

                startActivity(int2);
            }
        });


    }

    class CustomAdapter extends BaseAdapter
    {

        @Override
        public int getCount() {
            return Images.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view = getLayoutInflater().inflate(R.layout.customizedlayout, null);
            ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
            TextView textView = (TextView) view.findViewById(R.id.textView);

            imageView.setImageResource(Images[position]);
            textView.setText(Name[position]);

            return view;
        }
    }
}
