package io.renren.modules.wms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.wms.dao.CustomerInfoDao;
import io.renren.modules.wms.entity.CustomerInfoEntity;
import io.renren.modules.wms.service.CustomerInfoService;


@Service("customerInfoService")
public class CustomerInfoServiceImpl extends ServiceImpl<CustomerInfoDao, CustomerInfoEntity> implements CustomerInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CustomerInfoEntity> page = this.page(
                new Query<CustomerInfoEntity>().getPage(params),
                new QueryWrapper<CustomerInfoEntity>()
        );

        return new PageUtils(page);
    }

}