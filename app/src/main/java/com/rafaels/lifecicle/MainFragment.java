package com.rafaels.lifecicle;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Indogroup02 on 02/02/2018.
 */

public class MainFragment extends Fragment implements
        CustomDialog.OnCompleteListener
{

    public static final String TAG = "MAIN_FRAGMENT";
    private AppCompatActivity activity;

    private TextView textView;


    /**
     * LifeCile of creations
     *
     **/

    @Override
    public void onAttach (Context context){
        super.onAttach(context);
        this.activity = (AppCompatActivity) context;
        Toast.makeText(activity,"onAttach",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(activity,"onCreate",Toast.LENGTH_SHORT).show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        Toast.makeText(activity,"onCreateView",Toast.LENGTH_SHORT).show();

        textView = (TextView) view.findViewById(R.id.textView);

        Button bDialog = (Button) view.findViewById(R.id.dialog);

        bDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialog.startCustomDialog(activity, "Custom Title", "Custom Tesxt", "Text", 0 );
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Toast.makeText(activity,"onViewCreated",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        Toast.makeText(activity,"onActivityCreated",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStart(){
        super.onStart();
        Toast.makeText(activity, "onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume(){
        super.onResume();
        Toast.makeText(activity,"onResume",Toast.LENGTH_SHORT).show();
    }

    /**
     *
     * LifeCicle of destruction
     *
     ***/
    @Override
    public void onPause(){
        Toast.makeText(activity, "onPause", Toast.LENGTH_SHORT).show();
        super.onPause();
    }

    @Override
    public void onStop(){
        Toast.makeText(activity, "onStop", Toast.LENGTH_SHORT).show();
        super.onStop();
    }

    @Override
    public void onDestroyView(){
        Toast.makeText(activity, "onDestroyView", Toast.LENGTH_SHORT).show();
        super.onDestroyView();
    }


    @Override
    public void onDestroy(){
        Toast.makeText(activity, "onDestroy", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    @Override
    public void onDetach(){
        Toast.makeText(activity,"onDetach",Toast.LENGTH_SHORT).show();
        super.onDetach();
        activity = null;
    }


    @Override
    public void onCompleteCustomDialog(String text, int modo) {
         textView.setText(text);
    }
}
