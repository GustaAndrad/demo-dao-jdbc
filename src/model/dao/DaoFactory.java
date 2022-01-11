package model.dao;

import db.DB;
import model.dao.impl.SellerDaoJDBC;

/**
 *
 * @author gusta
 */
public class DaoFactory {


    public static SellerDao createSellerDao(){
        return new SellerDaoJDBC(DB.getConnection());
    }
}