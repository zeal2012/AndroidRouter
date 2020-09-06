package com.zeal.android.router.core;

public class Router {

    public interface OnRouteListener{
        Class<?> getClazz(String path);
    }

    private OnRouteListener onRouteListener;

    public void addOnRouteListener(OnRouteListener onRouteListener) {
        this.onRouteListener = onRouteListener;
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

    public Class getClazz(String annotationPath){
        if (onRouteListener != null){
            return onRouteListener.getClazz(annotationPath);
        }
        return null;
    }

}
