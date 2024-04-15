package com.company.dao;

import com.company.bean.ChannelTagMapping;

public interface ChannelTagMappingDao {

    public void add(ChannelTagMapping channelTagMapping);

    public boolean delete(String sourceAreaId, int tagId);

    public Object findBySourceAreaId(String sourceAreaId);

    public Object findByTagId(int tagId);

    public Object findAll();
}
