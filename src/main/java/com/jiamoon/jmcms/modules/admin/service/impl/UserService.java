package com.jiamoon.jmcms.modules.admin.service.impl;

import com.jiamoon.jmcms.common.service.impl.BaseService;
import com.jiamoon.jmcms.modules.admin.dao.UserMapper;
import com.jiamoon.jmcms.modules.admin.entity.User;
import com.jiamoon.jmcms.modules.admin.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<UserMapper,User> implements IUserService{
}
