package com.zeal.android.router.core.utils;

import com.zeal.android.router.core.RouteConsts;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RouteUtil {

    public static String getClassName(String routePath) {
        return RouteConsts.CORE_PACKAGE_NAME + "." + getSimpleClassName(routePath);
    }

    public static String getSimpleClassName(String routePath) {
        return "Route" + routePath.substring(0, routePath.indexOf("/"));
    }

    public static String getActivityTag(String routePath) {
        return routePath.substring(routePath.indexOf("/") + 1);
    }

    public static Class getClass(String path) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> clazz = Class.forName(RouteUtil.getClassName(path));
        Method method = clazz.getMethod(RouteConsts.METHOD_NAME, String.class);
        return (Class)method.invoke(null, RouteUtil.getActivityTag(path));
    }
}
