package www.lst.mall.service;

import www.lst.mall.common.api.CommonResult;

/**
 * 会员管理的service
 * by:lst
 */

public interface UmsMemberService {

    /**
     * 生成验证码
     */
    CommonResult generateAuthCode(String telephone);

    /**
     * 判断验证码和手机号是否正确
     *
     */
    CommonResult verifyAuthCode(String telephone, String authCode);

}
