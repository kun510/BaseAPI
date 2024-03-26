package com.example.mvvmnews.repository

import com.example.mvvmnews.api.RetrofitInstance
import com.example.mvvmnews.db.ArticleDatabase
import com.example.mvvmnews.models.Article


class NewsRepository(
    val db: ArticleDatabase //parameter
) {


    suspend fun getBreakingNews(countryCode:String, pageNumber:Int)=
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)


    suspend fun searchNews(searchQuery: String, pageNumber: Int)=
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)


    suspend fun upsert(article: Article)=
        db.getArticleDao().upsert(article)


    fun getSavedNews()=
        db.getArticleDao().getAllArticles()


    suspend fun deleteArticle(article: Article)=
        db.getArticleDao().deleteArticle(article)
}