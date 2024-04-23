package com.company.dao;

import com.company.bean.ChannelTagMapping;

import java.util.List;

public interface ChannelTagMappingDao {

    void add(ChannelTagMapping channelTagMapping);

    boolean delete(int id);

    boolean update(int id, ChannelTagMapping channelTagMapping);

    String findById(int id);

    String findBySourceAreaId(String sourceAreaId);

    String findByTagId(int tagId);

    String findAll();

    void addBatch(List<ChannelTagMapping> channelTagMappingList);
}
