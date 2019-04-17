package com.example.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Lewin Huang<huanglewin@gmail.com>
 *     获取配置文件里面的属性值
 */

@Component
public class WebSiteProperties {

    @Value("${website.name}")
    private String name;

    @Override
    public String toString() {
        return "WebSiteProperties{" +
                "name='" + name + '\'' +
                ", createtime='" + createtime + '\'' +
                '}';
    }

    @Value("${website.createtime}")
    private String createtime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }
}
