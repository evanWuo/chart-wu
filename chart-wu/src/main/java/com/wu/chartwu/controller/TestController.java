package com.wu.chartwu.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wu.chartwu.config.FactoryBean.WuFactoryBean;
import com.wu.chartwu.dao.TestDao;
import com.wu.chartwu.servce.HttpTest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@Controller
@Slf4j
@Api("---testUrl----")
public class TestController {
    Logger logger = LoggerFactory.getLogger(TestController.class);
    @Autowired
    private TestDao testDao;
    @Autowired
    private HttpTest httpTest;
    @Autowired
    private WuFactoryBean wuFactoryBean;


    @RequestMapping(value = "/query",method = RequestMethod.GET)
    @ResponseBody
    public Map query(int page,int limit){
        Map map = new HashMap();
        map.put("code","0");
        PageHelper.startPage(page,limit,true);
        List list = testDao.queryList();
        Properties p =wuFactoryBean.getProperties();
        for(Object s: p.keySet()){
            Map mp = new HashMap();
            mp.put("id",s);
            mp.put("date",p.getProperty(s.toString()));
            list.add(mp);
        }

        PageInfo pageer = new PageInfo(list);
        map.put("data",pageer.getList());
        map.put("count",pageer.getTotal());
        logger.debug("sssssssssss,{}",map);
        return map;
    }
    @RequestMapping("/")
	@ApiOperation("---------/index------------")
    public String index(){
        log.info("sdsdsd");
        return "index";
    }

    @ApiOperation("测试音频")
    @RequestMapping("/audio")
    public void getAudio(HttpServletRequest request, HttpServletResponse response) throws Exception{
        OutputStream os = null;
        try {
            byte[] bytes = httpTest.testHttp();
            response.setContentLength( bytes.length);
            response.setHeader("Content-Disposition", "attachment;filename=test");
            response.setContentType("application/octet-stream");
            os = response.getOutputStream();
            if (bytes.length > 0) {
                os.write(bytes);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != os) {
                os.flush();
                os.close();
            }
        }
    }

    @RequestMapping("/redis")
    @ResponseBody
    public String getred(){
        return httpTest.getRedis();
    }
    public static void main(String[] args) {
        BeanComparator comparator = new BeanComparator("id");
        Test t = new Test();
        t.setCount(1.203d);
        t.setId("1");
        Test t2 = new Test();
        t2.setCount(1.203d);
        t2.setId("2");
//        System.out.println(comparator.compare(t,t2));
        System.out.println(EqualsBuilder.reflectionEquals(t,t2));;

    }

}
