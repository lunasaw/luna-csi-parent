package com.luna.csi;

import com.luna.common.encrypt.Md5Utils;

/**
 * @author luna@mac
 * 2021年04月29日 10:16
 */
public class LoginTest {

    public static void main(String[] args) {
        System.out.println(Md5Utils.md5(Md5Utils.md5("admin123")));
    }
}
