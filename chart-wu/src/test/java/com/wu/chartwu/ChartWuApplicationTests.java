package com.wu.chartwu;

import com.wu.chartwu.dao.TestDao;
import com.wu.chartwu.servce.HttpTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChartWuApplicationTests {
	@Autowired
	private TestDao testDao;
	@Autowired
	private HttpTest httpTest;
	@Autowired
	private com.wu.chartwu.servce.AspectService aspectService;
	@Test
	public void contextLoads() throws Exception {
		httpTest.testHttp();
	}

}
