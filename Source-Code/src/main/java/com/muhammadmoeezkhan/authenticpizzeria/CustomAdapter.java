package com.muhammadmoeezkhan.authenticpizzeria;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {

    //Member Variables
    private Context context;
    private List<Pizza> pizzas;

    public CustomAdapter(Context context, List<Pizza> pizzas) {
        this.context = context;
        this.pizzas = pizzas;
    }

    @Override
    public int getCount() {
        return pizzas.size();
    }

    @Override
    public Object getItem(int position) {
        return pizzas.get(position);
    }

    @Override
    public long getItemId(int position) {
        //for ArrayList/List type Custom Adapter:
        // always return the index/position
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.listview_pizzas_row, parent, false);
        }
        Pizza thisPizza= pizzas.get(position);

        TextView pizzaName = convertView.findViewById(R.id.textview_pizza_name);
        TextView pizzaDescription = convertView.findViewById(R.id.textview_pizza_description);
        RatingBar pizzaRating = convertView.findViewById(R.id.ratingbar_pizza_rating);

        pizzaName.setText(thisPizza.getName());
        pizzaDescription.setText(thisPizza.getDescription());
        pizzaRating.setRating(thisPizza.getRating());

        return convertView;
    }

}
