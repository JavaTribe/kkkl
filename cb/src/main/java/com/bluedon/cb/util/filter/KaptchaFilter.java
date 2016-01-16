/**
 * Copyright (c) 2015
 * Company:蓝盾信息安全技术股份有限公司(Bluedon Information Security Technologies Co.,Ltd)
 * All rights reserved.
 */
package com.bluedon.cb.util.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

/**
 * Description:Kaptcha校验码过滤器
 * Time:2015年12月1日上午9:53:46
 * @version 1.0
 * @since 1.0
 * @author chenchengteng
 */
@Component
public class KaptchaFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		 HttpServletRequest req = (HttpServletRequest) request;
         HttpServletResponse res = (HttpServletResponse) response;
         String kaptchaExpected=(String)req.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
         String kaptchaReceived = request.getParameter("kaptcha");  
         if (kaptchaReceived == null || !kaptchaReceived.equalsIgnoreCase(kaptchaExpected)){  
        	 res.sendRedirect(req.getContextPath() + "/codeCheckFailed");
         }else{
        	 chain.doFilter(request, response);
         }
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
