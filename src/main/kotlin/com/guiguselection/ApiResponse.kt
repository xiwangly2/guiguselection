package com.guiguselection

data class ApiResponse<T>(
    val status: Int,
    val data: T? = null,
    val message: String? = null
)
