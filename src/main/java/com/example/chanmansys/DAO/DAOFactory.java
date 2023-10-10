package com.example.chanmansys.DAO;

// Abstract class DAO Factory
public abstract class DAOFactory {
    // список всех DAO вариантов загрузки данных
    public static final int SQLITE = 1;
    public static final int FILE = 2;
    public static final int RAM = 3;

    // мои интерфейсы всех DAO. The concrete factories will have to implement these methods.
    public abstract UserDAO getUserDAO();
    public abstract ChangeDAO getChangeDAO();
    public abstract ServiceDAO getServiceDAO();

    public static DAOFactory getDAOFactory(
            int whichFactory) {

        switch (whichFactory) {
            case SQLITE:
                return new SqlLiteDAOFactory();
            case FILE:
                return new SqlLiteDAOFactory(); //FileDAOFactory();
            case RAM:
                return new SqlLiteDAOFactory(); //RamDAOFactory();
            default:
                return null;
        }
    }
}