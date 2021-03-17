package app.shopsgod.partner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {




    /**
     * Permissions that need to be explicitly requested from end user.
     */

    ProgressBar progressBar;
    TextView per;
    int progressStatus = 0;
    Handler handler = new Handler();
    public String mytoken;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        per = (TextView) findViewById(R.id.loadper);
        progressBar=(ProgressBar)findViewById(R.id.horprogress);



        new Thread(new Runnable() {
            public void run() {
                while (progressStatus < 100)
                {
                    progressStatus += 1;
                    handler.post(new Runnable()
                    {
                        public void run()
                        {
                            progressBar.setProgress(progressStatus);
                            per.setText(progressStatus + "%");
                        }
                    });
                    try
                    {
                        Thread.sleep(20);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
                if (progressStatus==100)
                {

                    Intent i = new Intent(Welcome.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        }).start();







    }



}
