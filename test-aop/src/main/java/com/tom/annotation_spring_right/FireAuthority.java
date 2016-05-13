package com.tom.annotation_spring_right;

import java.lang.annotation.*;

/**
 * Created by tom on 2016/5/3.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FireAuthority {//annotation类, 用于标注到需要权限验证的地方
    int accessRightId();//传入的权限位
    ResultTypeEnum resultType() default ResultTypeEnum.page;

}
