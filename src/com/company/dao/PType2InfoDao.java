package com.company.dao;

import com.company.bean.PType2Info;

public interface PType2InfoDao {

    public void add(PType2Info pType2Info);

    public boolean delete(int id);

    public boolean update(int id, PType2Info pType2Info);

    public Object findById(int id);

    public Object findAll();
}
