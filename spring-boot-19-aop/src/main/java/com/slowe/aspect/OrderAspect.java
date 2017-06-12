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
public class OrderAspect {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderAspect.class);

	// 定义一个切点，可以是一个规则表达式，
	@Pointcut("execution(public * com.slowe.web.*.order(..))")

	public void order() {
	}

	// 在切入点开始处切入内容
	@Before("order()")
	public void doBefore(JoinPoint joinPoint) throws Throwable {
		LOGGER.info("类默认没有order注解 ，执行befofe ");
	}

	// 使用@After在切入点结尾处切入内容

	// 在切入点return内容之后切入内容（可以用来对处理返回值做一些加工处理）
	@AfterReturning(returning = "ret", pointcut = "order()")
	public void doAfterReturning(Object ret) throws Throwable {
		// 处理完请求，返回内容
		LOGGER.info("类默认没有order注解 ，执行doAfterReturning ");
	}

	// 使用@Around在切入点前后切入内容，并自己控制何时执行切入点自身的内容
	// 使用@AfterThrowing用来处理当切入内容部分抛出异常之后的处理逻辑
}
