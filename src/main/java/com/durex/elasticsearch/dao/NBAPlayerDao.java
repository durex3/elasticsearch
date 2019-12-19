package com.durex.elasticsearch.dao;

import com.durex.elasticsearch.model.NBAPlayer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * @author gelong
 */
@Mapper
public interface NBAPlayerDao {

    /**
     * 查询所有nba球员
     * @return List<NBAPlayer>
     */
    @Select("select * from nba_player")
    public List<NBAPlayer> findAll();
}
