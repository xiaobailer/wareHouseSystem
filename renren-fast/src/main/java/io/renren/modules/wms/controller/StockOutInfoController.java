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

import io.renren.modules.wms.entity.StockOutInfoEntity;
import io.renren.modules.wms.service.StockOutInfoService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author Suagr_D_van
 * @email th15986581153@gmail.com
 * @date 2023-02-24 22:58:34
 */
@RestController
@RequestMapping("wms/stockoutinfo")
public class StockOutInfoController {
    @Autowired
    private StockOutInfoService stockOutInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("wms:stockoutinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = stockOutInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{stockid}")
    @RequiresPermissions("wms:stockoutinfo:info")
    public R info(@PathVariable("stockid") Integer stockid){
		StockOutInfoEntity stockOutInfo = stockOutInfoService.getById(stockid);

        return R.ok().put("stockOutInfo", stockOutInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("wms:stockoutinfo:save")
    public R save(@RequestBody StockOutInfoEntity stockOutInfo){
		stockOutInfoService.save(stockOutInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("wms:stockoutinfo:update")
    public R update(@RequestBody StockOutInfoEntity stockOutInfo){
		stockOutInfoService.updateById(stockOutInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("wms:stockoutinfo:delete")
    public R delete(@RequestBody Integer[] stockids){
		stockOutInfoService.removeByIds(Arrays.asList(stockids));

        return R.ok();
    }

}
