package com.ttth.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Thanh Hang on 05/01/17.
 */

public class MyImage implements Parcelable {
    private int image;
    private String title;

    public MyImage(int image, String title) {
        this.image = image;
        this.title = title;
    }


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.image);
        dest.writeString(this.title);
    }

    protected MyImage(Parcel in) {
        this.image = in.readInt();
        this.title = in.readString();
    }

    public static final Parcelable.Creator<MyImage> CREATOR = new Parcelable.Creator<MyImage>() {
        @Override
        public MyImage createFromParcel(Parcel source) {
            return new MyImage(source);
        }

        @Override
        public MyImage[] newArray(int size) {
            return new MyImage[size];
        }
    };
}
