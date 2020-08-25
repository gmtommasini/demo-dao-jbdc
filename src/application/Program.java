package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== Test 1: seller findById ===");
		Seller seller = sellerDao.fingById(3);		
		System.out.println(seller);
		
		System.out.println("\n=== Test 2: seller findByDepartment ===");
		Department department = new Department(4, null);
		List<Seller> list =  sellerDao.findByDepartment(department);
		for (Seller seller2 : list) {
			System.out.println(seller2);
		}
		
		System.out.println("\n=== Test 3: seller findAll ===");
		//Department department = new Department(4, null);
		List<Seller> listAll =  sellerDao.findAll();
		for (Seller seller2 : listAll) {
			System.out.println(seller2);
		}

	}

}
