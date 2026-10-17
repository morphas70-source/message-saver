ackage com.messagesaver.app;

import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.content.SharedPreferences;

public class MessageListener extends NotificationListenerService {

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        if (sbn.getNotification() == null ||
            sbn.getNotification().extras == null) {
            return;
        }

        String appName = sbn.getPackageName();

        String title = sbn.getNotification().extras
                .getCharSequence("android.title", "").toString();

        String message = sbn.getNotification().extras
                .getCharSequence("android.text", "").toString();

        SharedPreferences prefs =
                getSharedPreferences("MessageSaver", MODE_PRIVATE);

        String oldData = prefs.getString("saved_notifications", "");

        String newData = "App: " + appName +
                "\nTitle: " + title +
                "\nMessage: " + message +
                "\n--------------------\n" + oldData;

        prefs.edit()
                .putString("saved_notifications", newData)
                .apply();
    }
}
