package crayon.airtime;

import android.app.IntentService;
import android.content.Intent;
import android.media.AudioManager;
import android.provider.SyncStateContract;
import android.util.Log;
import android.view.KeyEvent;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class ControllerService extends IntentService {
    public static final String TAG = "ControllerService";

    Socket s;
    DataInputStream dIn;
    OutputStream outputStream;
    PrintWriter printWriter;


    public ControllerService() {
        super(TAG);
        Log.e(TAG,"Constructor");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String ip = "10.42.0.1" ;
        if(intent.hasExtra("SERVER_IP_EXTRA"))
            ip = intent.getStringExtra("SERVER_IP_EXTRA");
        int PORT_NO = intent.getIntExtra("SERVER_PORT", 6000);

        Log.e(TAG,"Service started with ip:"+ip+":"+PORT_NO);

        int message = 0;

        try {
            InetAddress inetAddress = InetAddress.getByName(ip);
            s = new Socket(inetAddress, PORT_NO);
            BufferedReader bReader = new BufferedReader(new InputStreamReader(s.getInputStream()));
            outputStream = s.getOutputStream();
            printWriter = new PrintWriter(outputStream, true);
            String line;
            while(true) {
                if((line = bReader.readLine()) != null) {

                }
            }
//            s.close();

        } catch (Exception e) {
            Log.e(TAG, "Exception " + e);
        }
    }
}