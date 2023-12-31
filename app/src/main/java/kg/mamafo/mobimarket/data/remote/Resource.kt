package kg.mamafo.mobimarket.data.remote

class Resource<out T>(val status: Status, val data: T?, val message: String?, val code: Int?) {

    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null, null)
        }

        fun <T> error(message: String?, data: T?, code: Int?): Resource<T> {
            return Resource(Status.ERROR, data, message, code)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(Status.LOADING, data, null, null)
        }
    }
}