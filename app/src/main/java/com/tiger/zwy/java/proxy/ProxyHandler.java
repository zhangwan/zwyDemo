package com.tiger.zwy.java.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author zwy
 * create at 2020/7/2 0002
 * description:
 */
public class ProxyHandler implements InvocationHandler {
    private Object target;

    //真实主题通过构造方法传递进来
    public ProxyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("整理相关资料");
        // 调用真实主题的方法
        Object result = method.invoke(target, args); //placeholder
        System.out.println("邮寄资料给客户");
        return result;
    }
}
