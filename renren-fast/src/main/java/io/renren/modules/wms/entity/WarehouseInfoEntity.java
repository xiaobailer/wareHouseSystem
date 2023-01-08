package io.renren.modules.wms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author Suagr_D_van
 * @email th15986581153@gmail.com
 * @date 2023-01-08 11:04:04
 */
@Data
@TableName("wms_warehouse_info")
public class WarehouseInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String warehouseid;
	/**
	 * 
	 */
	private String employeeid;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private String address;
	/**
	 * 
	 */
	private String phone;

}
