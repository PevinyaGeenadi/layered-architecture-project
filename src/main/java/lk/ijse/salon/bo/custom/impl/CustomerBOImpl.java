package lk.ijse.salon.bo.custom.impl;

import lk.ijse.salon.dao.DAOFactory;
import lk.ijse.salon.dao.custom.CustomerDAO;
import lk.ijse.salon.dto.CustomerDTO;
import lk.ijse.salon.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl {
    CustomerDAO customerDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
        ArrayList<Customer> arrayList =  customerDAO.getAll();
        ArrayList<CustomerDTO> dtoArrayList = new ArrayList<>();
        for (Customer c : arrayList) {
            dtoArrayList.add(new CustomerDTO(c.getCustID(),c.getFirstName(),c.getFirstName(),c.getStreet(),c.getCity(),c.getLane(),c.getContact()));
        }
        return dtoArrayList;
    }


    public boolean saveCustomer(CustomerDTO cusDTO) throws SQLException, ClassNotFoundException {

        return customerDAO.save(new Customer(cusDTO.getCustID(), cusDTO.getFirstName(), cusDTO.getLastName(), cusDTO.getStreet(), cusDTO.getCity(), cusDTO.getLane(), cusDTO.getContact()));
    }


    public boolean updateCustomer(CustomerDTO cusDTO) throws SQLException, ClassNotFoundException {
        return customerDAO.update(new Customer(cusDTO.getCustID(), cusDTO.getFirstName(), cusDTO.getLastName(), cusDTO.getStreet(), cusDTO.getCity(), cusDTO.getLane(), cusDTO.getContact()));
    }


    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.delete(id);
    }
}
