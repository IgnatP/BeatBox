package com.ivpomazkov.beatbox;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ivpomazkov on 18.05.2016.
 */
public class BeatBox {
    private static final String TAG = "BeatBox";
    private static final String SOUNDS_FOLDER = "sample_sounds";
    private List<Sound> mSounds = new ArrayList<>();

    private AssetManager mAssets;

    public BeatBox(Context context){
        mAssets = context.getAssets();
        loadSounds();
    }

    private void loadSounds(){
        String[] soundNames;
        try{
            soundNames = mAssets.list(SOUNDS_FOLDER);
            Log.i("info", "Found " + soundNames.length + " sounds");
        } catch (IOException e){
            Log.e("exception", "Couldn't list assets", e);
            return;
        }

        for ( String fileName : soundNames ){
            String assethPath = SOUNDS_FOLDER + "/" + fileName;
            Sound sound = new Sound(assethPath);
            mSounds.add(sound);
        }

    }

    public List<Sound> getSounds() {
        return mSounds;
    }
}
