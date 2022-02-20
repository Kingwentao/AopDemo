package com.example.aopdemo

import android.util.Log
import android.view.View

/**
 * author: WentaoKing
 * created on: 2022/2/11
 * description: 快速点击检查类
 */
object FastClickCheckUtil {

    private const val TAG = "FastClickCheckUtil"
    /**
     * 判断是否属于快速点击
     *
     * @param view     点击的View
     * @param interval 快速点击的阈值
     * @return true：快速点击
     */
    fun isFastClick(view: View, interval: Long): Boolean {
        val key: Int = view.id
        Log.d(TAG, "isFastClick: $view $interval")
        val currentClickTime: Long = System.currentTimeMillis()
        // 如果两次点击间隔超过阈值，则不是快速点击
        if (view.getTag(key) == null || currentClickTime - (view.getTag(key) as Long) > interval) {
            // 保存最近点击时间
            view.setTag(key, currentClickTime)
            return false
        }else{
            return true
        }

    }
}


