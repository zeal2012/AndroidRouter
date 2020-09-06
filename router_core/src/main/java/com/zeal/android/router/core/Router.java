package com.zeal.android.router.core;

public class Router {

    private static Router instance;

    private OnRouteListener onRouteListener;

    private Router() {

    }

    public static Router getInstance() {
        if (instance != null) {
            return instance;
        }
        synchronized (Router.class) {
            if (instance == null) {
                instance = new Router();
            }
        }
        return instance;
    }


    public interface OnRouteListener {
        Class<?> getClazz(String path);
    }

    public void addOnRouteListener(OnRouteListener onRouteListener) {
        this.onRouteListener = onRouteListener;
    }

    public Class getClazz(String annotationPath) {
        if (onRouteListener != null) {
            return onRouteListener.getClazz(annotationPath);
        }
        return null;
    }

}
