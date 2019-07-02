package com.wu.chartwu.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync
public class ThreadPoolConfig {
	private Logger logger = LoggerFactory.getLogger(ThreadPoolConfig.class);
	@Value("${async.executor.thread.core.size}")
	private int corePoolSize;
	@Value("${async.executor.thread.max.size}")
	private int maxPoolSize;
	@Value("${async.executor.thread.queue.capacity}")
	private int queueCapacity;
	@Value("${async.executor.thread.name.prefix}")
	private String namePrefix;
	@Bean
	public Executor asyncExecutor(){
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		//配置核心线程数
		executor.setCorePoolSize(corePoolSize);
		//配置最大线程数
		executor.setMaxPoolSize(maxPoolSize);
		//配置队列大小
		executor.setQueueCapacity(queueCapacity);
		//配置线程池中的线程的名称前缀
		executor.setThreadNamePrefix(namePrefix);
		executor.setKeepAliveSeconds(1000);

		// rejection-policy：当pool已经达到max size的时候，如何处理新任务
		// CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		//执行初始化
		executor.initialize();
		logger.info("线程池初始化成功！");
		return executor;
	}
}
