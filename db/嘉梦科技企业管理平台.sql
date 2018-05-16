#用户基础数据表
drop table if exists `sys_user`;
create table if not exists `sys_user`(
	id varchar(32) primary key comment '主键id',
  user_code int COMMENT '用户编码',
  username VARCHAR(50) COMMENT '用户名',
  password VARCHAR(32) COMMENT '用户密码',
  avatar VARCHAR(200) COMMENT '头像',
  sign VARCHAR(200) COMMENT '个性签名',
  reg_time DATETIME COMMENT '注册时间',
  reg_ip VARCHAR(15) COMMENT '注册IP',
  last_login_time DATETIME COMMENT '最后登录时间',
  last_login_ip VARCHAR(15) COMMENT '最后登录IP',
  status INT COMMENT '状态',
	create_time datetime comment '创建时间',
	update_time datetime comment '更新时间',
	remarks text comment '备注',
	del_flag int default 0 comment '删除标志'
)engine=INNODB;
alter table `sys_user` comment='用户基础数据表';
#用户登录信息表
drop table if exists `sys_user_auth`;
create table if not exists `sys_user_auth`(
  id varchar(32) primary key comment '主键id',
  user_id varchar(32) COMMENT '用户id',
  login_type VARCHAR(10) COMMENT '登录类型',
  open_id VARCHAR(30) COMMENT '登录账号',
  access_token VARCHAR(100) COMMENT '登录凭证',
  status INT COMMENT '状态',
  create_time datetime comment '创建时间',
  update_time datetime comment '更新时间',
  remarks text comment '备注',
  del_flag int default 0 comment '删除标志'
)engine=INNODB;
alter table `sys_user_auth` comment='用户登录信息表';
#账号表
drop table if exists `sys_admin`;
create table if not exists `sys_admin`(
  id varchar(32) primary key comment '主键id',
  user_id varchar(32) COMMENT '用户id',
  status INT COMMENT '状态',
  create_time datetime comment '创建时间',
  update_time datetime comment '更新时间',
  remarks text comment '备注',
  del_flag int default 0 comment '删除标志'
)engine=INNODB;
alter table `sys_admin` comment='账号表';