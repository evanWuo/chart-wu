/*
package com.wu.chartwu.config;

import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import java.util.concurrent.CountDownLatch;

@Configuration
@ImportResource("classpath:elasticjob.xml")
public class JobRegistryCenterConfig {
	private final String cron = "0/5 * * * * ?";
	private final int shardingTotalCount = 3;
	private final String shardingItemParameters = "0=A,1=B,2=C";
	private final String jobParameters = "parameter";

	*/
/*@Autowired
	private ZookeeperRegistryCenter regCenter;


	*//*
*/
/*@Bean(initMethod = "init")
	public ZookeeperRegistryCenter regCenter(@Value("${regCenter.serverList}") final String serverList,
											 @Value("${regCenter.namespace}") final String namespace) {
		ZookeeperConfiguration zc = new ZookeeperConfiguration(serverList, namespace);
		return new ZookeeperRegistryCenter(zc);
	}*//*
*/
/*


	@Bean
	public SimpleJob stockJob() {
		return new FirstJob();
	}

	@Bean(initMethod = "init")
	public JobScheduler simpleJobScheduler(final SimpleJob simpleJob) {
		return new SpringJobScheduler(simpleJob, regCenter, getLiteJobConfiguration(simpleJob.getClass(),
				cron, shardingTotalCount, shardingItemParameters, jobParameters));
	}*//*



	private LiteJobConfiguration getLiteJobConfiguration(final Class<? extends SimpleJob> jobClass,
														 final String cron,
														 final int shardingTotalCount,
														 final String shardingItemParameters,
														 final String jobParameters) {
		// 定义作业核心配置
		JobCoreConfiguration simpleCoreConfig = JobCoreConfiguration.newBuilder(jobClass.getName(), cron, shardingTotalCount).
				shardingItemParameters(shardingItemParameters).jobParameter(jobParameters).build();
		// 定义SIMPLE类型配置
		SimpleJobConfiguration simpleJobConfig = new SimpleJobConfiguration(simpleCoreConfig, jobClass.getCanonicalName());
		// 定义Lite作业根配置
		LiteJobConfiguration simpleJobRootConfig = LiteJobConfiguration.newBuilder(simpleJobConfig).overwrite(true).build();
		return simpleJobRootConfig;

	}
	private static CountDownLatch connectedSemaphore = new CountDownLatch( 1 );
	public static void main(String[] args) throws Exception {

		ZooKeeper zk = new ZooKeeper("192.168.135.155:2181", 3000, new Watcher() {
			@Override
			public void process(WatchedEvent event) {
				System.out.println("已经触发了" + event.getType() + "事件！");
				if ( Event.KeeperState.SyncConnected == event.getState() ) {
					//连接完成的同步事件，互斥变量取消，下面的阻塞停止，程序继续执行
					connectedSemaphore.countDown();
				}
			}
		});
		connectedSemaphore.await();
		System.out.println(zk);
	}
}
*/
