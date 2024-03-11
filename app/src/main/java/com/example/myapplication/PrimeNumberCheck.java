package com.example.myapplication;

import android.util.Log;

public class PrimeNumberCheck {
    private String matriculationNumber;
    private String allPrimeNumbers = "";
    public PrimeNumberCheck(String matriculationNumber) {
        this.matriculationNumber = matriculationNumber;
    }

    public void checkPrimeNumbers(){
        String[] singleDigits = matriculationNumber.split("(?!^)");

        for (int i = 0; i < singleDigits.length; i++){
            int digit = Integer.parseInt(singleDigits[i]);
            if (isPrime(digit)){
            allPrimeNumbers += digit;
            }
        }
        Log.d("PrimeNumbers", "checkPrimeNumbers: "+ allPrimeNumbers);
    }

    //Algorithm found on https://www.geeksforgeeks.org/prime-numbers/
    public boolean isPrime(int digit){
        if (digit <= 1)
            return false;

        for (int i = 2; i <= Math.sqrt(digit); i++)
            if (digit % i == 0)
                return false;

        return true;
    }
}
