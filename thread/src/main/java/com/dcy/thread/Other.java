package com.dcy.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author dingchengyun
 * @date 2020/7/9
 * @description
 */
public class Other {

    public static void main(String[] args) {

        // 创建线程的方式
        Map<Object, Object> m =new HashMap<>();
        m.put(null, null);
//        CurrentHashMap m = new ;
        MyThread t1 = new MyThread();

        RThread r = new RThread();
        Thread t2 = new Thread(r);

        CThread c = new CThread();
        FutureTask<String> f = new FutureTask<String>(c);
        Thread t3 = new Thread(f);

        Thread t4 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(i);
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            System.out.println(f.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


}

class MyThread extends Thread {
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("继承thread类，线程id：" + Thread.currentThread().getName() + "---" + i);
        }
    }
}

class RThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {

            System.out.println("实现Runnable接口，线程id：" + Thread.currentThread().getName() + "---" + i);
        }
    }
}

class CThread<String> implements Callable<String> {

    @Override
    public String call() throws Exception {
        return (String) ("实现Callable接口，线程id:" + Thread.currentThread().getName());
    }
}
