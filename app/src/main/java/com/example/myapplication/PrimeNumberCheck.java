package com.example.myapplication;

import android.util.Log;

public class PrimeNumberCheck {
    private String matriculationNumber;
    public PrimeNumberCheck(String matriculationNumber) {
        this.matriculationNumber = matriculationNumber;
    }

    public void checkPrimeNumbers(){
        String[] singleDigits = matriculationNumber.split("(?!^)");
        Log.d("PrimeNumbers", "checkPrimeNumbers: "+ singleDigits[1]+singleDigits[2]);

    }
}
