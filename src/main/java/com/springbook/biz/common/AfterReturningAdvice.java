package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardVO;

@Service
@Aspect
public class AfterReturningAdvice {

	@AfterReturning(pointcut="PointcutCommon.getPointcut()", returning="returnObj")
    public void afterLog(JoinPoint jp, Object returnObj) {
        String method = jp.getSignature().getName();
        
        if(returnObj instanceof BoardVO) {
        	BoardVO board = (BoardVO) returnObj;
            if("����".equals(board.getTitle())) {
                System.out.println(board.getTitle() + " ������ ����");
            }
        }
                
        System.out.println("[���� ó��] " + method +"() �޼ҵ� ���ϰ� : " + returnObj.toString());
    }
}
