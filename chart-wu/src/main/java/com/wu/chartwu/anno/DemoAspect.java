package com.wu.chartwu.anno;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoAspect {
	@Pointcut("@annotation(com.wu.chartwu.anno.DemoAn)")
	public void demoinit(){
		System.out.println(1);
	}

	@Before("demoinit()")
	public void before(JoinPoint jp){
		System.out.println("2");

	}
}
