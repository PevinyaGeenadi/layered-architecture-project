package lk.ijse.salon.bo.custom.impl;

import lk.ijse.salon.dao.custom.impl.ItemDAOImpl;
import lk.ijse.salon.dto.ItemDTO;
import lk.ijse.salon.entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl {
    ItemDAOImpl itemDAO = new ItemDAOImpl();

    public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Item> arrayList =  itemDAO.getAll();
        ArrayList<ItemDTO> dtoArrayList = new ArrayList<>();
        for (Item c : arrayList) {
            dtoArrayList.add(new ItemDTO(c.getItemCode(),c.getItemProductName(),c.getItemUnitPrice(),c.getItemType(),
                    c.getItemmfgDate(),c.getItemDate(),c.getItemQOH()));
        }
        return dtoArrayList;
    }
    public boolean save(ItemDTO itmAdd) throws SQLException, ClassNotFoundException {
        return itemDAO.save(new Item(itmAdd.getItemCode(), itmAdd.getItemProductName(), itmAdd.getItemUnitPrice()
                , itmAdd.getItemType(), itmAdd.getItemmfgDate(), itmAdd.getItemDate(), itmAdd.getItemQOH()));
    }
    public boolean update(ItemDTO itmAdd) throws SQLException, ClassNotFoundException {
        return itemDAO.update(new Item(itmAdd.getItemCode(), itmAdd.getItemProductName(), itmAdd.getItemUnitPrice()
                , itmAdd.getItemType(), itmAdd.getItemmfgDate(), itmAdd.getItemDate(), itmAdd.getItemQOH()));

    }

    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return itemDAO.delete(id);
    }



}
