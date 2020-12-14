package org.samriddhi.healthnepal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    ListView lvData;

    CustomAdapter customAdapter;

    ArrayList<CountryModel> countryData;

//    String[] countries = {"Nepal","India","China","America","Australia",
//            "Nepal","India","China","America","Australia"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        lvData = (ListView) findViewById(R.id.lv_data);

//        ArrayAdapter countryAdapter = new ArrayAdapter(ListActivity.this,
//                android.R.layout.simple_list_item_2, countries);
//        lvData.setAdapter(countryAdapter);

        countryData = new ArrayList<>();

        CountryModel nepal = new CountryModel("https://cdn.countryflags.com/thumbs/nepal/flag-400.png",
                "Nepal","3,000,000,000","3.14","1990");
        countryData.add(nepal);

        CountryModel india = new CountryModel("https://pngimg.com/uploads/flags/flags_PNG14590.png",
                "India","4,000,000,000","4.14","2000");
        countryData.add(india);

        CountryModel china = new CountryModel("https://img.favpng.com/8/20/16/flag-of-china-national-emblem-of-the-peoples-republic-of-china-national-flag-png-favpng-WdRSRFEGZB93W3nAR2NF4KCAX.jpg",
                "China","5,000,000,000","5.14","2010");
        countryData.add(china);

        CountryModel america = new CountryModel("https://pngimg.com/uploads/flags/flags_PNG14592.png",
                "America","10,000,000,000","8.14","1990");
        countryData.add(america);

        customAdapter = new CustomAdapter(countryData, ListActivity.this);

        lvData.setAdapter(customAdapter);


        lvData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                CountryModel countryModel = (CountryModel) adapterView.getItemAtPosition(position);
                Toast.makeText(ListActivity.this,countryModel.getPopulation(), Toast.LENGTH_SHORT).show();
            }
        });



//        lvData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                CountryModel countryModel = (CountryModel) adapterView.getItemAtPosition(i);
//                Toast.makeText(ListActivity.this, countryModel.getName(), Toast.LENGTH_SHORT).show();
//            }
//        });

    }
}