package io.renren.modules.wms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.wms.dao.CommondityCheckInfoDao;
import io.renren.modules.wms.entity.CommondityCheckInfoEntity;
import io.renren.modules.wms.service.CommondityCheckInfoService;


@Service("commondityCheckInfoService")
public class CommondityCheckInfoServiceImpl extends ServiceImpl<CommondityCheckInfoDao, CommondityCheckInfoEntity> implements CommondityCheckInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CommondityCheckInfoEntity> page = this.page(
                new Query<CommondityCheckInfoEntity>().getPage(params),
                new QueryWrapper<CommondityCheckInfoEntity>()
        );

        return new PageUtils(page);
    }

}