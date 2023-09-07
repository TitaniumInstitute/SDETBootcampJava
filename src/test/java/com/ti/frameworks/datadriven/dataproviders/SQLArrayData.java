package com.ti.frameworks.datadriven.dataproviders;

import com.ti.jdbc.DataBaseInfo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

import static com.ti.frameworks.datadriven.config.Constants.QUERIES_FOLDER;

public class SQLArrayData {
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    private static Connection getDBConnectio(String dbName) throws SQLException {
        return connection = DriverManager.getConnection(
                String.format("jdbc:mysql://%s:%s/%s?useSSL=false",
                        DataBaseInfo.DBHOST.dbConn, DataBaseInfo.DBPORT.dbConn, dbName),
                DataBaseInfo.DBUSERNAME.dbConn, DataBaseInfo.DBPASSWORD.dbConn);
    }

    private static Statement getStatement(String dbName) throws SQLException {
        return statement = getDBConnectio(dbName)
                .createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    }

    private static String readSqlFile(String sqlFile) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(QUERIES_FOLDER + sqlFile));
        StringBuilder sb = new StringBuilder();
        String line;

        while (Optional.ofNullable((line = br.readLine())).isPresent()) {
            sb.append(line);
        }

        return sb.toString();
    }

    public static ResultSet getResultSet(String dbName, String sqlFile) throws IOException, SQLException {
        return getStatement(dbName).executeQuery(readSqlFile(sqlFile));
    }

    public static void closeConnection() throws SQLException {
        if (Optional.ofNullable(statement).isPresent()) statement.close();
        if (Optional.ofNullable(connection).isPresent()) connection.close();
    }

    public static Object[][] getQueryTableArray(String dbName, String sqlFile) throws SQLException, IOException {
        resultSet = getResultSet(dbName, sqlFile);
        int colCount = resultSet.getMetaData().getColumnCount();
        resultSet.last();
        resultSet.beforeFirst();

        List<LinkedHashMap<Object,Object>> results = new ArrayList<>();

        while (resultSet.next()){
            LinkedHashMap<Object,Object> resultMap = new LinkedHashMap<>();
            for (int i = 1; i < colCount; i++) {
                resultMap.put(resultSet.getMetaData().getColumnName(i),resultSet.getObject(i));
            }
            results.add(resultMap);
        }
        return asTwoDimensionalArray(results);
    }

    private static Object[][] asTwoDimensionalArray(List<LinkedHashMap<Object,Object>> interimResults){
        Object[][] results = new Object[interimResults.size()][1];
        int index = 0;
        for (LinkedHashMap<Object,Object> interimResult : interimResults){
            results[index++] = new Object[] {interimResult};
        }
        return results;
    }
}
