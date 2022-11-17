package com.gaurav.quoraapp.controller;
import com.gaurav.quoraapp.Dto.UserDto;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ExcelFileExporter {


    public static ByteArrayInputStream contactListToExcelFile(List< UserDto > users) {

        try(Workbook workbook = new XSSFWorkbook()){
            Sheet sheet = workbook.createSheet("Users");
            Row row = sheet.createRow(0);
            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
            headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            // Creating header
            Cell cell = row.createCell(0);
            cell.setCellValue("Full Name");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(1);
            cell.setCellValue("Email");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(2);
            cell.setCellValue("DateOfBirth");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(3);
            cell.setCellValue("Phone");
            cell.setCellStyle(headerCellStyle);

            // Creating data rows for each customer
            for(int i = 0; i < users.size(); i++) {
                Row dataRow = sheet.createRow(i + 1);
                dataRow.createCell(0).setCellValue(users.get(i).getName());
                dataRow.createCell(1).setCellValue(users.get(i).getEmail());

             //   dataRow.createCell(2).setCellValue(String.valueOf(users.get(i).getRoles()));
             //   dataRow.createCell(3).setCellValue(String.valueOf(users.get(i).getExpertise()));


//                dataRow.createCell(1).setCellValue(users.get(i).getGetABoolean());
                String mobileNumber= (String) users.get(i).getMobileNumber().toString();
                dataRow.createCell(3).setCellValue(mobileNumber);
                dataRow.createCell(2).setCellValue( users.get(i).getDob().toString());
                System.out.println(mobileNumber);
                System.out.println(users.get(i).getDob());
               // System.out.println(String.valueOf(users.get(i).getExpertise()));
              //  System.out.println(String.valueOf(users.get(i).getRoles()));

            }

            // Making size of column auto resize to fit with data
            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
            sheet.autoSizeColumn(2);
            sheet.autoSizeColumn(3);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);
            return new ByteArrayInputStream(outputStream.toByteArray());
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
