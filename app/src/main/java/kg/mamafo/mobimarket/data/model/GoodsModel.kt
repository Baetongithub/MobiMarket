package kg.mamafo.mobimarket.data.model

data class GoodsModel(
    val id: Int,
    val name: String,
    val price: String,
    val amountOfLikes: String,
    val image: String
) : java.io.Serializable