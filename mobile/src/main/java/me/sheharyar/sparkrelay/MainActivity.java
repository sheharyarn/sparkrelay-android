package me.sheharyar.sparkrelay;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;


public class MainActivity extends Activity {
    SQLiteDatabse my_cores = openOrCreateDatabase("spark_core_db", MODE_PRIVATE, null);
    final FragmentManager fragManager = getFragmentManager();
    final NoCoresFragment nocores = new NoCoresFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragManager.beginTransaction().replace(R.id.fragContainer, nocores).commit();

    }

}
