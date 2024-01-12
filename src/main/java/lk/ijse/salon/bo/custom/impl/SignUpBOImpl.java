package lk.ijse.salon.bo.custom.impl;

import lk.ijse.salon.dao.DAOFactory;
import lk.ijse.salon.dao.custom.impl.UserDAOImpl;
import lk.ijse.salon.dto.UserDTO;
import lk.ijse.salon.entity.User;

import java.sql.SQLException;

public class SignUpBOImpl {
    UserDAOImpl userDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.USER);

    public boolean save(UserDTO userDTO) throws SQLException, ClassNotFoundException {
        return userDAO.save(new User(userDTO.getUsername(),userDTO.getPassword(),userDTO.getEmial()));
    }

}
