package com.example.chanmansys.Model;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.*;

public class Change {
    private int ChangeID;
    private String ChangeDescription;
    private String ChangePriority;
    private String ChangeStatus;
    private int ServiceID_FK;
    private int UserID_FK;

    public int getChangeID() {
        return ChangeID;
    }
    public void setChangeID(int changeID) {
        this.ChangeID = changeID;
    }

    public String getChangeDescription() {
        return ChangeDescription;
    }
    public void setChangeDescription(String changeDescription) {
        this.ChangeDescription = changeDescription;
    }

    public String getChangePriority() {
        return ChangePriority;
    }
    public void setChangePriority(String changePriority) {
        this.ChangePriority = changePriority;
    }

    public String getChangeStatus() {
        return ChangeStatus;
    }
    public void setChangeStatus(String changeStatus) {
        this.ChangeStatus = changeStatus;
    }

    public int getServiceID_FK() {
        return ServiceID_FK;
    }
    public void setServiceID_FK(int serviceID_FK) {
        this.ServiceID_FK = serviceID_FK;
    }

    public int getUserID_FK() {
        return UserID_FK;
    }
    public void setUserID_FK(int userID_FK) {
        this.UserID_FK = userID_FK;
    }

    /*public void setResponsibleChange(String responsibleChange) throws SQLException, URISyntaxException, IOException {
        System.out.print(Integer.parseInt(responsibleChange));
        this.ResponsibleChange= HomeViewController.daoFactory.getUserDAO().findUserByID(Integer.parseInt(responsibleChange));
    }
    public void setResponsibleChange(Users responsibleChange) {
        ResponsibleChange = responsibleChange;
    }*/
}
