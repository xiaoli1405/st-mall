package www.lst.mall.service.impl;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import www.lst.mall.common.api.CommonResult;
import www.lst.mall.component.CancelOrderSender;
import www.lst.mall.dto.OrderParam;
import www.lst.mall.service.OmsPortalOrderService;

/**
 * 实现前台订单管理Service
 * by：lst 2021/1/18
 */
@Service
public class OmsPortalOrderServiceImpl implements OmsPortalOrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OmsPortalOrderServiceImpl.class);
    @Autowired
    private CancelOrderSender cancelOrderSender;

    @Override
    public CommonResult generatorOrder(OrderParam orderParam) {
        //todo 执行一系类下单操作，具体参考mall项目
        LOGGER.info("process, generatorOrder");
        //下单完成后开启一个延迟消息，用于当用户没有付款时取消订单（orderId应该在下单后生成）
        sendDelayMessageCancelOrder(11L);
        return CommonResult.success(null,"下单成功");
    }

    private void sendDelayMessageCancelOrder(long l) {
        //获取订单超时时间, 假设为60分钟
        long delayTime = 30 * 1000;
        //发送延迟消息
        cancelOrderSender.sendMessage(l,delayTime);
    }

    @Override
    public void cancelOrder(Long orderId) {
        //todo 执行一系类取消订单操作
        LOGGER.info("process cancelOrder orderId:{}", orderId);
    }
}
