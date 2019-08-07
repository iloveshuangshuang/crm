这是一个spring boot+redis 集成demo  

访问地址：  

http://localhost:8888/crm/customer/list 原主页面  

http://localhost:8888/crm/customer/redis  redis 测试页面  


进入集成redis测试页面，点击按钮发送Ajax请求，进入controller控制层，再进入service业务层。  

1、先通过 redisTemplate.hasKey(id) 判断redis是否有对应的键，  

如果有，从redis中查询，若没有，则从mysql中查询，查询出来的结果再存入redis中。  


思考：  

1、redis与mysql的数据同步。  

2、此查询是有主键作为条件，若无主键作为条件，如何存取。  


