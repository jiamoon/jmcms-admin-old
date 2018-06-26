package com.jiamoon.jmcms.modules.admin.service.impl;

import com.jiamoon.jmcms.common.service.impl.BaseService;
import com.jiamoon.jmcms.modules.admin.dao.AdminMapper;
import com.jiamoon.jmcms.modules.admin.entity.AdminBiz;
import com.jiamoon.jmcms.modules.admin.service.IAdminService;
import org.springframework.stereotype.Service;

@Service
public class AdminService extends BaseService<AdminMapper,AdminBiz> implements IAdminService {
}
