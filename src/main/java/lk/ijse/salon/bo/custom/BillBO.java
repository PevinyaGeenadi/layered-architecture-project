package lk.ijse.salon.bo.custom;

import lk.ijse.salon.bo.SuperBO;
import lk.ijse.salon.dto.BillDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface BillBO extends SuperBO {
    ArrayList<BillDTO> getAllBills() throws SQLException, ClassNotFoundException;
    boolean saveBill(BillDTO dto) throws SQLException, ClassNotFoundException;
    boolean updateBill(BillDTO dto) throws SQLException, ClassNotFoundException;
    boolean deleteBill(String id) throws SQLException, ClassNotFoundException;
    BillDTO searchBill(String id) throws SQLException, ClassNotFoundException;
}
