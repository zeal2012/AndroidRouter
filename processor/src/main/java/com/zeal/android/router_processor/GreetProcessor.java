package com.zeal.android.router_processor;


import java.io.Writer;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.ElementFilter;
import javax.tools.JavaFileObject;

// 这里填写要处理的注解类
@SupportedAnnotationTypes("com.zeal.android.router_processor.Route")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class GreetProcessor extends AbstractProcessor {

    private Filer filerUtils;

    private final String PACKAGE_NAME = "com.zeal.android.router_core";

    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        filerUtils = processingEnv.getFiler();
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnv) {
        System.out.println(" ======================== GreetProcessor::process() ========================= ");

        try {
            // 1.获取类型信息
            Collection<? extends Element> annotatedElements = roundEnv.getElementsAnnotatedWith(Route.class);
            System.out.println("annotatedElements:" + annotatedElements.size());
            List<TypeElement> types = ElementFilter.typesIn(annotatedElements);
            if (types == null || types.size() == 0)
                return false;

            String className;
            String path = null;
            String simpleClassName;

//            for (TypeElement type : types) {
//                path = type.getAnnotation(Route.class).path();          //path_ThirdActivity
//                className = type.asType().toString();            //com.example.lsn16_test2.ThirdActivity
//                simpleName = type.getSimpleName().toString();    //ThirdActivity
//                System.out.println("===========================");
//                System.out.println("path:" + path);
//                System.out.println("className:" + className);
//                System.out.println("simpleName:" + simpleName.toString());
//            }

            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("package ")
                    .append(PACKAGE_NAME)
                    .append(";\n\n")
                    .append("import java.util.HashMap;\n")
                    .append("import java.util.Map;\n");

            for (TypeElement type : types) {
                className = type.asType().toString();            //com.example.lsn16_test2.ThirdActivity
                stringBuffer.append("import " + className + ";\n");
                if (path == null) {
                    path = type.getAnnotation(Route.class).path();          // app/SecondActivity
                }
            }
            stringBuffer.append("\n");
            String routeClazzName = "Route" + getModuleName(path);
            stringBuffer.append("public class ")
                    .append(routeClazzName)
                    .append(" {\n\n")
                    .append("    public static Class getClazz(String activityTag) {\n")
                    .append("        switch (activityTag){\n");

            for (TypeElement type : types) {
                path = type.getAnnotation(Route.class).path();
                simpleClassName = type.getSimpleName().toString();
                stringBuffer.append("            case \"")
                        .append(getActivityTag(path))
                        .append("\":\n")
                        .append("                return ")
                        .append(simpleClassName)
                        .append(".class;\n");
            }
            stringBuffer.append("        }\n")
                    .append("        return null;\n")
                    .append("    }\n")
                    .append("}\n");

            // 3.生成Java源文件
            JavaFileObject javaFileObject = processingEnv.getFiler().createSourceFile(PACKAGE_NAME + "." + routeClazzName);
            Writer writer = javaFileObject.openWriter();
            writer.write(stringBuffer.toString());
            writer.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception: " + e.getMessage());

        }
        return false;
    }

    public static String getModuleName(String routePath) {
        return routePath.substring(0, routePath.indexOf("/"));
    }

    public static String getActivityTag(String routePath) {
        return routePath.substring(routePath.indexOf("/") + 1);
    }

}
