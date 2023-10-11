package kg.mamafo.mobimarket.data.remote

import kg.mamafo.mobimarket.data.model.*
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface MobiMarketAPI {

    @POST("auth/login/")
    suspend fun login(
        @Body login:Login
    ) : Response<Login>

    @POST("auth/api/token/")
    suspend fun token(
        @Body login:TokenObtainPair
    ) : Response<TokenObtainPair>

    @POST("auth/api/token/")
    suspend fun tokenPair(
        @Body login:TokenObtainPair
    ) : Response<TokenObtainPair>

    @GET("auth/profile-view/")
    suspend fun getProfileDetails() : Response<ProfileRegistration>

    @PUT("auth/code-send/")
    suspend fun sendOTP(
        @Body send: CodeSend
    ) : Response<CodeSend>

    @POST("auth/register/")
    suspend fun registration(
        @Body registration: Registration
    ) : Response<Registration>
}