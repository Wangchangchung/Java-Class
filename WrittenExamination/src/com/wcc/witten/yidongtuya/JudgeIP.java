package com.wcc.witten.yidongtuya;

import java.util.regex.Pattern;

/**
 * Created by charse on 17-9-7.
 *写一个算法，判断某个字符串是不是一个合法非的 ip地址．
 *
 * 198.168.1.1
 *
 */
public class JudgeIP {

    public static boolean regularJudgeIp(String ip){

        //正则表达式判断是否是一个合法的ip
        String regIpv4 = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
                +"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                +"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                +"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";

        String regIpv6Std ="\"^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$\"";

        String regIpv6Com = "\"^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$\"";

        boolean resIpv4 = Pattern.compile(regIpv4).matcher(ip).find();
        if (resIpv4){
            return resIpv4;
        }
        boolean resIpv6 = Pattern.compile(regIpv6Std).matcher(ip).find();
        if (resIpv6){
            return resIpv6;
        }
        boolean resIpv6Com = Pattern.compile(regIpv6Com).matcher(ip).find();
        if (resIpv6Com){
            return resIpv6Com;
        }
        return false;
    }

    public static  void main(String[] args){
        System.out.println(regularJudgeIp("289.105.1.0"));
    }
}
