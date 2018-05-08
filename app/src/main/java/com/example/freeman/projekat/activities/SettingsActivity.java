package com.example.freeman.projekat.activities;

import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.os.Bundle;

import com.example.freeman.projekat.R;
import android.app.DatePickerDialog;


import java.util.Calendar;
import android.widget.DatePicker;

public class SettingsActivity extends PreferenceActivity implements android.app.DatePickerDialog.OnDateSetListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //nema vise ovoga jer se koristi androidov fajl za izgled, da bi podesavanja izgledala isto u svim aplikacijama
        //setContentView(R.layout.activity_settings);
        addPreferencesFromResource(R.xml.preferences);

        Preference btnDateFilter = (Preference) findPreference("filterDatuma");
        //listener za klik na preferencu
        btnDateFilter.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {

            @Override
            public boolean onPreferenceClick(Preference preference) {
                showDateDialog();
                return false;
            }
        });

    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        //Logika nakon setovanja datuma
        //Log.i("dasd","year "+i+" month "+i2+" day "+i3);
    }

    private void showDateDialog(){
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        new DatePickerDialog(this,this, year, month, day).show();

    }

    @Override
    protected void onStart() {
        super.onStart();


    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }


    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }
}
