package com.imooc.web.async;

/**
 * LN
 * 2019/9/4 0004 13:56
 */
public class MockQueue {
    private String placeOrder;
    private String completeOrder;

    public String getPlaceOrder() {
        return placeOrder;
    }

    public void setPlaceOrder(String placeOrder) throws InterruptedException {
        System.out.println("接到下单请求:" + placeOrder);
        Thread.sleep(1000);
        this.placeOrder = placeOrder;
        System.out.println("下单请求处理完毕：" + placeOrder);
    }

    public String getCompleteOrder() {
        return completeOrder;
    }

    public void setCompleteOrder(String completeOrder) {
        this.completeOrder = completeOrder;
    }
}
