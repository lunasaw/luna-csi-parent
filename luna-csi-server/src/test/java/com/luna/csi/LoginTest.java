package com.luna.csi;

import com.google.common.collect.ImmutableMap;
import com.luna.common.encrypt.Md5Utils;
import com.luna.csi.entity.User;
import com.luna.redis.util.RedisHashUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author luna@mac
 * 2021年04月29日 10:16
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class LoginTest {

    public static void main(String[] args) {
        System.out.println(Md5Utils.md5(Md5Utils.md5("admin123")));
    }

    @Autowired
    private RedisHashUtil redisHashUtil;

    @Test
    public void atest() {
        User user = new User();
        redisHashUtil.set("luna:session:", ImmutableMap.of("sessionKey", user));
    }
}
