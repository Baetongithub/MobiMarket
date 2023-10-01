package kg.mamafo.mobimarket.data.model

import com.google.gson.annotations.SerializedName

data class ProfileRegistration(
    val avatar: String,
    @SerializedName("username")
    val userName: String,
    val email: String,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String,
    @SerializedName("date_of_birth")
    val dateOfBirth: String,
)
