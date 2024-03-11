package com.example.myapplication;

import android.util.Log;

public class PrimeNumberCheck {
    private String matriculationNumber;
    private String allPrimeNumbers = "These are the prime numbers : ";
    public PrimeNumberCheck(String matriculationNumber) {
        this.matriculationNumber = matriculationNumber;
    }

    public String checkPrimeNumbers(){
        if (matriculationNumber != null && matriculationNumber.length() > 0){


        String[] singleDigits = matriculationNumber.split("(?!^)");

        for (int i = 0; i < singleDigits.length; i++){
            int digit = Integer.parseInt(singleDigits[i]);
            if (isPrime(digit)){
            allPrimeNumbers += digit+",";
            }
        }
        Log.d("PrimeNumbers", "checkPrimeNumbers: "+ allPrimeNumbers);
        allPrimeNumbers = removeLastComma(allPrimeNumbers);
        }
        else {
            allPrimeNumbers = "Please enter a number first !";
        }

        if (allPrimeNumbers == "These are the prime numbers : "){
            allPrimeNumbers = "No prime numbers found";
        }

        return allPrimeNumbers;
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

    public static String removeLastComma(String str) {
        if (str.charAt(str.length() - 1) == ',') {
            return str.substring(0, str.length() - 1);
        }
        return str;
    }

}
