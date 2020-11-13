package com.groceryshop.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groceryshop.demo.entitites.AdminEntity;
import com.groceryshop.demo.exception.DuplicateRecordException;
import com.groceryshop.demo.exception.RecordNotFoundException;
import com.groceryshop.demo.service.AdminServiceImp;

@RestController
@RequestMapping("/adminEntity")
public class AdminController {
	@Autowired
	AdminServiceImp adminServiceImp;
	/**
	 * addAdminEntity
	 * <p>
	 * In This method we are sending adminEntity object as the parameter.
	 * with the help of AdminServiceImp we are finding if the object sent is present in the database or not by using the
	 * method findbyLoginId().If the
	 * id is present then we are throwing the duplicate record Exception or
	 * else we are adding the id object to database using add()and returning the ResponseEntity.  
	 * </p>
	 * @param bean
	 * @return ResponseEntity<AdminEntity>
	 */
	@PostMapping("/addAdminEntity")
	public ResponseEntity<AdminEntity> addAdminEntity(@RequestBody AdminEntity bean) {
		long adminEntityId = adminServiceImp.add(bean);
		if (adminEntityId > 0) {
			return new ResponseEntity<AdminEntity>(bean, HttpStatus.OK);
		} else {
			throw new DuplicateRecordException("ID already exists");
		}
	}
	/**
	 * deleteAdminEntity
	 * <p>
	 * In This method we are sending adminEntity object as the parameter.
	 * with the help of AdminServiceImp we are finding if the object sent is present in the database or not by using the
	 * method findByLoginId().If the
	 * id is present then we are throwing the duplicate record Exception or
	 * else we are deleting the order object to database using delete()and returning the ResponseEntity.  
	 * </p>
	 * @param bean
	 * @return ResponseEntity<AdminEntity>
	 */
	@DeleteMapping("/deleteAdminEntity/{id}")
	public ResponseEntity<AdminEntity> deleteAdminEntity(@RequestBody long id) throws RecordNotFoundException {
		AdminEntity admin = adminServiceImp.findByLoginId(id);
		if (admin != null) {
			return new ResponseEntity<AdminEntity>(admin, HttpStatus.OK);
		} else {

			throw new RecordNotFoundException("Login not available with ID:" + admin.getLoginId());
		}

	}
	/**
	 * updateAdminEntity
	 * <p>
	 * In This method we are sending adminEntity object as the parameter.
	 * with the help of AdminServiceImp we are finding if the object sent is present in the database or not by using the
	 * method findByLoginId().If the order is present then we are throwing the duplicate record Exception or
	 * else we are deleting the id object to database using update()and returning the ResponseEntity.  
	 * </p>
	 * @param bean
	 * @return ResponseEntity<AdminEntity>
	 */
	@PutMapping("/updateAdminEntity")
	public ResponseEntity<AdminEntity> updateAdminEntity(@RequestBody AdminEntity bean) throws RecordNotFoundException {
		AdminEntity admin = adminServiceImp.findByLoginId(bean.getLoginId());
		if (admin != null) {
			adminServiceImp.update(bean);
			return new ResponseEntity<AdminEntity>(bean, HttpStatus.OK);
		}

		else {
			throw new RecordNotFoundException("Login not available with ID:" + bean.getLoginId());
		}
	}
	/**
	 * authenticateAdminEntity
	 * <p>
	 * In This method we are sending adminEntity object as the parameter.
	 * with the help of AdminServiceImp we are finding if the object sent is present in the database or not by using the
	 * method findByLoginId().If the
	 * id is present then we are throwing the duplicate record Exception or
	 * else we are deleting the id object to database using getPassword and returning the ResponseEntity.  
	 * </p>
	 * @param bean
	 * @return ResponseEntity<AdminEntity>
	 */
	@GetMapping("/authenticateAdminEntity")
	public ResponseEntity<AdminEntity> authenticateAdminEntity(@RequestBody AdminEntity bean) {
		AdminEntity adminEntity = adminServiceImp.findByLoginId(bean.getLoginId());
		if(adminEntity!=null)
		{
			if(adminEntity.getPassword().equals(bean.getPassword()))
			{
				return new ResponseEntity<AdminEntity>(adminEntity, HttpStatus.OK);
			}else {
				throw new RecordNotFoundException("Invalid Password");
			}
		}else {
			throw new RecordNotFoundException("Invalid userName");
		}
	}
	/**
	 * findByLoginAdminEntity
	 * <p>
	 * In This method we are sending adminEntity object as the parameter.
	 * with the help of AdminServiceImp we are finding if the object sent is present in the database or not by using the
	 * method findByLogin().If the id is present then we are throwing the duplicate record Exception or
	 * else we are deleting the id object to database using delete()and returning the ResponseEntity.  
	 * </p>
	 * @param bean
	 * @return ResponseEntity<AdminEntity>
	 */
	@GetMapping("/findByLogin/{login}/{id}")
	public ResponseEntity<AdminEntity> findByLogin(@PathVariable Long id) {
		if (adminServiceImp.findByLoginId(id) == null) {
			throw new RecordNotFoundException("Record not found with id:" + id);
		} else {
			return new ResponseEntity<AdminEntity>(adminServiceImp.findByLoginId(id), HttpStatus.OK);
		}
	}
	/**
	 * ListAdminEntity
	 * <p>
	 * In This method we are sending adminEntity object as the parameter.
	 * with the help of AdminServiceImpwe are finding if the object sent is present in the database or not by using the
	 * method checks in list in bean and returned bean.
	 * </p>
	 * @param bean
	 * @return ResponseEntity<AdminEntity>
	 */
	@GetMapping("/search/{bean}")
	public List<AdminEntity> search(@PathVariable AdminEntity bean) {
		return adminServiceImp.search(bean);
	}

}
