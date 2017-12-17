package util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExportExcelCollection {
	public static XSSFWorkbook exportExcel(String export_num, String[] headers, List<Map<String, String>> list) {
		// 声明一个工作薄
		XSSFWorkbook workbook = new XSSFWorkbook();
		// 生成一个表格
		XSSFSheet sheet = workbook.createSheet();
		// 设置表格默认列宽度为15个字节
		sheet.setDefaultColumnWidth((short) 15);
		// 产生表格标题行
		XSSFRow row = sheet.createRow(0);
		// 表格头部的列数
		int cell_num = 0;
		if (export_num != null) {
			// 将所需要导出的属性索引（字符串）分割成数组
			String[] arr_num = export_num.split(",");
			// 循环
			for (short i = 0; i < headers.length; i++) {
				// 判断是否选中
				if (ArrayUtils.contains(arr_num, i + "")) {
					XSSFCell cell = row.createCell(cell_num);
					XSSFRichTextString text = new XSSFRichTextString(headers[i]);
					cell.setCellValue(text);
					cell_num++;
				}
			}
		} else
			for (short i = 0; i < headers.length; i++) {
				XSSFCell cell = row.createCell(i);
				XSSFRichTextString text = new XSSFRichTextString(headers[i]);
				cell.setCellValue(text);
			}

		int index = 0;
		// 遍历集合数据
		for (Map<String, String> map : list) {
			// 表中行数
			index++;
			// 创建一行
			row = sheet.createRow(index);
			// 列数
			short in = 0;
			for (String str : map.keySet()) {

				// 一行中创建列
				XSSFCell cell = row.createCell(in);
				try {
					// map中获取value值
					Object value = map.get(str);
					// 判断获取的值的类型
					String textValue = null;
					// 数字类型
					if (value instanceof Integer) {
						int intValue = (Integer) value;
						cell.setCellValue(intValue);
					}
					// 日期类型
					else if (value instanceof Date) {
						Date date = (Date) value;
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						textValue = sdf.format(date);
					} else {
						// 其它数据类型都当作字符串简单处理
						textValue = value.toString();
					}
					// 用正则表达式判断textValue是否全部由数字组成
					if (textValue != null) {
						Pattern p = Pattern.compile("^//d+(//.//d+)?$");
						Matcher matcher = p.matcher(textValue);
						if (matcher.matches()) {
							// 是数字当作double处理
							cell.setCellValue(Double.parseDouble(textValue));
						} else {
							XSSFRichTextString richString = new XSSFRichTextString(textValue);
							XSSFFont font3 = workbook.createFont();
							richString.applyFont(font3);
							cell.setCellValue(richString);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				// 列自增
				in++;
			}
		}
		// 输出处理
		return workbook;
	}
}
