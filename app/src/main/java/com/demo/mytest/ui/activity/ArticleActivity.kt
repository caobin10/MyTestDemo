package com.demo.mytest.ui.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.demo.mytest.R
import com.demo.mytest.adapter.ArticleAdapter
import com.demo.mytest.view.model.ArticleViewModel
import kotlinx.android.synthetic.main.activity_view_model.*

class ArticleActivity : AppCompatActivity() {
    private val adapter by lazy {
        ArticleAdapter()
    }
    lateinit var viewModel: ArticleViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)
        viewModel = ArticleViewModel()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        recyclerView.adapter = adapter
        //观察文章列表数据
        viewModel.articleListData.observe(this, Observer { list ->
            //articleListData 的值改变时触发此监听
            loadProgress.visibility = View.GONE
            adapter.submitList(list)
        })
        viewModel.errorMsg.observe(this, Observer {
            if (it != null) {
//                toast(it)
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        })
        btn.setOnClickListener {
            loadProgress.visibility = View.VISIBLE
            viewModel.fetch(1) //请求数据
        }
    }
}