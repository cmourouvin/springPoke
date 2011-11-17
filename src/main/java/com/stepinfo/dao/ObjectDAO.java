package com.stepinfo.dao;

import java.util.List;

public interface ObjectDAO {
	
	List<Object> getAll();
	Object getById(long id);

}
