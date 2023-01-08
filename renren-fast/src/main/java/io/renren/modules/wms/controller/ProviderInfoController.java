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

import io.renren.modules.wms.entity.ProviderInfoEntity;
import io.renren.modules.wms.service.ProviderInfoService;
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
@RequestMapping("wms/providerinfo")
public class ProviderInfoController {
    @Autowired
    private ProviderInfoService providerInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("wms:providerinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = providerInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{providerid}")
    @RequiresPermissions("wms:providerinfo:info")
    public R info(@PathVariable("providerid") String providerid){
		ProviderInfoEntity providerInfo = providerInfoService.getById(providerid);

        return R.ok().put("providerInfo", providerInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("wms:providerinfo:save")
    public R save(@RequestBody ProviderInfoEntity providerInfo){
		providerInfoService.save(providerInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("wms:providerinfo:update")
    public R update(@RequestBody ProviderInfoEntity providerInfo){
		providerInfoService.updateById(providerInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("wms:providerinfo:delete")
    public R delete(@RequestBody String[] providerids){
		providerInfoService.removeByIds(Arrays.asList(providerids));

        return R.ok();
    }

}
