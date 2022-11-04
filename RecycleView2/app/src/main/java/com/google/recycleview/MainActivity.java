package com.google.recycleview;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity {


    private RecyclerView rcvItem;
    private ItemAdapter mItemAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcvItem = findViewById(R.id.rcv_item);
        mItemAdapter = new ItemAdapter(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        rcvItem.setLayoutManager(gridLayoutManager);
        mItemAdapter.setData(getListItem());
        rcvItem.setAdapter(mItemAdapter);


    }
    private List<Item> getListItem() {
        List<Item> list =new ArrayList<>();
        list.add(new Item(R.drawable.img_introip_1,"Iphone"));
        list.add(new Item(R.drawable.img_introip2,"Iphone"));
        list.add(new Item(R.drawable.img_introip3,"Iphone"));


        list.add(new Item(R.drawable.img_intross1,"SamSung"));
        list.add(new Item(R.drawable.img_intross2,"SamSung"));
        list.add(new Item(R.drawable.img_intross3,"SamSung"));


        list.add(new Item(R.drawable.img_introxm1,"Xiaomi"));
        list.add(new Item(R.drawable.image_introxm2,"Xiaomi"));
        list.add(new Item(R.drawable.image_introxm3,"Xiaomi"));

        list.add(new Item(R.drawable.img_samsung,"Xiaomi"));
        list.add(new Item(R.drawable.img_introip_1,"Xiaomi"));
        list.add(new Item(R.drawable.img_intross2,"Xiaomi"));
        list.add(new Item(R.drawable.img_introip_1,"Iphone"));
        list.add(new Item(R.drawable.img_introip2,"Iphone"));
        list.add(new Item(R.drawable.img_introip3,"Iphone"));


        list.add(new Item(R.drawable.img_intross1,"SamSung"));
        list.add(new Item(R.drawable.img_intross2,"SamSung"));
        list.add(new Item(R.drawable.img_intross3,"SamSung"));


        list.add(new Item(R.drawable.img_introxm1,"Xiaomi"));
        list.add(new Item(R.drawable.image_introxm2,"Xiaomi"));
        list.add(new Item(R.drawable.image_introxm3,"Xiaomi"));

        list.add(new Item(R.drawable.img_samsung,"Xiaomi"));
        list.add(new Item(R.drawable.img_introip_1,"Xiaomi"));
        list.add(new Item(R.drawable.img_intross2,"Xiaomi"));
        return list;
    }
}