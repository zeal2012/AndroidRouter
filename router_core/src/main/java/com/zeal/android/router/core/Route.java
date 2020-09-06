package com.zeal.android.router.core;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//编译阶段
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)
public @interface Route {
    /**
     *路由的路径，标识一个路由节点, /module/activity
     */
    String path();
}
