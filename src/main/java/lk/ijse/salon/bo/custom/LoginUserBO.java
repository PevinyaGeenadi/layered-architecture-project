package lk.ijse.salon.bo.custom;

import lk.ijse.salon.bo.SuperBO;
import lk.ijse.salon.dto.EmployeeDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface LoginUserBO extends SuperBO {
    public ArrayList<EmployeeDTO> searchUser(String id) throws SQLException, ClassNotFoundException ;
}
