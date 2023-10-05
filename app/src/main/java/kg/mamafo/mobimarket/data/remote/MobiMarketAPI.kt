package kg.mamafo.mobimarket.data.remote

import kg.mamafo.mobimarket.data.model.Login
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface MobiMarketAPI {

    @POST("auth/login/")
    suspend fun login(
        @Body login:Login
    ) : Response<Login>
}