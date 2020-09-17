package events.tgh2020.sc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static Call callInstance = null;

    private SharedPreferences dataStore;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataStore = getSharedPreferences("DataStore", MODE_PRIVATE);
        editText = findViewById(R.id.edit_text);

        callInstance = new Call(getApplicationContext());

        Button buttonWrite = findViewById(R.id.button_write);
        buttonWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // エディットテキストのテキストを取得
                String text = editText.getText().toString();
                // 入力文字列を"input"に書き込む
                SharedPreferences.Editor editor = dataStore.edit();
                editor.putString("input", text);
                //editor.commit();
                editor.apply();
            }
        });

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
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