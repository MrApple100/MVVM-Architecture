package com.elitegroup.myapplication;

import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main3ViewModel extends ViewModel {

    public MutableLiveData<Model> model = new MutableLiveData<>();

    public MutableLiveData<Integer> color = new MutableLiveData<>();


    String kislota = "kislota";
    String sheloch = "sheloch";
    String neitral = "neitral";
    String unknown = "unknown";
    String empty = "one of fields is empty";

    List<String> kisloti = new ArrayList<>(Arrays.asList("solkis","azotkis","serkis"));
    List<String> shelochi = new ArrayList<>(Arrays.asList("KOH","NAOH","LIOH"));
    List<String> all = new ArrayList<>();

    public Main3ViewModel() {
        all.addAll(kisloti);
        all.addAll(shelochi);
        model.setValue( new Model("",""));
        color.setValue(R.color.white);
    }



    public MutableLiveData<String> resultMessage= new MutableLiveData<>();


    public void ButtonClick(){
        if(!model.getValue().getFirstReactive().isEmpty() && !model.getValue().getSecondReactive().isEmpty()){
            if(all.stream().anyMatch(it-> it.equals(model.getValue().getFirstReactive())) && all.stream().anyMatch(it-> it.equals(model.getValue().getSecondReactive()))){
                if(shelochi.stream().anyMatch(it-> it.equals(model.getValue().getFirstReactive())) || shelochi.stream().anyMatch(it-> it.equals(model.getValue().getSecondReactive()))){
                    if(kisloti.stream().anyMatch(it-> it.equals(model.getValue().getFirstReactive())) || kisloti.stream().anyMatch(it-> it.equals(model.getValue().getSecondReactive()))){
                        resultMessage.setValue(neitral);
                    }else{
                        resultMessage.setValue(sheloch);
                    }
                }else{
                    resultMessage.setValue(kislota);
                }
            }else{
                resultMessage.setValue(unknown);
            }
        }else{
            resultMessage.setValue(empty);
        }
    }
}
