package me.sheharyar.sparkrelay;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.FragmentManager;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
//        FrameLayout container = (FrameLayout)findViewById(R.id.fragContainer);

        try {
            NoCoresFragment nocores = new NoCoresFragment();
            FragmentManager frgManager = getFragmentManager();
            FragmentTransaction trans = frgManager.beginTransaction();
            trans.replace(R.id.fragContainer, nocores);
            trans.commit();
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "error " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

}
