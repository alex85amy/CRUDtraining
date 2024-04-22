package com.company.dao;

import com.company.bean.TagInfo;

public interface TagInfoDao {
    void add(TagInfo tagInfo);

    boolean delete(int tagId);

    boolean update(int tagId, TagInfo tagInfo);

    Object findByTagId(int tagId);

    Object findAll();
}
