package com.dcy.prodconsum;

/**
 * @author dingchengyun
 * @date 2021/1/2
 * @description
 */
public class TestProduct {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer p = new Producer(clerk);
        Thread tp = new Thread(p);

        Consumer c = new Consumer(clerk);
        Thread tc = new Thread(c);

        tp.start();
        tc.start();
    }
}

class Producer implements Runnable {
    Clerk clerk;
    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println("生产者生产产品。");
        while (true) {
            try {
                Thread.sleep((int)Math.random() * 1000);
                clerk.addProduct();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
    Clerk clerk;
    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println("消费者消费产品。");
        while (true) {
            try {
                Thread.sleep((int)Math.random() * 1000);
                clerk.consumeProduct();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Clerk {
    int product;

    public synchronized void consumeProduct() {
        if (product <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            product--;
            System.out.println(Thread.currentThread().getName() + "消费产品第" + product + "个产品");
            notifyAll();
        }
    }
    public synchronized void addProduct() {
        if (product >= 20) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            product++;
            System.out.println(Thread.currentThread().getName() + "生产第" + product + "个产品");
            notifyAll();
        }
    }
}
