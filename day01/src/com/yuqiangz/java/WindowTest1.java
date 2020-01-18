package com.yuqiangz.java;
/**
 * 三个窗口卖票，总票数100.
 * 解决：给线程加锁
 * @author yuqiangzhao
 * @create 2020-01-17 18:56
 */
public class WindowTest1 {
    public static void main(String[] args) {
        window t1 = new window();

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

class  window implements  Runnable{
    private  int ticket = 100;
    final Object obj = new Object();
    @Override
    public void run() {
        while (true){
            synchronized(obj) {//使用this,是唯一的。
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "：卖票，票号：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}