/**
 * Created by tom on 2016/5/3.
 */
package com.tom.aop;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public interface IBusiness {
       Logger logger=LoggerFactory.getLogger(IBusiness.class);
     void execute();
}