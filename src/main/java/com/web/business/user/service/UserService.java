package com.web.business.user.service;

import com.web.base.BaseService;
import com.web.business.user.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author keven-song.
 * Created on 2017/1/2.
 * @Description
 */
@Service
public class UserService extends BaseService<User> {

    /**
     * 入库数据
     * @param user
     */
    public void insertUser(User user){
        insert("insertUser", user);
    }

    /**
     * 根据用户名更新数据
     * @param user
     */
    public void updateByUserName(User user){
        update("updateByUserName" ,user);
    }

    /**
     * 查询用户集合
     * @param user
     * @return
     */
    public List<User> queryUserList(User user){
        return (List<User>) selectList("queryUserList", user);
    }

    /**
     * 根据用户名查询
     * @param userName
     * @return
     */
    public User queryUserByUserName(String userName){
        return selectOne("queryUserByUserName", userName);
    }

}
