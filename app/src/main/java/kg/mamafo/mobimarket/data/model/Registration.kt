package kg.mamafo.mobimarket.data.model

import com.google.gson.annotations.SerializedName

data class Registration(
    @SerializedName("username") val userName: String,
    val email: String,
    val password: String,
    @SerializedName("password_confirm") val passwordConfirm: String
)