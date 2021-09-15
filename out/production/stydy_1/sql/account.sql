DROP TABLE IF EXISTS user_role;
create table  user_role(
    id bigint(20) not null comment 'ID',
    user_id bigint(20)  null default null  comment '用户ID',
    role_id bigint(20) null default null comment '角色ID',
    created datetime(0) null default null comment '创建时间',
    deleted tinyint(1) UNSIGNED ZEROFILL NULL DEFAULT 0 COMMENT '逻辑删除:0=未删除,1=已删除',
    primary key(id) using btree,
    index member(user_id) using btree comment '用户',
    index role_id(role_id)using btree comment '角色ID'
)ENGINE = InnoDB  CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色' ROW_FORMAT = Dynamic;
