package com.androidapp.demoproject;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MyDialog myDialog;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
    }

    public void openDialog(View view) {

        new DroidDialog.Builder(context)
                .icon(R.mipmap.ic_launcher)
                .title("All Well!")
                .content(getString(R.string.short_text))
                .cancelable(true, true)
                .positiveButton("OK", new DroidDialog.onPositiveListener() {
                    @Override
                    public void onPositive(Dialog droidDialog) {
                        Toast.makeText(context, "YES", Toast.LENGTH_SHORT).show();
                    }
                })
                .negativeButton("NO", new DroidDialog.onNegativeListener() {
                    @Override
                    public void onNegative(Dialog droidDialog) {
                        droidDialog.dismiss();
                        Toast.makeText(context, "NO", Toast.LENGTH_SHORT).show();
                    }
                })
                .neutralButton("Dismiss", new DroidDialog.onNeutralListener() {
                    @Override
                    public void onNeutral(Dialog droidDialog) {
                        droidDialog.dismiss();
                        Toast.makeText(context, "Dismiss", Toast.LENGTH_SHORT).show();
                    }
                })
                .typeface("regular.ttf")
                .animation(AnimUtils.AnimZoomInOut)
                .color(ContextCompat.getColor(context, R.color.colorPrimary), ContextCompat.getColor(context, R.color.colorWhite),
                        ContextCompat.getColor(context, R.color.colorPrimaryDark))
                .divider(true, ContextCompat.getColor(context, R.color.orange))
                .show();
    }
}
