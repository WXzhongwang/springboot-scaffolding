package com.redis.demo.controller;

import com.redis.demo.util.RedisLockUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author dick <18668485565@163.com>
 * @version V1.0.0
 * @description
 * @date created on 2020/8/11
 */
@RestController
public class LuaController {

    private static final Logger logger = LoggerFactory.getLogger(LuaController.class);

    @Resource
    private DefaultRedisScript<Boolean> redisScript;
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/lua")
    public ResponseEntity lua(){
        List<String> keys = Arrays.asList("distributed_lock", "hello lua");
        Boolean execute = stringRedisTemplate.execute(redisScript, keys, "1000000");
        assert execute != null;
        return ResponseEntity.ok(execute);
    }






    /**
     * stock
     */
    private long stock = 0;

    //商品key名字


    private String goodKey = "computer_key";

    private int timeOut = 5 * 1000;

    @GetMapping("/grab-order")
    public List<String> grabOrder() {

        //抢到商品的用户
        List<String> shopUsers = new ArrayList<>();

        //构造很多用户
        List<String> users = new ArrayList<>();
        IntStream.range(0, 100000).parallel().forEach(b -> {
            users.add("神牛-" + b);
        });

        //初始化库存
        stock = 10;

        //模拟开抢
        users.parallelStream().forEach(b -> {
            String shopUser = mock(b);
            if (!StringUtils.isEmpty(shopUser)) {
                shopUsers.add(shopUser);
            }
        });

        return shopUsers;
    }


    /**
     * 模拟抢单动作
     *
     * @param b
     * @return
     */
    private String mock(String b) {

        //用户开抢时间
        long startTime = System.currentTimeMillis();

        //未抢到的情况下，5秒内继续获取锁
        while ((startTime + timeOut) >= System.currentTimeMillis()) {
            //商品是否剩余
            if (stock <= 0) {
                break;
            }
            if (RedisLockUtil.tryGetDistributedLock(stringRedisTemplate, goodKey, b, 3000)) {
                //用户b拿到锁
                logger.info("用户{}拿到锁...", b);
                System.out.println("用户" + b + "拿到锁...");
                try {
                    //商品是否剩余
                    if (stock <= 0) {
                        break;
                    }
                    //模拟生成订单耗时操作，方便查看：神牛-50 多次获取锁记录
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    //抢购成功，商品递减，记录用户
                    stock -= 1;

                    //抢单成功跳出
                    logger.info("用户{}抢单成功跳出...所剩库存：{}", b, stock);
                    System.out.println("用户" + b + "抢单成功跳出...所剩库存：" + stock);

                    return b + "抢单成功，所剩库存：" + stock;
                } finally {
                    logger.info("用户{}释放锁...", b);
                    System.out.println("用户" + b + "释放锁...");
                    //释放锁
                    RedisLockUtil.releaseDistributedLock(stringRedisTemplate, goodKey, b);
                }
            }
        }
        return "";
    }
}
