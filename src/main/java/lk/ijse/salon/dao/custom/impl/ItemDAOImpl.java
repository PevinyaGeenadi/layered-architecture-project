package lk.ijse.salon.dao.custom.impl;

import lk.ijse.salon.dao.custom.ItemDAO;
import lk.ijse.salon.dao.custom.impl.util.SQLUtil;
import lk.ijse.salon.db.DBConnection;
import lk.ijse.salon.dto.PlaceOrderDTO;
import lk.ijse.salon.entity.Item;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public ArrayList<Item> getAll() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM Product";

        ArrayList<Item> obList = new ArrayList<>();

        ResultSet resultSet = SQLUtil.crudUtil(sql);

        while (resultSet.next()) {
            obList.add(new Item(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7)
            ));
        }
        return obList;
    }

    @Override
    public boolean save(Item supAdd) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO product(productID, productName,productUnitPrice, type, mfgDate , expDate, qtyOnHand) " +
                "VALUES(?, ?, ?, ? ,? ,?, ?)";
        /*return SQLUtil.crudUtil(
                sql,
                itmAdd.getItemCode(),
                itmAdd.getItemMedName(),
                itmAdd.getItemUnitPrice(),
                itmAdd.getItemType(),
                itmAdd.getItemmfgDate(),
                itmAdd.getItemDate(),
                itmAdd.getItemQOH()
        );*/

        try (PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql)) {

            pstm.setString(1, supAdd.getItemCode());
            pstm.setString(2, supAdd.getItemProductName());
            pstm.setString(3, supAdd.getItemUnitPrice());
            pstm.setString(4, supAdd.getItemType());
            pstm.setString(5, supAdd.getItemDate());
            pstm.setString(6, supAdd.getItemmfgDate());
            pstm.setString(7, supAdd.getItemQOH());


            return pstm.executeUpdate() > 0;
        }
    }

    @Override
    public boolean update(Item supAdd) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE product SET productName = ?, productUnitPrice=?, type = ?, mfgDate = ?, expDate = ?, qtyOnHand = ? WHERE productID = ?";


        try (PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql)) {

            pstm.setString(1, supAdd.getItemProductName());
            pstm.setString(2, supAdd.getItemUnitPrice());
            pstm.setString(3, supAdd.getItemType());
            pstm.setString(4, supAdd.getItemDate());
            pstm.setString(5, supAdd.getItemmfgDate());
            pstm.setString(6, supAdd.getItemQOH());
            pstm.setString(7, supAdd.getItemCode());

            return pstm.executeUpdate() > 0;
        }
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.crudUtil("DELETE FROM product WHERE productID = ?", id);
    }

    @Override
    public ArrayList<Item> search(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM product WHERE productID=?";

        ArrayList<Item> arrayList = new ArrayList<>();
        ResultSet resultSet = SQLUtil.crudUtil(sql,id);
        if(resultSet.next()){
            arrayList.add(new Item(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7)));
        }
        return arrayList;
    }


    public List<String> loadCodes() throws SQLException, ClassNotFoundException {
        String sql = "SELECT productID FROM product";
        ResultSet resultSet = SQLUtil.crudUtil(sql);

        List<String> data =new ArrayList<>();

        while (resultSet.next()) {
            data.add(resultSet.getString(1));
        }
        return data;
    }

    /*public ItemDTO findById(String itemcode) throws SQLException, ClassNotFoundException {
        *//*String sql = "SELECT * FROM medicine WHERE medID=?";

        ResultSet resultSet = SQLUtil.crudUtil(sql,itemcode);
        if(resultSet.next()){
            return (new ItemDTO(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(7),
                    resultSet.getString(6)
            ));
        }
        return null;*//*
    }*/

    public static boolean updateQty(List<PlaceOrderDTO> placeOrderDTOList) throws SQLException, ClassNotFoundException {
        for(PlaceOrderDTO placeorder : placeOrderDTOList) {
            if(!updateQty(placeorder)) {
                return false;
            }
        }
        return true;
    }

    private static boolean updateQty(PlaceOrderDTO placeorder) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE product SET qtyOnHand = (qtyOnHand - ?) WHERE productID = ?";

        return SQLUtil.crudUtil(
                sql,
                placeorder.getOrdereditemqty(),
                placeorder.getOrdereditemcode()
        );
    }
}
