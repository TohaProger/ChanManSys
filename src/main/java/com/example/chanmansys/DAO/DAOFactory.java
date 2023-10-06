package com.example.chanmansys.DAO;

// Abstract class DAO Factory
public abstract class DAOFactory {
    // список всех DAO типов
    public static final int SQLITE = 1;
    //public static final int ORACLE = 2;
    //public static final int SYBASE = 3;

    // мои интерфейсы всех DAO that can be created. The concrete factories will have to implement these methods.
    public abstract UserDAO getUserDAO();

    public abstract ChangeDAO getChangeDAO();
    //public abstract OrderDAO getOrderDAO();

    public static DAOFactory getDAOFactory(
            int whichFactory) {

        switch (whichFactory) {
            case SQLITE:
                return new SqlLiteDAOFactory();
            /*case ORACLE    :
                return new OracleDAOFactory();
            case SYBASE    :
                return new SybaseDAOFactory();*/

            default:
                return null;
        }
    }
}