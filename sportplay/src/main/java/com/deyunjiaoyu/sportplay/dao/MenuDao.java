package com.deyunjiaoyu.sportplay.dao;
import com.deyunjiaoyu.sportplay.bean.MainMenu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface  MenuDao {
    public List<MainMenu> getMenus();
}
