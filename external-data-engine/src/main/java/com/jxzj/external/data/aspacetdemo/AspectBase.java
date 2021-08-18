package com.jxzj.external.data.aspacetdemo;

import java.util.Arrays;

import org.apache.curator.shaded.com.google.common.base.Stopwatch;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.JoinPoint.StaticPart;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.SourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(value = 999)
@Component
public class AspectBase {

    private static final Logger LOG = LoggerFactory.getLogger(AspectBase.class);

    @Pointcut(value = "execution(* com.jxzj.external.data.aspacetdemo.ISay.sayHello(..))")
    private void aspectPointcut() {

    }

    /**
     * * 前置通知： 目标方法执行之前执行以下方法体的内容
     * 
     * @param joinPoint
     */
    @Before(value = "aspectPointcut()")
    public void aspectBefore(JoinPoint joinPoint) {
        LOG.info("=================");
        // 返回次连接点处（目标方法）的参数，目标方法无参数时，返回空数组
        Object[] args = joinPoint.getArgs();
        // 返回连接点处的签名
        Signature signature = joinPoint.getSignature();
        // 返回目标对象
        Object target = joinPoint.getTarget();
        // 返回正在执行的对象
        Object this1 = joinPoint.getThis();
        // 返回一个封装此连接点的静态部分的对象。
        StaticPart staticPart = joinPoint.getStaticPart();
        // 返回此连接点对应的源位置
        SourceLocation sourceLocation = joinPoint.getSourceLocation();
        // 返回连接点的扩展字符串表示形式
        String longString = joinPoint.toLongString();
        // 返回连接点的缩写字符串表示形式
        String shortString = joinPoint.toShortString();
        // 返回表示连接点类型的字符串
        String kind = joinPoint.getKind();
        LOG.info(
            "【前置通知】" + "args={},signature={},target={},aThis={},staticPart={},"
                + "sourceLocation={},longString={},shortString={}",
            Arrays.asList(args), signature, target, this1, staticPart, sourceLocation, longString, shortString);
    }

    /**
     * *后置通知：目标方法执行之后执行以下方法体的内容，不管目标方法是否发生异常。 <br>
     * value：绑定通知的切入点表达式。可以关联切入点声明，也可以直接设置切入点表达式
     * 
     * @param joinPoint
     */
    @After(value = "aspectPointcut()")
    public void aspectAfter(JoinPoint joinPoint) {
        LOG.info("【后置通知】kind={}" + joinPoint.getKind());
    }

    /**
     * getStr()方法执行
     */
    @Pointcut(value = "execution(* com.jxzj.external.data.aspacetdemo.ISay.getStr(..))")
    private void aspectPointcut2() {

    }

    /**
     * *返回通知：目标方法返回后执行一下代码<br>
     * value属性 : 绑定通知的切入点表达式，可以关联切入点声明，可以以直接设置切入点表达式 <br>
     * pointcut属性： 绑定通知的切入点表达式，优先级高于value， 默认为“”<br>
     * returning属性: 通知签名中要将返回值绑定到的参数的名称， 默认为“”<br>
     * 
     * @param joinPoint ： 提供对连接点处可用状态和有关它的静态信息的反射访问。<br>
     * @param result ：目标方法返回的值，参数名与returning属性一致。无返回值时，这里result为null.<br>
     */
    // @AfterReturning(pointcut = "aspectPointcut2()", returning = "result")
    public void aspectAfterReturning(JoinPoint joinPoint, Object result) {
        LOG.info("【返回通知】,shortString={},result={}", joinPoint.toShortString(), result);
    }

    /**
     * a异常通知<br>
     * value属性：绑定通知的切入点表达式。可以关联切入点声明，也可以直接设置切入点表达式<br>
     * pointcut属性：绑定通知的切入点表达式，优先级高于value，默认为""<br>
     * throwing属性：与方法中的异常参数名称一致。
     * 
     * @param joinPoint
     * @param ex 捕获的异常对象，名称与throwing属性值一致
     */
    // @AfterThrowing(pointcut = "aspectPointcut2()", throwing = "ex")
    public void aspectAfterThrowing(JoinPoint joinPoint, Exception ex) {
        LOG.info("【异常通知开始】 ====================================");
        String methodName = joinPoint.getSignature().getName();
        if (ex instanceof ArithmeticException) {
            LOG.error("【异常通知】\" + methodName + \"方法算术异常（ArithmeticException）：\" + ex.getMessage()");
        } else {
            LOG.error("【异常通知】" + methodName + "方法异常：" + ex.getMessage());
        }
    }

    @Around(value = "aspectPointcut2()")
    public Object handleControllMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        this.checkRequestParam(joinPoint);

        Stopwatch stopWatch = Stopwatch.createStarted();
        LOG.info("【环绕通知】执行接口开始，方法={}，参数={} ", joinPoint.getSignature(), Arrays.asList(joinPoint.getArgs()).toString());
        // 继续下一通知活目标方法调用，返回处理结果，如果目标方法发生异常，则proceed会抛出异常。
        // 如果在调用目标方法或者下一个切面通知前抛出异常，则不会在继续往后走。
        Object proceed = joinPoint.proceed(joinPoint.getArgs());

        stopWatch.stop();
        LOG.info("【环绕通知】执行接口结束，方法={}, 返回值={},耗时={} (毫秒)", joinPoint.getSignature(), proceed);

        return null;
    }

    /**
     * -参数校验，防止sql注入
     * 
     * @param joinPoint
     */
    private void checkRequestParam(ProceedingJoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        if (args == null || args.length <= 0) {
            return;
        }
        String params = Arrays.toString(joinPoint.getArgs()).toUpperCase();
        String[] keywords = {"DELETE ", "UPDATE ", "SELECT ", "INSERT ", "SET ", "SUBSTR(", "COUNT(", "DROP ",
            "TRUNCATE ", "INTO ", "DECLARE ", "EXEC ", "EXECUTE ", " AND ", " OR ", "--"};
        for (String keyword : keywords) {
            if (params.contains(keyword)) {
                LOG.warn("参数存在SQL注入风险，其中包含非法字符 {}.", keyword);
                throw new RuntimeException("参数存在SQL注入风险：params=" + params);
            }
        }
    }

}
