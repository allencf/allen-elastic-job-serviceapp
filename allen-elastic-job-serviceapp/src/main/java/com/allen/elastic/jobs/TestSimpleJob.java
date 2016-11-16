package com.allen.elastic.jobs;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dangdang.ddframe.job.api.JobExecutionMultipleShardingContext;
import com.dangdang.ddframe.job.plugin.job.type.simple.AbstractSimpleElasticJob;

public class TestSimpleJob extends AbstractSimpleElasticJob{
	
	private final static Logger logger = LoggerFactory.getLogger(TestSimpleJob.class);
	
	@Override
	public void process(JobExecutionMultipleShardingContext shardingContext) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		logger.info("开始执行TestSimpleJob定时任务,开始时间:" + sf.format(new Date()) );
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			logger.error("执行异常,异常信息:" + e.getMessage(),e);
		}
		
		logger.info("TestSimpleJob定时任务执行结束,结束时间:" + sf.format(new Date()) );
	}

	public static void main(String[] args) {
		System.out.println("test logger");
		
		logger.info("success ……");

	}

}
