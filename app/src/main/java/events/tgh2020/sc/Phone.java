package events.tgh2020.sc;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Phone extends AppCompatActivity {
    Call callInstance;
    private TextView textRead;
    private SharedPreferences dataStore;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phone);

        textRead = findViewById(R.id.text_read);
        dataStore = MainActivity.getDataStore();
        String str = dataStore.getString("input", "Nothing");
        if(!str.equals("Nothing")) {
            textRead.setText(str);
        }

        callInstance = MainActivity.getCall();

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // クリック時の処理
                callInstance.stop();
            }
        });

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            callInstance.stop();
            Intent intent = new Intent(Phone.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            return true;
        }
        return false;
    }

}