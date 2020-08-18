package com.tiger.zwy.java.proxy;

/**
 * @author zwy
 * create at 2020/7/2 0002
 * description:
 */
public class Decorator implements Componet{
    private Componet component;

    public Decorator(Componet component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
    }

}
