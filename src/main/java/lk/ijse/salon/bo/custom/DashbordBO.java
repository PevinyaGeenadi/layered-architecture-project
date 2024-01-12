package lk.ijse.salon.bo.custom;

import lk.ijse.salon.bo.SuperBO;

import java.sql.SQLException;

public interface DashbordBO extends SuperBO {
    public int getTotCustomers() throws SQLException, ClassNotFoundException ;
    public int getTotEmployee() throws SQLException, ClassNotFoundException;
}
