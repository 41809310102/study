package com.deyunjiaoyu.sportplay.controller;

import com.alibaba.fastjson.JSON;

import com.deyunjiaoyu.sportplay.bean.Page;
import com.deyunjiaoyu.sportplay.bean.QueryInfo;
import com.deyunjiaoyu.sportplay.bean.User;
import com.deyunjiaoyu.sportplay.dao.pageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.List;

@RestController
public class PageController {
    @Autowired
    private pageDao pageDao;
    @RequestMapping("/allpages")
    public String getUserList(QueryInfo queryInfo){
        //获取最大列表数和当前编号
        int numbers =   pageDao.getPageCounts("%"+queryInfo.getQuery()+"%");
        int pageStart =  (queryInfo.getPageNum()-1)*queryInfo.getPageSize();
        List<Page> pages =  pageDao.getAllPage("%"+queryInfo.getQuery()+"%",pageStart,queryInfo.getPageSize());
        HashMap<String,Object> res=new HashMap<>();
        res.put("number",numbers);
        res.put("data",pages);
        String res_string = JSON.toJSONString(res);
        return res_string;
    }

    @RequestMapping("/addpage")
    public String addPage(@RequestBody Page page){
        page.setPagenum(0);
        int i = pageDao.addPage(page);
        return  i>0? "success":"error";
    }

    @RequestMapping("/deletepage")
    public String deletePage(int id){
        int i = pageDao.deletePage(id);
        return i>0? "success":"error";
    }
}
