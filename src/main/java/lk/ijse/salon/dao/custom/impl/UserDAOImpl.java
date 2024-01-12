package lk.ijse.salon.dao.custom.impl;

import lk.ijse.salon.dao.custom.UserDAO;
import lk.ijse.salon.dao.custom.impl.util.SQLUtil;
import lk.ijse.salon.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAOImpl implements UserDAO {

    @Override
    public ArrayList<User> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(User userDTO) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO user(Username,Password,Email)VALUES(?,?,?)";

        return SQLUtil.crudUtil(sql,
                userDTO.getUsername(),
                userDTO.getPassword(),
                userDTO.getEmial());


    }

    @Override
    public boolean update(User dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<User> search(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM user WHERE Username=?";
        ResultSet resultSet = SQLUtil.crudUtil(sql,id);

        ArrayList<User> arrayList = new ArrayList<>();
        while (resultSet.next()) {
            arrayList.add(new User(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3)));
        }

        return arrayList;
    }


}
