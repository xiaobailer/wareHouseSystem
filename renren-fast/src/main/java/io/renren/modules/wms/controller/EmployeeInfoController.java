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

import io.renren.modules.wms.entity.EmployeeInfoEntity;
import io.renren.modules.wms.service.EmployeeInfoService;
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
@RequestMapping("wms/employeeinfo")
public class EmployeeInfoController {
    @Autowired
    private EmployeeInfoService employeeInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("wms:employeeinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = employeeInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{employeeid}")
    @RequiresPermissions("wms:employeeinfo:info")
    public R info(@PathVariable("employeeid") String employeeid){
		EmployeeInfoEntity employeeInfo = employeeInfoService.getById(employeeid);

        return R.ok().put("employeeInfo", employeeInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("wms:employeeinfo:save")
    public R save(@RequestBody EmployeeInfoEntity employeeInfo){
		employeeInfoService.save(employeeInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("wms:employeeinfo:update")
    public R update(@RequestBody EmployeeInfoEntity employeeInfo){
		employeeInfoService.updateById(employeeInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("wms:employeeinfo:delete")
    public R delete(@RequestBody String[] employeeids){
		employeeInfoService.removeByIds(Arrays.asList(employeeids));

        return R.ok();
    }

}
