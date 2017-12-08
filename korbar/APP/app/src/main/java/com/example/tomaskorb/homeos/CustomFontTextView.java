package com.example.tomaskorb.homeos;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by tomas.korb on 12/8/17.
 */

public class CustomFontTextView extends TextView {
    public CustomFontTextView(Context context) {
        super(context);
        Typeface face=Typeface.createFromAsset(context.getAssets(), "fonts/hacked.ttf");
        this.setTypeface(face);
    }

    public CustomFontTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Typeface face=Typeface.createFromAsset(context.getAssets(), "fonts/hacked.ttf");
        this.setTypeface(face);
    }

    public CustomFontTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Typeface face=Typeface.createFromAsset(context.getAssets(), "fonts/hacked.ttf");
        this.setTypeface(face);
    }




}
