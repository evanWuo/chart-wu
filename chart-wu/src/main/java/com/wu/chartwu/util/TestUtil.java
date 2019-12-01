package com.wu.chartwu.util;

import com.wu.chartwu.servce.HttpTest;

public class TestUtil {
	public static void test() throws Exception {
		HttpTest http = SpringUtil.getBean(HttpTest.class);
		System.out.println(http.testHttp());
	}
}
