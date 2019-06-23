package com.example.webapirxsample.model

data class SearchData(
    val result: ItemsData
)

data class ItemsData(
    val items: List<Item>?,
    val status: Int
)

data class Item (
    var service_code: String,
    var service_name: String,
    var floor_code: String,
    var floor_name: String,
    var category_name: String,
    var content_id: String,
    var product_id: String,
    var title: String,
    var volume: String,
    var imageURL: ImageURL
)

data class DmmApiResult(
    val result: ItemsData
)

data class ImageURL(
    var list: String,
    var small: String,
    var large: String
)
