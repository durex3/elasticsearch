package com.durex.elasticsearch.service.impl;

import com.durex.elasticsearch.model.NBAPlayer;
import com.durex.elasticsearch.service.NBAPlayerService;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gelong
 * @date 2019/12/19 23:11
 */
@Service
public class NBAPlayerServiceImpl implements NBAPlayerService {

    @Resource
    private RestHighLevelClient client;

    @Override
    public void addPlayer(String id, NBAPlayer player) {
        IndexRequest indexRequest = new IndexRequest("nba")
                .id(id).source(player);
        try {
            IndexResponse response = client.index(indexRequest, RequestOptions.DEFAULT);
            System.out.println(response);
        } catch (IOException e) {
            throw new RuntimeException("创建失败");
        }
    }

    @Override
    public Map<String, Object> getPlayer(String id) {
        GetRequest request = new GetRequest("nba").id(id);
        try {
            GetResponse response = client.get(request, RequestOptions.DEFAULT);
            return response.getSource();
        } catch (IOException e) {
            throw new RuntimeException("获取球员失败");
        }
    }

    private <T> Map<String, Object> beanToMap(T bean) {
        Map<String, Object> map = new HashMap<>(16);
        if (bean != null) {
            BeanMap beanMap = BeanMap.create(bean);
            for (Object key : beanMap.keySet()) {
                map.put(key.toString(), beanMap.get(key));
            }
        }
        return map;
    }
}
