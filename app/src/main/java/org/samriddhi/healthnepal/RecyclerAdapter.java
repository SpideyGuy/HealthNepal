package org.samriddhi.healthnepal;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.CountryViewHolder> {

    ArrayList<CountryModel> countryData;

    public RecyclerAdapter(ArrayList<CountryModel> countryModelData){
        this.countryData = countryModelData;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View countryList = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_country, viewGroup, false);
        CountryViewHolder countryViewHolder = new CountryViewHolder(countryList);
        return countryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder countryViewHolder, int position) {
        final CountryModel countryModel = countryData.get(position);
        countryViewHolder.countryName.setText(countryModel.getName());
        countryViewHolder.countryPopulation.setText(countryModel.getPopulation());
        countryViewHolder.countryGDP.setText(countryModel.getGDP());
        countryViewHolder.countryIndependence.setText(countryModel.getIndependenceSince());
        Picasso.get().load(countryModel.getCountryFlag()).into(countryViewHolder.countryFlag);

        countryViewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), countryModel.getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return countryData.size();
    }

    static class CountryViewHolder extends RecyclerView.ViewHolder{
        ImageView countryFlag;
        TextView countryName, countryPopulation, countryGDP, countryIndependence;

        LinearLayout linearLayout;

        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            this.countryFlag = (ImageView) itemView.findViewById(R.id.country_flag);
            this.countryName = (TextView) itemView.findViewById(R.id.country_name);
            this.countryPopulation = (TextView) itemView.findViewById(R.id.country_population);
            this.countryGDP = (TextView) itemView.findViewById(R.id.country_gdp);
            this.countryIndependence = (TextView) itemView.findViewById(R.id.country_independence);

            this.linearLayout = (LinearLayout) itemView.findViewById(R.id.lv_row);
        }
    }


}
