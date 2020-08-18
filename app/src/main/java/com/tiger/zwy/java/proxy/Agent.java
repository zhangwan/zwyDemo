package com.tiger.zwy.java.proxy;

/**
 * @author zwy
 * create at 2020/7/2 0002
 * description:
 */
public class Agent implements IBusiness {
    private IBusiness business;

    public Agent() {
        this.business = new GovDepartment();
    }
    @Override
    public void registerCompany() {
        before();
        business.registerCompany();
        after();
    }
    private void before() {
        System.out.println("整理相关资料...");
    }

    private void after() {
        System.out.println("邮寄证件给客户...");
    }

}
