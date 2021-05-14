package com.example.moviecatalogue.ui.show

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.moviecatalogue.databinding.FragmentShowBinding

class ShowFragment : Fragment() {

    private lateinit var fragmentShowBinding: FragmentShowBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentShowBinding = FragmentShowBinding.inflate(layoutInflater, container, false)
        return fragmentShowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[ShowViewModel::class.java]
            val listShow = viewModel.getShow()

            val showAdapter = ShowAdapter()
            showAdapter.setShow(listShow)

            with(fragmentShowBinding.rvShow) {
                layoutManager = GridLayoutManager(context,2)
                setHasFixedSize(true)
                adapter = showAdapter
            }
        }
    }
}