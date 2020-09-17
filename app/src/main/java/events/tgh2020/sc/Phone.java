package events.tgh2020.sc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Phone extends AppCompatActivity {
    Call callInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phone);

        callInstance = new Call(getApplicationContext());

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // クリック時の処理
                callInstance.stop();
            }
        });

    }

}