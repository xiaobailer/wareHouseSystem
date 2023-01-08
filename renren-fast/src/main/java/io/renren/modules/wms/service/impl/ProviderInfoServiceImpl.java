package io.renren.modules.wms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.wms.dao.ProviderInfoDao;
import io.renren.modules.wms.entity.ProviderInfoEntity;
import io.renren.modules.wms.service.ProviderInfoService;


@Service("providerInfoService")
public class ProviderInfoServiceImpl extends ServiceImpl<ProviderInfoDao, ProviderInfoEntity> implements ProviderInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ProviderInfoEntity> page = this.page(
                new Query<ProviderInfoEntity>().getPage(params),
                new QueryWrapper<ProviderInfoEntity>()
        );

        return new PageUtils(page);
    }

}