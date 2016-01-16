/*
 * Copyright (c) 2015
 * 蓝盾信息安全技术股份有限公司(Bluedon Information Security Technologies Co.,Ltd) 
 * All rights reserved.
 */
package com.bluedon.cb.common.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;


/**
 * Description:系统登录入口Controller
 * Time:2015年12月3日上午8:18:50
 * @version 1.0
 * @since 1.0
 * @author chenchengteng
 */
@Controller
public class IndexController {
	private Logger log = LoggerFactory.getLogger(IndexController.class);
	public static final String MESSAGE = "message";
	
	@Autowired  
    private Producer captchaProducer = null;
	
	@RequestMapping(value = {"/","/index.html"}, method = RequestMethod.GET)
	public String index() {
		return "common/login/userlogin";
	}
	
	@RequestMapping(value = {"/admin","/admin_login.html"}, method = RequestMethod.GET)
	public String admin_login() {
		return "common/login/adminlogin";
	}
	/**
	 * 获取验证码
	 * @param req HttpServletRequest
	 * @param resp HttpServletResponse
	 * @throws IOException 
	 */
	@RequestMapping("/getCaptcha")
	public void getCaptcha(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		HttpSession session = req.getSession();  
        resp.setDateHeader("Expires", 0);  
        resp.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");  
        resp.addHeader("Cache-Control", "post-check=0, pre-check=0");  
        resp.setHeader("Pragma", "no-cache");  
        resp.setContentType("image/jpeg");  
        String capText = captchaProducer.createText();  
        session.setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);  
        BufferedImage bi = captchaProducer.createImage(capText);  
        ServletOutputStream out= resp.getOutputStream();  
        ImageIO.write(bi, "jpg", out);  
        try {  
            out.flush();  
        }catch(Exception e) { 
        	log.info(e.getMessage());
        }finally { 
            out.close();  
        }  
	}

	/**
	  * @Description: 校验码输入错误
	  * @param req
	  * @param resp
	  * @return
	  */
	@RequestMapping("/codeCheckFailed")
	@ResponseBody
	public Map<String, Object> codeCheckFailed(HttpServletRequest req, HttpServletResponse resp) {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put(MESSAGE, "captchaError");
		return msg;
	}

	/**
	  * @Description: 用户名或者密码输入错误
	  * @param req
	  * @param resp
	  * @return
	  */
	@RequestMapping("/usernameCheckFailed")
	@ResponseBody
	public Map<String, Object> usernameCheckFailed(HttpServletRequest req, HttpServletResponse resp) {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put(MESSAGE, "usernameError");
		return msg;
	}
}
