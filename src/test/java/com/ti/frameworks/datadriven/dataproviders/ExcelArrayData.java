package com.ti.frameworks.datadriven.dataproviders;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static com.ti.frameworks.config.Constants.WORKBOOKS_FOLDER;

public class ExcelArrayData {
    private static Sheet sheet;
    private static Workbook workbook;
    private static final DataFormatter dataFormatter = new DataFormatter();

    public static void readExcel(String workBook) throws IOException {
        workbook = WorkbookFactory.create(new File(WORKBOOKS_FOLDER + workBook));
    }

    public static Sheet getWorkSheet(String sheetName){
        return workbook.getSheet(sheetName);
    }

    private static Object[][] asTwoDimensionalArray(List<LinkedHashMap<Object,Object>> interimResults){
        Object[][] results = new Object[interimResults.size()][1];
        int index = 0;
        for (LinkedHashMap<Object,Object> interimResult : interimResults){
            results[index++] = new Object[] {interimResult};
        }
        return results;
    }

    private static LinkedHashMap<Object, Object> transform(List<String> names, List<String> values){
        LinkedHashMap<Object, Object> results = new LinkedHashMap<>();
        for (int i=0; i< names.size(); i++){
            String key = names.get(i);
            String value = values.get(i);
            results.put(key,value);
        }
        return results;
    }
    private static List<String> getValuesInEachRow(Row row){
        List<String> data = new ArrayList<>();
        Iterable<Cell> columns = row::cellIterator;
        for (Cell column: columns){
            data.add(column.toString().equalsIgnoreCase("empty")?"":dataFormatter.formatCellValue(column));
        }
        return data;
    }

    public static Object[][] getExcelTableArray(String excelWorkbook, String excelWorkSheet) throws IOException {
        readExcel(excelWorkbook);
        sheet = getWorkSheet(excelWorkSheet);
        Iterable<Row> rows = sheet::rowIterator;
        List<LinkedHashMap<Object, Object>> results = new ArrayList<>();
        boolean header = true;
        List<String> keys = null;
        for (Row row: rows){
            List<String> values = getValuesInEachRow(row);
            if (header){
                header = false;
                keys = values;
                continue;
            }
            results.add(transform(keys,values));
        }
        return asTwoDimensionalArray(results);
    }
}
