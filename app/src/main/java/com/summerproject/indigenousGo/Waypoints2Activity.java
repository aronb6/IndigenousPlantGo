package com.summerproject.indigenousGo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.content.res.TypedArray;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class Waypoints2Activity extends AppCompatActivity {

    private CustomAdapter adapter;
    private ListView listView;

    String[] waypointNames = {"Plants", "Lavender","Kinnikinnick","Strawberry","Salal","Snowberry",
            "Tobacco", "PointsofInterest", "TieredGardens", "TheGatheringPlace", "TheHousePost",
            "TheSweatLodge"};

    //Plants
    private final LatLng LAVENDER  = new LatLng(49.254500, -122.998250);
    private final LatLng KINNIKINNICK = new LatLng(49.253722, -122.998167);
    private final LatLng STRAWBERRY = new LatLng(49.253667, -123.001333);
    private final LatLng SALAL = new LatLng(49.251508, -123.003891);
    private final LatLng SNOWBERRY = new LatLng(49.253667, -122.998167);
    private final LatLng TOBACCO = new LatLng(49.245982, -122.998682);

    //Points of Interest
    private final LatLng TIEREDGARDENS = new LatLng(49.250428, -123.002965);
    private final LatLng THEGATHERINGPLACE = new LatLng(49.2508575,-123.0030182);
    private final LatLng THEHOUSEPOST = new LatLng(49.2511455,-123.0031097);
    private final LatLng THESWEATLODGE = new LatLng(49.245982, -122.998682);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waypoints2);

        adapter = new CustomAdapter();
        listView = (ListView) findViewById(R.id.listView);

        ArrayList<Item> waypointList = new ArrayList<Waypoints2Activity.Item>();
        // Header
        waypointList.add(new SectionItem("Plants"));
        // Waypoint Name
        waypointList.add(new EntryItem("Lavender"));
        waypointList.add(new EntryItem("Kinnikinnick"));
        waypointList.add(new EntryItem("Strawberry"));
        waypointList.add(new EntryItem("Salal"));
        waypointList.add(new EntryItem("Snowberry"));
        waypointList.add(new EntryItem("Tobacco"));

        // Header
        waypointList.add(new SectionItem("Points of Interest"));
        // Waypoint Name
        waypointList.add(new EntryItem("Tiered Gardens"));
        waypointList.add(new EntryItem("The Gathering Place"));
        waypointList.add(new EntryItem("The House Post"));
        waypointList.add(new EntryItem("The Sweat Lodge"));

        // set adapter
        final WaypointAdapter adapter = new WaypointAdapter(this, waypointList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                Intent intent = new Intent(Waypoints2Activity.this, MapActivity.class);
                intent.putExtra("name", waypointNames[position]);
                startActivity(intent);

                //String number = String.valueOf(id);

                //Toast.makeText(Waypoints2Activity.this, number, Toast.LENGTH_SHORT).show();


            }

        });

    }
    /**
     * row item
     */
    public interface Item {
        public boolean isSection();
        public String getTitle();
    }

    /**
     * Section Item
     */
    public class SectionItem implements Item {
        private final String title;

        public SectionItem(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        @Override
        public boolean isSection() {
            return true;
        }
    }

    /**
     * Entry Item
     */
    public class EntryItem implements Item {
        public final String title;

        public EntryItem(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        @Override
        public boolean isSection() {
            return false;
        }
    }

    /**
     * Adapter
     */
    public class WaypointAdapter extends BaseAdapter {
        private Context context;
        private ArrayList<Item> item;
        private ArrayList<Item> originalItem;

        public WaypointAdapter() {
            super();
        }

        public WaypointAdapter(Context context, ArrayList<Item> item) {
            this.context = context;
            this.item = item;
            //this.originalItem = item;
        }

        @Override
        public int getCount() {
            return item.size();
        }

        @Override
        public Object getItem(int position) {
            return item.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (item.get(position).isSection()) {
                // if section header
                convertView = inflater.inflate(R.layout.layout_section, parent, false);
                TextView tvSectionTitle = (TextView) convertView.findViewById(R.id.listSectionTitle);
                tvSectionTitle.setText(((SectionItem) item.get(position)).getTitle());
            }
            else
            {
                // if item
                convertView = inflater.inflate(R.layout.layout_waypointitem, parent, false);
                TextView tvItemTitle = (TextView) convertView.findViewById(R.id.listItemTitle);
                tvItemTitle.setText(((EntryItem) item.get(position)).getTitle());
            }

            return convertView;
        }
    }
}