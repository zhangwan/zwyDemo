package com.tiger.zwy.java.proxy;

/**
 * @author zwy
 * create at 2020/7/2 0002
 * description:
 */
public class ConcreteComponent implements Componet {
    @Override
    public void operation() {
        System.out.println("正在处理相关逻辑...");
    }
}