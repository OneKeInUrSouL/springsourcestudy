package com.example.springsourcestudy.pojo;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserDao userDao;

    //显示注入
//    @Autowired
//    void setUserService(UserDao userDao){
//        this.userDao = userDao;
//    }


//    /**
//     * 隐式注入
//     *
//     * @param userDao 用户
//     */
//    public UserService(UserDao userDao) {
//        this.userDao = userDao;
//    }

    /**
     * 用户服务
     *
     * @param userDao 用户刀
     */
    public UserService(ObjectProvider<UserDao> userDao) {//当使用objectProvider时，如果UserDao不是Bean时，则不会报错，而是返回null，当UserDao是Bean时，则返回Bean
        this.userDao = userDao.getIfUnique();
    }


//    public UserService() {
//    }

    @Override
    public String toString() {
        return "UserService{" +
                "userDao=" + userDao +
                '}';
    }
}
