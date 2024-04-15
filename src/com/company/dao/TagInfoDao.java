package com.company.dao;

import com.company.bean.ChannelInfo;
import com.company.bean.TagInfo;

public interface TagInfoDao {
    public void add(TagInfo tagInfo);

    public boolean delete(int tagId);

    public boolean update(int tagId, TagInfo tagInfo);

    public Object findByTagId(int tagId);

    public Object findAll();
}
