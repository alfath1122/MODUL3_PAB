package com.example.modul3_pab;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements TextWatcher {
    AutoCompleteTextView ac;
    public String[] stringdataprodi = {"Prodi Teknik Informatika", "Prodi Sistem Informasi",
            "Prodi Desain Komunikasi Visual", "Prodi Manajemen Informatika", "Prodi Teknik Sipil"};
    EditText lv;
    View mainView;
    int originalColor;

    @SuppressLint("MissingInflatedId")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainView = findViewById(R.id.main_view);

        originalColor = ((ColorDrawable)mainView.getBackground()).getColor();

        ac = findViewById(R.id.dataautocomplete);
        ac.addTextChangedListener(this);
        ac.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, stringdataprodi));
    }

    @Override
    protected void onPause() {
        super.onPause();
        mainView.setBackgroundColor(Color.GRAY);
        Toast.makeText(this, "Posisi lagi pause nih", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mainView.setBackgroundColor(originalColor);
        Toast.makeText(this, "Posisi lagi start nih", Toast.LENGTH_LONG).show();
    }

    public void pilihprodi(View v) {
        lv = findViewById(R.id.datalistview);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Data Prodi Fakultas Ilmu Komputer");
        builder.setItems(stringdataprodi, (dialog, item) -> {
            lv.setText(stringdataprodi[item]);
            dialog.dismiss();
        }).show();
    }

    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    public void afterTextChanged(Editable s) {
    }
}