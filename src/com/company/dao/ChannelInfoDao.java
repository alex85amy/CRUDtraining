package com.company.dao;

import com.company.bean.ChannelInfo;

import java.util.List;

public interface ChannelInfoDao {

    void add(ChannelInfo channelInfo);

    boolean delete(int id);

    boolean update(int id, ChannelInfo channelInfo);

    Object findById(int id);

    Object findAll();

    void addBatch(List<ChannelInfo> channelInfoList);
}
