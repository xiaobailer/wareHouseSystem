package io.renren.modules.wms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.wms.entity.ShelfInfoEntity;

import java.util.Map;

/**
 * 
 *
 * @author Suagr_D_van
 * @email th15986581153@gmail.com
 * @date 2023-01-08 11:04:04
 */
public interface ShelfInfoService extends IService<ShelfInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

