package com.company.dao;

import com.company.bean.ChannelInfo;

public interface ChannelInfoDao {

    public void add(ChannelInfo channelInfo);

    public boolean delete(String sourceAreaId);

    public boolean update(String sourceAreaId, ChannelInfo channelInfo);

    public Object findBySourceAreaId(String sourceAreaId);

    public Object findAll();
}
