package net.sendukbesi.springbootrest.util;

import java.util.List;

public class BaseUtil {
	
	public static boolean isObjNull(Object obj) {
        if (obj != null && getStr(obj).length() > 0) {
            return false;
        } else {
            return true;
        }
    }
	
	public static boolean isEquals(String oriSrc, String compareSrc) {
        if (oriSrc != null && getStr(oriSrc).equals(getStr(compareSrc))) {
            return true;
        } else {
            return false;
        }
    }
	
	public static String getStr(Object obj) {
        if (obj != null) {
            return obj.toString().trim();
        } else {
            return "";
        }
    }
	
	public static Integer getListSize(List o) {
        if (o != null && o.size() > 0) {
            return o.size();
        } else {
            return 0;
        }
    }
	
	

}
