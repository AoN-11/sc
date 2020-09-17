package events.tgh2020.sc;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Phone extends AppCompatActivity {
    Button stopbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phone);

        stopbutton = (Button) findViewById(R.id.button3);
    }

}