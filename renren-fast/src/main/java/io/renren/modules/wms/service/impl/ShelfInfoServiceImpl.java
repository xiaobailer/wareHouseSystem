package io.renren.modules.wms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.wms.dao.ShelfInfoDao;
import io.renren.modules.wms.entity.ShelfInfoEntity;
import io.renren.modules.wms.service.ShelfInfoService;


@Service("shelfInfoService")
public class ShelfInfoServiceImpl extends ServiceImpl<ShelfInfoDao, ShelfInfoEntity> implements ShelfInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ShelfInfoEntity> page = this.page(
                new Query<ShelfInfoEntity>().getPage(params),
                new QueryWrapper<ShelfInfoEntity>()
        );

        return new PageUtils(page);
    }

}