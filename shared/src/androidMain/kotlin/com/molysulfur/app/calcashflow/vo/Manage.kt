package com.molysulfur.app.calcashflow.vo

import android.os.Parcel
import android.os.Parcelable

data class Manage(
    var price: Float = 0f,
    var percent: Int = 0
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readFloat(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeFloat(price)
        parcel.writeInt(percent)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Manage> {
        override fun createFromParcel(parcel: Parcel): Manage {
            return Manage(parcel)
        }

        override fun newArray(size: Int): Array<Manage?> {
            return arrayOfNulls(size)
        }
    }
}