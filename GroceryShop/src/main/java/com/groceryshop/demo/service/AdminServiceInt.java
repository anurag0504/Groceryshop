package com.groceryshop.demo.service;

import java.util.List;

import com.groceryshop.demo.entitites.AdminEntity;
import com.groceryshop.demo.exception.DuplicateRecordException;

public interface AdminServiceInt {

	public long add(AdminEntity bean) throws DuplicateRecordException;

	public void delete(int id) ;

	public void update(AdminEntity bean) throws DuplicateRecordException;
	public AdminEntity authenticate(AdminEntity bean);

	public AdminEntity findByLoginId(long login) ;

	public List<AdminEntity> search(AdminEntity bean);

	//public List search(AdminEntity bean, int pageNo, int pageSize) ;

	//	AdminEntity findByLoginId(long loginId);


}
