package com.company.dao;

import com.company.bean.TagInfo;

import java.util.List;

public interface TagInfoDao {
    void add(TagInfo tagInfo);

    boolean delete(int tagId);

    boolean update(int tagId, TagInfo tagInfo);

    String findByTagId(int tagId);

    String findAll();

    void addBatch(List<TagInfo> tagInfoList);

}
