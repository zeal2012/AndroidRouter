帮助 Android App 进行组件化改造的轻量级路由框架，使模块间的activity可以灵活跳转



本地jar包导入使用方法：

1 导入jar包 

1）将项目根目录的/jar/router-core-1.0.jar文件添加到到工程的base模块的libs下，在base模块的build.gradle中添加依赖

```
api files('libs\router-core-1.0.jar') 
```

（如果没有base模块，则需要在使用到 @Route的每个模块添加此依赖）



 2）在使用注解 @Route 的模块的 build.gradle 中添加注解处理器，如：

```
dependencies{ 
	annotationProcessor files('..\base\libs\router-core-1.0.jar') 
}
```



2 在Application的onCreate()方法中添加： 

```
Router.getInstance().addOnRouteListener(new Router.OnRouteListener() {
            @Override
            public Class<?> getClazz(String path) {
                try {
                    return RouteUtil.getClazz(path);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                return null;
            }
        });
```



3 使用 

1）在需要跳转到的目标activity中添加注解，path格式为：/模块名/activity别名

```
@Route(path = "/app/SecondActivityAlias") 
public class SecondActivity extends AppCompatActivity {
	
}
```

(注：path需要遵循 “/模块名/activity” 的格式，否则编译时不能通过) 



2）其他模块跳转到 SecondActivity

```
Class clazz = Router.getInstance().getClazz("/app/SecondActivityAlias"); 
startActivity(new Intent(mContext, clazz));
```

