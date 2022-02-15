package com.practice.composeplayground

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import org.junit.Test

import org.junit.Assert.*
import kotlin.system.measureTimeMillis

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
  @ExperimentalCoroutinesApi
  @Test
  fun addition_isCorrect() {
    val parentJob = runTest {
      val job1 = launch {
        val startTime = System.currentTimeMillis()
        delay(1000)
        println("Job 1 Finished ${System.currentTimeMillis() - startTime}")
      }
      job1.join()

      val job2 = CoroutineScope(Dispatchers.IO).launch {
        val startTime = System.currentTimeMillis()
        delay(1000)
        println("Job 2 Finished ${System.currentTimeMillis() - startTime}")
      }
    }
  }
}