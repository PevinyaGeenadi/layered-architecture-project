package lk.ijse.salon.dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T,t> extends SuperDAO{   /* facade design pattern  */
    ArrayList<T> getAll() throws SQLException, ClassNotFoundException;
    boolean save(T dto) throws SQLException, ClassNotFoundException;
    boolean update(T dto) throws SQLException, ClassNotFoundException;
 boolean delete(t id) throws SQLException, ClassNotFoundException;
    ArrayList<T> search(t id) throws SQLException, ClassNotFoundException;
}
