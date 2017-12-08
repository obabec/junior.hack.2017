package com.example.tomaskorb.homeos;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by tomas.korb on 12/8/17.
 */

public class LightImageView extends ImageView {
    int PercentOfLight = 0;

    public LightImageView(Context context) {
        super(context);

        Bitmap source1 = BitmapFactory.decodeResource(getResources(), R.drawable.fill);

        Paint alphaPaint = new Paint();
        alphaPaint.setAlpha(PercentOfLight);


        Bitmap source2 = BitmapFactory.decodeResource(getResources(), R.drawable.light_0);
        Bitmap big = Bitmap.createBitmap(source1.getWidth(), source1.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(big);
        canvas.drawBitmap(source1,0,0,alphaPaint);
        canvas.drawBitmap(source2,0,0,null);
        this.setImageBitmap(big);
    }

    public LightImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Bitmap source1 = BitmapFactory.decodeResource(getResources(), R.drawable.fill);

        Paint alphaPaint = new Paint();
        alphaPaint.setAlpha(PercentOfLight);


        Bitmap source2 = BitmapFactory.decodeResource(getResources(), R.drawable.light_0);
        Bitmap big = Bitmap.createBitmap(source1.getWidth(), source1.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(big);
        canvas.drawBitmap(source1,0,0,alphaPaint);
        canvas.drawBitmap(source2,0,0,null);
        this.setImageBitmap(big);
    }

    public LightImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Bitmap source1 = BitmapFactory.decodeResource(getResources(), R.drawable.fill);

        Paint alphaPaint = new Paint();
        alphaPaint.setAlpha(PercentOfLight);

        Bitmap source2 = BitmapFactory.decodeResource(getResources(), R.drawable.light_0);
        Bitmap big = Bitmap.createBitmap(source1.getWidth(), source1.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(big);
        canvas.drawBitmap(source1,0,0,alphaPaint);
        canvas.drawBitmap(source2,0,0,null);
        this.setImageBitmap(big);
    }

    public void RedrawLightness()
    {
        Bitmap source1 = BitmapFactory.decodeResource(getResources(), R.drawable.fill);

        Paint alphaPaint = new Paint();
        alphaPaint.setAlpha((int)(PercentOfLight*(double)2.5));

        Bitmap source2 = BitmapFactory.decodeResource(getResources(), R.drawable.light_0);
        Bitmap big = Bitmap.createBitmap(source1.getWidth(), source1.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(big);
        canvas.drawBitmap(source1,0,0,alphaPaint);
        canvas.drawBitmap(source2,0,0,null);
        this.setImageBitmap(big);
    }








}
