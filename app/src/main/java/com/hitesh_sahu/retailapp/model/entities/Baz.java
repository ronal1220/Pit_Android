
/*
 * Copyright (c) 2019. http://hiteshsahu.com- All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * If you use or distribute this project then you MUST ADD A COPY OF LICENCE
 * along with the project.
 *  Written by Hitesh Sahu <hiteshkrsahu@Gmail.com>, 2017.
 */

package com.hitesh_sahu.retailapp.model.entities;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Baz implements Serializable, Parcelable
{

    @SerializedName("type")
    @Expose
    private String type;
    public final static Creator<Baz> CREATOR = new Creator<Baz>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Baz createFromParcel(Parcel in) {
            return new Baz(in);
        }

        public Baz[] newArray(int size) {
            return (new Baz[size]);
        }

    }
    ;
    private final static long serialVersionUID = 1083642175188810215L;

    protected Baz(Parcel in) {
        this.type = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Baz() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(type);
    }

    public int describeContents() {
        return  0;
    }

}
