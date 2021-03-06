package events.tgh2020.sc;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

public class Call {
    private SoundPool soundPool;
    private int soundId;
    private int streamId;

    public Call(Context context) {
        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        soundId = soundPool.load(context,R.raw.sound1, 1);
    }

    public void play() {
        streamId = soundPool.play(soundId, 1.0f, 1.0f, 0, -1, 1.0f);
    }

    public void stop() {
        soundPool.stop(streamId);
    }
}
