package com.dcy.thread;

import com.google.common.util.concurrent.*;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author dingchengyun
 * @date 2020/12/23
 * @description
 */
public class ListenFutureTest {
    public static void main(String[] args) {

        testListenFuture();

    }


    public static void testListenFuture() {

        System.out.println("主任务执行完，开始异步执行副任务1.....");

        ListeningExecutorService pool = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(5));

        ListenableFuture<String> future = pool.submit(new Task());

        Futures.addCallback(future, new FutureCallback<String>() {
            @Override
            public void onSuccess(@Nullable String s) {
                System.out.println("ok : " + s);
            }

            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("error");
            }
        }, new Executor() {
            @Override
            public void execute(Runnable command) {

            }
        });

        System.out.println("副本任务启动,回归主任务线，主业务正常返回2.....");

    }

}


class Task implements Callable<String> {

    public String call() throws Exception {

        TimeUnit.SECONDS.sleep(1);

// int a =1/0;

        return "task done";

    }

}
