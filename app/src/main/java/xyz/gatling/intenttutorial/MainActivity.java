package xyz.gatling.intenttutorial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Call one of the methods below
//        usePlainIntent();
        useIntentWithBundle();
//        useIntentWithParcelable();
    }

    private void usePlainIntent(){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    private void useIntentWithBundle(){
        Intent intent = new Intent(this, SecondActivity.class);

        Bundle bundle = new Bundle();
        bundle.putString("key_1", "value_1");
        bundle.putInt("key_2", 2);
        bundle.putBoolean("key_3", false);

        intent.putExtras(bundle);
        startActivity(intent);
    }

    private void useIntentWithParcelable(){
        Intent intent = new Intent(this, SecondActivity.class);

        ParcelableItem parcelableItem = new ParcelableItem("something", 2);
        intent.putExtra("someKey", parcelableItem);

        startActivity(intent);
    }
}
