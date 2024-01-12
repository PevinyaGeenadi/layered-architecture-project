package lk.ijse.salon.bo.custom.impl;

import lk.ijse.salon.dao.DAOFactory;
import lk.ijse.salon.dao.custom.impl.UserDAOImpl;
import lk.ijse.salon.dto.UserDTO;
import lk.ijse.salon.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;

public class LoginUserBOImpl {
    UserDAOImpl userDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.USER);

    public ArrayList<UserDTO> searchName(String name) throws SQLException, ClassNotFoundException {
        ArrayList<User> arrayList=  userDAO.search(name);

        ArrayList<UserDTO> dtoArrayList = new ArrayList<>();
        for (User c : arrayList) {
            dtoArrayList.add(new UserDTO(c.getUsername(),c.getPassword(),c.getEmial()));
        }
        return dtoArrayList;
    }
}
