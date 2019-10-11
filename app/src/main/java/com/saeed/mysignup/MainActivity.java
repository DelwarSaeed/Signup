package com.saeed.mysignup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    private EditText firstName,lastName,email,password;
    private AutoCompleteTextView bloodGroup;
    private CheckBox condition;
    private Button Submit;
    private String [] bloodgroup ={"A+","A-","B+","B-","AB+","AB-"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        ArrayAdapter adapter= new ArrayAdapter(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,bloodgroup);
        bloodGroup.setAdapter(adapter);
        bloodGroup.setThreshold(1);

        condition.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean check) {
                if(check == true){
                    Submit.setVisibility(View.VISIBLE);
                }else{
                    Submit.setVisibility(View.GONE);
                }
            }
        });

       Submit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(firstName.length()==0){
                   firstName.setError("Enter Firstname");
               }else if(lastName.length()==0){
                   lastName.setError("Enter Lastnamee");
               }else if(email.length()==0){
                   email.setError("Enteer email");
               }else if(password.length()==0){
                   password.setError("Enteer password");
               }else if(bloodGroup.length()==0){
                   bloodGroup.setError("Enteer bloodGroup");
               }else {
                   Toast.makeText(MainActivity.this,"Successfully SignUp",Toast.LENGTH_LONG).show();
               }
           }
       });
    }

    private void init() {
        firstName=findViewById(R.id.firstEt);
        lastName=findViewById(R.id.lastEt);
        email=findViewById(R.id.emailEt);
        password=findViewById(R.id.passwordEt);
        bloodGroup=findViewById(R.id.bloodACTV);
        condition=findViewById(R.id.conditionCB);
        Submit=findViewById(R.id.btn);
    }
}
