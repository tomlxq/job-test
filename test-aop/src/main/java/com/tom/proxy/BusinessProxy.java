package com.tom.proxy;

/**
 * Created by tom on 2016/5/22.
 */
public class BusinessProxy implements IBusiness {
    private IBusiness bi = null;

    public BusinessProxy(IBusiness bi) {
        this.bi = bi;
    }

    public void doBusiness() {
        System.out.println("事务、日志、权限等操作");
        bi.doBusiness();
        System.out.println("事务、日志、权限等操作");
    }

    public static void main(String[] args) {
        IBusiness bi = new BusinessImpl();
        BusinessProxy proxy = new BusinessProxy(bi);
        proxy.doBusiness();
    }
}
