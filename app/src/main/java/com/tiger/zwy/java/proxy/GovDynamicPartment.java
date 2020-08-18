package com.tiger.zwy.java.proxy;

/**
 * @author zwy
 * create at 2020/7/2 0002
 * description:
 */
public class GovDynamicPartment implements ISettle {

    @Override
    public void settle() {
        System.out.println("----落户----");
    }
}
