package com.zeal.android.router.core.utils;

import com.zeal.android.router.core.RouteConsts;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RouteUtil {

    public static String getClassName(String path) {
        return RouteConsts.CORE_PACKAGE_NAME + "." + getSimpleClassName(path);
    }

    public static String getSimpleClassName(String path) {
        return "Route_" + path.substring(1, path.lastIndexOf("/"));
    }

    public static String getActivityTag(String path) {
        return path.substring(path.lastIndexOf("/") + 1);
    }

    public static Class getClass(String path) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> clazz = Class.forName(RouteUtil.getClassName(path));
        Method method = clazz.getMethod(RouteConsts.METHOD_NAME, String.class);
        return (Class) method.invoke(null, RouteUtil.getActivityTag(path));
    }
}
