package com.example.challenge1

import com.example.challenge1.service.RequestResults
import com.example.challenge1.service.SampleServiceBuilder
import org.junit.Test

import org.junit.Assert.*
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import timber.log.Timber

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val results =  SampleServiceBuilder.buildService().getUpcomingGuides().toBlocking().first()
        assertNotNull(results)
    }
}
