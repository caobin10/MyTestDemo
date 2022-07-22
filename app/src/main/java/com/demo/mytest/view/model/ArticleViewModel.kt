package com.demo.mytest.view.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.mytest.model.bean.Article
import com.demo.mytest.https.RetrofitFactory
import com.wjx.android.wanandroidmvvm.base.https.ApiService
import kotlinx.coroutines.launch

/**
 * @Author yangtianfu
 * @CreateTime 2020/4/5 20:24
 * @Describe
 */
class ArticleViewModel : ViewModel() {
    private val _articleListData = MutableLiveData<List<Article>>()

    //保证外部只能观察此数据，不同通过setValue修改 model调用articleListData拿到网络请求数据交个观察者，但是不能修改
    val articleListData: LiveData<List<Article>> = _articleListData

    private val _errorMsg = MutableLiveData<String?>()
    val errorMsg: LiveData<String?> = _errorMsg

    fun fetch(page: Int) {
        viewModelScope.launch {
            var result = RetrofitFactory.instance.getService(ApiService::class.java).getArticleList(page)
            //请求到的数据用livedata包裹
            _articleListData.value = result.data.datas
        }
    }
}