package com.example.demo.login.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspct {
    /*
	// ポイント２： AOPの実装
	@Before("execution(* com.example.demo.login.controller.LoginController.getLogin(..))")
	public void startLog(JoinPoint jp) {
		System.out.println("メソッド 開始： " + jp. getSignature());
	}


	// ポイント２： AOPの実装
	@After("execution(* com.example.demo.login.controller.LoginController.getLogin(..))")
	public void endLog(JoinPoint jp) {
		System.out.println("メソッド 終了： " + jp.getSignature());
	}
    */

	/*
	// ポイント： コントローラークラスの全てのメソッドを対象
	@Before("execution(* *..*.*Controller.*(..))")
	public void startLog(JoinPoint jp) {
	    System.out.println("メソッド 開始： " + jp. getSignature());
	}

	// ポイント： コントローラークラスの全てのメソッドを対象
	@After("execution(* *..*.*Controller.*(..))")
	public void endLog(JoinPoint jp) {
		System.out.println("メソッド 終了： " + jp. getSignature());
	}
    */


    /**
     * コントローラークラスのログ出力用アスペクト.
     */
	@Around("@within(org.springframework.stereotype.Controller)")
    public Object startLog(ProceedingJoinPoint jp) throws Throwable {

        System.out.println("メソッド開始： " + jp.getSignature());

        try {
            // ポイント２：メソッド実行
            Object result = jp.proceed();

            System.out.println("メソッド終了： " + jp.getSignature());

            return result;

        } catch (Exception e) {
            System.out.println("メソッド異常終了： " + jp.getSignature());
            e.printStackTrace();
            throw e;
        }
    }
}
