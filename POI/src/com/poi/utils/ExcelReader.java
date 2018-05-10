package com.poi.utils;
import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.IOException;  
import java.io.InputStream;  
import java.util.ArrayList;  
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFDataFormatter;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;  
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.Row;  
import org.apache.poi.ss.usermodel.Sheet;  
import org.apache.poi.ss.usermodel.Workbook;  
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.poi.bean.Rdxbdm;  
  



public class ExcelReader {
    /**
     * 根据excal路径生成实体集合
     * @author Changhai
     * @data 2017-7-5
     * @param filePath
     * @return
     */
    public static List<?> getList(String filePath){
        InputStream is;
        try {
            is = new FileInputStream(filePath);
            return getList(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 根据输入流生成实体集合
     * @param is
     * @author Changhai
     * @data 2017-7-5
     * @return
     * @throws IOException
     */
    public static List<Rdxbdm> getList(InputStream is)
            throws IOException {
        List<List<String>> list = ExcelReader.readExcel(is);
        
        //-----------------------遍历数据到实体集合开始-----------------------------------
        List<Rdxbdm> listBean = new ArrayList<Rdxbdm>();
        for (int i = 1; i < list.size(); i++) {// i=1是因为第一行不要
        	Rdxbdm uBean = new Rdxbdm();
            List<String> listStr = list.get(i);
            for (int j = 0; j < listStr.size(); j++) {
                switch(j){
                    case 0:uBean.setDm(listStr.get(j));break;// 第一列
                    case 1:uBean.setMc(listStr.get(j));break;// 第二列
                    //case 2:uBean.setId(Integer.parseInt(listStr.get(j).substring(0,listStr.get(j).indexOf("."))));
                }
            }
            listBean.add(uBean);
        }
        //----------------------------遍历数据到实体集合结束----------------------------------
        return listBean;
    }

    /**
     * Excel读取 操作
     */
    public static List<List<String>> readExcel(InputStream is)
            throws IOException {
        Workbook wb = null;
        try {  
              wb = WorkbookFactory.create(is);        
            } catch (FileNotFoundException e) {  
              e.printStackTrace();  
            } catch (InvalidFormatException e) {  
              e.printStackTrace();  
            } catch (IOException e) {  
              e.printStackTrace();  
            }  

        /** 得到第一个sheet */
        Sheet sheet = wb.getSheetAt(0);
        /** 得到Excel的行数 */
        int totalRows = sheet.getPhysicalNumberOfRows();

        /** 得到Excel的列数 */
        int totalCells = 0;
        if (totalRows >= 1 && sheet.getRow(0) != null) {
            totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
        }

        List<List<String>> dataLst = new ArrayList<List<String>>();
        /** 循环Excel的行 */
        for (int r = 0; r < totalRows; r++) {
            Row row = sheet.getRow(r);
            if (row == null)
                continue;
            List<String> rowLst = new ArrayList<String>();
            /** 循环Excel的列 */
            for (int c = 0; c < totalCells; c++) {
                Cell cell = row.getCell(c);
                String cellValue = "";
                if (null != cell) {
                	HSSFDataFormatter hSSFDataFormatter = new HSSFDataFormatter();
                	cellValue= hSSFDataFormatter.formatCellValue(cell);

                	// 以下是判断数据的类型
                	/*

                    switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_NUMERIC: // 数字
                        cellValue = cell.getNumericCellValue() + "";
                        break;
                    case Cell.CELL_TYPE_STRING: // 字符串
                        cellValue = cell.getStringCellValue();
                        break;
                    case Cell.CELL_TYPE_BOOLEAN: // Boolean
                        cellValue = cell.getBooleanCellValue() + "";
                        break;
                    case Cell.CELL_TYPE_FORMULA: // 公式
                        cellValue = cell.getCellFormula() + "";
                        break;
                    case Cell.CELL_TYPE_BLANK: // 空值
                        cellValue = "";
                        break;
                    case Cell.CELL_TYPE_ERROR: // 故障
                        cellValue = "非法字符";
                        break;
                    default:
                        cellValue = "未知类型";
                        break;
                    }*/
                }
                rowLst.add(cellValue);
            }
            /** 保存第r行的第c列 */
            dataLst.add(rowLst);
        }
        return dataLst;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            //根据流
            InputStream is = new FileInputStream("e:\\111.xlsx");
            List<Rdxbdm> list = (List<Rdxbdm>) ExcelReader.getList(is);
            //根据文件路径
            //List<User> list = (List<User>) ExcelReader.getList("d:\\user.xlsx");
            for (int i = 0; i < list.size(); i++) {
            	Rdxbdm cBean = list.get(i);
                System.out.println(cBean);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}  