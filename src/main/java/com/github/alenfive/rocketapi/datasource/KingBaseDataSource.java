package com.github.alenfive.rocketapi.datasource;

import com.github.alenfive.rocketapi.entity.vo.Page;
import com.github.alenfive.rocketapi.entity.vo.TableInfo;
import com.github.alenfive.rocketapi.extend.IApiPager;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.List;

/**
 * KingBase 数据源
 */
public class KingBaseDataSource extends JdbcDataSource {

    public KingBaseDataSource() {
    }

    public KingBaseDataSource(PlatformTransactionManager transactionManager) {
        super(transactionManager);
    }

    public KingBaseDataSource(PlatformTransactionManager transactionManager, boolean storeApi) {
        super(transactionManager, storeApi);
    }

    @Override
    public String buildCountScript(String script, IApiPager apiPager, Page page) {
        return "select count(1) from ("+script+") t1";
    }

    @Override
    public String buildPageScript(String script, IApiPager apiPager, Page page) {
        Integer offset = apiPager.getOffset(page.getPageSize(),page.getPageNo());
        return script + " limit "+page.getPageSize()+" offset "+offset;
    }

    @Override
    public String transcoding(String param) {
        return param
                .replace("'","''");
    }

    @Override
    public List<TableInfo> buildTableInfo() {
        return null;
    }
}
