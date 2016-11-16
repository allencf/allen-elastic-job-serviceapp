package com.allen.elastic.jobs;

import org.springframework.beans.factory.annotation.Value;

import com.dangdang.ddframe.job.api.JobConfiguration;
import com.dangdang.ddframe.job.api.JobScheduler;
import com.dangdang.ddframe.reg.base.CoordinatorRegistryCenter;
import com.dangdang.ddframe.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.reg.zookeeper.ZookeeperRegistryCenter;

public class ElasticJobDemo {

	@Value("${zookeeper.registry.address}")
	private static String location;
	
	// 定义Zookeeper注册中心配置对象
    private ZookeeperConfiguration zkConfig = new ZookeeperConfiguration("localhost:2182", "elastic-job-example", 1000, 3000, 1);
    
    // 定义Zookeeper注册中心
    private CoordinatorRegistryCenter regCenter = new ZookeeperRegistryCenter(zkConfig);
    
    // 定义简单作业配置对象
    /*private final TestSimpleJob simpleJobConfig = JobConfigurationFactory.createSimpleJobConfigurationBuilder("simpleElasticDemoJob", 
                    SimpleJobDemo.class, 10, "0/30 * * * * ?").build();*/
    
    private JobConfiguration jobConfig1 = new JobConfiguration("oneOffElasticDemoJob", TestSimpleJob.class, 10, "1/10 * * * * ?");
    
    
    /*// 定义高吞吐流式处理的数据流作业配置对象
    private final DataFlowJobConfiguration throughputJobConfig = JobConfigurationFactory.createDataFlowJobConfigurationBuilder("throughputDataFlowElasticDemoJob", 
                    ThroughputDataFlowJobDemo.class, 10, "0/5 * * * * ?").streamingProcess(true).build();
    
    // 定义顺序的数据流作业配置对象
    private final DataFlowJobConfiguration sequenceJobConfig = JobConfigurationFactory.createDataFlowJobConfigurationBuilder("sequenceDataFlowElasticDemoJob", 
                    SequenceDataFlowJobDemo.class, 10, "0/5 * * * * ?").build();
    
    // 定义脚本作业配置对象
    private final ScriptJobConfiguration scriptJobConfig = JobConfigurationFactory.createScriptJobConfigurationBuilder("scriptElasticDemoJob", 
                    10, "0/5 * * * * ?", "test.sh").build();*/
    
    private void init() {
        // 连接注册中心
        regCenter.init();
        // 启动简单作业
        new JobScheduler(regCenter, jobConfig1).init();
        
        
        /*// 启动高吞吐流式处理的数据流作业
        new JobScheduler(regCenter, throughputJobConfig).init();
        // 启动顺序的数据流作业
        new JobScheduler(regCenter, sequenceJobConfig).init();
        // 启动脚本作业
        new JobScheduler(regCenter, scriptJobConfig).init();*/
    }
	
    
    public static void main(final String[] args) {
        //System.out.println(location);
    	new ElasticJobDemo().init();
    }

	
	

}
