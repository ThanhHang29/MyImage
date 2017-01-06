package com.ttth.asynctask;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

/**
 * Created by Thanh Hang on 05/01/17.
 */

public class BitmapAsynctask extends AsyncTask<Integer, Void, Bitmap> {
    private Context mContext;
    private ImageView imageView;
    private int data = 0;

    public BitmapAsynctask(Context mContext, ImageView imageView) {
        this.mContext = mContext;
        this.imageView = imageView;
    }


    public static int caculateInsampleSize(BitmapFactory.Options options, int reWidth, int reHeight){
        final int imageHeight = options.outHeight;
        final int imageWidth = options.outWidth;
        int inSampleSize = 1;
        if (imageWidth >  reWidth || imageHeight > reHeight){
            int halfHeight = imageHeight/2;
            int halfWidth = imageWidth/2;
            while ((halfHeight/inSampleSize) >= reHeight && (halfWidth/inSampleSize) >= reWidth){
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }
    public static Bitmap decodeImageBitmap(Resources res, int id, int reWidth, int reHeight){
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, id, options);
        options.inSampleSize = caculateInsampleSize(options, reWidth, reHeight);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, id, options);
    }

    @Override
    protected Bitmap doInBackground(Integer... params) {
        data = params[0];
        return decodeImageBitmap(mContext.getResources(), data, 250, 250);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if (imageView!=null){
            imageView.setImageBitmap(bitmap);
        }
    }
}
