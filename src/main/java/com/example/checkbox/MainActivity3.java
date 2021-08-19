package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity3 extends AppCompatActivity {
    ListView bl1, bl2, bl3;
    TextView t_amt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        bl1 = findViewById(R.id.item);
        bl2 = findViewById(R.id.price);
        bl3 = findViewById(R.id.count);
        t_amt = findViewById(R.id.t5);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            List<String> final_items = bundle.getStringArrayList("final_items");
            List<Integer> final_price = bundle.getIntegerArrayList("final_price");
            List<Integer> final_count = bundle.getIntegerArrayList("final_count");
            Integer bill_amount = bundle.getInt("bill_amount");
            t_amt.setText(bill_amount.toString());
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, final_items);
            bl1.setAdapter(adapter);
            bl1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                }
            });
            ArrayAdapter<Integer> adapter1 = new ArrayAdapter<Integer>
                    (this, android.R.layout.simple_list_item_1, final_count);
            bl2.setAdapter(adapter1);
            bl2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                }
            });
            ArrayAdapter<Integer> adapter2 = new ArrayAdapter<Integer>
                    (this, android.R.layout.simple_list_item_1, final_price);
            bl3.setAdapter(adapter2);
            bl3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                }
            });

        }
    }
}