package com.example.moviecatalogue.ui.detail

import com.example.moviecatalogue.repository.DataDummy
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class DetailViewModelTest {

    private lateinit var viewModelForMovies: DetailViewModel
    private lateinit var viewModelForShow: DetailViewModel
    private val dummyMovies = DataDummy.generateDummyContentMovies()[0]
    private val moviesId = dummyMovies.id

    private val dummyShow = DataDummy.generateDummyContentShow()[0]
    private val showId = dummyShow.id

    @Before
    fun setUp() {
        viewModelForMovies = DetailViewModel()
        viewModelForMovies.setSelectedContent(moviesId, "MOVIES")
        viewModelForShow = DetailViewModel()
        viewModelForShow.setSelectedContent(showId, "SHOW")
    }

    @Test
    fun getContentMovies() {
        viewModelForMovies.setSelectedContent(dummyMovies.id, "MOVIES")
        val contentEntity = viewModelForMovies.getContent()
        assertNotNull(contentEntity)
        assertEquals(dummyMovies.id, contentEntity?.id)
        assertEquals(dummyMovies.name, contentEntity?.name)
        assertEquals(dummyMovies.category, contentEntity?.category)
        assertEquals(dummyMovies.score, contentEntity?.score)
        assertEquals(dummyMovies.overview, contentEntity?.overview)
        assertEquals(dummyMovies.image, contentEntity?.image)
    }

    @Test
    fun getContentShow() {
        viewModelForShow.setSelectedContent(dummyShow.id, "SHOW")
        val contentEntity = viewModelForShow.getContent()
        assertNotNull(contentEntity)
        assertEquals(dummyShow.id, contentEntity?.id)
        assertEquals(dummyShow.name, contentEntity?.name)
        assertEquals(dummyShow.category, contentEntity?.category)
        assertEquals(dummyShow.score, contentEntity?.score)
        assertEquals(dummyShow.overview, contentEntity?.overview)
        assertEquals(dummyShow.image, contentEntity?.image)
    }
}