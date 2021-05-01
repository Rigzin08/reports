package com.spring.mvc.helper;

import org.hibernate.dialect.MySQL5Dialect;

public class MySQLCustomDialect extends MySQL5Dialect {
    public MySQLCustomDialect() {
        super();
        registerHibernateType(-9, "string");
    }
}

