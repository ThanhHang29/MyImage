package com.ttth.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ttth.asynctask.BitmapAsynctask;
import com.ttth.example.R;
import com.ttth.model.MyImage;

import java.util.ArrayList;

/**
 * Created by Thanh Hang on 05/01/17.
 */

public class ListImageAdapter extends RecyclerView.Adapter<ListImageAdapter.MyViewHolder>{
    private ArrayList<MyImage> arrImages;
    private Context mContext;
    public ListImageAdapter(ArrayList<MyImage> arrImages, Context mContext) {
        this.arrImages = arrImages;
        this.mContext = mContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_image, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MyImage myImage = arrImages.get(position);
        holder.tvTitle.setText(myImage.getTitle());

        BitmapAsynctask bitmapAsynctask = new BitmapAsynctask(mContext, holder.image);
        bitmapAsynctask.execute(myImage.getImage());
    }


    @Override
    public int getItemCount() {
        if (arrImages == null || arrImages.size() == 0){
            return 0;
        }
        return arrImages.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView tvTitle;
        public MyViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.img_image);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);

        }

    }

//
//    public static int caculateInsampleSize(BitmapFactory.Options options, int reWidth, int reHeight){
//        final int imageHeight = options.outHeight;
//        final int imageWidth = options.outWidth;
//        int inSampleSize = 1;
//        if (imageWidth >  reWidth || imageHeight > reHeight){
//            int halfHeight = imageHeight/2;
//            int halfWidth = imageWidth/2;
//            while ((halfHeight/inSampleSize) >= reHeight && (halfWidth/inSampleSize) >= reWidth){
//                inSampleSize *= 2;
//            }
//        }
//        return inSampleSize;
//    }
//    public static Bitmap decodeImageBitmap(Resources res, int id, int reWidth, int reHeight){
//        BitmapFactory.Options options = new BitmapFactory.Options();
//        options.inJustDecodeBounds = true;
//        BitmapFactory.decodeResource(res, id, options);
//        options.inSampleSize = caculateInsampleSize(options, reWidth, reHeight);
//        options.inJustDecodeBounds = false;
//        return BitmapFactory.decodeResource(res, id, options);
//    }
}
