package com.zeal.android.router_core;

import java.util.HashMap;
import java.util.Map;

public class Router {

    public interface OnRouteListener{
        Class getClazz(String path);
    }

    private OnRouteListener onRouteListener;

    public OnRouteListener getOnRouteListener() {
        return onRouteListener;
    }

    private static Router instance;

    public static Router getInstance(){
        if (instance != null){
            return instance;
        }
        synchronized (Router.class){
            if (instance == null){
                instance = new Router();
            }
        }
        return instance;
    }

    public void setOnRouteListener(OnRouteListener onRouteListener) {
        this.onRouteListener = onRouteListener;
    }

    public Class getClazz(String annotationPath){
        if (onRouteListener != null){
            return onRouteListener.getClazz(annotationPath);
        }
        return null;
    }

}
