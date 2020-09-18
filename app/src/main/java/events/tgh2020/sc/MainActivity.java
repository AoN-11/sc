package events.tgh2020.sc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static Call callInstance = null;
    private static SharedPreferences dataStore = null;
    private EditText editText;
    final int length = Toast.LENGTH_SHORT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataStore = getSharedPreferences("DataStore", MODE_PRIVATE);
        editText = findViewById(R.id.edit_text);

        final Context context = getApplicationContext();
        final CharSequence text = "Completed";
        final int duration = Toast.LENGTH_SHORT;

        final Toast toast = Toast.makeText(context, text, duration);
        //toast.setGravity(Gravity.TOP|Gravity.LEFT,100,200);

        Button buttonWrite = findViewById(R.id.button_write);
        buttonWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                // エディットテキストのテキストを取得
                String text = editText.getText().toString();
                // 入力文字列を"input"に書き込む
                SharedPreferences.Editor editor = dataStore.edit();
                editor.putString("input", text);
                //editor.commit();
                editor.apply();
                toast.show();
            }
        });

        callInstance = new Call(getApplicationContext());

        findViewById(R.id.imageButton2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlphaAnimation aanim1 = new AlphaAnimation(1, 0.2f);
                int duration = 400;
                int delay = 6400;
                aanim1.setDuration( duration );
                aanim1.setRepeatCount( delay / duration );
                aanim1.setRepeatMode( Animation.REVERSE );
                ((ImageView)findViewById(R.id.imageButton2)).startAnimation(aanim1);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // クリック時の処理
                        callInstance.play();
                        Intent intent = new Intent(getApplication(), Phone.class);
                        startActivity(intent);
                    }
                }, delay);
            }
        });

    }

    public static Call getCall() {
        return callInstance;
    }

    public static SharedPreferences getDataStore() {
        return dataStore;
    }
}