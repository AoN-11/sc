package events.tgh2020.sc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static Call callInstance = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        callInstance = new Call(getApplicationContext());

        findViewById(R.id.imageButton2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // クリック時の処理
                callInstance.play();
                Intent intent = new Intent(getApplication(), Phone.class);
                startActivity(intent);
            }
        });

    }

    public static Call getCall() {
        return callInstance;
    }
}