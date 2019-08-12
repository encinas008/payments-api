package com.payments.dal;

import java.util.List;

/**
 * Actions to interact with stored data.
 */
public interface DataAction<T> {
    boolean save(T data);
    List<T> findAll();
}
