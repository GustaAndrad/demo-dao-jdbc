package Application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

/**
 *
 * @author gusta
 */
public class Program {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

       SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== Test 1 :  seller findById ===");    
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);
        
        System.out.println("=== Test 2 :  seller findByDepartment ==="); 
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj : list){
            System.out.println(obj);
        }
        
        System.out.println("=== Test 3 :  seller findAll ==="); 
        list = sellerDao.findAll();
        for (Seller obj : list){
            System.out.println(obj);
        }
        
        System.out.println("=== Test 4 :  seller insert ==="); 
        Seller newSeller = new Seller(null, "Greg", "greg@mail.com", new Date(),
                4000.00, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! new id = " + newSeller.getId());
        
        
        System.out.println("=== Test 5 :  seller update ===");
        seller = sellerDao.findById(1);
        seller.setName("Martha Waine");
        sellerDao.update(seller);
        System.out.println("Update completed!");
        
        System.out.println("=== Test 6 :  seller delete ===");
        System.out.println("Enter id for delete test: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete completed!");
        
        sc.close();
    }
}
