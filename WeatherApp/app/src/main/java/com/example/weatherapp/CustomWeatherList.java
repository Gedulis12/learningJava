package com.example.weatherapp;

import android.app.Activity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.ArrayList;

// CustomWeatherList is an adapter which connects data from sqlite with xml views
public class CustomWeatherList extends BaseAdapter {

    private Activity context;
    private ArrayList<Weather> weatherList;
    private PopupWindow popupWindow;
    private WeatherDAO weatherDAO;

    public CustomWeatherList() {
    }

    public CustomWeatherList(Activity context, ArrayList<Weather> weatherList, WeatherDAO weatherDAO) {
        this.context = context;
        this.weatherList = weatherList;
        this.weatherDAO = weatherDAO;
    }

    public void setWeatherList(ArrayList<Weather> weatherList) {
        this.weatherList = weatherList;
    }

    // has all GUI elements inside (view of a row_item)
    public static class ViewHolder {
        TextView textViewId;
        TextView textViewCountry;
        TextView textViewDegrees;
        Button editButton;
        Button deleteButton;
    }


    @Override
    public int getCount() {
        return weatherList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    // this method will link variables in ViewHolder class and GUI elements (row_item.xml)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        LayoutInflater inflater = context.getLayoutInflater();
        ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            row = inflater.inflate(R.layout.row_item, null, true);

            viewHolder.textViewId = row.findViewById(R.id.id);
            viewHolder.textViewCountry = row.findViewById(R.id.country_name);
            viewHolder.textViewDegrees = row.findViewById(R.id.degrees);
            viewHolder.editButton = row.findViewById(R.id.edit_button);
            viewHolder.deleteButton = row.findViewById(R.id.delete_button);

            // saves holder with views
            row.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // filling view with entries from db
        viewHolder.textViewId.setText("" + weatherList.get(position).getId());
        viewHolder.textViewCountry.setText(weatherList.get(position).getCountryName());
        viewHolder.textViewDegrees.setText("" + weatherList.get(position).getDegrees());

        final int positionPopup = position;

        viewHolder.editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editPopupWindow(positionPopup);
            }
        });

        viewHolder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weatherDAO.delete(weatherList.get(positionPopup));

                // list must be refreshed after each deletion
                weatherList = (ArrayList<Weather>) weatherDAO.readAll();
                notifyDataSetChanged();
            }
        });

        return row;
    }

    private void editPopupWindow(final int positionPopup) {
        // popup window created
        LayoutInflater layoutInflater = context.getLayoutInflater();
        View layout = layoutInflater.inflate(R.layout.edit_popup,
                (ViewGroup) context.findViewById(R.id.popup));
        popupWindow = new PopupWindow(layout, 600, 670, true);
        popupWindow.showAtLocation(layout, Gravity.CENTER, 0, 0);

        // linking code with view
        final EditText country = layout.findViewById(R.id.edit_country);
        final EditText degrees = layout.findViewById(R.id.edit_degrees);
        Button save = layout.findViewById(R.id.save_popup_button);
        country.setText(weatherList.get(positionPopup).getCountryName());
        degrees.setText("" + weatherList.get(positionPopup).getDegrees());

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getCountry = country.getText().toString();
                String getDegrees = degrees.getText().toString();
                Weather weather = weatherList.get(positionPopup);
                weather.setCountryName(getCountry);
                weather.setDegrees(Double.parseDouble(getDegrees));

                weatherDAO.update(weather);

                // after editing view must be refreshed
                weatherList = (ArrayList<Weather>) weatherDAO.readAll();
                notifyDataSetChanged();

                popupWindow.dismiss();
            }
        });
    }
}
