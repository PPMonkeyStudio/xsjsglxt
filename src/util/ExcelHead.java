package util;

public class ExcelHead {
	private final static String[] xsjsglxt_contrast_fingerprint = { "对比指纹ID", "对比时间", "对比方式", "现场指纹编号", "按印指纹编号", "案件类型", "案件属地", "案件级别",
			"简要案情", "嫌疑人姓名", "性别", "出生日期", "户籍地", "身份证号", "现住址", "是否抓获","按印部门","提取部门"," 按印人","按印时间"," 提取人"," 指位"," 对比单位"," 对比人"," 复核人",
			" 抓获单位"," 抓获时间"," 联系电话"," 备注","创建时间","修改时间" };

	private final static String[] xsjsglxt_dna = { "DNAID", "DNA编号", "姓名", "性别", "出生日期", "身份证号", "住址", "违法事实", "建档单位",
			"建档人", "建档时间", "交档时间", "备注", "创建时间", "修改时间" };

	private final static String[] xsjsglxt_equipment = { "器材装备ID", "序号", "装备名称", "装备类型", "装备特征", "数量", "金额", "启用日期",
			"使用情况", "备注", "创建时间", "修改时间" };

	private final static String[] xsjsglxt_fingerprint = { "指纹ID", "指纹卡编号", "姓名", "性别", "出生日期=", "身份证号", "住址", "违法事实",
			"建档单位", "建档人", "建档时间", "交档时间","备注","创建时间","修改时间" };

	

	public static String[] getExcelHeadArray(String str) {
		String[] st = null;
		if ("xsjsglxt_contrast_fingerprint".equals(str)) {
			st = xsjsglxt_contrast_fingerprint;
		} else if ("xsjsglxt_dna".equals(str)) {
			st = xsjsglxt_dna;
		} else if ("xsjsglxt_equipment".equals(str)) {
			st = xsjsglxt_equipment;
		} else if ("xsjsglxt_fingerprint".equals(str)) {
			st = xsjsglxt_fingerprint;
		} 
		return st;
	}
}
