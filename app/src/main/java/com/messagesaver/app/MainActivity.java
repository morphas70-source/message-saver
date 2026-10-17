package com.messagesaver.app;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ScrollView;

public class MainActivity extends Activity {

    private LinearLayout layout;
    private TextView messages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ScrollView scroll = new ScrollView(this);
        layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(32, 48, 32, 32);
        scroll.addView(layout);

        TextView title = new TextView(this);
        title.setText("Message Saver ❤️");
        title.setTextSize(26);
        layout.addView(title);

        Button settingsButton = new Button(this);
        settingsButton.setText("Notification Settings திற");
        settingsButton.setOnClickListener(v -> {
            startActivity(new Intent(
                Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS));
        });
        layout.addView(settingsButton);

        Button refreshButton = new Button(this);
        refreshButton.setText("Saved Messages பார்க்க");
        refreshButton.setOnClickListener(v -> showMessages());
        layout.addView(refreshButton);

        messages = new TextView(this);
        messages.setTextSize(16);
        layout.addView(messages);

        setContentView(scroll);
        showMessages();
    }

    private void showMessages() {
        SharedPreferences prefs =
            getSharedPreferences("MessageSaver", MODE_PRIVATE);

        String data = prefs.getString("saved_notifications", "");

        if (messages != null) {
            messages.setText(data.isEmpty()
                ? "இன்னும் notifications சேமிக்கப்படவில்லை."
                : data);
        }
    }
}
