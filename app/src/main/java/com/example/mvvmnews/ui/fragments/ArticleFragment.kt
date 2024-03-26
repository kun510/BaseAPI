package com.example.mvvmnews.ui.fragments

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.example.mvvmnews.R
import com.example.mvvmnews.ui.MainActivity
import com.example.mvvmnews.ui.NewsViewModel
import kotlinx.android.synthetic.main.fragment_article.*

class ArticleFragment : Fragment(R.layout.fragment_article){
    lateinit var viewModel: NewsViewModel

    private val args: ArticleFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel= (activity as MainActivity).viewModel


        val article = args.article
        webView.apply {
            webViewClient= WebViewClient()
            loadUrl(article.url.toString())
        }


        fab.setOnClickListener{
            viewModel.saveArticle(article)
            Snackbar.make(view, " Article Saved Successfully! ", Snackbar.LENGTH_SHORT).show()
        }


    }
}