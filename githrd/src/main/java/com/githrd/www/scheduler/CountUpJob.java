package com.githrd.www.scheduler;

import org.quartz.*;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class CountUpJob extends QuartzJobBean {
	private CountUp upSal;
	
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		upSal.upSal();
	}
	
	public void setUpSal(CountUp upSal) {
		this.upSal = upSal;
	}
	
}
