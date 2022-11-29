package com.elitegroup.myapplication;

import android.text.TextUtils;

import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainViewModel extends BaseObservable {

    Model model;

    String kislota = "kislota";
    String sheloch = "sheloch";
    String neitral = "neitral";
    String unknown = "unknown";
    String empty = "one of fields is empty";

    List<String> kisloti = new ArrayList<>(Arrays.asList("solkis","azotkis","serkis"));
    List<String> shelochi = new ArrayList<>(Arrays.asList("KOH","NAOH","LIOH"));
    List<String> all = new ArrayList<>();

    public MainViewModel() {
        all.addAll(kisloti);
        all.addAll(shelochi);
        model = new Model("","");
    }

    @Bindable
    public String getFirstReactive() {
        return model.firstReactive;
    }

    public void setFirstReactive( String firstReactive) {
        model.firstReactive = firstReactive;
        notifyPropertyChanged(BR.firstReactive);
    }

    @Bindable
    public String getSecondReactive() {
        return model.secondReactive;
    }

    public void setSecondReactive( String secondReactive) {
        model.secondReactive = secondReactive;
        notifyPropertyChanged(BR.secondReactive);
    }

    @Bindable
    String resultMessage=null;

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
        notifyPropertyChanged(BR.resultMessage);
    }

    public void ButtonClick(){
        if(!getFirstReactive().isEmpty() && !getSecondReactive().isEmpty()){
            if(all.stream().anyMatch(it-> it.equals(getFirstReactive())) && all.stream().anyMatch(it-> it.equals(getSecondReactive()))){
                if(shelochi.stream().anyMatch(it-> it.equals(getFirstReactive())) || shelochi.stream().anyMatch(it-> it.equals(getSecondReactive()))){
                    if(kisloti.stream().anyMatch(it-> it.equals(getFirstReactive())) || kisloti.stream().anyMatch(it-> it.equals(getSecondReactive()))){
                        setResultMessage(neitral);
                    }else{
                        setResultMessage(sheloch);
                    }
                }else{
                    setResultMessage(kislota);
                }
            }else{
                setResultMessage(unknown);
            }
        }else{
            setResultMessage(empty);
        }
    }
}
