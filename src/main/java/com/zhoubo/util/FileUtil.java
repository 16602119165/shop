
package com.zhoubo.util;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.text.SimpleDateFormat;



/**
 * @author Administrator
 *
 */
public class FileUtil {

	/**
	 * 
	 * @param dir 上传文件存储路径
	 * @param fileName 文件名
	 * @param bytes 文件数据
	 * @return 
	 */
	public static File fileUpload(String dir,String fileName,byte[] bytes) {
		File file = createFile(dir, fileName);
		if(null == file) {
			return null;
		}
		FileOutputStream fos = null;
		InputStream is =new ByteArrayInputStream(bytes);
		try {
			fos = new FileOutputStream(file);
			int len = 0;
			byte[] buffer = new byte[8192];
			while((len = is.read(buffer)) != -1) {
				fos.write(buffer, 0, len);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return file;
	};
	/**
	 * 
	 * @param dir
	 * @param fileName
	 * @return file or return null
	 */
	public static File createFile(String dir,String fileName) {
 		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String stringDate = simpleDateFormat.format(new Date());
		File file = null;
		File filedir = new File(dir);
		if(!filedir.exists()) {
			filedir.mkdirs();
		}
		File[] files = filedir.listFiles();
		if(files.length >= 20) {
			return null;
		}else {
			String newFileName = stringDate+fileName;
			file = new File(filedir + File.separator + newFileName);
			return file;		
		}
	};
	/**
	 * 
	 * @param file
	 * @return List<String[]> 返回读取的表格内容的集合，帮助解耦，在具体的service中
	 * 去进行，实体类-数据库表的赋值 
	 * 
	 */
	public static List<String[]> readExcle(File file) {
		InputStream is = null;
		//1.创建工作薄，workbook，代表一个Excel文件	
		Workbook workbook = null;
		Sheet sheet = null;
		Row row = null;
		List<String[]> list = new ArrayList<String[]>();
		try {
			is = new FileInputStream(file);
			//2.判断文件后缀是xls(使用HSSFWorkBook)还是xlsx(使用XSSFWorkBook)
			if(file.getName().endsWith("xls")) {
				workbook = new HSSFWorkbook(is);
			}else {
				workbook = new XSSFWorkbook(is);
			}
			//3.获取当前工作薄中所有的表格页sheet
			if(null != workbook) {
				for(int sheetNum = 0;sheetNum < workbook.getNumberOfSheets();sheetNum++) {
					sheet = workbook.getSheetAt(sheetNum);
					//4获得当前sheet的第一行以及最后一行
					int fristRow = sheet.getFirstRowNum();
					int lastRow = sheet.getLastRowNum();
					//5.遍历除了第一行之外的所有行
					for(int rowNum = fristRow + 1;rowNum <= lastRow; rowNum++ ) {
						//6.获得当前行row
						row = sheet.getRow(rowNum);
						//7获得当前行开始列以及结束列
						int fristCell = row.getFirstCellNum();
						int lastCell = row.getLastCellNum();
						//8.new一个string[] 数组，数组的大小（size）是当前行中有数据的列记录数
						String[] cells = new String[lastCell];
						for(int cellNum = fristCell; cellNum < lastCell;cellNum++) {
							//10.遍历当前行的每一个cell单元格
							Cell cell = row.getCell(cellNum);
							//11.string 数组中每一位都给赋值同步。
							switch(cell.getCellType()) {
							case STRING:
								cells[cellNum] = cell.getStringCellValue();
								break;
							case NUMERIC:
								cells[cellNum] = String.valueOf(cell.getNumericCellValue());
								break;
							}
							
							
						}
						list.add(cells);
					}
				}
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(null != workbook) {
				try {
					workbook.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	
	
}
