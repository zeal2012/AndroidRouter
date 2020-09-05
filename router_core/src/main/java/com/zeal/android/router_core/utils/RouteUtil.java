package com.zeal.android.router_core.utils;


import com.zeal.android.router_core.RouteMeta;

public class RouteUtil {

    public static RouteMeta getRouteMeta(String routePath) {
        String[] split = routePath.split("/");
        RouteMeta routeMeta = new RouteMeta();
        routeMeta.setModuleName(split[0]);
        routeMeta.setActivityTag(split[1]);
        return routeMeta;
    }
}
