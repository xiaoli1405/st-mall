package www.lst.mall.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 订单超时取消并解锁库存定时器
 * by：lst 21/1/12
 */
@Component
public class OrderTimeOutCancelTask {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderTimeOutCancelTask.class);

    /**
     * cron表达式：Seconds Minutes Hours DayofMonth Month DayoWeek
     * 每10分钟扫描一次，扫描设定超时时间之前下的订单，如果每支付则取消该订单
     */
    @Scheduled(cron = "0 0/10 * ? * ?")
    private void cancelTimeOutOrder() {
        //2021/
        LOGGER.info("取消订单，并根据sku编号释放锁定库存");
    }
}
