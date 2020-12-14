package org.samriddhi.healthnepal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {

    RecyclerView rvCountry;

    ArrayList<CountryModel> countryData;

    RecyclerAdapter adapter;

    CustomItemAnimator animator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        rvCountry = (RecyclerView) findViewById(R.id.rv_country);

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

        CountryModel nepal2 = new CountryModel("https://cdn.countryflags.com/thumbs/nepal/flag-400.png",
                "Nepal","3,000,000,000","3.14","1990");
        countryData.add(nepal2);

        CountryModel india2 = new CountryModel("https://pngimg.com/uploads/flags/flags_PNG14590.png",
                "India","4,000,000,000","4.14","2000");
        countryData.add(india2);

        CountryModel china2 = new CountryModel("https://img.favpng.com/8/20/16/flag-of-china-national-emblem-of-the-peoples-republic-of-china-national-flag-png-favpng-WdRSRFEGZB93W3nAR2NF4KCAX.jpg",
                "China","5,000,000,000","5.14","2010");
        countryData.add(china2);

        CountryModel america2 = new CountryModel("https://pngimg.com/uploads/flags/flags_PNG14592.png",
                "America","10,000,000,000","8.14","1990");
        countryData.add(america2);

        adapter = new RecyclerAdapter(countryData);

        rvCountry.setLayoutManager(new LinearLayoutManager(this));
//        rvCountry.setLayoutManager(new GridLayoutManager(this, 2));

        animator = new CustomItemAnimator();

        rvCountry.setItemAnimator(animator);

        rvCountry.setAdapter(adapter);

        adapter.notifyDataSetChanged();

    }
}