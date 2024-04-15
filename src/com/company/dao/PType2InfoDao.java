package com.company.dao;

import com.company.bean.PType2Info;

public interface PType2InfoDao {

    public void add(PType2Info pType2Info);

    public boolean delete(String category);

    public boolean update(String category, PType2Info pType2Info);

    public Object findByCategory(String category);

    public Object findAll();
}
