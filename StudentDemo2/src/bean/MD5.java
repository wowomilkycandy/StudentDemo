package bean;
import java.security.MessageDigest;
public class MD5 {
    public MD5() {}
    private static String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
    /**
     * 转换字节数组为16进制字串
     *
     * @param byteArray
     * 字节数组
     * @return 16进制字串
     */
    private static String byteArrayToHexString (byte[] byteArray) { //  字符数组转换为字符串，参数命名最好不要用单个字符
        if(byteArray==null) {//对空进行处理
            return null;
        }
        StringBuffer resultSb = new StringBuffer ();
        for (int i = 0; i < byteArray.length; i++) {
            resultSb.append ( byteToHexString ( byteArray[i] ));
        }
        return resultSb.toString();
    }

    private static String byteToHexString (byte b1) {  //byte转化为string

        int n = b1;
        if ( n < 0 ) n += 256;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    public static String MD5Encode (String origin) { //进行MD5加密
        if(origin==null){
            return null;
        }
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return resultString;
    }
}

//测试

class Test {


    public static void main (String[] args) {

        MD5 md5 = new MD5();
        String test = md5.MD5Encode("123123123");
        System.out.println(test);

    }
}
