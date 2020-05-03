package com.summer.springboot;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @program: springboot
 * @author: 大禹
 * @create: 2020-05-02 18:47
 *
 * springboot 缓存
 * 在SpringbootApplication 上增加注解@EnableCaching
 * 在方法上增加 @Cacheable(cacheNames = "c1")
 * 注意cacheNames = "c1" 要和配置文件中配置的cach名字相同
 * 默认方法参数是key 方法返回值为value
 **/
@Service
public class UserService {

    //keyGenerator为实例的名字首字母小写
    @Cacheable(cacheNames = "c1",keyGenerator = "myKeyGenerator")
    public User getUserById(Integer id)
    {
        System.out.println("getUserById>>>"+id);
        User user = new User();
        user.setId(id);
        return user;
    }

    //如果在实际中已经删除了但是缓存中还有的话 要把缓存中的也要删除掉
    //要用@CacheEvict注解
    @CacheEvict(cacheNames = "c1")
    public void deleteUSerById(Integer id){
        System.out.println("deleteUserById>>"+id);
    }
}
