package Application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
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
       DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
       
       
       //Testes para seller abaixo:

        
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
        Seller newSeller = new Seller(null, "Matheus", "matheus@mail.com", new Date(),
                4500.00, department);
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
        
        
        //Testes para o departamento abaixo
        
        System.out.println("=== Test 1 Department :  department insert ===");
        Department newDepartment = new Department(null, "food");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! new id = " + newDepartment.getId());
        
        
        System.out.println("=== Test 2 Department :  department update ===");
        Department dep2 = departmentDao.findById(7);
        dep2.setName("Food");
        departmentDao.update(dep2);
        System.out.println("Update completed!");
        
       
        System.out.println("=== Test 3 Department : department deleteById ===");
        System.out.println("Enter id for delete test:");
        int depid = sc.nextInt();
        departmentDao.deleteById(depid);
        System.out.println("Delete completed!");
        
        
        System.out.println("=== Test 4 Department : department findAll ===");
        List<Department> deplist = departmentDao.findAll();
        for(Department obj : deplist){
            System.out.println(obj);
        }
        
        sc.close();
    }
}
