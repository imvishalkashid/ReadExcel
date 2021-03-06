package org.apache.commons.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ReadDataExcel {

	 public String[][] getExcelData(String excelLocation,String sheetname)
	 {
		try
		{
			String dataset[][]=null;
			FileInputStream file=new FileInputStream(new File(excelLocation));
			
			@SuppressWarnings("resource")
			HSSFWorkbook workbook=new HSSFWorkbook(file);
			
			HSSFSheet Sheet=workbook.getSheet(sheetname);
			
			int totalrow= Sheet.getLastRowNum();
			
			
			
			int totalcolumn=Sheet.getRow(0).getLastCellNum();
			
			//System.out.println(totalcolumn);
			
			dataset=new String[totalrow][totalcolumn];
			
			Iterator<Row> rowIterator=Sheet.iterator();
			
			int i=0;
			
		    while(rowIterator.hasNext())
		    {
		    	i=i++;
		    	Row row=rowIterator.next();
		    	
		    	Iterator<Cell> cellIterator=row.cellIterator();
		    	
		    	int j=0;
		    	
		    	while(cellIterator.hasNext())
		    	{
		    		Cell cell=cellIterator.next();
		    		if(cell.getStringCellValue().contains("email"))
		    		{
		    		break;
		    		}
		    		switch(cell.getCellType())
		    		{
		    			case Cell.CELL_TYPE_NUMERIC:
		    				dataset[i][j++]=cell.getStringCellValue();
		    				System.out.println(cell.getNumericCellValue());
		    				break;
		    			case Cell.CELL_TYPE_STRING:
		    				dataset[i][j++]=cell.getStringCellValue();
		    				System.out.println(cell.getStringCellValue());
		    				break;
		    			case Cell.CELL_TYPE_BOOLEAN:
		    				dataset[i][j++]=cell.getStringCellValue();
		    				System.out.println(cell.getStringCellValue());
		    				break;
		    			case Cell.CELL_TYPE_FORMULA:
		    				dataset[i][j++]=cell.getStringCellValue();
		    				System.out.println(cell.getStringCellValue());
		    				break;
		    			case Cell.CELL_TYPE_BLANK:
		    				dataset[i][j++]=cell.getStringCellValue();
		    				System.out.println(cell.getStringCellValue());
		    				break;	
		    		}
		    	}System.out.println("");
		    }
		    file.close();
		    return dataset;   
		}catch(Exception e){
			e.printStackTrace();
		    }
		return null;
		}

public static void main(String args[])throws IOException
{
	ReadDataExcel ReadDataExcel = new ReadDataExcel();
	String excelLocation="E:/Study Material/test/readData.xls"; 
	String sheetname="readDemo";
	
	String[][] data=ReadDataExcel.getExcelData(excelLocation,sheetname);
	System.out.println(data);
	
}
}
	 
    




