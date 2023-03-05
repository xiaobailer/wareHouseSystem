package io.renren.modules.wms.service.impl;

import org.apache.commons.lang.StringUtils;
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

        System.out.println(params);

        String key = (String) params.get("key");
        //select * from pms_attr_group where catelog_id=? and (attr_group_id=key or attr_group_name like %key%)
        QueryWrapper<EmployeeInfoEntity> wrapper = new QueryWrapper<EmployeeInfoEntity>();
        if (!StringUtils.isEmpty(key)) {
            wrapper.eq("employeeId", key).or().like("name", key);
        }
        IPage<EmployeeInfoEntity> page = this.page(
                new Query<EmployeeInfoEntity>().getPage(params),
                wrapper
        );

        return new PageUtils(page);
    }

}