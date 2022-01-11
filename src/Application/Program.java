package Application;

import java.util.List;
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
    }
}
