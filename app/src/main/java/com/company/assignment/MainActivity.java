package com.company.assignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
Button btnSubmit,btnView;
EditText name,day,month,year,email;
DatabaseReference databaseUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSubmit = findViewById(R.id.btnsubmit);
        btnView = findViewById(R.id.btnview);
        name = findViewById(R.id.edtname);
        day = findViewById(R.id.edtday);
        month = findViewById(R.id.edtmonth);
        year = findViewById(R.id.edtyear);
        email= findViewById(R.id.edtemail);
        databaseUser= FirebaseDatabase.getInstance().getReference();

btnSubmit.setOnClickListener(new View.OnClickListener(){
    @Override
    public void onClick(View v){
        InsertData();
    }
});

btnView.setOnClickListener(new View.OnClickListener(){
    @Override
    public void onClick(View v){
        startActivity(new Intent(MainActivity.this,UserList.class));
        finish();
    }
});


    }

    private void InsertData(){
        String username = name.getText().toString();
        String userday = day.getText().toString();
        String usermonth = month.getText().toString();
        String useryear = year.getText().toString();
        String useremail = email.getText().toString();
        String id = databaseUser.push().getKey();

        User user = new User(username,userday,usermonth,useryear,useremail);
        databaseUser.child("users").child(id).setValue(user)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "User details submitted", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}