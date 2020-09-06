package com.zeal.android.router;

import android.app.Application;

import com.zeal.android.router.core.Router;
import com.zeal.android.router.core.utils.RouteUtil;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Router.getInstance().addOnRouteListener(new Router.OnRouteListener() {
            @Override
            public Class<?> getClazz(String path) {
                try {
                    return RouteUtil.getClazz(path);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
        });
    }
}
