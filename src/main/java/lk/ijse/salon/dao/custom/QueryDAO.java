package lk.ijse.salon.dao.custom;

import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import lk.ijse.salon.dao.SuperDAO;

import java.sql.SQLException;

public interface  QueryDAO extends SuperDAO {
    public ObservableList<PieChart.Data> getDataToPieChart() throws SQLException, ClassNotFoundException;
}
