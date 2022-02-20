package com.example.aopdemo

/**
 * author: WentaoKing
 * created on: 2022/2/11
 * description: 点击次数限制注解
 */
@Target(AnnotationTarget.FUNCTION)
@Retention(value = AnnotationRetention.RUNTIME)
annotation class FastClickView(val interval: Long = 3000L)