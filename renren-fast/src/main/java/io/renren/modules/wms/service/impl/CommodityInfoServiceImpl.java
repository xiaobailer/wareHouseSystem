package io.renren.modules.wms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.wms.dao.CommodityInfoDao;
import io.renren.modules.wms.entity.CommodityInfoEntity;
import io.renren.modules.wms.service.CommodityInfoService;


@Service("commodityInfoService")
public class CommodityInfoServiceImpl extends ServiceImpl<CommodityInfoDao, CommodityInfoEntity> implements CommodityInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CommodityInfoEntity> page = this.page(
                new Query<CommodityInfoEntity>().getPage(params),
                new QueryWrapper<CommodityInfoEntity>()
        );

        return new PageUtils(page);
    }

}