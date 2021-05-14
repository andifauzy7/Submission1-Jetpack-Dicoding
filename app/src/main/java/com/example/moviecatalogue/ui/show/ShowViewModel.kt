package com.example.moviecatalogue.ui.show

import androidx.lifecycle.ViewModel
import com.example.moviecatalogue.model.ContentEntity
import com.example.moviecatalogue.repository.DataDummy

class ShowViewModel : ViewModel() {
    fun getShow(): List<ContentEntity> = DataDummy.generateDummyContentShow()
}