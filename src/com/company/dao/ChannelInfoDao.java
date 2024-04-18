package com.company.dao;

import com.company.bean.ChannelInfo;

public interface ChannelInfoDao {

    public void add(ChannelInfo channelInfo);

    public boolean delete(int id);

    public boolean update(int id, ChannelInfo channelInfo);

    public Object findById(int id);

    public Object findAll();
}
