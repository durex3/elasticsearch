package com.durex.elasticsearch.service;

import com.durex.elasticsearch.model.NBAPlayer;

import java.util.Map;

/**
 * @author gelong
 * @date 2019/12/19 23:11
 */
public interface NBAPlayerService {

    /**
     * 添加球员
     * @param player 球员信息
     * @param id id
     * @return
     */
    void addPlayer(String id, NBAPlayer player);

    /**
     * 获取一个球员
     * @param id id
     * @return Map<String, Object>
     */
    Map<String, Object> getPlayer(String id);
}
