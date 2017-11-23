package util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class ExcelToBean {

	private static ResourceBundle userPropertiesBundle;

	/**
	 * 2003<将excel表中的数据放入到List<Map<String, Object>>中
	 * 
	 * @param workbook
	 * @return
	 */
	public static <T> List<Map<String, Object>> parseUpdateExcel(Workbook workbook, String user) {
		userPropertiesBundle = ResourceBundle.getBundle(user);
		List<Map<String, Object>> result = new LinkedList<Map<String, Object>>();
		int excleRowLength = workbook.getSheetAt(0).getRow(0).getPhysicalNumberOfCells();
		String[] columnName = new String[excleRowLength]; // 相应的javabean类的属性名称数组
		
		
		
		for (int i = 0; i < columnName.length; i++) { // 从资源文件中获取
			if (userPropertiesBundle.containsKey((String.valueOf(i)))) {
				columnName[i] = userPropertiesBundle.getString(String.valueOf(i));
			}
		}
		
		
		
		for (int sheetIndex = 0; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++) {
			// sheet
			XSSFSheet sheet = (XSSFSheet) workbook.getSheetAt(sheetIndex);
			// row
			for (int rowIndex = 1; rowIndex < sheet.getPhysicalNumberOfRows(); rowIndex++) {
				XSSFRow row = sheet.getRow(rowIndex);
				Map<String, Object> map = new HashMap<String, Object>();
				for (int cellIndex = 0; cellIndex < row.getPhysicalNumberOfCells(); cellIndex++) {
					// cell
					XSSFCell cell = row.getCell(cellIndex);
					
					
					if (columnName[cellIndex] != null && columnName[cellIndex].trim().length() > 0) { // 该列值在对应的java对象中有值
						// 取出当前cell的值和对应Javabean类的属性放入到map中
						map.put(columnName[cellIndex].trim(), getCellValue(cell));
					}
					
					
					
				}
				result.add(map);
			}
		}
		return result;
	}

	/**
	 * 将excel表中的数据放入到List<Map<String, Object>>中
	 * 
	 * @param workbook
	 * @return
	 */
	public static <T> List<Map<String, Object>> parseExcel(Workbook workbook, String user) {
		userPropertiesBundle = ResourceBundle.getBundle(user);
		List<Map<String, Object>> result = new LinkedList<Map<String, Object>>();

		int excleRowLength = workbook.getSheetAt(0).getRow(0).getPhysicalNumberOfCells();
		String[] columnName = new String[excleRowLength]; // 相应的javabean类的属性名称数组
		for (int i = 0; i < columnName.length; i++) { // 从资源文件中获取
			if (userPropertiesBundle.containsKey((String.valueOf(i)))) {
				columnName[i] = userPropertiesBundle.getString(String.valueOf(i));
			}
		}
		for (int sheetIndex = 0; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++) {
			// sheet
			HSSFSheet sheet = (HSSFSheet) workbook.getSheetAt(sheetIndex);
			// row
			for (int rowIndex = 1; rowIndex < sheet.getPhysicalNumberOfRows(); rowIndex++) {
				HSSFRow row = sheet.getRow(rowIndex);
				Map<String, Object> map = new HashMap<String, Object>();
				for (int cellIndex = 0; cellIndex < row.getPhysicalNumberOfCells(); cellIndex++) {
					// cell
					HSSFCell cell = row.getCell(cellIndex);
					if (columnName[cellIndex] != null && columnName[cellIndex].trim().length() > 0) { // 该列值在对应的java对象中有值
						// 取出当前cell的值和对应Javabean类的属性放入到map中
						map.put(columnName[cellIndex].trim(), getCellValue(cell));
					}
				}
				result.add(map);
			}
		}
		return result;
	}

	/**
	 * 利用反射将List<Map<String,Object>> 结构 生成相应的List<T>数据
	 */
	public static <T> List<T> toObjectPerproList(List<Map<String, Object>> list, Class<T> clazz) throws Exception {
		T t = null;
		List<T> returnList = new LinkedList<T>();
		for (int i = 0; i < list.size(); i++) {
			// 利用反射创建Class对应的对象
			t = clazz.newInstance();
			// 遍历Map对象，用反射填充对象的属性
			for (Map.Entry<String, Object> ent : list.get(i).entrySet()) {
				String name = ent.getKey();
				Object value = ent.getValue();
				// 用反射赋值
				setFieldValue(t, name, value);
			}
			returnList.add(t);
		}
		return returnList;
	}

	/**
	 * 获取当前单元格内容
	 */
	@SuppressWarnings("deprecation")
	private static String getCellValue(Cell cell) {
		String value = "";
		if (null == cell) {
			return value;
		}
		switch (cell.getCellType()) {
		// 数值型
		case Cell.CELL_TYPE_NUMERIC:
			if (HSSFDateUtil.isCellDateFormatted(cell)) {
				// 如果是date类型则 ，获取该cell的date值
				Date date = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				value = format.format(date);
				;
			} else {// 纯数字
				BigDecimal big = new BigDecimal(cell.getNumericCellValue());
				value = big.toString();
				// 解决1234.0 去掉后面的.0
				if (null != value && !"".equals(value.trim())) {
					String[] item = value.split("[.]");
					if (1 < item.length && "0".equals(item[1])) {
						value = item[0];
					}
				}
			}
			break;
		// 字符串类型
		case Cell.CELL_TYPE_STRING:
			value = cell.getStringCellValue().toString();
			break;
		// 公式类型
		case Cell.CELL_TYPE_FORMULA:
			// 读公式计算值
			value = String.valueOf(cell.getNumericCellValue());
			if (value.equals("NaN")) {// 如果获取的数据值为非法值,则转换为获取字符串
				value = cell.getStringCellValue().toString();
			}
			break;
		// 布尔类型
		case Cell.CELL_TYPE_BOOLEAN:
			value = " " + cell.getBooleanCellValue();
			break;
		// 空值
		case Cell.CELL_TYPE_BLANK:
			value = "";
			break;
		// 故障
		case Cell.CELL_TYPE_ERROR:
			value = "";
			System.out.println("excel出现故障");
			break;
		default:
			value = cell.getStringCellValue().toString();
		}
		if ("null".endsWith(value.trim())) {
			value = "";
		}
		return value;
	}

	// 利用反射给对象赋值
	public static void setFieldValue(Object object, String fieldName, Object value) {
		Field field = null;
		for (Class<?> superClass = object.getClass(); superClass != Object.class; superClass = superClass
				.getSuperclass()) {
			try {
				field = superClass.getDeclaredField(fieldName);
			} catch (NoSuchFieldException e) {
				System.out.println("异常");
			}
		}
		if (field == null)
			throw new IllegalArgumentException("Could not find field [" + fieldName + "] on target [" + object + "]");

		if (!Modifier.isPublic(field.getModifiers())) {
			field.setAccessible(true);
		}
		try {
			field.set(object, value);
		} catch (IllegalAccessException e) {
			System.out.println("不可能抛出的异常");
		}
	}
}
