package com.example.nikki.plucheck;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {
    private SQLiteHelper sqLiteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        sqLiteHelper = new SQLiteHelper(SearchActivity.this);

        ArrayList<Fresh> products = sqLiteHelper.getAllRecords();

        ProductsAdapter adapter = new ProductsAdapter(this, products);

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter (adapter);
    }
}
