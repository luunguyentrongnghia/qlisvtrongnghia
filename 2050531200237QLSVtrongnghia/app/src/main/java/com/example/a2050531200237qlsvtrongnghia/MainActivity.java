package com.example.a2050531200237qlsvtrongnghia;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private SQLiteDatabase db;
    private ListView lvUser;
    private EditText editName, editDes;
    private ArrayAdapter<User> adapter;
    private ArrayList<User> userList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
//        insertTest();
        editName = findViewById(R.id.editName);
        editDes = findViewById(R.id.editDes);

        findViewById(R.id.bthAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertRow();
                loadData();
            }
        });

        lvUser = findViewById(R.id.lvUser);
        adapter = new ArrayAdapter<User>(this,0,userList ){

            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.data_item,null);

                TextView tvName = convertView.findViewById(R.id.tvName);
                TextView tvDes = convertView.findViewById(R.id.tvDes);

                User u =  userList.get(position);
                tvName.setText(u.getName());
                tvDes.setText(u.getDes());

                return convertView;
            }
        };
        lvUser.setAdapter(adapter);
        lvUser.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                deleteUser(position);
                loadData();
                return false;
            }
        });
        loadData();

    }
    private void initData(){
        db = openOrCreateDatabase("smartphone.db",MODE_PRIVATE,null );
        String sql = "CREATE TABLE IF NOT EXISTS tbsmartphone (id integer primary key autoincrement,name text, des text)";
        db.execSQL(sql);

    }
    private void insertRow(){
        String name = editName.getText().toString();
        String des = editDes.getText().toString();
        String sql = "INSERT INTO tbsmartphone (name,des) VALUES ('" + name + "','" + des + "')";
        db.execSQL(sql);
    }
    private void deleteUser(int position){
        int id = userList.get(position).getId();
        String sql = "DELETE FROM tbsmartphone WHERE id = " + id;
        db.execSQL(sql);
    }
    private void loadData(){
        userList.clear();
        String sql = "SELECT * FROM tbsmartphone";
        Cursor cursor = db.rawQuery(sql, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String des = cursor.getString(2);
            String data = id + " - " + name + " - " + des + "\n";
            User u = new User();
            u.setId(id);
            u.setName(name);
            u.setDes(des);

            userList.add(u);
            cursor.moveToNext();
        }
        adapter.notifyDataSetChanged();

    }
}