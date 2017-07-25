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
            if("제목".equals(board.getTitle())) {
                System.out.println(board.getTitle() + " 제목을 맞춤");
            }
        }
                
        System.out.println("[사후 처리] " + method +"() 메소드 리턴값 : " + returnObj.toString());
    }
}
