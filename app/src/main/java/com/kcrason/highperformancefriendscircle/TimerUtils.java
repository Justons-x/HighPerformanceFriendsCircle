package com.kcrason.highperformancefriendscircle;

import android.annotation.SuppressLint;

import com.kcrason.highperformancefriendscircle.enums.TranslationState;
import com.kcrason.highperformancefriendscircle.interfaces.OnTimerResultListener;

import java.util.concurrent.TimeUnit;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * @author KCrason
 * @date 2018/5/2
 */
public class TimerUtils {

    @SuppressLint("CheckResult")
    public static void timerTranslation(OnTimerResultListener onTimerResultListener) {
        Single.timer(1000, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread()).subscribe(aLong -> {
            if (onTimerResultListener != null) {
                onTimerResultListener.onTimerResult();
            }
        });
    }
}
