package com.example.challenge1.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.challenge1.R
import com.example.challenge1.service.RequestResults
import com.example.challenge1.service.SampleServiceBuilder
import kotlinx.android.synthetic.main.activity_main.*
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private val service by lazy {
        SampleServiceBuilder.buildService()
    }

    private val adapter by lazy {
        GuideAdapter(recycler)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindLoadingState(true)
    }

    override fun onStart() {
        super.onStart()
        service.getUpcomingGuides()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.newThread())
            .subscribe({ results : RequestResults ->
                bindLoadingState(false)
                adapter.updateData(results.data)
            }) {error ->
                Timber.w("problem fetching guides")
                Timber.w(error)
            }

    }

    private fun bindLoadingState(isLoading: Boolean) {
        if(isLoading) {
            loading_message.visibility = View.VISIBLE
        } else {
            loading_message.visibility = View.GONE
        }
    }
}
