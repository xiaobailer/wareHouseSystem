package io.renren.modules.wms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.wms.dao.StockInInfoDao;
import io.renren.modules.wms.entity.StockInInfoEntity;
import io.renren.modules.wms.service.StockInInfoService;


@Service("stockInInfoService")
public class StockInInfoServiceImpl extends ServiceImpl<StockInInfoDao, StockInInfoEntity> implements StockInInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<StockInInfoEntity> page = this.page(
                new Query<StockInInfoEntity>().getPage(params),
                new QueryWrapper<StockInInfoEntity>()
        );

        return new PageUtils(page);
    }

}