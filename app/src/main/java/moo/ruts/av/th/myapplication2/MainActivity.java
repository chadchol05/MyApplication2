package moo.ruts.av.th.myapplication2;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer objbutt, objBG;
    private Button OK;
    private RadioGroup radioGroup;
    private EditText ET1, ET2;
    private Integer P_zaza;
    private String S_NAME, S_PASS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        objBG = MediaPlayer.create(getBaseContext(), R.raw.sounbg);
        objBG.start();

        ET1 = (EditText) findViewById(R.id.Username);
        ET2 = (EditText) findViewById(R.id.Password);
        radioGroup = (RadioGroup) findViewById(R.id.RBGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.radio1:
                        P_zaza = 1;
                        break;
                    case R.id.radio2:
                        P_zaza = 2;
                        break;
                     }
                }
            });

    }

    private void sounButt() {
        objbutt = MediaPlayer.create(getBaseContext(), R.raw.sounbutt);
        objbutt.start();
    }

    private void UN_PASS() {
        S_NAME = ET1.getText().toString().trim();
        S_PASS = ET2.getText().toString().trim();
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        intent.putExtra("Usname", S_NAME);
        intent.putExtra("Pass", S_PASS);

    }


    public void BUTOK(View view) {

        OK = (Button) findViewById(R.id.OK);
        OK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UN_PASS();
                sounButt();
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });

    }
}
