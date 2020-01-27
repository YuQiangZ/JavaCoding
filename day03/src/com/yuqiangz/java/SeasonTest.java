package com.yuqiangz.java;

/**
 * 使用enum关键字定义枚举类
 * 说明：定义的枚举类默认继承与java.lang.Enum类
 * 很好的关于枚举类的例子
 * @author yuqiangzhao
 * @create 2020-01-21 11:16
 */
public class SeasonTest {
    public static void main(String[] args) {
        Season summer = Season.SUMMER;
        //toString():返回枚举类对象的名称
        System.out.println(summer);

        System.out.println("****************");
        //values():返回所有的枚举类对象构成的数组
        Season[] values = Season.values();
        for (Season value : values) {
            System.out.println(value);
            value.show();
        }
        System.out.println("****************");
        Thread.State[] values1 = Thread.State.values();
        for (Thread.State state : values1) {
            System.out.println(state);
        }

        //valueOf(String objName):返回枚举类中对象名是objName的对象。
        Season winter = Season.valueOf("WINTER");
        //如果没有objName的枚举类对象，则抛异常：IllegalArgumentException

        System.out.println(winter);
        winter.show();
        System.out.println(winter.getSeasonDesc());

    }
}

interface  Info{
    /**
     * 显示对应类型的对应天气信息
     */
    void show();
}

enum Season implements Info{
    //1.提供当前枚举类的对象，多个对象之间用","隔开，末尾对象";"结束
    SPRING("春天","春暖花开"){
        @Override
        public void show() {
            System.out.println("春天在哪里？");
        }
    },
    SUMMER("夏天","夏日炎炎"){
        @Override
        public void show() {
            System.out.println("宁夏");
        }
    },
    AUTUMN("秋天","秋高气爽"){
        @Override
        public void show() {
            System.out.println("秋天不回来");
        }
    },
    WINTER("冬天","冰天雪地"){
        @Override
        public void show() {
            System.out.println("大约在冬季");
        }
    };

    //2.声明Season对象的属性:private final修饰
    private final String seasonName;
    private final String seasonDesc;

    //2.私有化类的构造器,并给对象属性赋值

    private Season(String seasonName,String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //4.其他诉求1：获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }
}