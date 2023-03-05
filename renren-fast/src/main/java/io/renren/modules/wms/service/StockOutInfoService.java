package io.renren.modules.wms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.wms.entity.StockOutInfoEntity;

import java.util.Map;

/**
 * 
 *
 * @author Suagr_D_van
 * @email th15986581153@gmail.com
 * @date 2023-02-24 22:58:34
 */
public interface StockOutInfoService extends IService<StockOutInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

