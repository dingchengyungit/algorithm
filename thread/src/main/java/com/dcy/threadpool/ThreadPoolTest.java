package com.dcy.threadpool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author dingchengyun
 * @date 2021/1/16
 * @description
 */
public class ThreadPoolTest {
    ExecutorService executorService = new ThreadPoolExecutor(10,100,1000,
            TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>(100),
            new ThreadFactoryBuilder().build(),
            new ThreadPoolExecutor.AbortPolicy());


    public void threadPool() {
        for (int i = 0; i < 11; i++) {
            Thread t = new MyThread(i);
            t.setName("dcy-thead-name-" + i);
            executorService.execute(t);
        }
        executorService.shutdown();
//        executorService.submit();
        System.out.println("main end...");;
    }

    public static void main(String[] args) {
        ThreadPoolTest t = new ThreadPoolTest();
        t.threadPool();
//        try {
//            TimeUnit.MINUTES.sleep(5);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("main end...");;

    }

    static class MyThread extends Thread {
        int i;
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "---" + i);
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public MyThread(int i) {
            this.i = i;
        }


    }

}
