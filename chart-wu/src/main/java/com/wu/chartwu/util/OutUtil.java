package com.wu.chartwu.util;

import org.apache.commons.io.IOUtils;

import java.nio.charset.Charset;

public class OutUtil {
	public static String endOut(){
		try {
			return IOUtils.resourceToString("bannerout.txt",Charset.forName("utf-8"),OutUtil.class.getClassLoader());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println(endOut());
	}
}
