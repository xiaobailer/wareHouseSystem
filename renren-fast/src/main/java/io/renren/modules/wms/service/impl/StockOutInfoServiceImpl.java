package io.renren.modules.wms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.wms.dao.StockOutInfoDao;
import io.renren.modules.wms.entity.StockOutInfoEntity;
import io.renren.modules.wms.service.StockOutInfoService;


@Service("stockOutInfoService")
public class StockOutInfoServiceImpl extends ServiceImpl<StockOutInfoDao, StockOutInfoEntity> implements StockOutInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<StockOutInfoEntity> page = this.page(
                new Query<StockOutInfoEntity>().getPage(params),
                new QueryWrapper<StockOutInfoEntity>()
        );

        return new PageUtils(page);
    }

}