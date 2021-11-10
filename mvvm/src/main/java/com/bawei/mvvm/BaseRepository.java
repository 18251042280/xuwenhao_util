package com.bawei.mvvm;


import java.lang.reflect.Field;

/**
 * Created by Android Studio.
 * User: 小徐
 * Date: 2021/11/9
 * Time: 18:32
 */
public abstract class BaseRepository {

    public BaseRepository() {
        injectModel();
    }

    private void injectModel(){
        Class<? extends BaseRepository> aClass = this.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        if (declaredFields.length==0){
            throw new RuntimeException("没有匹配的");
        }

        boolean falg = false;
        for (Field declaredField : declaredFields) {
            Model annotation = declaredField.getAnnotation(Model.class);
            if (null!=annotation){
                declaredField.setAccessible(true);
                falg = true;
                String name = declaredField.getType().getName();
                try {
                    Class<?> aClass1 = Class.forName(name);
                    Object o = aClass1.newInstance();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }
        if (!falg){
            throw new RuntimeException("没有model");
        }
    }
}