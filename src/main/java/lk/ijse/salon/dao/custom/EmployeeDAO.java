package lk.ijse.salon.dao.custom;

import lk.ijse.salon.dao.CrudDAO;
import lk.ijse.salon.entity.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO extends CrudDAO<Employee,String> {
    public List<String> loadIds() throws SQLException, ClassNotFoundException ;

    public int getTotEmployee() throws SQLException, ClassNotFoundException ;
}
