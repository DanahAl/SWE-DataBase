package com.example.softwarelab4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button JoinButton ;
    EditText customerName , CustomerAge;
    Switch activeSwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JoinButton = findViewById(R.id.Joinbutton);
        customerName = findViewById(R.id.customerName) ;
        CustomerAge = findViewById(R.id.CustomerAge);
        activeSwitch = findViewById(R.id.actveSwitch);

        JoinButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CustomerModel cm;
               // Toast.makeText(MainActivity.this , "view all button" ,Toast.LENGTH_SHORT).show();

                try{
                    cm = new CustomerModel(-1,customerName.getText().toString(),Integer.parseInt(CustomerAge.getText().toString()),activeSwitch.isChecked());
                    Toast.makeText(MainActivity.this , cm.toString(), Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(MainActivity.this , "Enter Valid input" , Toast.LENGTH_SHORT) .show();
                  cm = new CustomerModel(-1 , "Error" , 0 , false);
                }

                DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this);

               boolean sucess =  dataBaseHelper.addOne(cm);
               Toast.makeText(MainActivity.this , "Success= "+ sucess , Toast.LENGTH_SHORT).show();
            }
    });




    }
}