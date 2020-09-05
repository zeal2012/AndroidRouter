package com.zeal.android.router;

import android.app.Application;

import com.zeal.android.router_core.RouteApp;
import com.zeal.android.router_core.RouteConsts;
import com.zeal.android.router_core.RouteMeta;
import com.zeal.android.router_core.RouteModule1;
import com.zeal.android.router_core.RouteModule2;
import com.zeal.android.router_core.utils.RouteUtil;
import com.zeal.android.router_core.Router;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Router.getInstance().setOnRouteListener(new Router.OnRouteListener() {
            @Override
            public Class getClazz(String path) {
                RouteMeta routeMeta = RouteUtil.getRouteMeta(path);
                Class clazz = null;
                switch (routeMeta.getModuleName()) {
                    case RouteConsts.MODULE_APP:
                        clazz = RouteApp.getClazz(routeMeta.getActivityTag());
                        break;
                    case RouteConsts.MODULE_1:
                        clazz = RouteModule1.getClazz(routeMeta.getActivityTag());
                        break;
                    case RouteConsts.MODULE_2:
                        clazz = RouteModule2.getClazz(routeMeta.getActivityTag());
                        break;
                }
                return clazz;
            }
        });

    }
}
