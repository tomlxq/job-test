package com.tom.aop;

/**
 * Created by tom on 2016/5/3.
 */


public class BusinessImpl implements IBusiness {
    public void execute() {
        logger.debug("{}","业务逻辑的执行");
        //System.out.println("BusinessImpl.excute");
    }
}
