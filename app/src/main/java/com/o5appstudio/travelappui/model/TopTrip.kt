package com.o5appstudio.travelappui.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Parcelize
data class TopTrip(val place:String, val country:String, val image: Int, var isFav : Boolean) : Parcelable