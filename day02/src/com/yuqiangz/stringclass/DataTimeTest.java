package com.yuqiangz.stringclass;

import org.junit.Test;

import java.util.Date;

/**
 * @author yuqiangzhao
 * @create 2020-01-20 10:28
 */
public class DataTimeTest {
    @Test
    public void test2(){
        //构造器:Date():创建一个对应当前时间的Date对象
        Date date1 = new Date();
        System.out.println(date1.toString());
        System.out.println(date1.getTime());
    }
}
