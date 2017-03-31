package com.androidapp.demoproject;

import android.app.Dialog;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sagartahelyani on 23-03-2017.
 */

public class MyDialog extends Dialog {

    private final View view;
    private ImageView imgIcon;
    private Button btnNegative, btnNeutral, btnPositive;
    private Context context;
    private String contentTitle;
    private TextView txtTitle, txtContent;
    private RelativeLayout iconLayout;
    private Typeface typeface;

    public MyDialog(@NonNull Context context) {
        super(context);
        this.context = context;
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        view = LayoutInflater.from(context).inflate(R.layout.layout_dialog, null);
        setContentView(view);

        typeface = Typeface.DEFAULT;

        init();

    }

    private void init() {
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.CENTER;
        getWindow().setAttributes(lp);

        iconLayout = (RelativeLayout) view.findViewById(R.id.iconLayout);
        imgIcon = (ImageView) view.findViewById(R.id.imgIcon);
        btnNegative = (Button) view.findViewById(R.id.btnNegative);
        btnNeutral = (Button) view.findViewById(R.id.btnNeutral);
        btnPositive = (Button) view.findViewById(R.id.btnPositive);

        txtTitle = (TextView) view.findViewById(R.id.txtTitle);
        txtContent = (TextView) view.findViewById(R.id.txtContent);

        btnNegative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

    }

    public void setTitle(String title) {
        txtTitle.setVisibility(View.VISIBLE);
        txtTitle.setText(title);
    }

    public void setContent(String content) {
        txtContent.setVisibility(View.VISIBLE);
        txtContent.setText(content);
    }

    public void setPositiveButton(String positiveButton, int textColor, final View.OnClickListener onClickListener) {
        btnPositive.setVisibility(View.VISIBLE);
        btnPositive.setTextColor(textColor);
        btnPositive.setText(positiveButton);
        btnPositive.setOnClickListener(onClickListener);
    }

    public void setNegativeButton(String positiveButton, int textColor, View.OnClickListener onClickListener) {
        btnNegative.setVisibility(View.VISIBLE);
        btnNegative.setText(positiveButton);
        btnNegative.setTextColor(textColor);
        btnNegative.setOnClickListener(onClickListener);
    }

    public void setNeutralButton(String positiveButton, int textColor, View.OnClickListener onClickListener) {
        btnNeutral.setVisibility(View.VISIBLE);
        btnNeutral.setText(positiveButton);
        btnNeutral.setTextColor(textColor);
        btnNeutral.setOnClickListener(onClickListener);
    }

    public void setIcon(int drawable, int backgroundColor, int iconColor) {
        iconLayout.setVisibility(View.VISIBLE);
        iconLayout.setBackgroundColor(backgroundColor);
        imgIcon.setImageResource(drawable);
        imgIcon.setColorFilter(iconColor, PorterDuff.Mode.SRC_ATOP);
    }

    public void setFont(String fontName) {
        if (!TextUtils.isEmpty(fontName)) {
            typeface = Typeface.createFromAsset(context.getAssets(), "fonts/" + fontName);
        }
        txtTitle.setTypeface(typeface);
        txtContent.setTypeface(typeface);
        btnNegative.setTypeface(typeface, Typeface.BOLD);
        btnNeutral.setTypeface(typeface, Typeface.BOLD);
        btnPositive.setTypeface(typeface, Typeface.BOLD);
    }
}
