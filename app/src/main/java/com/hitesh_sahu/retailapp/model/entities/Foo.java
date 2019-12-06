
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

public class Foo implements Serializable, Parcelable
{

    @SerializedName("type")
    @Expose
    private String type;
    public final static Creator<Foo> CREATOR = new Creator<Foo>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Foo createFromParcel(Parcel in) {
            return new Foo(in);
        }

        public Foo[] newArray(int size) {
            return (new Foo[size]);
        }

    }
    ;
    private final static long serialVersionUID = -5567841542023640452L;

    protected Foo(Parcel in) {
        this.type = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Foo() {
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
