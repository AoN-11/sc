package events.tgh2020.sc;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

public class Call {
    private SoundPool soundPool;
    private int soundId;

    public Call(Context context) {
        SoundPool soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        soundId = soundPool.load(context,R.raw.Telephone-Ringtone01-1, 1);
    }


    public void play() {
        soundPool.play(soundId, 1.0f, 1.0f, 0, 0, 1.0f);
    }
}
