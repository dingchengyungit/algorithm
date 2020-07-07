package com.dcy.thread;

import org.openjdk.jol.info.ClassLayout;

import java.sql.Time;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dingchengyun
 * @date 2020/7/3
 * @description
 */
public class TestLock {

    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        Lock lock = new ReentrantLock();

//        lock.lock();

        synchronized (o) {

            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }

        TimeUnit.SECONDS.sleep(1L);

        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        CountDownLatch c = new CountDownLatch(1);
        c.await();
//        lock.unlock();

    }
}
