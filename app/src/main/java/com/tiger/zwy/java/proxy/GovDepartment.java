package com.tiger.zwy.java.proxy;

/**
 * @author zwy
 * create at 2020/7/2 0002
 * description:
 */
public class GovDepartment implements IBusiness {
    @Override
    public void registerCompany() {
        System.out.println("-----注册公司----");
    }
}
