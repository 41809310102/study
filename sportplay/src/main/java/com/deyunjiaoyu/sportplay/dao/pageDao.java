package com.deyunjiaoyu.sportplay.dao;

import com.deyunjiaoyu.sportplay.bean.Page;
import com.deyunjiaoyu.sportplay.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public  interface pageDao {
    public List<Page> getAllPage(@Param("pagename") String pagename, @Param("pageStart") int pageStart, @Param("pageSize") int pageSize);
    public int getPageCounts(@Param("pagename") String pagename);
    public int addPage(Page page);
    public int deletePage(int id);
}


