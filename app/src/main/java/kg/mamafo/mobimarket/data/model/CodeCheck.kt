package kg.mamafo.mobimarket.data.model

import com.google.gson.annotations.SerializedName

data class CodeCheck(
    @SerializedName("verification_code")
    val verificationCode: String
)
