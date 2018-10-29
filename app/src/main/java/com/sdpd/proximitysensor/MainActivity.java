package com.sdpd.proximitysensor;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ProximitySensor proximitySensor;

    private TextView distText;

    private void initialise() {
        proximitySensor=new ProximitySensor(this);
        distText=(TextView)findViewById(R.id.dist);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialise();
    }

    @Override
    protected void onResume() {
        super.onResume();
        proximitySensor.registerProximitySensorListener();
    }

    @Override
    protected void onPause() {
        super.onPause();
        proximitySensor.unregisterProximitySensorListener();
    }

    public void updateText(float distance) {
        if (distance<(float)5)
            distText.setText("close");
        else
            distText.setText("far");
    }
}
