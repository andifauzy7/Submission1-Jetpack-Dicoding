package com.example.moviecatalogue.ui.detail

import androidx.lifecycle.ViewModel
import com.example.moviecatalogue.model.ContentEntity
import com.example.moviecatalogue.repository.DataDummy

class DetailViewModel : ViewModel() {
    private lateinit var contentId: String
    private lateinit var typeContent: String

    fun setSelectedContent(contentId: String, typeContent: String) {
        this.contentId = contentId
        this.typeContent = typeContent
    }

    fun getContent(): ContentEntity? {
        var content: ContentEntity? = null
        if (typeContent == "MOVIES"){
            for(contentEntity in DataDummy.generateDummyContentMovies()){
                if (contentEntity.id == contentId) {
                    content = contentEntity
                }
            }
        } else {
            for(contentEntity in DataDummy.generateDummyContentShow()){
                if (contentEntity.id == contentId) {
                    content = contentEntity
                }
            }
        }
        return content
    }

}