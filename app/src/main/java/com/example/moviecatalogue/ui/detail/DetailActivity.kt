package com.example.moviecatalogue.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.moviecatalogue.databinding.ActivityDetailBinding
import com.example.moviecatalogue.model.ContentEntity

class DetailActivity : AppCompatActivity() {

    companion object {
        const val ID_CONTENT = "id_content"
        const val TYPE_CONTENT = "type_content"
    }

    private lateinit var detailBinding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityDetailBinding = ActivityDetailBinding.inflate(layoutInflater)
        detailBinding = activityDetailBinding
        setContentView(activityDetailBinding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val contentId = extras.getString(ID_CONTENT)
            val typeContent = extras.getString(TYPE_CONTENT)
            if ((contentId != null) && (typeContent != null)) {
                viewModel.setSelectedContent(contentId, typeContent)
                val modules = viewModel.getContent()
                modules?.let { populateContent(it) }
            }
        }
    }

    private fun populateContent(contentEntity: ContentEntity) {
        detailBinding.tvJudulDetail.text = contentEntity.name
        detailBinding.tvRatingDetail.text = contentEntity.score.toString()
        detailBinding.tvCategoryDetail.text = contentEntity.category
        detailBinding.tvOverviewDetail.text = contentEntity.overview
        Glide.with(this)
                .load(contentEntity.image)
                .transform(RoundedCorners(20))
                .into(detailBinding.imgItemDetail)
    }
}