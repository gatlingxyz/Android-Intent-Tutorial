package xyz.gatling.intenttutorial;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by tavongatling on 2/12/17.
 */

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Call the method which corresponds with how you started this Activity
//        fromPlainIntent();
        fromIntentWithBundle();
//        fromIntentWithParcelable();
    }

    private void fromPlainIntent(){
        //Nothing to do here. We didn't pass any extra information.
    }

    private void fromIntentWithBundle(){
        Bundle extras = getIntent().getExtras();

        String someString = extras.getString("key_1");
        int someInt = extras.getInt("key_2");
        boolean someBoolean = extras.getBoolean("key_3");
        /*
            I believe all the .get's on a Bundle allow you to set a default value
            that will be returned in case the key you provided doesn't exist
            inside the bundle.
         */
        String someStringYouDidntPass = extras.getString("key_4", "defaultValue");

        /*
            You can check these by opening up "Android Monitor" at the bottom, and searching
            for your Tag. In the following example, just search for "SecondActivity."
         */
        Log.v("SecondActivity", "someString = " + someString);
        Log.v("SecondActivity", "someInt = " + someInt);
        Log.v("SecondActivity", "someBoolean = " + someBoolean);
        Log.v("SecondActivity", "someStringYouDidntPass = " + someStringYouDidntPass);
    }

    private void fromIntentWithParcelable(){
        ParcelableItem parcelableItem = getIntent().getParcelableExtra("someKey");

        Log.v("SecondActivity", "someString = " + parcelableItem.getSomeString());
        Log.v("SecondActivity", "someInt = " + parcelableItem.getSomeInt());
    }
}
