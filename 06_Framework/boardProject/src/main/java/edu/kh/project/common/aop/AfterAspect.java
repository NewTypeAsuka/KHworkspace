package edu.kh.project.common.aop;

import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.config.Order;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.mybatis.logging.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AfterAspect {

	private Logger logger = LoggerFactory.getLogger(AfterAspect.class);
	
	@Order(3)
	@After("CommonPointcut.serviceImplePointCut()")
	public void afterLog() {
		logger.info("-----------------------------------------------------------------\n\n");
	}
}
