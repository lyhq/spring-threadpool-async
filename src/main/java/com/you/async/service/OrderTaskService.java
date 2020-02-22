package com.you.async.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/***
 * OrderTaskService 业务类
 *
 * 调用发信息的方法, 该方法不能与被调用的异步方法在同一个类中，否则无效;
 * @author: You
 * @date: 2020/2/21
 */
@Service
public class OrderTaskService {

    @Autowired
    private MessageService messageService;

    // 订单处理任务
    public void cancelOrderTask() throws InterruptedException, ExecutionException {
        this.cancelOrder(); // 取消订单
        messageService.sendSmsMessage(); // 发短信
        Future<String> future = messageService.sendEmailMessage();// 发邮件
        //future.get()方法是会阻塞的
        System.out.println("["+Thread.currentThread().getName() + "]" + future.get());
        System.out.println("["+Thread.currentThread().getName() + "] 完成取消订单并邮件通知的任务！");

    }

    // 取消订单
    public void cancelOrder() throws InterruptedException {
        System.out.println("[" + Thread.currentThread().getName() + "] 取消订单------开始");
        System.out.println("[" + Thread.currentThread().getName() + "] 取消订单------结束 ");
    }
}
