package com.itcorey.service.impl;

import com.itcorey.entity.User;
import com.itcorey.mapper.UserMapper;
import com.itcorey.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 公众号：徐买狼
 * @since 2020-11-10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
