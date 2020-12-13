package org.samriddhi.healthnepal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

class CustomAdapter extends BaseAdapter {

    private ArrayList<CountryModel> countryData;
    Context mContext;


    public CustomAdapter(@NonNull ArrayList<CountryModel> data,Context context) {
        this.countryData = data;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return countryData.size();
    }

    @Override
    public CountryModel getItem(int position) {
        return countryData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(mContext)
                    .inflate(R.layout.row_country, parent,false);
        }

        CountryModel countryModel = getItem(position);

        ImageView countryFlag = (ImageView) convertView.findViewById(R.id.country_flag);

        TextView countryName = (TextView) convertView.findViewById(R.id.country_name);
        TextView countryPopulation = (TextView) convertView.findViewById(R.id.country_population);
        TextView countryGDP = (TextView) convertView.findViewById(R.id.country_gdp);
        TextView countryIndependence = (TextView) convertView.findViewById(R.id.country_independence);

        Picasso.get().load(countryModel.getCountryFlag()).into(countryFlag);

        countryName.setText("Country Name: " + countryModel.getName());
        countryPopulation.setText("Country Population: " + countryModel.getPopulation());
        countryGDP.setText("Country GDP: " + countryModel.getGDP());
        countryIndependence.setText("Independence: " + countryModel.getIndependenceSince());

        return convertView;

    }
}
