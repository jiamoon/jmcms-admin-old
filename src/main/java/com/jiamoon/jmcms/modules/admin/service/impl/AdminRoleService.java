package com.jiamoon.jmcms.modules.admin.service.impl;

import com.jiamoon.jmcms.common.service.impl.BaseService;
import com.jiamoon.jmcms.modules.admin.dao.AdminRoleMapper;
import com.jiamoon.jmcms.modules.admin.entity.AdminRoleBiz;
import com.jiamoon.jmcms.modules.admin.service.IAdminRoleService;
import org.springframework.stereotype.Service;

@Service
public class AdminRoleService extends BaseService<AdminRoleMapper, AdminRoleBiz> implements IAdminRoleService {
}
