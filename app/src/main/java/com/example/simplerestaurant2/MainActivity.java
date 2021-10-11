package com.example.simplerestaurant2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;



import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    protected EditText getChicken;
    protected Button requestButton, sendRequestToCook;
    protected TextView txt;
    protected TextView quality;
    protected Button servePreparedFoodToTheCustomers;
    protected TextView txtEggQuality;
    protected EditText getEgg;
    protected String fooBar;
    protected int highQuality=0;
    protected int lowQuality=0;
    protected Spinner drinkable;
    Random getEggQuality;
    String foo, fool="";

    ArrayList<String> list=new ArrayList<>();
    ArrayList<String> drinkList;
    int count=0;
    Random eggQuality;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getChicken = findViewById(R.id.getChicken);
        requestButton = findViewById(R.id.requestButton);
        sendRequestToCook = findViewById(R.id.sentRequestToCook);
        txt = findViewById(R.id.txt);
        quality = findViewById(R.id.quality);
        servePreparedFoodToTheCustomers = findViewById(R.id.servePreparedFoodToTheCustomers);
        getEgg = findViewById(R.id.getEgg);
        drinkable = findViewById(R.id.drinkable);
        txtEggQuality = findViewById(R.id.tztQuality);
        requestButton.setOnClickListener(this);
        sendRequestToCook.setOnClickListener(this);
        servePreparedFoodToTheCustomers.setOnClickListener(this);
        txtEggQuality.setText(R.string.txtEggQuality);
        drinkList = new ArrayList<>();
        drinkList.add("No drink");
        drinkList.add("Tea");
        drinkList.add("Coca Cola");
        drinkList.add("Pepsi");

        ArrayAdapter<String> drinkAdapter = new ArrayAdapter<> (
            this,
            android.R.layout.simple_spinner_dropdown_item,
                drinkList
        );
        fool="";
        drinkable.setAdapter(drinkAdapter);

        drinkable.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                fool = drinkList.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent){}
        });

    }



    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.requestButton:
                foo="";
                count++;
                String getString = getChicken.getText().toString();
                int getQuantity = Integer.parseInt(getString);
                String getEg = getEgg.getText().toString();
                int eggQuantity = Integer.parseInt(getEg);
                lowQuality +=eggQuantity;
                foo += "Customer " + count + ": ordered " + getQuantity + " chickens, " + eggQuantity + " eggs, " + fool + " for drink\n";
                list.add(foo);
                txt.setText("");
                fool = "";
                break;
            case R.id.sentRequestToCook:
                eggQuality = new Random();
                getEggQuality = new Random();
                highQuality =lowQuality + getEggQuality.nextInt(100 - 33) + 33;
                int result = eggQuality.nextInt(highQuality  - lowQuality) + lowQuality;
                String resultInString = String.valueOf(result);
                quality.setText(resultInString);
                fooBar = "";
                for(int i=0; i<list.size(); i++){
                    fooBar += list.get(i);
                }
                break;
            case R.id.servePreparedFoodToTheCustomers:
                txt.setText(fooBar);
                count=0;
                list.clear();
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()){
            case R.id.settings_menu:
                Toast.makeText(this, "item Settings is clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.alarm_menu:
                Toast.makeText(this, "item alarm is selected", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}
