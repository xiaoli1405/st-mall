package www.lst.mall.service;

import org.springframework.transaction.annotation.Transactional;
import www.lst.mall.common.api.CommonResult;
import www.lst.mall.dto.OrderParam;

/**
 * 前台订单service
 * by：lst 2021/1/18
 */
public interface OmsPortalOrderService {

    /**
     * 根据提交信息生成订单
     * @param orderParam
     * @return
     */
    @Transactional
    CommonResult generatorOrder(OrderParam orderParam);

    /**
     * 取消单个超时订单
     * @param orderId
     */
    @Transactional
    void cancelOrder(Long orderId);
}
