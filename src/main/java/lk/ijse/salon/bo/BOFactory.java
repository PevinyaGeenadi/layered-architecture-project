package lk.ijse.salon.bo;

import lk.ijse.salon.bo.custom.impl.CustomerBOImpl;
import lk.ijse.salon.bo.custom.impl.DashbordBOImpl;
import lk.ijse.salon.bo.custom.impl.EmployeeBOImpl;
import lk.ijse.salon.bo.custom.impl.OrderFormBOImpl;

public class BOFactory {
    private static BOFactory boObjectCreater;

    private BOFactory() {

    }

    public static BOFactory getBOFactory() {
        if (boObjectCreater==null) {
            boObjectCreater = new BOFactory();
        }
        return boObjectCreater;
    }

    public enum BOType{
        CUSTOMER,DASHBORD,EMPLOYEE,ORDERFORM
    }

    public <T extends SuperBO>T getBO(BOType rest) {
        switch (rest) {
            case CUSTOMER:
                return (T) new CustomerBOImpl();
            case DASHBORD:
                return (T) new DashbordBOImpl();
            case EMPLOYEE:
                return (T) new EmployeeBOImpl();
            case ORDERFORM:
                return (T) new OrderFormBOImpl();

            default:
                return null;

        }
    }
}
