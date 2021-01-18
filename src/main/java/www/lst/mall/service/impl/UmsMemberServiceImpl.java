package www.lst.mall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import www.lst.mall.common.api.CommonResult;
import www.lst.mall.service.RedisService;
import www.lst.mall.service.UmsMemberService;

import java.util.Random;

/**
 * 会员管理Service的实现类
 * by：lst
 */
@Service
public class UmsMemberServiceImpl implements UmsMemberService {

    @Autowired
    private RedisService redisService;
    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;
    @Value("${redis.key.expire.authCode}")
    private Long AUTH_CODE_EXPIRE_SECONDS;


    @Override
    public CommonResult generateAuthCode(String telephone) {
        StringBuffer stringBuffer = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            stringBuffer.append(random.nextInt(10));
        }
        //验证码绑定手机号并存储到redis
        redisService.set(REDIS_KEY_PREFIX_AUTH_CODE + telephone, stringBuffer.toString());
        redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE + telephone, AUTH_CODE_EXPIRE_SECONDS);

        return CommonResult.success(stringBuffer.toString(), "获取验证码成功");
    }

    /**
     * 输入验证码进行校验
     * @param telephone
     * @param authCode
     * @return
     */
    @Override
    public CommonResult verifyAuthCode(String telephone, String authCode) {
        if (StringUtils.isEmpty(authCode)) {
            return CommonResult.failed("请输入验证码");
        }
        String s = redisService.get(REDIS_KEY_PREFIX_AUTH_CODE + telephone);
        boolean equals = authCode.equals(redisService);
        if (equals) {
            return CommonResult.success(null, "验证码校验成功");
        }else {
            return CommonResult.failed("验证码不正确");
        }
    }
}
