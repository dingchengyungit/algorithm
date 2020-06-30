package com.dcy.thread;

import java.util.concurrent.*;

/**
 * @author dingchengyun
 * @date 2020/6/30
 * @description
 */
public class TestThreadPool {
    public static void main(String[] args){
        ExecutorService es = Executors.newFixedThreadPool(5);
        Callable callable = new Callable() {
            public Object call() throws Exception {

                Thread.sleep(5000);
                System.out.println("线程处理开始...");
                int a = 0;
                int b = 3;
                System.out.println("除以0的结果为：" + b / a);
                System.out.println("线程处理结束...");
                return "0";
            }
        };
        for (int i = 0;i <5 ;i++){

            try {
                ThreadPoolExecutor tpe = ((ThreadPoolExecutor) es);
                System.out.println(tpe.getActiveCount() );
                Future<String> future = es.submit(callable);
//                System.out.println("任务执行完成，结果为：" + future.get());
//                Thread.sleep(2500);
            }catch (Exception e ){
                System.out.println("捕获到异常！");
            }

        }
        System.out.println("");
        es.shutdown();
    }
}

