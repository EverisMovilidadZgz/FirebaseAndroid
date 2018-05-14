package com.everis.firebaseandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.firebase.iid.FirebaseInstanceId;

public class MainActivity extends AppCompatActivity {

    TextView tokenText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linkView();
        obtainToken();
    }

    private void linkView() {
        tokenText = findViewById(R.id.tokenPush);
    }

    private void obtainToken() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String token = FirebaseInstanceId.getInstance().getToken();
                if (token != null && !token.isEmpty()) {
                    tokenText.setText(token);
                }
            }
        }).run();
    }
}
