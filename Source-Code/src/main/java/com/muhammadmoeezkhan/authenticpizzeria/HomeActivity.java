package com.muhammadmoeezkhan.authenticpizzeria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.muhammadmoeezkhan.authenticpizzeria.databinding.ActivityHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding binding;

    //Click Listener
    private AdapterView.OnItemClickListener listViewPizzas_onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int index, long id) {
            String pizzaName = adapterView.getItemAtPosition(index).toString();
            //Test ListView Selection
            Log.d("PizzeriaApp", String.valueOf(index) +  " : " + pizzaName);
        }
    };

    public List<Pizza> generatePizzaList(){
        ArrayList<Pizza> myList = new ArrayList<Pizza>();

        myList.add(new Pizza("Margherita", "Tomato sauce, mozzarella, and oregano", 4.2f));
        myList.add(new Pizza("Marinara", "Tomato sauce, garlic, and basil", 4.9f));
        myList.add(new Pizza("Frutti de Mare", "Tomato sauce and seafood", 4.5f));
        myList.add(new Pizza("Crudo", "Tomato sauce, mozzarella, and Parma ham", 3.0f));
        myList.add(new Pizza("Napoletana", "Tomato sauce, mozzarella, oregano, and anchovies", 1.9f));
        myList.add(new Pizza("Pugliese", "Tomato sauce, mozzarella, oregano, and onions", 2.7f));

        return myList;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        List<Pizza> myList = generatePizzaList();
        CustomAdapter myAdapter = new CustomAdapter(this, myList);
        binding.listviewPizzas.setAdapter(myAdapter);

        //String[] myArray = new String[]{"Margherita", "Quattro Stagioni", "Carbonara", "Frutti di Mare", "Quattro Formaggi", "Crudo", "Napoletana", "Pugliese", "Montanara", "Emiliana"};
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,myArray);
        //binding.listviewPizzas.setAdapter(adapter);
        //binding.listviewPizzas.setOnItemClickListener(listViewPizzas_onItemClickListener);
    }
}