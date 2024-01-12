package lk.ijse.salon.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import lk.ijse.salon.dto.AttendanceDTO;
import lk.ijse.salon.model.EmployeeAttendanceModel;
import lk.ijse.salon.dto.tm.EmployeeAttendanceTm;
import lk.ijse.salon.model.EmployeeModel;
import lk.ijse.salon.util.DateTimeUtil;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AttendanceFormController implements Initializable {
    public JFXTextField txtSearch;
    public TableView tbl;
    public TableColumn tblid;
    public TableColumn tbllName;
    public TableColumn tblcity;
    public TableColumn tblcontactNumber;
    public Pane pane;
    public Pane pane1;
    public Text txtEmpCount;
    public Pane pane2;
    public JFXComboBox cmbId;
    public Text txtEmployeeAttendance;

    ObservableList<EmployeeAttendanceTm>tms= FXCollections.observableArrayList();

    public void txtseazrchKeyReleased(KeyEvent keyEvent) {

    }

    public void cmbEmployeeId(ActionEvent actionEvent) {
        try {
            if (EmployeeAttendanceModel.add(new AttendanceDTO(
                    (String) cmbId.getValue(),
                    id(),
                    DateTimeUtil.dateNow(),
                    DateTimeUtil.timeNow()
            ))) {
                tbl.getItems().clear();
                tms.clear();
                loadIds();
              //  cmbId.getItems().clear();
                setDataCombo();
                new Alert(Alert.AlertType.CONFIRMATION, " Ok ").show();

            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }

    private String id() {
        try {
            ArrayList<String> allId = EmployeeAttendanceModel.getAllId();
            String lastId = null;
            for (int i = 0; i < allId.size(); i++) {
                lastId = allId.get(i);
                System.out.println(allId.get(i));
            }
            try {
                String[] e00s = lastId.split("A00");
                int idIndex = Integer.parseInt(e00s[1]);
                idIndex++;
                System.out.println(idIndex);
                return "A00" + idIndex;
            } catch (Exception e) {
                return "A001";
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setDataCombo();
        setTableProperty();
        loadAllEmployeeCount();
        loadTodayEmployeeCount();
        try {
            loadIds();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void loadTodayEmployeeCount() {
        try {
            txtEmployeeAttendance.setText(EmployeeAttendanceModel.getTodayAttendanceCount());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void loadAllEmployeeCount() {
        try {
            txtEmpCount.setText(EmployeeModel.getEmployeeCount());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    private void loadIds() throws SQLException, ClassNotFoundException {
        ArrayList<String>ids= EmployeeAttendanceModel.getAllId();
        for (int i = 0; i < ids.size(); i++) {
            loadIdData(ids.get(i));
        }

    }

    private void loadIdData(String id) {
        try {
            EmployeeAttendanceTm  tm= EmployeeAttendanceModel.getIdData(id);
            tms.add(tm);
        } catch (SQLException throwables) {


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void setTableProperty() {
        tblid.setCellValueFactory(new PropertyValueFactory<>("id"));
        tbllName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tblcontactNumber.setCellValueFactory(new PropertyValueFactory<>("date"));
        tblcity.setCellValueFactory(new PropertyValueFactory<>("time"));
        tbl.setItems(tms);
    }

    private void setDataCombo() {
        try {
            cmbId.getItems().clear();
            ArrayList<String> allEmployeeIds = EmployeeAttendanceModel.get();
            ArrayList<String> monthly_AttendanceIds = EmployeeAttendanceModel.getAttendance();

            for (int i = 0; i < allEmployeeIds.size(); i++) {
                for (int j = 0; j < monthly_AttendanceIds.size(); j++) {
                    if (allEmployeeIds.get(i).equals(monthly_AttendanceIds.get(j))) {
                        allEmployeeIds.remove(i);
                    }
                }
            }
            System.out.println(allEmployeeIds);
            System.out.println(monthly_AttendanceIds);
            cmbId.getItems().addAll(allEmployeeIds);

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}
