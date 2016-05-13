package com.tom.annotation_spring_right;

import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URLEncoder;

/**
 * Created by tom on 2016/5/3.
 */
public class AuthorityAnnotationInterceptor extends HandlerInterceptorAdapter {
    final Logger logger = LoggerFactory.getLogger(AuthorityAnnotationInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        FireAuthority fireAuthority = ((HandlerMethod) handler).getMethodAnnotation(FireAuthority.class);
        if (fireAuthority == null) {
            //没有权限检查，放行
            return true;
        }
        //从session中取出权限信息

        Integer[] rights = (Integer[]) WebUtils.getSessionAttribute(request, "ACCESS_RIGHTS");
        if (ArrayUtils.contains(rights, fireAuthority.accessRightId())) {
            //拥有权限，不需要拦截
            return true;
        }
        //没有权限，需要拦截输出错误
        if (fireAuthority.resultType() == ResultTypeEnum.page) {
            //传统的登录页面
            StringBuilder sb = new StringBuilder();
            sb.append(request.getContextPath());
            sb.append("/error?oprst=false&opmsg=NOT_HAVE_AUTHORITY");
            response.sendRedirect(sb.toString());
        } else if (fireAuthority.resultType() == ResultTypeEnum.json) {
            //ajax类型的登录提示
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=UTF-8");
            OutputStream out = response.getOutputStream();
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(out, "utf-8"));
            pw.println("{\"result\":false,\"code\":12,\"errorMessage\":\"NOT_HAVE_AUTHORITY\"}");
            pw.flush();
            pw.close();
        }
        return false;
    }
}
