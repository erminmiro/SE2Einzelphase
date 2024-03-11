package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private String matrNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button checkHowLong = findViewById(R.id.button);

        EditText inputField = findViewById(R.id.editTextNumber);

        TextView responseField = findViewById(R.id.responseField);

        Button checkPrimeButton = findViewById(R.id.primeButton);

        TextView primeResponseField = findViewById(R.id.primeResponseField);

        checkHowLong.setOnClickListener(v -> {
            try {
                String result = getTheTimeStudied(inputField.getText().toString());
                responseField.setText(result);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        checkPrimeButton.setOnClickListener(v -> {
            PrimeNumberCheck getPrimeNumbers = new PrimeNumberCheck(inputField.getText().toString());
            String result = getPrimeNumbers.checkPrimeNumbers();
            primeResponseField.setText(result);
        });

    }

    public String getTheTimeStudied(String matrNumber) throws InterruptedException {
        GetDateStudied getDateStudied = new GetDateStudied(matrNumber);
        Thread connectionThread = new Thread(getDateStudied);

        connectionThread.start();
        connectionThread.join();

        return getDateStudied.getResponse();
    }
}