package com.demo.mytest.model.bean

import com.google.gson.annotations.SerializedName


/**
 * @Author yangtianfu
 * @CreateTime 2020/4/5 19:31
 * @Describe 文章列表
 */
class Article(
    @SerializedName("desc") val desc: String,
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
)