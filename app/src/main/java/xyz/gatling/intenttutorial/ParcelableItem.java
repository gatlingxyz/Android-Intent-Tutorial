package xyz.gatling.intenttutorial;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by tavongatling on 2/12/17.
 */

public class ParcelableItem implements Parcelable {

    private String someString;
    private int someInt;

    public ParcelableItem(String someString, int someInt) {
        this.someString = someString;
        this.someInt = someInt;
    }

    protected ParcelableItem(Parcel in) {
        someString = in.readString();
        someInt = in.readInt();
    }

    public static final Creator<ParcelableItem> CREATOR = new Creator<ParcelableItem>() {
        @Override
        public ParcelableItem createFromParcel(Parcel in) {
            return new ParcelableItem(in);
        }

        @Override
        public ParcelableItem[] newArray(int size) {
            return new ParcelableItem[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(someString);
        dest.writeInt(someInt);
    }

    public String getSomeString() {
        return someString;
    }

    public int getSomeInt() {
        return someInt;
    }
}
