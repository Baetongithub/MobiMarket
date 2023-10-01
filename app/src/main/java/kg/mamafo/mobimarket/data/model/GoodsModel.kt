package kg.mamafo.mobimarket.data.model

data class GoodsModel(
    val id: Int,
    val name: String,
    val description: String,
    val price: String,
    val amountOfLikes: String,
    val photo: String
) : java.io.Serializable