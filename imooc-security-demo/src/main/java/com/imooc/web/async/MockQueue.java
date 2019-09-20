package com.imooc.web.async;

import org.springframework.stereotype.Component;

/**
 * 模拟消息队列
 * LN
 * 2019/9/4 0004 13:56
 */
@Component
public class MockQueue {
    private String placeOrder;
    private String completeOrder;

    String getPlaceOrder() {
        return placeOrder;
    }

    void setPlaceOrder(String placeOrder) throws InterruptedException {
        new Thread(() -> {
            System.out.println("接到下单请求:" + placeOrder);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.placeOrder = placeOrder;
            System.out.println("下单请求处理完毕：" + placeOrder);
        }).start();
    }

    public String getCompleteOrder() {
        return completeOrder;
    }

    public void setCompleteOrder(String completeOrder) {
        this.completeOrder = completeOrder;
    }
}
