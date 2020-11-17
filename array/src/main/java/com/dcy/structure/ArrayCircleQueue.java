package com.dcy.structure;

import java.util.Scanner;

/**
 * @author dingchengyun
 * @date 2020/11/5
 * @description
 */
public class ArrayCircleQueue {

    // 数组最大容量
    private int maxSize;
    // 指向队列的第一个元素，初始值为0
    private int front;
    // 指向队列最后一个元素的后一个位置，初始值为0，这样整个数组留有一个空位
    private int rear;
    // 存放数据的数组
    private int[] arr;

    public ArrayCircleQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    // 队列是否满了
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    // 队列是否为空
    public boolean isEmpty() {
        return front == rear;
    }

    public void addQueue(int n) {
        if (isFull()) {
            throw new RuntimeException("queue is full, can not add");
        }

        arr[rear] = n;
        rear = (rear + 1) % maxSize; // 需要考虑取模
    }

    public int getQueue() {
        if (isEmpty()) {
            System.out.println("queue is empty, can not get");
            throw new RuntimeException("queue is empty, can not get");
        }
        // 1. 先把front 对应的值保存到临时变量
        // 2. 将front 后移
        // 3. 将临时保存的变量返回
        int result = arr[front];
        front = (front + 1) % maxSize; // 需要考虑取模
        return result;
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("queue is empty...");
            return;
        }
        // 需要考虑环形队列
        for (int i = front; i < this.queueLength() + front; i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("queue is empty..");
        }
        return arr[front];
    }

    public int queueLength() {
        return  (rear + maxSize - front) % maxSize;
    }

    public static void main(String[] args) {
        ArrayCircleQueue arrayQueue = new ArrayCircleQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");

            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    arrayQueue.printQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数字");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.println("取出来的数字是：" + res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = arrayQueue.headQueue();
                        System.out.println("队列头的数字是：" + res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序 退出..");

    }
}
