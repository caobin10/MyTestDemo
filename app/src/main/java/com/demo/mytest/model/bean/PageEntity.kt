package com.demo.mytest.model.bean

/**
 * @Author yangtianfu
 * @CreateTime 2020/4/5 19:30
 * @Describe
 */
data class PageEntity<T>(
    val curPage:Int,
    val offset:Int,
    val over:Boolean,
    val size:Int,
    val PageCount:Int,
    val total:Int,
    val datas:List<T>
)