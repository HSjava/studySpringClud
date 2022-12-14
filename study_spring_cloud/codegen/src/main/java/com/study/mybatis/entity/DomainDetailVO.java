package com.study.mybatis.entity;

import java.io.Serializable;

/**
 * 功能描述:表结构的实体
 * @author husong
 * @date 2022 年 12 月 13 日 20:44
 */

public class DomainDetailVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String filedName; //字段名

    private String filedType; //字段类型

    private boolean primaryKey; //是否是主键

    private String columnKey; //数据库主键

    private String columnName; //数据库字段名

    private String columnLength; //数据库字段长度

    private String comments; //字段注释信息

    private String tableDesc; //表描述

}
