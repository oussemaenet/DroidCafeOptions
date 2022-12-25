package com.example.android.droidcafeoptions;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.icu.text.DateFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DatePickerDialogFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        // Créez une nouvelle instance de DatePickerDialog et définissez cet objet comme étant l'écouteur de date
        Calendar calendar = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            calendar = Calendar.getInstance();
        }
        int year = 0;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            year = calendar.get(Calendar.YEAR);
        }
        int month = 0;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            month = calendar.get(Calendar.MONTH);
        }
        int day = 0;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            day = calendar.get(Calendar.DAY_OF_MONTH);
        }
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
        Calendar calendar = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            calendar = Calendar.getInstance();
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            calendar.set(Calendar.YEAR, year);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            calendar.set(Calendar.MONTH, month);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        }

        // Affichez la date choisie dans un message Toast
        String dateString = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            dateString = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        }
        Toast.makeText(getActivity(), "Date sélectionnée: " + dateString, Toast.LENGTH_SHORT).show();
    }
}

