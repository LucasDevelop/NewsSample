package com.lucas.newssample.utils;

import android.content.Context;
import android.graphics.Point;
import android.view.WindowManager;

/**
 * 作者：lucas on 2016/7/4 10:46
 * 邮箱：lucas_developer@163.com
 * 说明：
 */
public abstract class ViewUtils {
    /**
     * 获取屏幕的宽高
     * width: point.x  height: point.y
     * @param context 上下文
     * @return 屏幕相关信息
     */
    public static Point getWindowSize(Context context){
        WindowManager service = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Point outSize = new Point();
        service.getDefaultDisplay().getSize(outSize);
        return outSize;
    }
}
