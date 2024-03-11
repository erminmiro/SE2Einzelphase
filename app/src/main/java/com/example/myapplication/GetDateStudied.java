package com.example.myapplication;

import android.util.Log;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class GetDateStudied implements Runnable{
    private String matriculationNumber;
    private String response;

    private final String uniIP = "se2-submission.aau.at";

    private final int port = 20080;
    public GetDateStudied(String matriculationNumber) {
        this.matriculationNumber = matriculationNumber;
    }

    @Override
    public void run() {
        try {
            Socket socket = new Socket(uniIP,port);

            DataOutputStream sendToServer = new DataOutputStream(socket.getOutputStream());
            BufferedReader getFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            sendToServer.writeBytes(this.matriculationNumber + '\n');

            response = getFromServer.readLine();

            Log.d("Response","Response from server : "+response);

        } catch (IOException e) {
            Log.d("Response","Response from server error ");
            throw new RuntimeException(e);
        }
    }
}
