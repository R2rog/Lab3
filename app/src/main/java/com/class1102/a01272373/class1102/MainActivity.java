package com.class1102.a01272373.class1102;

import android.app.Notification;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.app.NotificationManager;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import android.app.AlertDialog;
import android.widget.EditText;
import android.content.DialogInterface;

public class MainActivity extends AppCompatActivity {
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Variable definition.
        context = getApplicationContext();
        AlertDialog.Builder DialogConf = new AlertDialog.Builder(this);
        Toast MyToast = new Toast(context);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyToast.makeText(context,"This is a Toast Message",Toast.LENGTH_LONG).show();
        DialogConf.setTitle("Regular Menus");
        DialogConf.setMessage("This is the Text of the First Dialog");
        DialogConf.setIcon(R.mipmap.ic_launcher);

        DialogConf.setNeutralButton("OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(context,"You closed the dialog.", Toast.LENGTH_LONG).show();
                    }
                });

        AlertDialog MyDialog = DialogConf.create();
        MyDialog.show();

        //Creating an alert dialog that allows you to make choices within the app.
        AlertDialog.Builder DialogConf2 = new AlertDialog.Builder(this);
        DialogConf2.setTitle("Regular Menus");
        DialogConf2.setMessage("This is the Text of theS Second Dialog");//Preparing the messge that will be displayed.
        DialogConf2.setIcon(R.mipmap.ic_launcher);//Prepare the icon tht we render

        //Coding the yes option.
        DialogConf2.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(context,"You answered yes.", Toast.LENGTH_LONG).show();
                    }
                });
        //Coding the no option.
        DialogConf2.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(context,"You answered no.", Toast.LENGTH_LONG).show();
                    }
                });

        //Coding the closing button.
        DialogConf2.setNeutralButton("close",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(context,"You closed the dialog.", Toast.LENGTH_LONG).show();
                    }
                });

        AlertDialog MySecondDialog = DialogConf2.create();
        MySecondDialog.show();

        /*Input notification:
        You use a regular dialog and you make it more complex. */

        AlertDialog.Builder DialogConf3 = new AlertDialog.Builder(this);
        DialogConf3.setTitle("confirmation dialog");
        DialogConf3.setMessage("This is the Text of the third Dialog");//Preparing the messge that will be displayed.
        DialogConf3.setIcon(R.mipmap.ic_launcher);//Prepare the icon tht we render

        final EditText TextInput = new EditText(context);
        TextInput.setTextColor(Color.BLUE);
        DialogConf3.setView(TextInput);
        DialogConf3.setNeutralButton("close",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        String str = TextInput.getEditableText().toString();
                        Toast.makeText(context,"You wrote this dialog." + str, Toast.LENGTH_LONG).show();
                    }
                });

        AlertDialog MyThirdDialog = DialogConf3.create();
        MyThirdDialog.show();

        //Bar notification.
        int NOTIF_ID = 1234;
        Notification.Builder NotifBuilder = new Notification.Builder(this);
        NotifBuilder.setSmallIcon(R.mipmap.ic_launcher);
        NotifBuilder.setContentTitle("Important notification");
        NotifBuilder.setContentText("This is the detail of the notification");

        NotificationManager MyNotification = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        MyNotification.notify(NOTIF_ID, NotifBuilder.build());

    }
}
