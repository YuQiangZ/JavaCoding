package com.yuqiangz.java;

/**
 * 使用同步方法
 * @author yuqiangzhao
 * @create 2020-01-18 7:02
 */
public class WindowTest3 {
    public static void main(String[] args) {
        window3 t1 = new window3();

        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t1);
        Thread thread3 = new Thread(t1);

        thread1.setName("窗口一");
        thread2.setName("窗口二");
        thread3.setName("窗口三");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class  window3 implements  Runnable{
    private  int ticket = 100;
    final Object obj = new Object();

    private synchronized void show(){//同步方法
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "：卖票，票号：" + ticket);
            ticket--;
        }
    }
    @Override
    public void run() {
        while (true) {
            show();
        }
    }
}
