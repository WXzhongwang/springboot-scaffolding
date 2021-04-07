
---
--- Created by Dick.
--- 释放分布式锁
--- DateTime: 2020/8/11 10:43

if redis.call("get", KEYS[1]) == ARGV[1]
then
    return redis.call("del", KEYS[1])
else
    return 0
end