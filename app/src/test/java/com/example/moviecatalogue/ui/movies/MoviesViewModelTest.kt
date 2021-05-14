package com.example.moviecatalogue.ui.movies

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class MoviesViewModelTest {

    private lateinit var viewModel: MoviesViewModel

    @Before
    fun setUp(){
        viewModel = MoviesViewModel()
    }

    @Test
    fun getMovies() {
        val contentEntity = viewModel.getMovies()
        assertNotNull(contentEntity)
        assertEquals(19, contentEntity.size)
    }
}