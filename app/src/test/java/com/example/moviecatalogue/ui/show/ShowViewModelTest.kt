package com.example.moviecatalogue.ui.show

import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class ShowViewModelTest {

    private lateinit var viewModel: ShowViewModel
    @Before
    fun setUp() {
        viewModel = ShowViewModel()
    }

    @Test
    fun getShow() {
        val contentEntity = viewModel.getShow()
        assertNotNull(contentEntity)
        assertEquals(19, contentEntity.size)
    }
}