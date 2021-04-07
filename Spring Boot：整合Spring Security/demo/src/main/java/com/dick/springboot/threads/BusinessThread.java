package com.dick.springboot.threads;

/**
 * @author dick <18668485565@163.com>
 * @version V1.0.0
 * @description 下单线程
 * @date created on 2019/11/25
 */
public class BusinessThread implements Runnable{

    private String acceptStr;

    public BusinessThread(String acceptStr) {
        this.acceptStr = acceptStr;
    }

    public String getAcceptStr() {
        return acceptStr;
    }

    public void setAcceptStr(String acceptStr) {
        this.acceptStr = acceptStr;
    }


    @Override
    public void run() {
        //业务操作
        System.out.println("多线程已经处理订单插入系统，订单号："+ acceptStr);
        //线程阻塞
        /*
        try {
            Thread.sleep(1000);
            System.out.println("多线程已经处理订单插入系统，订单号：" + acceptStr);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        */
    }
}
