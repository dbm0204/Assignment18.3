package com.example.dbm0204.assignment183;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * The main activity extends the AppCompactAcitivity and instantiates the Notification Instance
 */
public class MainActivity extends AppCompatActivity {
    private Button ShowNotificationBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ShowNotificationBtn =(Button) findViewById(R.id.show);
        ShowNotificationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent resultIntent = new Intent(getApplicationContext(),ResultClass.class);
                resultIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                PendingIntent piResult = PendingIntent.getActivity(getApplicationContext(), 0, resultIntent, 0);

                Notification.Builder builder = new Notification.Builder(getApplicationContext())
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("ContentTitle")
                        .setContentText("ContentText")
                        .setContentIntent(piResult);

                //Here we add the text that needs to be added to the notification Box
                Notification notification = new Notification.InboxStyle(builder)
                        .addLine("Helloo..!")
                        .addLine("How are you?")
                        .addLine("Hi!!")
                        .addLine("I am Fine...")
                        .addLine("What about you? all is well")
                        .addLine("Yes every thing is all right")
                        .setBigContentTitle("Event Details")
                        .setSummaryText("+3 more")
                        .build();
                NotificationManager notificationManager =(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(121,notification);

            }
        });
    }

}
