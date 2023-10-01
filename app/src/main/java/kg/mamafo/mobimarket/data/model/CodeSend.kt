package kg.mamafo.mobimarket.data.model

import com.google.gson.annotations.SerializedName

data class CodeSend(
    @SerializedName("phone_number")
    val phoneNumber:String
)
