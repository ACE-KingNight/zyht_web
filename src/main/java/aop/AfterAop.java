package aop;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package aop
 * @author wangzhenxin
 * @date 2017-10-18 16:23
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author wangzhenxin
 * @ClassName AfterAop
 * @Description 类描述
 * @date 2017-10-18
 */
@Aspect
public class AfterAop {

    @Pointcut("execution(* com.service..*(..))")
    public void myPointCut(){
    }

    @Before(value = "myPointCut()")
    public void before(){
        System.out.println("注解before");
    }
    @After(value = "myPointCut()")
    public void after(){
        System.out.println("注解AfterAop");
    }
    @Around(value = "myPointCut()")
    public Object  around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("around 执行...."+proceedingJoinPoint.proceed());
        String mothedName=proceedingJoinPoint.getStaticPart().getSignature().getName();
        System.out.println(mothedName);
        return proceedingJoinPoint.proceed();
    }

}
