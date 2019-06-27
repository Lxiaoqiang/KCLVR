package com.zcsmart.kclvr;

/**
 * @Date 2019/6/27 10:29
 * @auth lihuiqiang
 * @discription
 */
public class LamdaJavaTest {


    public static void main(String[] args) {
        a(()->{});

        Runnable runnable = () ->{};
    }

    private static void a(Callback callback){

    }

    public interface Callback{
        void test();
    }
}
