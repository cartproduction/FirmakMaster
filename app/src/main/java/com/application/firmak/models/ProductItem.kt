package com.application.firmak.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ProductItem(name: String,description: String,date: String,profilePictureUrl: Int,color: Int,size: Int) {

    @SerializedName("name")
    @Expose
    var name: String? = name
    @SerializedName("description")
    @Expose
    var description: String? = description
    @SerializedName("price")
    @Expose
    var date: String? = date
    @SerializedName("profilePictureUrl")
    @Expose
    var profilePictureUrl: Int? = profilePictureUrl
    @SerializedName("color")
    @Expose
    var color: Int? = color
    @SerializedName("size")
    @Expose
    var size: Int? = size

}