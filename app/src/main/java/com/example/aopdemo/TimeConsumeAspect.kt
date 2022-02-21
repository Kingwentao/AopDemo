package com.example.aopdemo

import android.util.Log
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.After
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut
import org.aspectj.lang.reflect.MethodSignature

/**
 * author: WentaoKing
 * created on: 2022/2/21
 * description: 时间消费切面类
 */
@Aspect
class TimeConsumeAspect {

    companion object {
        private const val TAG = "TimeConsumeAspect"
    }

    var startTime: Long = 0

    @Pointcut("execution(@com.example.aopdemo.TimeConsume * *(..))")
    fun methodTimeConsumePoint() {
    }

    @Before("methodTimeConsumePoint()")
    fun doBefore(joinPoint: JoinPoint) {
        val signature: MethodSignature = joinPoint.signature as MethodSignature
        val method = signature.method
        Log.d(TAG, "doBefore: $method")
        startTime = System.currentTimeMillis()
    }

    @After("methodTimeConsumePoint()")
    fun doAfter() {
        val endTime = System.currentTimeMillis()
        val consumeTime = endTime - startTime
        Log.d(TAG, "开始于${startTime}，结束于$endTime, 耗时 $consumeTime ms")
    }

}