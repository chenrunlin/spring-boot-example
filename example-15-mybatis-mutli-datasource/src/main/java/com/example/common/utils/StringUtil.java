package com.example.common.utils;

import java.util.Random;

public class StringUtil {
	public static boolean isEmpty(Object s) {
		if (null == s) {
			return true;
		} else if ("".equals(s.toString()) || "".equals(s.toString().trim())
				|| "null".equalsIgnoreCase(s.toString())) {
			return true;
		} else {
			return false;
		}
	}

	public static String toHtml(String src) {
		String htmlStr = "";
		for (int i = 0; i != src.length(); i++) {
			int str = src.codePointAt(i);
			htmlStr = htmlStr + "&#" + str + ";";
		}
		return htmlStr;
	}

	public static Long createSqp(String dev_code) {
		String str = "";
		for (int i = dev_code.length() - 1; i >= 0; i--) {
			if (dev_code.charAt(i) >= '0' && dev_code.charAt(i) <= '9') {
				str += dev_code.charAt(i);
			} else {
				break;
			}
		}
		System.out.println(str);
		String str1 = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			str1 += str.charAt(i);
		}
		return Long.valueOf(str1);
	}

	public static String prefixZero(String s, int num) {
		String oriStr = "";
		for (int i = 0; i < num; i++) {
			oriStr += "0";
		}
		int len = s.length();
		int n = oriStr.length() - len;
		return oriStr.substring(0, n) + s;
	}

	public static String prefixString(String s, String r, int num) {
		String oriStr = "";
		for (int i = 0; i < num; i++) {
			oriStr += r;
		}
		int len = s.length();
		int n = oriStr.length() - len;
		return oriStr.substring(0, n) + s;
	}

	public static String suffixString(String s, String r, int num) {
		String oriStr = "";
		for (int i = 0; i < num; i++) {
			oriStr += r;
		}
		int len = s.length();
		int n = num - (oriStr.length() - len);
		return s + oriStr.substring(n);
	}

	public static String gen8Key() {
		String s = "0123456789";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 8; i++) {
			int j = (int) (Math.random() * 10);
			sb.append(s.charAt(j));
		}
		return sb.toString();
	}

	public static int randomNum(int i) {
		Random rand = new Random();
		return rand.nextInt(i);
	}

	/** 金额为分的格式 */
	public static final String CURRENCY_FEN_REGEX = "\\-?[0-9]+";

	/**
	 * 将分为单位的转换为元并返回金额格式的字符串 （除100）
	 * 
	 * @param amount
	 * @author runlin.chen
	 * @date 2016年7月25日上午10:49:23
	 */
	public static String changeF2Y(int amount) throws Exception {
		if (!(amount + "").matches(CURRENCY_FEN_REGEX)) {
			throw new Exception("金额格式有误");
		}

		int flag = 0;
		String amString = amount + "";
		if (amString.charAt(0) == '-') {
			flag = 1;
			amString = amString.substring(1);
		}
		StringBuffer result = new StringBuffer();
		if (amString.length() == 1) {
			result.append("0.0").append(amString);
		} else if (amString.length() == 2) {
			result.append("0.").append(amString);
		} else {
			String intString = amString.substring(0, amString.length() - 2);
			for (int i = 1; i <= intString.length(); i++) {
				if ((i - 1) % 3 == 0 && i != 1) {
					result.append(",");
				}
				result.append(intString.substring(intString.length() - i, intString.length() - i + 1));
			}
			result.reverse().append(".").append(amString.substring(amString.length() - 2));
		}
		if (flag == 1) {
			return "-" + result.toString();
		} else {
			return result.toString();
		}
	}

	public static void main(String[] args) {
		// System.out.println(randomNum(1));
		for (int i = 0; i < 1000; i++) {
			System.out.println(randomNum(7));
		}

	}
}
