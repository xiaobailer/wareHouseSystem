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

import io.renren.modules.wms.entity.CustomerInfoEntity;
import io.renren.modules.wms.service.CustomerInfoService;
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
@RequestMapping("wms/customerinfo")
public class CustomerInfoController {
    @Autowired
    private CustomerInfoService customerInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("wms:customerinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = customerInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{customerid}")
    @RequiresPermissions("wms:customerinfo:info")
    public R info(@PathVariable("customerid") String customerid){
		CustomerInfoEntity customerInfo = customerInfoService.getById(customerid);

        return R.ok().put("customerInfo", customerInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("wms:customerinfo:save")
    public R save(@RequestBody CustomerInfoEntity customerInfo){
		customerInfoService.save(customerInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("wms:customerinfo:update")
    public R update(@RequestBody CustomerInfoEntity customerInfo){
		customerInfoService.updateById(customerInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("wms:customerinfo:delete")
    public R delete(@RequestBody String[] customerids){
		customerInfoService.removeByIds(Arrays.asList(customerids));

        return R.ok();
    }

}
