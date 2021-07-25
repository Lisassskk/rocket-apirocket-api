package com.github.alenfive.rocketapi.datasource.factory;

import com.github.alenfive.rocketapi.datasource.DataSourceDialect;
import com.github.alenfive.rocketapi.datasource.PostgreSQLDataSource;
import com.github.alenfive.rocketapi.entity.DBConfig;
import org.springframework.stereotype.Component;

/**
 * postgre SQL  构造器
 */
@Component
public class PostgreSQLFactory extends JdbcFactory{

    @Override
    public String getName() {
        return "PostgreSQL";
    }

    @Override
    public String getIcon() {
        return "rocket-api/image/postgresql.png";
    }

    @Override
    public String getFormat() {
        return "jdbc:postgresql://localhost:5432/postgres";
    }

    @Override
    public DataSourceDialect factory(DBConfig config) throws Exception {
        return new PostgreSQLDataSource(super.getJdbcTemplate(config));
    }
}
