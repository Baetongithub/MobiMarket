package kg.mamafo.mobimarket.data.model

import com.google.gson.annotations.SerializedName

data class Login(
    @SerializedName("username")
    val userName: String,
    val password: String
)
