package com.example.chanmansys.DAO;

// SqlLiteChangeDAO implementation of the
// ChangeDAO interface. This class can contain all
// SqlLite specific code and SQL statements.
// The client is thus shielded from knowing
// these implementation details.

import com.example.chanmansys.Model.Change;

public class SqlLiteChangeDAO implements ChangeDAO {
    @Override
    public Change get(int changeID) {
        return null;
    }

    @Override
    public void create(Change change) {

    }

    @Override
    public void update(Change change) {

    }
}
