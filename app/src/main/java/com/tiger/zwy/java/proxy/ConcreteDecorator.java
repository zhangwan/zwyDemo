package com.tiger.zwy.java.proxy;

/**
 * @author zwy
 * create at 2020/7/2 0002
 * description:
 */
public class ConcreteDecorator extends Decorator  {
    public ConcreteDecorator(Componet component) {
        super(component);
    }
    @Override
    public void operation() {
        System.out.println("在处理之前，增加点功能...");
        super.operation();

    }
}
