package com.kirarabbit.utils;

/**
 * @author: kira
 * @Date: 2019/11/18 15:42
 * Describe: 字符常量
 */
public class StringUtil {

    public static final String BLANK = "";

    public static final int USERNAME_MAX_LENGTH = 35;

    /**
     * 文章点赞标志
     */
    public static final String ARTICLE_THUMBS_UP = "articleThumbsUp";



    /**
     * 截取指定字段
     */

        public  String subString(String str, String strStart, String strEnd) {

            /* 找出指定的2个字符在 该字符串里面的 位置 */
            int strStartIndex = str.indexOf(strStart);
            int strEndIndex = str.indexOf(strEnd)+1;

            /* index为负数 即表示该字符串中没有该字符 */
            if (strStartIndex < 0) {
                return "字符串 :" + str + "中不存在 " + strStart + ", 无法截取目标字符串";
            }
            if (strEndIndex < 0) {
                return "字符串 :" + str + "中不存在 " + strEnd + ", 无法截取目标字符串";
            }
            /* 开始截取 */
            String result = str.substring(strStartIndex, strEndIndex);
            return result;
        }

}
