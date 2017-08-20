package com.wcc.classloader;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by WCC on 2017/3/15.
 * 类与加载器
 * 比较两个类来源是否相等，只有在这两个类是同一个类加载器加载的前提下
 * 才有意义，否则，即使这两个类来源于同一个Class文件，被同一个虚拟机加载
 * ，只要加载他们的类加载器不同，那么这两个类就必定不相等。
 *
 * 返回的第二个结果是 false
 * 这是因为 虚拟机中存在了两个 ClassLoaderTest类，一个是由系统应用程序类
 * 加载器加载的，另外一个是由我们自己定义的类加载器加载的，虽然是同一个Class文件
 * 但是依然是两个独立的类，做对象所属类型检查是结果自然是 false
 *
 */
public class ClasserLoaderTest {

    public static void main(String[] args){
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String  fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream inputStream = getClass().getResourceAsStream(fileName);
                    if (inputStream == null){
                        return  super.loadClass(name);
                    }
                    byte[] b = new byte[inputStream.available()];
                    inputStream.read(b);
                    return  defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        };

        try {
            Object object = null;
            try {
                object = myLoader.loadClass("com.wcc.classloader.ClasserLoaderTest").newInstance();
                System.out.println(object.getClass());
                System.out.println(object instanceof  com.wcc.classloader.ClasserLoaderTest);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        }
    }
}
