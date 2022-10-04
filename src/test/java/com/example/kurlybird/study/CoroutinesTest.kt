package com.example.kurlybird.study

import kotlinx.coroutines.*
import kotlinx.coroutines.test.runTest
import net.bytebuddy.implementation.FixedValue.self
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.stream.IntStream
import kotlin.streams.toList
import kotlin.system.measureTimeMillis

class CoroutinesTest {

    @Test
    fun test() = runTest {
        println("hi")
        launchTest()
        asyncTest()
    }

    @Test
    fun 반복문_coroutine() {
        launchRoofTest()
    }

    fun asyncTest() {
        println("start async test")
        runBlocking {
            var time = measureTimeMillis {
                var job1 = async {
                    delay(1000L)
                    println("async 1")
                    1
                }
                var job2 = async {
                    delay(1000L)
                    println("async 1")
                    2
                }
                awaitAll(job1, job2)
            }
            println("result -> $time")
        }

    }

    suspend fun launchTest() {
        val time = measureTimeMillis {
            println("start launch test")
            coroutineScope {
                val job1 = launch {
                    delay(1000L)
                }
                val job2 = launch {
                    delay(1000L)
                }
                job1.join()
                job2.join()
            }
        }
        println("result time: $time")
        Assertions.assertEquals(1, 1)
    }

    fun launchRoofTest() = runBlocking {
        val time = measureTimeMillis {
            println("start")
            coroutineScope {
//                기대값 약 1000ms -> 결과 1055ms
//                val time1 = measureTimeMillis {
//                    IntRange(1, 10).map {
//                        launch {
//                            delay(1000L)
//                            println("execute")
//                        }
//                    }.joinAll()
//                }
                val time1 = measureTimeMillis {
                    val arr = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

                    val list = arr.stream().map {
                        launch {
                            delay(1000L)
                            println("execute")
                        }
                    }.toList()
                    list.joinAll()
                }
                println("result time1: $time1")
            }
        }
        println("result time: $time")
        Assertions.assertEquals(1, 1)
    }
}