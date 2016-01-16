package com.bluedon.cb.util.log;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.bluedon.cb.common.controller.IndexController;
import com.bluedon.cb.common.entity.SystemLog;
import com.bluedon.cb.util.DateUtil;
import com.bluedon.cb.util.session.SessionPropertyUtil;

@Component
@Aspect
public class SystemLogAspect {
	private Logger logger = LoggerFactory.getLogger(IndexController.class);
	//Service层切点    
     public  void serviceAspect() {    
    }    
    
    //Controller层切点    
    @Pointcut("@annotation(com.bluedon.cb.module.admin.controller.AdminDepartmentController)")    
     public  void controllerAspect() {    
    }    
    
    /**  
     * 前置通知 用于拦截Controller层记录用户的操作  
     *  
     * @param joinPoint 切点  
     */    
    @Before("controllerAspect()")    
     public  void doBefore(JoinPoint joinPoint) {    
    	
         try {    
            SystemLog systemLog=new SystemLog();
            systemLog.setSyloCreateDate(DateUtil.getCurrentTime());
            systemLog.setSyloIp(SessionPropertyUtil.getIP());
            systemLog.setSyloDescription(getControllerMethodDescription(joinPoint));
            systemLog.setSyloMethod(joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()");
            if(SessionPropertyUtil.getUserAccount()!=null){
            	systemLog.setSyloUsroName(SessionPropertyUtil.getUserAccount());
            }else{
            	systemLog.setSyloUsroName(SessionPropertyUtil.getAdmiAccount());
            }
            if(SessionPropertyUtil.getUsroId()!=null){
            	systemLog.setSyloUsroId(SessionPropertyUtil.getUsroId());
            }else{
            	systemLog.setSyloUsroId(SessionPropertyUtil.getAdroId());
            }
            systemLog.setSyloRoleName(SessionPropertyUtil.getRoleName());
            systemLog.setSyloParams(getParams(joinPoint));
            //保存数据库    
            System.out.println("=====前置通知结束====="+JSON.toJSONString(systemLog));    
        }  catch (Exception e) {    
            //记录本地异常日志    
            logger.error("==前置通知异常==");    
            logger.error("异常信息:{}", e.getMessage());    
        }    
    }    
    
    /**  
     * 异常通知 用于拦截service层记录异常日志  
     *  
     * @param joinPoint  
     * @param e  
     */    
    @AfterThrowing(pointcut = "serviceAspect()", throwing = "e")    
     public  void doAfterThrowing(JoinPoint joinPoint, Throwable e) {    
  
    }    
    
    
    /**  
     * 获取注解中对方法的描述信息 用于service层注解  
     *  
     * @param joinPoint 切点  
     * @return 方法描述  
     * @throws Exception  
     */    
     public  static String getServiceMthodDescription(JoinPoint joinPoint)    
             throws Exception {    
        String targetName = joinPoint.getTarget().getClass().getName();    
        String methodName = joinPoint.getSignature().getName();    
        Object[] arguments = joinPoint.getArgs();    
        Class targetClass = Class.forName(targetName);    
        Method[] methods = targetClass.getMethods();    
        String description = "";    
         for (Method method : methods) {    
             if (method.getName().equals(methodName)) {    
                Class[] clazzs = method.getParameterTypes();    
                 if (clazzs.length == arguments.length) {    
                    description = method.getAnnotation(ServiceLogAnnotation. class).description();    
                     break;    
                }    
            }    
        }    
         return description;    
    }    
    
    /**  
     * 获取注解中对方法的描述信息 用于Controller层注解  
     *  
     * @param joinPoint 切点  
     * @return 方法描述  
     * @throws Exception  
     */    
     public  static String getControllerMethodDescription(JoinPoint joinPoint)  throws Exception {    
        String targetName = joinPoint.getTarget().getClass().getName();    
        String methodName = joinPoint.getSignature().getName();    
        Object[] arguments = joinPoint.getArgs();    
        Class targetClass = Class.forName(targetName);    
        Method[] methods = targetClass.getMethods();    
        String description = "";    
         for (Method method : methods) {    
             if (method.getName().equals(methodName)) {    
                Class[] clazzs = method.getParameterTypes();    
                 if (clazzs.length == arguments.length) {    
                    description = method.getAnnotation(ControllerLogAnnotation. class).description();    
                     break;    
                }    
            }    
        }    
         return description;    
    }
     
    /**
     * @param joinPoint
     * @return
     */
    public static String getParams(JoinPoint joinPoint){
    	StringBuilder stringBuilder=new StringBuilder();
    	Object[] objects=joinPoint.getArgs();
    	if (objects !=  null && objects.length > 0) { 
    		for (Object object : objects) {
    			stringBuilder.append(JSON.toJSON(object));
			}
       }    
       return stringBuilder.toString();
    }
}    