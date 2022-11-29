package com.elitegroup.myapplication;

import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main2ViewModel extends ViewModel {

    public ObservableField<Model> model = new ObservableField<>();

    String kislota = "kislota";
    String sheloch = "sheloch";
    String neitral = "neitral";
    String unknown = "unknown";
    String empty = "one of fields is empty";

    List<String> kisloti = new ArrayList<>(Arrays.asList("solkis","azotkis","serkis"));
    List<String> shelochi = new ArrayList<>(Arrays.asList("KOH","NAOH","LIOH"));
    List<String> all = new ArrayList<>();

    public Main2ViewModel() {
        all.addAll(kisloti);
        all.addAll(shelochi);
        model.set( new Model("",""));
    }
    


    public ObservableField<String> resultMessage= new ObservableField<>();
    

    public void ButtonClick(){
        if(!model.get().getFirstReactive().isEmpty() && !model.get().getSecondReactive().isEmpty()){
            if(all.stream().anyMatch(it-> it.equals(model.get().getFirstReactive())) && all.stream().anyMatch(it-> it.equals(model.get().getSecondReactive()))){
                if(shelochi.stream().anyMatch(it-> it.equals(model.get().getFirstReactive())) || shelochi.stream().anyMatch(it-> it.equals(model.get().getSecondReactive()))){
                    if(kisloti.stream().anyMatch(it-> it.equals(model.get().getFirstReactive())) || kisloti.stream().anyMatch(it-> it.equals(model.get().getSecondReactive()))){
                        resultMessage.set(neitral);
                    }else{
                        resultMessage.set(sheloch);
                    }
                }else{
                    resultMessage.set(kislota);
                }
            }else{
                resultMessage.set(unknown);
            }
        }else{
            resultMessage.set(empty);
        }
    }
}
