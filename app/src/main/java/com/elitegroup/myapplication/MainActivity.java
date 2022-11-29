package com.elitegroup.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.elitegroup.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Main2ViewModel main2ViewModel = ViewModelProviders.of(this).get(Main2ViewModel.class);
        Main3ViewModel main3ViewModel = ViewModelProviders.of(this).get(Main3ViewModel.class);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
       // binding.setViewmodel(main2ViewModel);
       // binding.executePendingBindings();
        binding.setViewmodel(main3ViewModel);
        binding.setLifecycleOwner(this);

        main3ViewModel.resultMessage.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                if(main3ViewModel.color.getValue()==R.color.white){
                    main3ViewModel.color.setValue(R.color.purple_500);
                }else{
                    main3ViewModel.color.setValue(R.color.white);
                }
            }
        });
    }
    @BindingAdapter({"resultmessagebind"})
    public static void runMe(View view,String message){
        if(message!=null)
            Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
    }
}