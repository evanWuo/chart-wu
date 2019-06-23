package com.wu.chartwu.controller;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Testc implements InitializingBean, DisposableBean {
	@Override
	public void destroy() throws Exception {
		System.out.println("销毁");

	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("初始化");
	}
}
