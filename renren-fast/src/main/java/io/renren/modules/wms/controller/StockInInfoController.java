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

import io.renren.modules.wms.entity.StockInInfoEntity;
import io.renren.modules.wms.service.StockInInfoService;
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
@RequestMapping("wms/stockininfo")
public class StockInInfoController {
    @Autowired
    private StockInInfoService stockInInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("wms:stockininfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = stockInInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{stockinid}")
    @RequiresPermissions("wms:stockininfo:info")
    public R info(@PathVariable("stockinid") Integer stockinid){
		StockInInfoEntity stockInInfo = stockInInfoService.getById(stockinid);

        return R.ok().put("stockInInfo", stockInInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("wms:stockininfo:save")
    public R save(@RequestBody StockInInfoEntity stockInInfo){
		stockInInfoService.save(stockInInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("wms:stockininfo:update")
    public R update(@RequestBody StockInInfoEntity stockInInfo){
		stockInInfoService.updateById(stockInInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("wms:stockininfo:delete")
    public R delete(@RequestBody Integer[] stockinids){
		stockInInfoService.removeByIds(Arrays.asList(stockinids));

        return R.ok();
    }

}
