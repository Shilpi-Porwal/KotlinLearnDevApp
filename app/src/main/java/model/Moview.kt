package model

data class Moview(
    val page: Int,
    val results: List<ResultSet>,
    val total_pages: Int,
    val total_results: Int
)
