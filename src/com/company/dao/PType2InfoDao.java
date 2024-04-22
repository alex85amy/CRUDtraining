package com.company.dao;

import com.company.bean.PType2Info;

public interface PType2InfoDao {

    void add(PType2Info pType2Info);

    boolean delete(int id);

    boolean update(int id, PType2Info pType2Info);

    Object findById(int id);

    Object findAll();
}
