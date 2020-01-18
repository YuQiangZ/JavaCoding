package com.yuqiangz.java1;

/**
 * 使用同步机制将单例模式中的懒汉式改写为线程安全的
 * @author yuqiangzhao
 * @create 2020-01-18 7:28
 */
public class Bank {
    private  Bank(){}
    private   static  Bank instance = null;

//    public static synchronized Bank getInstance() {//线程的安全
//        if (instance == null) {
//            instance = new Bank();
//        }
//        return  instance;
//    }
    //比较高效的方法
        public static  Bank getInstance(){
            if (instance == null) {
                synchronized (Bank.class){
                    if (instance == null) {
                        instance =new Bank();
                    }
                }
            }
            return  instance;
        }
}
