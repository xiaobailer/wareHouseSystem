package io.renren.modules.wms.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.wms.entity.WarehouseInfoEntity;
import io.renren.modules.wms.service.WarehouseInfoService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author Suagr_D_van
 * @email th15986581153@gmail.com
 * @date 2023-01-08 11:04:04
 */
@RestController
@RequestMapping("wms/warehouseinfo")
public class WarehouseInfoController {
    @Autowired
    private WarehouseInfoService warehouseInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("wms:warehouseinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = warehouseInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{warehouseid}")
    @RequiresPermissions("wms:warehouseinfo:info")
    public R info(@PathVariable("warehouseid") String warehouseid){
		WarehouseInfoEntity warehouseInfo = warehouseInfoService.getById(warehouseid);

        return R.ok().put("warehouseInfo", warehouseInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("wms:warehouseinfo:save")
    public R save(@RequestBody WarehouseInfoEntity warehouseInfo){
		warehouseInfoService.save(warehouseInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("wms:warehouseinfo:update")
    public R update(@RequestBody WarehouseInfoEntity warehouseInfo){
		warehouseInfoService.updateById(warehouseInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("wms:warehouseinfo:delete")
    public R delete(@RequestBody String[] warehouseids){
		warehouseInfoService.removeByIds(Arrays.asList(warehouseids));

        return R.ok();
    }

}
