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

import io.renren.modules.wms.entity.ShelfInfoEntity;
import io.renren.modules.wms.service.ShelfInfoService;
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
@RequestMapping("wms/shelfinfo")
public class ShelfInfoController {
    @Autowired
    private ShelfInfoService shelfInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("wms:shelfinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = shelfInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{shelfid}")
    @RequiresPermissions("wms:shelfinfo:info")
    public R info(@PathVariable("shelfid") Integer shelfid){
		ShelfInfoEntity shelfInfo = shelfInfoService.getById(shelfid);

        return R.ok().put("shelfInfo", shelfInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("wms:shelfinfo:save")
    public R save(@RequestBody ShelfInfoEntity shelfInfo){
		shelfInfoService.save(shelfInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("wms:shelfinfo:update")
    public R update(@RequestBody ShelfInfoEntity shelfInfo){
		shelfInfoService.updateById(shelfInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("wms:shelfinfo:delete")
    public R delete(@RequestBody Integer[] shelfids){
		shelfInfoService.removeByIds(Arrays.asList(shelfids));

        return R.ok();
    }

}
