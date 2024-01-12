package lk.ijse.salon.bo.custom;

import lk.ijse.salon.bo.SuperBO;
import lk.ijse.salon.dto.EmployeeDTO;

import java.sql.SQLException;

public interface SignUpBO extends SuperBO {
    public boolean saveSignUp(EmployeeDTO empDTO) throws SQLException, ClassNotFoundException ;
}
