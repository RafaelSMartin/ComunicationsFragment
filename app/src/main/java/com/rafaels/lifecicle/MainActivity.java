package com.rafaels.lifecicle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CustomDialog.OnCompleteListener {

    MainFragment mainFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mainFragment = (MainFragment) getSupportFragmentManager().findFragmentByTag(MainFragment.TAG);

        if(mainFragment == null){
            mainFragment = new MainFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_root, mainFragment, MainFragment.TAG)
                    .commit();
        }


    }


    @Override
    public void onCompleteCustomDialog(String text, int modo) {
        mainFragment.onCompleteCustomDialog(text, modo);
    }

}
