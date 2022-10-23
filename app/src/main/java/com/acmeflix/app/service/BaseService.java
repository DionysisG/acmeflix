package com.acmeflix.app.service;

import java.util.List;

import com.acmeflix.app.domain.BaseModel;

public interface BaseService<T extends BaseModel, ID> {
	T create(final T item);

	List<T> createAll(final T... items);

	List<T> createAll(final List<T> items);

	void update(T item);

	void delete(T item);

	void deleteById(ID id);

	boolean exists(T item);

	T get(ID id);

	List<T> findAll();
}
