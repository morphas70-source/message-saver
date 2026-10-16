package com.messagesaver.app;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.provider.Settings;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(32, 48, 32, 32);

        TextView title = new TextView(this);
        title.setText("Message Saver ❤️");
        title.setTextSize(26);
        layout.addView(title);

        TextView info = new TextView(this);
        info.setText(
            "உன் போனுக்கு வந்த notifications-ஐ " +
            "அனுமதியுடன் சேமிக்க உதவும் app."
        );
        info.setTextSize(18);
        layout.addView(info);

        Button settingsButton = new Button(this);
        settingsButton.setText("Notification Settings திற");
        settingsButton.setOnClickListener(v -> {
            Intent intent =
                new Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS);
            startActivity(intent);
        });
        layout.addView(settingsButton);

        setContentView(layout);
    }
}
