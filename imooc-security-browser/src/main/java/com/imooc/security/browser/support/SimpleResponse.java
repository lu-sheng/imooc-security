package com.imooc.security.browser.support;

/**自定义的一个服务返回对象
 * LN
 * 2019/9/19 0019 15:07
 */
public class SimpleResponse {
    private Object content;

    public SimpleResponse(Object content) {
        this.content = content;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
