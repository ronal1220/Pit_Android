
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

public class Properties implements Serializable, Parcelable
{

    @SerializedName("foo")
    @Expose
    private Foo foo;
    @SerializedName("bar")
    @Expose
    private Bar bar;
    @SerializedName("baz")
    @Expose
    private Baz baz;
    public final static Creator<Properties> CREATOR = new Creator<Properties>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Properties createFromParcel(Parcel in) {
            return new Properties(in);
        }

        public Properties[] newArray(int size) {
            return (new Properties[size]);
        }

    }
    ;
    private final static long serialVersionUID = 8548752899781043681L;

    protected Properties(Parcel in) {
        this.foo = ((Foo) in.readValue((Foo.class.getClassLoader())));
        this.bar = ((Bar) in.readValue((Bar.class.getClassLoader())));
        this.baz = ((Baz) in.readValue((Baz.class.getClassLoader())));
    }

    public Properties() {
    }

    public Foo getFoo() {
        return foo;
    }

    public void setFoo(Foo foo) {
        this.foo = foo;
    }

    public Bar getBar() {
        return bar;
    }

    public void setBar(Bar bar) {
        this.bar = bar;
    }

    public Baz getBaz() {
        return baz;
    }

    public void setBaz(Baz baz) {
        this.baz = baz;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(foo);
        dest.writeValue(bar);
        dest.writeValue(baz);
    }

    public int describeContents() {
        return  0;
    }

}
