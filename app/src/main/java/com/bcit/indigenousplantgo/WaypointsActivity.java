package com.bcit.indigenousplantgo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.widget.ListView;

public class WaypointsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waypoints);

        ListView listview ;
        ListViewAdapter adapter;

        // Adapter 생성
        adapter = new ListViewAdapter() ;

        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) findViewById(R.id.listview1);
        listview.setAdapter(adapter);

        // 첫 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.way1),
                "This house post was commissioned to mark the British Columbia Institute of Technology’s 50th anniversary.", "Find Me") ;
        // 두 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.way2),
                "Through cultural and educational activities, the Gathering Place creates a sense of inclusion and belonging for Indigenous students.", "Find Me") ;
        // 세 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.way3),
                "A lodge ceremony is a gentle and caring approach to the cleansing of your mind, body, and spirit.", "Find Me") ;

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.way5),
                "Will contain corn, bean and squash for the three sisters.", "Find Me") ;
    }
}
