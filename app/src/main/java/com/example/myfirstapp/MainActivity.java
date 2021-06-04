package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mobile_tv;
    TextView email_tv;
    ImageView photo;
    Button call_bt;
    Button mail_bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mobile_tv = (TextView)findViewById(R.id.mobile_tv);
        email_tv=(TextView)findViewById(R.id.email_tv);
        photo=(ImageView)findViewById(R.id.photo_iv);
        call_bt=(Button)findViewById(R.id.call_bt);
        mail_bt=(Button)findViewById(R.id.mail_bt);

        mobile_tv.setText("123456789");
        email_tv.setText("abcd@gmail.com");
        photo.setImageResource(R.drawable.app);

        call_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number=mobile_tv.getText().toString();
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+number));
                startActivity(callIntent);
            }
        });

        mail_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String to=email_tv.getText().toString();
                String subject="for checking";
                String message="hi,how are you?";
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);
                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose an Email client :"));
            }
        });
    }
}