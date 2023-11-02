package com.wyq.quanOj;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 主类（项目启动入口）
 *
 * @author
 * @from
 */
// todo 如需开启 Redis，须移除 exclude 中的内容
@SpringBootApplication(exclude = {RedisAutoConfiguration.class})
@MapperScan("com.wyq.quanOj.mapper")
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
public class MainApplication {
    private static final Logger LOG = LoggerFactory.getLogger(MainApplication.class);

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(MainApplication.class);
        Environment env = app.run(args).getEnvironment();
        LOG.info("在线文档地址: \thttp://127.0.0.1:{}{}/doc.html", env.getProperty("server.port"), env.getProperty("server.servlet.context-path"));
    }
    /*
     todo 待增加功能 1.ai判题接入glmSDK
      2. judge0的api
      3.ai判题的收费功能
      4.接入微信登录
      5.在线讨论
      6.增加题目的通过数、提交数统计，计算通过率 redis实现 对数据的准确性要求没那么高感觉可以每天更新
      7.限制单个用户的提交频率，可以通过 Redisson 或者 Sentinel 网关层限流实现。
      8.网关
      9.给判题过程中的每个测试用例增加一个独立的内存、时间占用的统计
     */

}
