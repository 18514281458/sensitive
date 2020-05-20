package com.lk.sensitive.demo.mapper;

import com.lk.sensitive.demo.model.UserModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    int insert(UserModel userModel);

    int insert2(@Param("userName") String userName, @Param("idcard") String idcard);
    List<UserModel> findAll();
    List<UserModel> findAll2();
    UserModel findOne(@Param("id") int id);
    /**
     * 测试 通过加密字段查询的情况
     * @param userModel ;
     * @return ;
     */
    List<UserModel> findByCondition(UserModel userModel);

    /**
     * 测试更新时带条件字段，update的字段里有需要加密的字段，where条件里也有需要加密的
     * @param userModel userDto
     * @return return
     */
    int updateByCondition(UserModel userModel);
}
