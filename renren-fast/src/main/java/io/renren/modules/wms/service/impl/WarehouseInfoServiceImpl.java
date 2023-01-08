package io.renren.modules.wms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.wms.dao.WarehouseInfoDao;
import io.renren.modules.wms.entity.WarehouseInfoEntity;
import io.renren.modules.wms.service.WarehouseInfoService;


@Service("warehouseInfoService")
public class WarehouseInfoServiceImpl extends ServiceImpl<WarehouseInfoDao, WarehouseInfoEntity> implements WarehouseInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<WarehouseInfoEntity> page = this.page(
                new Query<WarehouseInfoEntity>().getPage(params),
                new QueryWrapper<WarehouseInfoEntity>()
        );

        return new PageUtils(page);
    }

}