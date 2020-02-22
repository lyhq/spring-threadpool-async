package com.you.async.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/***
 * MessageService 类
 *
 * 模拟发短信和邮件通知
 *
 * @author: You
 * @date: 2020/2/21
 */
@Service
public class MessageService {

    // 发送提醒短信, 假设发短信没有返回信息
    //@Async("poolTaskExecutor") //可以指定使用的线程池，没指定就是默认被激活的线程池
    @Async
    public void sendSmsMessage() throws InterruptedException {
        System.out.println("[" + Thread.currentThread().getName() + "] 发送短信   执行开始");
        Thread.sleep(5000); // 模拟耗时
        System.out.println("[" + Thread.currentThread().getName() + "] 发送短信   执行结束");
    }

    // 发送提醒邮件，假设发邮件有返回信息
    //@Async("poolTaskExecutor") //可以指定使用的线程池，没指定就是默认被激活的线程池
    @Async
    public Future<String> sendEmailMessage() throws InterruptedException {
        System.out.println("[" + Thread.currentThread().getName() + "] 发送邮件   执行开始");
        Thread.sleep(2000); // 模拟耗时
        System.out.println("[" + Thread.currentThread().getName() + "] 发送邮件   执行结束");
        //返回的结果需要通过AsyncResult这个类包装
        return new AsyncResult<>("[success]客户已收到消息");
    }
}
