package util;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TeamUtil {

	static SimpleDateFormat formatter;

	// 5级评分制评分
	public static String grade(int ggg) {

		switch (ggg / 10) {
		case 9:
			return "优秀";
		case 8:
			return "中";
		case 7:
			return "良";
		case 6:
			return "及格";
		default:
			return "不及格";
		}
	}

	// 一段yyyy-MM-dd HH:mm:ss字符串分成年月日三段
	// 2017-11-09 15:08:50
	//
	public static String timeToYear(String time) {
		String year = time.substring(0, 4);
		return year;
	}

	public static String timeToMonth(String time) {
		String month = time.substring(5, 7);
		return month;
	}

	//
	public static String timeToDay(String time) {
		String day = time.substring(8, 10);
		return day;
	}

	public static String getStringSecond() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date secondDate = new Date();
		String date = formatter.format(secondDate);
		try {
			secondDate = formatter.parse(date);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
			return "0000-00-00";
		}

	}

	public static String getDay_Of_Week(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("E");
		String week = sdf.format(date);
		return week;
	}

	public static String getWeek_Of_Month(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("W");
		String week = sdf.format(date);
		return week;
	}

	public static Date getDateSecond() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date secondDate = new Date();
		String date = formatter.format(secondDate);
		try {
			secondDate = formatter.parse(date);
			return secondDate;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}

	}

	public static String getStringDay() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date secondDate = new Date();
		String date = formatter.format(secondDate);
		try {
			secondDate = formatter.parse(date);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}

	}

	public static Date getDateDay() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date secondDate = new Date();
		String date = formatter.format(secondDate);
		try {
			secondDate = formatter.parse(date);
			return secondDate;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}

	}

	public static String getTimeChou() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		Date secondDate = new Date();
		String date = formatter.format(secondDate);
		try {
			secondDate = formatter.parse(date);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
			return "00000000";
		}
	}

	public static String getUuid() {
		UUID uuid = UUID.randomUUID();
		String s = uuid.toString();
		return s;
	}

	// 判断一个字符是否是中文
	public static boolean isChinese(char c) {
		return c >= 0x4E00 && c <= 0x9FA5;// 根据字节码判断
	}

	// 判断一个字符串是否含有中文
	public static boolean isChinese(String str) {
		if (str == null)
			return false;
		for (char c : str.toCharArray()) {
			if (isChinese(c))
				return true;// 有一个中文字符就返回
		}
		return false;
	}

	// 判断一个字符串是否都为数字
	public static boolean isDigit(String strNum) {
		if (strNum == null)
			return false;
		Pattern pattern = Pattern.compile("[0-9]{1,}");
		Matcher matcher = pattern.matcher((CharSequence) strNum);
		return matcher.matches();
	}

	// 获取当前年份
	public static String getCurrentYear() {
		Calendar now = Calendar.getInstance();
		String year = now.get(Calendar.YEAR) + "";
		return year;
	}

	// 两个整数相除求百分数
	public static String getPercent(int a, int b) {
		if (a == 0 && b > 0) {
			return "100%";
		}
		if (a == 0 && b == 0) {
			return "0%";
		}
		double percent = (double) b / (double) a;
		System.out.println("小树:" + percent);
		NumberFormat nt = NumberFormat.getPercentInstance();
		nt.setMinimumFractionDigits(2);
		return "" + nt.format(percent);
	}

}