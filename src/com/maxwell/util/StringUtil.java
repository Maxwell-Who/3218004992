package com.maxwell.util;

public class StringUtil {
	
	/**
	 * �пղ���
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if(str==null || "".equals(str.trim())) {
			return true;
		}else {return false;}	
	}
	
	public static boolean isNotEmpty(String str) {
		if (str!=null && !"".equals(str.trim())) {
			return true;
		}else {return false;}
	}
	
}
