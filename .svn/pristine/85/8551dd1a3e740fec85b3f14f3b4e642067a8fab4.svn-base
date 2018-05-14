/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.htc.airtime.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author Admin
 */
public class ExcelTool {
    public static void main(String[] args) {
        createExcel("otpRequest.xls","test");
    }
    public static void createExcel(String fileName,String sheetName) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet(sheetName);

        Map<String, Object[]> data = new HashMap<String, Object[]>();
        data.put("1", new Object[]{"Tiếng việt có dấu", "Name", "Salary"});
        data.put("2", new Object[]{1d, "John", 1500000d});
        data.put("3", new Object[]{2d, "Sam", 800000d});
        data.put("4", new Object[]{3d, "Dean", 700000d});

        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset) {
            Row row = sheet.createRow(rownum++);
            Object[] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof Date) {
                    cell.setCellValue((Date) obj);
                } else if (obj instanceof Boolean) {
                    cell.setCellValue((Boolean) obj);
                } else if (obj instanceof String) {
                    cell.setCellValue((String) obj);
                } else if (obj instanceof Double) {
                    cell.setCellValue((Double) obj);
                }
            }
        }

        try {
            String path = "D:\\"+fileName;
            FileOutputStream out = new FileOutputStream(new File(path));
            workbook.write(out);
            out.close();
            System.out.println("Excel written successfully..");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
