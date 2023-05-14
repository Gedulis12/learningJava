package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Weather> weatherList;
    private WeatherDAO weatherDAO;
    private Button add;
    private PopupWindow popupWindow;
    private ListView listView;
    private CustomWeatherList customWeatherList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weatherDAO = new WeatherDAO(getApplicationContext());
        listView = findViewById(R.id.main_list);
        add = findViewById(R.id.main_button);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addPopup();
            }
        });

        weatherList = (ArrayList<Weather>) weatherDAO.readAll();

        // creating an adapter customWeatherList
        customWeatherList = new CustomWeatherList(MainActivity.this, weatherList, weatherDAO);
        listView.setAdapter(customWeatherList);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "You have selected: "
                        + weatherList.get(position).getCountryName() + " as country", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addPopup() {
        LayoutInflater layoutInflater = MainActivity.this.getLayoutInflater();
        View layout = layoutInflater.inflate(R.layout.edit_popup,
                (ViewGroup) MainActivity.this.findViewById(R.id.popup));
        popupWindow = new PopupWindow(layout, 600, 670, true);
        popupWindow.showAtLocation(layout, Gravity.CENTER, 0, 0);

        final EditText country = layout.findViewById(R.id.edit_country);
        final EditText degrees = layout.findViewById(R.id.edit_degrees);
        Button save = layout.findViewById(R.id.save_popup_button);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getCountry = country.getText().toString();
                String getDegrees = degrees.getText().toString();
                Weather weather = new Weather(getCountry, Double.parseDouble(getDegrees));
                weatherDAO.create(weather);

                if (customWeatherList == null) {
                    customWeatherList = new CustomWeatherList(
                            (Activity) getApplicationContext(), weatherList, weatherDAO);
                    listView.setAdapter(customWeatherList);
                }

                ArrayList<Weather> weatherListForSetter = (ArrayList<Weather>) weatherDAO.readAll();
                customWeatherList.setWeatherList(weatherListForSetter);

                ((BaseAdapter) listView.getAdapter()).notifyDataSetChanged();
                popupWindow.dismiss();
            }
        });
    }
}