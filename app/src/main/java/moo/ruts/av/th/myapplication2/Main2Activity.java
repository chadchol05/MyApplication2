package moo.ruts.av.th.myapplication2;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Main2Activity extends AppCompatActivity {

    public FirebaseDatabase firebaseDatabase;
    public DatabaseReference led1,led2;
    public static final String TAG="LED Control";
    public Button Switch1,Switch2;
    public Integer Value0,Value1,Value2;
    public TextView TX1,TX2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        firebaseDatabase = FirebaseDatabase.getInstance();
        led1 = firebaseDatabase.getReference("Home/led1");
        led2 = firebaseDatabase.getReference("Home/led2");

        Switch1 = (Button) findViewById(R.id.button);
        led1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Value0 = dataSnapshot.getValue(Integer.class);
                if (Value0==1){
                    Switch1.setText("led1-ON");
                    Value1=0;
                }else {
                    Switch1.setText("led_OFF");
                    Value1=1;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        Switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                led1.setValue(Value1);
            }
        });//end buttonled1

        Switch2 = (Button) findViewById(R.id.button2);
        led2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Value0 = dataSnapshot.getValue(Integer.class);
                if (Value0==1){
                    Switch2.setText("led1-ON");
                    Value2=0;
                }else {
                    Switch2.setText("led_OFF");
                    Value2=1;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        Switch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                led2.setValue(Value2);
            }
        });//end buttonled2

    }

    public void ClicHOME (View view){
        Intent intent = new Intent(Main2Activity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

}
