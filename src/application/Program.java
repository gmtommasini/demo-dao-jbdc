/* DO NOT forget to start the MYSQL service and check db connection properties*/
package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao(); //This program does not know the implementation of DAO
		
		System.out.println("=== Test 1: seller findById ===");
		Seller seller = sellerDao.findById(3);		
		System.out.println(seller);
		
		System.out.println("\n=== Test 2: seller findByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list =  sellerDao.findByDepartment(department);
		for (Seller seller2 : list) {
			System.out.println(seller2);
		}
		
		System.out.println("\n=== Test 3: seller findAll ===");
		List<Seller> listAll =  sellerDao.findAll();
		for (Seller seller2 : listAll) {
			System.out.println(seller2);
		}
		
		System.out.println("\n=== Test 4: seller insert ===");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		
		System.out.println("\n=== Test 5: seller update ===");
		Integer id =  1;
		System.out.println("Updating seller id = " + id);
		Seller newSeller2 = sellerDao.findById(id);
		System.out.println(newSeller2);
		newSeller2.setName("Bobby");
		sellerDao.update(newSeller2);		
		newSeller2 = sellerDao.findById(id);
		System.out.println("Updated! "+ newSeller2);
		
		System.out.println("\n=== Test 6: seller delete ===");
		seller = sellerDao.findById(newSeller.getId());
		//System.out.println(seller);
		System.out.println("Deleting " + seller);
		sellerDao.deleteById(seller.getId());
		System.out.println("Verifying if deleted:");
		seller = sellerDao.findById(seller.getId());
		System.out.println(seller != null ? seller : "Seller not found!");
	}

}
