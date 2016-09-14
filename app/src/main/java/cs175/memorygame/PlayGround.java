package cs175.memorygame;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class PlayGround extends AppCompatActivity implements View.OnClickListener {

    // All images data
    int[] imageIds = {
            R.drawable.china,
            R.drawable.finland,
            R.drawable.france,
            R.drawable.germany,
            R.drawable.greece,
            R.drawable.hongkong,
            R.drawable.india,
            R.drawable.japan,
            R.drawable.turkey,
            R.drawable.uk
    };

    // All locations of the imageButtons
    int[] locateIds = {
            R.id.image1,
            R.id.image2,
            R.id.image3,
            R.id.image4,
            R.id.image5,
            R.id.image6,
            R.id.image7,
            R.id.image8,
            R.id.image9,
            R.id.image10,
            R.id.image11,
            R.id.image12,
            R.id.image13,
            R.id.image14,
            R.id.image15,
            R.id.image16,
            R.id.image17,
            R.id.image18,
            R.id.image19,
            R.id.image20,
    };

    // Initial 20 space for picking random tiles
    private ArrayList<Integer> ary = new ArrayList<>(20);

    // Clicked status, default value set false
    private Boolean clicked = new Boolean(false);

    // Save picked random tiles set
    // HashMap <Integer: locationID , Integer: imageID>
    private HashMap<Integer, Integer> randomHM = new HashMap<>(20);


    // ImageButton array
    final ImageButton[] btns = new ImageButton[20];

    // Log information
    private static final String TAG = "LogInfo";

    // Game points
    private int score = 0;

    // Use to check both tiles if they are match
    //private ArrayList<Integer> pair = new ArrayList<>(2);
    private int[] pair = new int[2];

    // Integer number indicate how many in pair.
    private int isPairReady = 0;

    // Handler delay feature
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playground);

        // Adding all 20 tiles to ary
        for (int i = 0; i < imageIds.length; i++) {
            ary.add(imageIds[i]);
            ary.add(imageIds[i]); // add 2 sets images
        }

        // Initial property of all tiles, and generate randomSet
        for (int i = 0; i < btns.length; i++) {
            btns[i] = (ImageButton) findViewById(locateIds[i]);
            btns[i].setTag(clicked); // wasn't clicked

            Random generator = new Random();
            int index = generator.nextInt(ary.size());
            int randomImageId = ary.get(index);
            //randomSet[i] = randomImageId;
            randomHM.put(locateIds[i], randomImageId);
            //randomMap[i][0] = locateIds[i];
            //randomMap[i][1] = randomImageId;
            btns[i].setImageResource(R.drawable.back);
            btns[i].setOnClickListener(this);
            //Log.i(TAG,String.valueOf(ary.size()));
            //Log.i(TAG,String.valueOf(index));
            ary.remove(index);
        }

    }

    // Click event handle connection imageButton to randomSet
    // And implement flip over and flip back by setTag
    @Override
    public void onClick(View v) {

        int i = 0;
        switch (v.getId()) {
            case R.id.image1: i = 0;
                break;
            case R.id.image2: i = 1;
                break;
            case R.id.image3: i = 2;
                break;
            case R.id.image4: i = 3;
                break;
            case R.id.image5: i = 4;
                break;
            case R.id.image6: i = 5;
                break;
            case R.id.image7: i = 6;
                break;
            case R.id.image8: i = 7;
                break;
            case R.id.image9: i = 8;
                break;
            case R.id.image10: i = 9;
                break;
            case R.id.image11: i = 10;
                break;
            case R.id.image12: i = 11;
                break;
            case R.id.image13: i = 12;
                break;
            case R.id.image14: i = 13;
                break;
            case R.id.image15: i = 14;
                break;
            case R.id.image16: i = 15;
                break;
            case R.id.image17: i = 16;
                break;
            case R.id.image18: i = 17;
                break;
            case R.id.image19: i = 18;
                break;
            case R.id.image20: i = 19;
                break;
        }

        if (((Boolean)btns[i].getTag()) == false ) {
            btns[i].setImageResource(randomHM.get(v.getId()));
            btns[i].setTag(new Boolean(true));
        } else {
            btns[i].setImageResource(R.drawable.back);
            btns[i].setTag(new Boolean(false));
        }

        addPair(v.getId());
        if (isPairReady == 2) {

            // Delay 500ms to validate those 2 tiles
            handler.postDelayed(matchValidate, 500);
            clearPair();
        }
    }

    private Runnable matchValidate = new Runnable() {
        @Override
        public void run() {
            matchCheck();
        }
    };

    private void addPair(int item) {
        if(isPairReady == 0) {
            pair[0] = item;
        } else if (isPairReady == 1) {
            pair[1] = item;
        }
        isPairReady++;
        Log.i(TAG,"addPair: " +randomHM.get(item)+ " how many Pair = "+isPairReady);
    }

    private void removeTile(int item) {
        ImageButton needRemove = (ImageButton) findViewById(item);
        needRemove.setVisibility(View.INVISIBLE);
        Log.i(TAG,"remove: " +randomHM.get(item));
    }

    private void recoverTile(int item) {
        ImageButton needRecover = (ImageButton) findViewById(item);
        needRecover.setImageResource(R.drawable.back);
        needRecover.setTag(new Boolean(false));
        Log.i(TAG,"recover: " +randomHM.get(item));
    }

    private void clearPair() {
        isPairReady -= 2;
        Log.i(TAG,"clearPair!");
    }

    private void matchCheck() {
        if(randomHM.get(pair[0]).equals(randomHM.get(pair[1]))) {
            score++;
            updateScore();
            removeTile(pair[0]);
            removeTile(pair[1]);
        } else {
            recoverTile(pair[0]);
            recoverTile(pair[1]);
        }
    }

    private void updateScore() {
        TextView s = (TextView) findViewById(R.id.score);
        s.setText(String.valueOf(score));
    }
}
