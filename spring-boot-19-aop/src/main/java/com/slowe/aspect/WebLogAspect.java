package com.slowe.aspect;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect // 将Java类定义为切面类
@Component
public class WebLogAspect {
	private static final Logger LOGGER = LoggerFactory.getLogger(WebLogAspect.class);

	//定义一个ThreadLocal来保持时间，然后通过@Before @@AfterReturning来计算时间
	//其实还可以通过@Around来统计时间
	private ThreadLocal<Long> startTime = new ThreadLocal<>();

	// 定义一个切点，可以是一个规则表达式，比如下例中某个package下的所有函数，也可以是一个注解等。
	@Pointcut("execution(public * com.slowe.web..*.hello(..))")
	public void webLog() {
	}

	// 在切入点开始处切入内容
	@Before("webLog()")
	public void doBefore(JoinPoint joinPoint) throws Throwable {
		LOGGER.info("doBefore Order(1)");
		startTime.set(System.currentTimeMillis());
		// 接到请求，记录请求内容
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();

		// 记录日志
		LOGGER.info("URL: " + request.getRequestURL().toString());
		LOGGER.info("HTTP_METHOD: " + request.getMethod());
		LOGGER.info("IP: " + request.getRemoteAddr());
		LOGGER.info("CLASS_METHOD: " + joinPoint.getSignature().getDeclaringTypeName() + "."
				+ joinPoint.getSignature().getName());
		LOGGER.info("ARGS: " + Arrays.toString(joinPoint.getArgs()));
	}

	// 使用@After在切入点结尾处切入内容

	// 在切入点return内容之后切入内容（可以用来对处理返回值做一些加工处理）
	@AfterReturning(returning = "ret", pointcut = "webLog()")
	public void doAfterReturning(Object ret) throws Throwable {
		LOGGER.info("doAfterReturning Order(10)");
		// 处理完请求，返回内容
		LOGGER.info("RESPONSE: " + ret);
		LOGGER.info("SPEND TIME : " + (System.currentTimeMillis() - startTime.get()));
	}

	// 使用@Around在切入点前后切入内容，并自己控制何时执行切入点自身的内容
	// 使用@AfterThrowing用来处理当切入内容部分抛出异常之后的处理逻辑
}
