package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== Test 1: department findById ===");
		Department Department = departmentDao.findById(3);		
		System.out.println(Department);
		
	
		System.out.println("\n=== Test 2: department findAll ===");
		List<Department> listAll =  departmentDao.findAll();
		for (Department dep : listAll) {
			System.out.println(dep);
		}
		
		System.out.println("\n=== Test 3: department insert ===");
		Department newDepartment = new Department(null, "depTeste");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());
		
		System.out.println("\n=== Test 4: department update ===");
		Integer id =  1;
		System.out.println("Updating Department id = " + id);
		Department dep = departmentDao.findById(id);
		System.out.println(dep);
		dep.setName("Groceries");
		departmentDao.update(dep);		
		dep = departmentDao.findById(id);
		System.out.println("Updated! "+ dep);
		
		System.out.println("\n=== Test 5: department delete ===");
		id= 12;
		Department = departmentDao.findById(id);
		System.out.println(Department);
		System.out.println("Deleting Department id = " + id);
		departmentDao.deleteById(id);
		Department = departmentDao.findById(id);
		System.out.println(Department != null ? Department : "Department not found!");
	}

}
