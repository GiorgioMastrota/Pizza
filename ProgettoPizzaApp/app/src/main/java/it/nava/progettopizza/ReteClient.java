package it.nava.progettopizza;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Nava_Stefano
 */
public class ReteClient implements Runnable {

    private Socket socket;
    private BufferedReader input;

    public static final int SERVERPORT = 3333;
    public static final String SERVER_IP = "127.0.0.1";

    public static final String TAG = ReteClient.class.getSimpleName();

    @Override
    public void run() {
        try {
            InetAddress serverAddr = InetAddress.getByName(SERVER_IP);
            socket = new Socket(serverAddr, SERVERPORT);

            while (!Thread.currentThread().isInterrupted()) {

                Log.i(TAG, "Waiting for message from server...");

                this.input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String message = input.readLine();
                Log.i(TAG, "Message received from the server : " + message);

                if (null == message || "Disconnect".contentEquals(message)) {
                    Thread.interrupted();
                    message = "Server Disconnected.";
                    updateMessage(getTime() + " | Server : " + message);
                    break;
                }

                updateMessage(getTime() + " | Server : " + message);

            }

        } catch (UnknownHostException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }

    void sendMessage(String message) {
        try {
            if (null != socket) {
                PrintWriter out = new PrintWriter(new BufferedWriter(
                        new OutputStreamWriter(socket.getOutputStream())),
                        true);
                out.println(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    String getTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(new Date());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != clientThread) {
            clientThread.sendMessage("Disconnect");
            clientThread = null;
        }
    }
}
