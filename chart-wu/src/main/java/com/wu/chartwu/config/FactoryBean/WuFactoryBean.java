package com.wu.chartwu.config.FactoryBean;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.util.Properties;

@Getter
@Setter
@Slf4j
public class WuFactoryBean {
	private String resourse;
	private volatile Properties properties;
	private boolean Off = true;
	private InputStream inStream;
	private Thread thread;
	private void init(){
		properties = new Properties();
		dynamic();
	}

	private void dynamic(){
		this.thread = new Thread(new Runnable() {
			@Override
			public void run() {
				while (Off) {
					try {
						inStream = this.getClass().getClassLoader().getResourceAsStream("properties/muti.properties");
						properties.load(inStream);
						System.out.println("sssssssssssssssssssssssssssss@@@@@@@@@@ss:我刷新了");
						log.info("sssssssssssssssssssssssssssss@@@@@@@@@@ss:我刷新了");
						Thread.sleep(1000L);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread.setDaemon(true);
		thread.setName("dynami");
		thread.start();
	}

	public void sys(){
		System.out.println(properties.getProperty("wu.one.url"));
	}

	public void destroy(){
		this.Off = false;
		log.info("sssssssssssssssssssssssssssss@@@@@@@@@@ss:刷新停止了");
	}
}
