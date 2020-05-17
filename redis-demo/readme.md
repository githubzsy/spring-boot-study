## Redis和Cache的演示
1. 修改了Redis的json序列化使用的类，让redis中可以查看到有语义的信息(json字符串)
2. 运行RedisConfigTest和RedisRepositoryTest，可以看到两种对于Redis的访问
3. PersonController中是@CacheXXX相关注解的运用
   - @Cacheable 通常应用到读取数据的方法上，如查找方法：先从缓存中读取，如果没有再调用方法获取数据，然后把数据查询结果添加到缓存中。如果缓存中查找到数据，被注解的方法将不会执行
   - @CachePut通常应用于保存和修改方法配置，能够根据方法的请求参数对其结果进行缓存，和 @Cacheable 不同的是，它每次都会触发被注解方法的调用
   - @CachEvict 通常应用于删除方法配置，能够根据一定的条件对缓存进行清空。可以清除一条或多条缓存