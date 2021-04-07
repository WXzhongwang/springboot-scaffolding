package com.redis.demo.util;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;

import java.util.Collections;

/**
 * @author dick <18668485565@163.com>
 * @version V1.0.0
 * @description
 * @date created on 2020/8/12
 */
public class RedisLockUtil {


    /**
     * redis分布式锁.<br>
     * 思路：
     * <pre>
     * 用SETNX命令，SETNX只有在key不存在时才返回成功。这意味着只有一个线程可以成功运行SETNX命令，而其他线程会失败，然后不断重试，直到它们能建立锁。
     * 然后使用脚本来创建锁，因为一个redis脚本同一时刻只能运行一次。
     * 创建锁代码：
     * <code>
     -- KEYS[1] key,
     -- ARGV[1] value,
     -- ARGV[2] expireTimeMilliseconds

     if redis.call('setnx', KEYS[1], ARGV[1]) == 1 then
     redis.call('pexpire', KEYS[1], ARGV[2])
     return 1
     else
     return 0
     end
     * </code>
     * 最后使用脚本来解锁。
     * 解锁代码：
     *
     * <code>
     -- KEYS[1] key,
     -- ARGV[1] value
     if redis.call("get", KEYS[1]) == ARGV[1]
     then
     return redis.call("del", KEYS[1])
     else
     return 0
     end
     * </code>
     * </pre>
     *
     * @author tanghc
     */

    public static final Long SUCCESS = 1L;

    public static final String SCRIPT_LOCK = "if redis.call('setnx', KEYS[1], ARGV[1]) == 1 then redis.call('pexpire', KEYS[1], ARGV[2]) return 1 else return 0 end";

    public static final String SCRIPT_UNLOCK = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";

    private static final String SCRIPT_LOCK_SHA1 = Sha1Util.encrypt(SCRIPT_LOCK);

    private static final String SCRIPT_UNLOCK_SHA1 = Sha1Util.encrypt(SCRIPT_UNLOCK);

    public static boolean tryGetDistributedLock(@SuppressWarnings("rawtypes") final RedisTemplate redisTemplate,
        final String lockKey, final String requestId, final int expireTimeMilliseconds) {

        Object result = redisTemplate.execute(new RedisScript<Long>() {
              @Override
              public String getSha1() {
                  return SCRIPT_LOCK_SHA1;
              }

              @Override
              public Class<Long> getResultType() {
                  return Long.class;
              }

              @Override
              public String getScriptAsString() {
                  return SCRIPT_LOCK;
              }

          }, Collections.singletonList(lockKey), requestId, String.valueOf(expireTimeMilliseconds)
        );

        return SUCCESS.equals(result);
    }


    public static boolean releaseDistributedLock(@SuppressWarnings("rawtypes") RedisTemplate redisTemplate,
        String lockKey, String requestId) {

        Object result = redisTemplate.execute(new RedisScript<Long>() {
            @Override
            public String getSha1() {
                return SCRIPT_UNLOCK_SHA1;
            }

            @Override
            public Class<Long> getResultType() {
                return Long.class;
            }

            @Override
            public String getScriptAsString() {
                return SCRIPT_UNLOCK;
            }

        }, Collections.singletonList(lockKey), requestId);

        return SUCCESS.equals(result);
    }
}
