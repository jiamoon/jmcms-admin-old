#字典类型表
drop table if exists `sys_dict_type`;
create table if not exists `sys_dict_type`(
	id varchar(32) primary key comment '主键id',
	type_name varchar(30) comment '类型名称',
	type_code varchar(30) comment '类型代码',
	sort int comment '排序',
	status int comment '状态',
	create_time datetime comment '创建时间',
	update_time datetime comment '更新时间',
	remarks text comment '备注',
	del_flag int default 0 comment '删除标志'
)engine=INNODB;
alter table `sys_dict_type` comment='字典类型表';
#字典表
drop table if exists `sys_dict`;
create table if not exists `sys_dict`(
	id varchar(32) primary key comment '主键id',
	dict_name varchar(30) comment '字典名称',
	dict_code varchar(30) comment '字典代码',
	status int comment '状态',
	create_time datetime comment '创建时间',
	update_time datetime comment '更新时间',
	remarks text comment '备注',
	del_flag int default 0 comment '删除标志'
)engine=INNODB;
alter table `sys_dict` comment='字典表';
#账号表
drop table if exists `sys_user`;
create table if not exists `sys_user`(
	id varchar(32) primary key comment '主键id',
	user_no varchar(50) comment '用户编号',
	nickname varchar(50) comment '昵称',
	real_name varchar(50) comment '真实姓名',
	profile_photo varchar(300) comment '头像',
	idcard_type varchar(10) comment '证件类型',
	idcard varchar(18) comment '证件号码',
	sign varchar(300) comment '个性签名',
	phone varchar(20) comment '联系电话',
	mobile varchar(11) comment '手机号码',
	reg_ip varchar(15) comment '注册ip',
	reg_time datetime comment '注册时间',
	birthday datetime comment '出生日期',
	status int comment '账号状态',
	create_time datetime comment '创建时间',
	update_time datetime comment '更新时间',
	remarks text comment '备注',
	del_flag int default 0 comment '删除标志'
)engine=INNODB;
alter table `sys_user` comment='账号表';
#认证表
drop table if exists `sys_user_oauth`;
create table if not exists `sys_user_oauth`(
	id varchar(32) primary key comment '主键id',
	user_id varchar(32) comment '用户id',
	oauth_type varchar(20) comment '认证类型',
	openid varchar(50) comment '认证id',
	access_token varchar(100) comment '认证token',
	status int comment '认证状态',
	create_time datetime comment '创建时间',
	update_time datetime comment '更新时间',
	remarks text comment '备注',
	del_flag int default 0 comment '删除标志'
)engine=INNODB;
alter table `sys_user_oauth` comment='认证表';











