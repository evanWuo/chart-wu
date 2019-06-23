package com.wu.chartwu.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wu.chartwu.dao.TestDao;
import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TestController {
    @Autowired
    private TestDao testDao;
    @RequestMapping("/query")
    @ResponseBody
    public Map query(int page,int limit){
        Map map = new HashMap();
        map.put("code","0");

        PageHelper.startPage(page,limit,true);
        List list = testDao.queryList();
        PageInfo pageer = new PageInfo(list);
        map.put("data",pageer.getList());
        map.put("count",pageer.getTotal());
        return map;
    }
    @RequestMapping("/")
    public String index(){
        return "index";
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
