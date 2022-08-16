package com.example.ptp09_2072008.dao;

import java.util.List;

public interface interfaceDao <T> {
    List<T> getData();
    void setData(T data);
    void delData(T data);
    void upData(T data);
}
