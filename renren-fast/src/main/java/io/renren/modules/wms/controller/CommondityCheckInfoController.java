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

import io.renren.modules.wms.entity.CommondityCheckInfoEntity;
import io.renren.modules.wms.service.CommondityCheckInfoService;
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
@RequestMapping("wms/commonditycheckinfo")
public class CommondityCheckInfoController {
    @Autowired
    private CommondityCheckInfoService commondityCheckInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("wms:commonditycheckinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = commondityCheckInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{commoditycheckid}")
    @RequiresPermissions("wms:commonditycheckinfo:info")
    public R info(@PathVariable("commoditycheckid") String commoditycheckid){
		CommondityCheckInfoEntity commondityCheckInfo = commondityCheckInfoService.getById(commoditycheckid);

        return R.ok().put("commondityCheckInfo", commondityCheckInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("wms:commonditycheckinfo:save")
    public R save(@RequestBody CommondityCheckInfoEntity commondityCheckInfo){
		commondityCheckInfoService.save(commondityCheckInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("wms:commonditycheckinfo:update")
    public R update(@RequestBody CommondityCheckInfoEntity commondityCheckInfo){
		commondityCheckInfoService.updateById(commondityCheckInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("wms:commonditycheckinfo:delete")
    public R delete(@RequestBody String[] commoditycheckids){
		commondityCheckInfoService.removeByIds(Arrays.asList(commoditycheckids));

        return R.ok();
    }

}
