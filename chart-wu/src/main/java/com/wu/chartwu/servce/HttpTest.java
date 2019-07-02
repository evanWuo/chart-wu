package com.wu.chartwu.servce;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

@Service
public class HttpTest {
	public byte[] testHttp() throws Exception {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		String str = "时光转今夕何年风已经散了云烟却出了曾经断情的剑到底谁情愿浊酒醉淹没爱恋却无法隔绝思念撕破了自己做的情茧涌出最后一滴血挥挥手不回头一片痴狂为谁留转身走怎么舍得放开手拥有过牵手分手太多理由一人去泪水流拥有笑过哭过太多理由爱已经腐朽挥挥手不回头一片痴狂为谁留转身走怎么舍得放开手拥有过牵手分手太多理由一人去泪水流拥有笑过哭过太多理由爱已经腐朽";
		HttpGet httpPost = new HttpGet("http://tts.baidu.com/text2audio?lan=zh&ie=UTF-8&spd=2&text="+str);
		RequestConfig requestConfig = RequestConfig.custom()
				.setSocketTimeout(10000).setConnectTimeout(20000)
				.setConnectionRequestTimeout(10000).build();
		httpPost.setConfig(requestConfig);
		try {
			CloseableHttpResponse response = httpClient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			byte[] bytes = EntityUtils.toByteArray(entity);
//			File file = new File("d:1.mp3");
//			IOUtils.write(bytes,new FileOutputStream(file));
			return bytes;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}

//	@Async("asyncExecutor")
	public void testThreadpool(int i){
		System.out.println(String.format("线程名：%s,value:%d",Thread.currentThread().getName(),i));
	}
}
