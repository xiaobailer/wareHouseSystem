package io.renren.modules.wms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.wms.dao.EmployeeInfoDao;
import io.renren.modules.wms.entity.EmployeeInfoEntity;
import io.renren.modules.wms.service.EmployeeInfoService;


@Service("employeeInfoService")
public class EmployeeInfoServiceImpl extends ServiceImpl<EmployeeInfoDao, EmployeeInfoEntity> implements EmployeeInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<EmployeeInfoEntity> page = this.page(
                new Query<EmployeeInfoEntity>().getPage(params),
                new QueryWrapper<EmployeeInfoEntity>()
        );

        return new PageUtils(page);
    }

}