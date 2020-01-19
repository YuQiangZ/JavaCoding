package com.yuqiangz.java1;


import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全的问题之方式三：Lock锁  JDK5.0
 * @author yuqiangzhao
 * @create 2020-01-18 8:26
 */
public class LockTest {
    public static void main(String[] args) {
        Window4 t1 = new Window4();

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


class  Window4 implements Runnable{
    private  int ticket = 100;
    //1.声明对象
    private ReentrantLock lock = new ReentrantLock();//fair（公平）

    @Override
    public void run() {
        while(true){
            try{
                //2.调用lock()
                lock.lock();
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "：卖票，票号：" + ticket);
                    ticket--;
                }else{
                    break;
                }
            }finally {
                //3.解锁
                lock.unlock();
            }
        }
    }
}