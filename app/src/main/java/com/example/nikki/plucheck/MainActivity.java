package com.example.nikki.plucheck;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private SQLiteHelper sqLiteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textViewSearch = (TextView) findViewById(R.id.textViewSearch);
        TextView textViewSaved = (TextView) findViewById(R.id.textViewSaved);

        textViewSearch.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view) {
                Intent intent = new Intent(MainActivity.this , SearchActivity.class);
                startActivity(intent);
            }
        });


        textViewSaved.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view) {
                Intent intent = new Intent(MainActivity.this , SavedActivity.class);
                startActivity(intent);
            }
        });

        final EditText editTextBrand = (EditText) findViewById(R.id.editTextBrand);
        final EditText editTextProductName = (EditText) findViewById(R.id.editTextProductName);
        final EditText editTextSKU = (EditText) findViewById(R.id.editTextSKU);
        final EditText editTextPLU = (EditText) findViewById(R.id.editTextPLU);
        Button buttonAdd = (Button) findViewById(R.id.buttonadd);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Brand = editTextBrand.getText().toString();
                String Product = editTextProductName.getText().toString();
                String SKU  = editTextSKU.getText().toString();
                String PLU = editTextPLU.getText().toString();
                //Check here if got mistake
                Fresh newproduct = new Fresh (Brand ,Product, SKU, PLU);
                sqLiteHelper.insertRecord(newproduct);
            }
        });
    }
}
