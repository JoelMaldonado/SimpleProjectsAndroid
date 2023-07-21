package com.jjmf.android.cocktailandroidapp.core

import com.google.gson.annotations.SerializedName

data class Wrapper <T>(
    @SerializedName("drinks") val data: T?
)