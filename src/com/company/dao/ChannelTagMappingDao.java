package com.company.dao;

import com.company.bean.ChannelTagMapping;

public interface ChannelTagMappingDao {

    public void add(ChannelTagMapping channelTagMapping);

    public boolean delete(int id);

    public boolean update(int id, ChannelTagMapping channelTagMapping);

    public Object findById(int id);

    public Object findBySourceAreaId(String sourceAreaId);

    public Object findByTagId(int tagId);

    public Object findAll();
}
