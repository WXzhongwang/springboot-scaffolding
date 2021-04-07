---
--- Created by Dick.
--- 创建分布式锁
--- DateTime: 2020/8/11 10:43

local key     = KEYS[1]
local value   = KEYS[2]
local ttl     = ARGV[1]

local lockSet = redis.call('setnx', key, value)

if lockSet == 1 then
  redis.call('pexpire', key, ttl)
end

return lockSet