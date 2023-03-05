package io.renren.wms;

import io.renren.modules.wms.entity.EmployeeInfoEntity;
import io.renren.modules.wms.service.EmployeeInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WmsSystemTestApplication {


    @Autowired
    EmployeeInfoService employeeInfoService;

    @Test
    public void testEmployee() {
        EmployeeInfoEntity employeeInfoEntity = new EmployeeInfoEntity();
        employeeInfoEntity.setName("小白");
        employeeInfoEntity.setSex("1");
        employeeInfoEntity.setAddress("湾湾省");
        employeeInfoService.save(employeeInfoEntity);
    }
}
