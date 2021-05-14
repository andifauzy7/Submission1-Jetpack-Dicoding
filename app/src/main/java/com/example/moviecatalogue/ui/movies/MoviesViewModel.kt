package com.example.moviecatalogue.ui.movies

import androidx.lifecycle.ViewModel
import com.example.moviecatalogue.model.ContentEntity
import com.example.moviecatalogue.repository.DataDummy

class MoviesViewModel : ViewModel() {
    fun getMovies(): List<ContentEntity> = DataDummy.generateDummyContentMovies()
}