package com.example.finalprojet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.finalprojet.Adapter.CatergoryAdapter;
import com.example.finalprojet.Domain.CategoryDomain;

import java.util.ArrayList;

public class Order extends AppCompatActivity {
    private RecyclerView.Adapter adapter,adapter2;
    private RecyclerView recyclerViewCategory,recyclerViewPopularList;
    private TextView name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_LTR);


        recyclerViewCategory();
        name = findViewById(R.id.name);

        try   {
            Bundle extras = getIntent().getExtras();
            String sentText = extras.getString("TextToSend");
            String msg = "Welcome "+ sentText ;
            name.setText(msg);
            //  Toast.makeText(this, sentText, Toast.LENGTH_SHORT).show();
        } catch (RuntimeException e) {

            e.printStackTrace();
        }
    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCategory = findViewById(R.id.view1);
        recyclerViewCategory.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> categoryList = new ArrayList<>();
        categoryList.add(new CategoryDomain("Pizza","cat_1"));
        categoryList.add(new CategoryDomain("Bugger","cat_2"));
        categoryList.add(new CategoryDomain("Chicken","cat_3"));
        categoryList.add(new CategoryDomain("HotDog","cat_4"));

        adapter = new CatergoryAdapter(categoryList);
        recyclerViewCategory.setAdapter(adapter);
    }
}