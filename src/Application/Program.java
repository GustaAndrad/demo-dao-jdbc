package Application;

import java.util.Date;
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

        
        //Forma de injeçao de dependencia sem explicitar a implementaçao usando DaoFactory
        SellerDao sellerDao = DaoFactory.createSellerDao();
        
        //Teste do findById
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);
    }
}
