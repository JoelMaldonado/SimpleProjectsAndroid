package com.jjmf.android.storeapp.core

import com.google.gson.annotations.SerializedName

data class Wrapper <T>(
    @SerializedName("drinks") val data: T?
)