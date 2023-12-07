package utils.demo;

import org.apache.commons.codec.digest.DigestUtils;

public class DigestUtilsDemo {

    public static void main(String[] args) {


        String str = "jackie123";

        String MD5 = DigestUtils.md5Hex(str);

        System.out.println(MD5);

    }
}
