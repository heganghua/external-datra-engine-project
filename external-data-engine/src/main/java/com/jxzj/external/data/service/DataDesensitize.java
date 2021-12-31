package com.jxzj.external.data.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 数据脱敏
 * 
 * @author hgh
 * @date 2021/12/20
 */
public class DataDesensitize {

    public static void main(String[] args) {
        String idCard = "430903199604165439";
        String iphone = "15680956315";
        String name = "周杰二零";
        String relaceStr = DataDesensitize.relaceStr(iphone);
        System.out.println(relaceStr);
        // System.out.println(IDCardVerify.identityCardVerification(idCard));
    }

    private static Pattern CHINESE_PHONE_PATTERN = Pattern.compile("((13|15|17|18)\\d{9})|(14[57]\\d{8})");
    private static String IDCARD_PATTERN = "(?<=\\w{6})\\w(?=\\w{3})";
    private static String PHONE_PATTERN = "(?<=\\w{3})\\w(?=\\w{4})";

    /**
     * 身份信息脱敏<br>
     * 手机号码显示前三位和后四位<br>
     * 身份证号码显示六位和后四位<br>
     * 
     * @param param
     * @return
     */
    public static String relaceStr(String param) {
        if (null == param && "".equals(param)) {
            return param;
        }
        String desensitizeData = param;
        if (isValidChinesePhone(param)) {
            // 手机号码
            desensitizeData = param.replaceAll(PHONE_PATTERN, "*");
        } else if (param.equals(IDCardVerify.simpleIdentityCardVerification(param))) {
            // 身份证
            desensitizeData = param.replaceAll(IDCARD_PATTERN, "*");
        } else if (isContainChinese(param)) {
            // 姓名
        }
        return desensitizeData;
    }

    /**
     * 验证手机号码
     * 
     * @param phone
     * @return
     */
    public static boolean isValidChinesePhone(String phone) {
        if (phone == null || phone.length() != 11) {
            return false;
        }
        Matcher matcher = CHINESE_PHONE_PATTERN.matcher(phone);
        return matcher.matches();
    }

    /**
     * 判断是否包含中文
     * 
     * @param param
     * @return
     */
    private static boolean isContainChinese(String param) {
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(param);
        if (m.find()) {
            return true;
        }
        return false;
    }

}
