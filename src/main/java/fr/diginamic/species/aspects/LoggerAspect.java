package fr.diginamic.species.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@After("execution(* getAll*(..))")
	public void logAfterGetAll(JoinPoint joinPoint)
	{
		logger.info("Executing after method {}", joinPoint.getSignature().getName());
	}
	
	@Before("within(@org.springframework.stereotype.Controller *))")
	public void logService(JoinPoint joinPoint)
	{
		logger.info("Executing before Controller method {}", joinPoint.getSignature().getName());
	}
	
	@AfterThrowing(value = "within(@org.springframework.stereotype.Service *)) && execution(* searchById(..))", throwing = "ex")
	public void logAfterThrowingSearchById(JoinPoint joinPoint, Throwable ex)
	{
		logger.info("Executing after method {} threw an exception : {}", joinPoint.getSignature().getName(), ex.getMessage());
	}
	
	@Around("within(@org.springframework.stereotype.Service *))")
	public Object logServiceExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable
	{
		long startTime = System.nanoTime();
		try
		{
			return joinPoint.proceed();
		}
		finally
		{
			double duration = System.nanoTime() - startTime;
			logger.info("Method {} duration time : {} ms", joinPoint.getSignature().getName(), duration / 1000000.0);
		}
	}
}
