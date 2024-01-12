package lk.ijse.salon.dao.custom;

import lk.ijse.salon.dao.CrudDAO;
import lk.ijse.salon.entity.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDAO extends CrudDAO<Customer,String> {
    public List<String> loadIds() throws SQLException, ClassNotFoundException;

    public String getCustName(String cust_id) throws SQLException, ClassNotFoundException ;

    public int getTotCustomers() throws SQLException, ClassNotFoundException ;
}
