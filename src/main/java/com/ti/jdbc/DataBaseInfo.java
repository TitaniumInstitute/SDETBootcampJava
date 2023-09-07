package com.ti.jdbc;

public enum DataBaseInfo {
    DBHOST(PropertyManager.getInstance().getProperty("DBHost")),
    DBPORT(PropertyManager.getInstance().getProperty("DBPort")),
    DBUSERNAME(PropertyManager.getInstance().getProperty("DBUserName")),
    DBPASSWORD(PropertyManager.getInstance().getProperty("DBPassword")),
    DBNAME(PropertyManager.getInstance().getProperty("DBStudent"));

    public final String dbConn;

    DataBaseInfo(String dbConn) {
        this.dbConn = dbConn;
    }
}
