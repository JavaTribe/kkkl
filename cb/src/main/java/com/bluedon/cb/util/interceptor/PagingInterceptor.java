/**
 * Copyright (c) 2015
 * Company:蓝盾信息安全技术股份有限公司(Bluedon Information Security Technologies Co.,Ltd)
 * All rights reserved.
 */
package com.bluedon.cb.util.interceptor;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.bluedon.cb.util.paging.PageContext;

/**
 * Description:设置默认不分页拦截器
 * Time:2015年12月4日下午2:40:54
 * @version 1.0
 * @since 1.0
 * @author chenchengteng
 */
@Component
@Aspect
public class PagingInterceptor {
	
	@Pointcut("execution(* com.bluedon.cb.*.controller.*.*(..))")
	public void doPageFalseBefore() throws Throwable{
    	PageContext.getContext().setPagination(false);
    }
}
