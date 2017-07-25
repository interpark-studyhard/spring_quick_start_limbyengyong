package com.springbook.biz.common;

import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
public class BeforeAdvice {
	@Pointcut("execution(* com.springbook.biz.. *Impl.*(..))")
	public void allPointcut(){}
	
	@Pointcut("execution(* com.springbook.biz.. *Impl.get*(..))")
	public void getPointcut(){}

	@Before("allPointcut()")
	public void printLog(){
		System.out.println("[���� �α�] ����Ͻ� ���� ������ ����");
	}
}