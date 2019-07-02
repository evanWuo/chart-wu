package com.wu.chartwu;

import com.wu.chartwu.servce.HttpTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class TestThreadPool extends ChartWuApplicationTests {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private HttpTest httpTest;
	@Test
	public void test(){
		long l = System.currentTimeMillis();
		for(int i=0;i<100000;i++){
			httpTest.testThreadpool(i);
		}
		logger.info("总共时间:{}",System.currentTimeMillis()-l);
		System.out.println(String.format("总共时间：%d",System.currentTimeMillis()-l));
	}
}
