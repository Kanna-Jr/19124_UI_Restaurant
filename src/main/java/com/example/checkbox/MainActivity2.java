package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    ListView listView1,listView2;
    CheckBox j_cb1,j_cb2,j_cb3,j_cb4;
    Button j_computeb,j_checkout;
    Spinner j_s1,j_s2,j_s3,j_s4;
    List<Integer> bill_cnt=new ArrayList<Integer>();
    List<String> bill_item=new ArrayList<String>();
    List<Integer> bill_price=new ArrayList<Integer>();

    String menu[]={"American Cheese Supreme Burger","Pizza","Garlic Bread Sticks","Hot Chocolate"};
    Integer price[]={160,220,120,115};
    String count[]={"1","2","3","4","5"};
    int final_amount=0,flag=0;
    TextView j_disp;

    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle b=getIntent().getExtras();
        String name =b.getString("user");
        t1=findViewById(R.id.msg);
        String message="Welcome "+name;
        t1.setText(message);


        j_disp=findViewById(R.id.amount_textview);
        listView1=findViewById(R.id.lv1);
        listView2=findViewById(R.id.lv2);
        j_cb1=findViewById(R.id.cb1);
        j_cb2=findViewById(R.id.cb2);
        j_cb3=findViewById(R.id.cb3);
        j_cb4=findViewById(R.id.cb4);
        j_computeb=findViewById(R.id.computeb);
        j_checkout=findViewById(R.id.b_checkout);
        j_s1=findViewById(R.id.sp1);
        j_s2=findViewById(R.id.sp2);
        j_s3=findViewById(R.id.sp3);
        j_s4=findViewById(R.id.sp4);
        j_s1.setOnItemSelectedListener(this);
        j_s2.setOnItemSelectedListener(this);
        j_s3.setOnItemSelectedListener(this);
        j_s4.setOnItemSelectedListener(this);
        ArrayAdapter spinner_adapter=new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,count);


        spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        j_s1.setAdapter(spinner_adapter);
        j_s2.setAdapter(spinner_adapter);
        j_s3.setAdapter(spinner_adapter);
        j_s4.setAdapter(spinner_adapter);
        j_computeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(j_cb1.isChecked())
                {
                    String temp_count=j_s1.getSelectedItem().toString();
                    int temp_append_c=Integer.parseInt(temp_count);
                    final_amount+=temp_append_c*150;
                    bill_cnt.add(temp_append_c);
                    bill_item.add(menu[0]);
                    bill_price.add(price[0]*temp_append_c);

                }
                if(j_cb2.isChecked())
                {
                    String temp_count=j_s2.getSelectedItem().toString();
                    int temp_append_c=Integer.parseInt(temp_count);
                    final_amount+=temp_append_c*40;
                    bill_cnt.add(temp_append_c);
                    bill_item.add(menu[1]);
                    bill_price.add(price[1]*temp_append_c);

                }
                if(j_cb3.isChecked())
                {
                    String temp_count=j_s3.getSelectedItem().toString();
                    int temp_append_c=Integer.parseInt(temp_count);
                    final_amount+=temp_append_c*20;
                    bill_cnt.add(temp_append_c);
                    bill_item.add(menu[2]);
                    bill_price.add(price[2]*temp_append_c);

                }
                if(j_cb4.isChecked())
                {
                    String temp_count=j_s4.getSelectedItem().toString();
                    int temp_append_c=Integer.parseInt(temp_count);
                    final_amount+=temp_append_c*300;
                    bill_cnt.add(temp_append_c);
                    bill_item.add(menu[3]);
                    bill_price.add(price[3]*temp_append_c);

                }
                j_disp.setText(Integer.toString(final_amount));
                flag=1;

            }
        });
        j_checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag==1)
                {
                    Bundle bundle=new Bundle();
                    bundle.putIntegerArrayList("final_price", (ArrayList<Integer>) bill_price);
                    bundle.putStringArrayList("final_items", (ArrayList<String>) bill_item);
                    bundle.putIntegerArrayList("final_count", (ArrayList<Integer>) bill_cnt);
                    bundle.putInt("bill_amount",final_amount);
                    Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    setContentView(R.layout.activity_main3);

                }
            }
        });

        ArrayAdapter<String> adapter=new ArrayAdapter<String>
                (this,android.R.layout.simple_list_item_1,menu);
        listView1.setAdapter(adapter);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
        ArrayAdapter<Integer> adapter1=new ArrayAdapter<Integer>
                (this,android.R.layout.simple_list_item_1,price);
        listView2.setAdapter(adapter1);
        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
