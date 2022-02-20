package com.example.aopdemo

import android.util.Log
import android.view.View
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.aspectj.lang.reflect.MethodSignature

/**
 * author: WentaoKing
 * created on: 2022/2/11
 * description: 快速点击view的切面处理类
 */
@Aspect
class FastClickViewAspect {

    companion object {
        private const val TAG = "FastClickViewAspect"
    }

    @Pointcut("execution(@com.example.aopdemo.FastClickView * *(..))")
    fun executeFastClickViewLimit() { }

    @Around("executeFastClickViewLimit()")
    @Throws(Throwable::class)
    fun aroundExecuteFastClickViewLimit(joinPoint: ProceedingJoinPoint) {
        Log.d(TAG, "aroundClickCountLimit: ")
        val signature: MethodSignature = joinPoint.signature as MethodSignature
        // 取出JoinPoint的方法
        val method = signature.method
        if (method.isAnnotationPresent(FastClickView::class.java)) {
            val annotation: FastClickView? = method.getAnnotation(FastClickView::class.java)
            annotation?.let {
                val interval = annotation.interval
                val view = joinPoint.args[0] as View
                if (!FastClickCheckUtil.isFastClick(view, interval)) {
                    joinPoint.proceed()
                }
            }
        }
    }

}