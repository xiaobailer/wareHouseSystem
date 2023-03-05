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

import io.renren.modules.wms.entity.CommodityInfoEntity;
import io.renren.modules.wms.service.CommodityInfoService;
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
@RequestMapping("wms/commodityinfo")
public class CommodityInfoController {
    @Autowired
    private CommodityInfoService commodityInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("wms:commodityinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = commodityInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{commodityid}")
    @RequiresPermissions("wms:commodityinfo:info")
    public R info(@PathVariable("commodityid") Integer commodityid){
		CommodityInfoEntity commodityInfo = commodityInfoService.getById(commodityid);

        return R.ok().put("commodityInfo", commodityInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("wms:commodityinfo:save")
    public R save(@RequestBody CommodityInfoEntity commodityInfo){
		commodityInfoService.save(commodityInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("wms:commodityinfo:update")
    public R update(@RequestBody CommodityInfoEntity commodityInfo){
		commodityInfoService.updateById(commodityInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("wms:commodityinfo:delete")
    public R delete(@RequestBody Integer[] commodityids){
		commodityInfoService.removeByIds(Arrays.asList(commodityids));

        return R.ok();
    }

}
