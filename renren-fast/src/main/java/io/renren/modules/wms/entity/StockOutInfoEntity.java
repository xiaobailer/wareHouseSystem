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
 * @date 2023-02-24 22:58:34
 */
@Data
@TableName("wms_stock_out_info")
public class StockOutInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer stockid;
	/**
	 * 
	 */
	private String employeeid;
	/**
	 * 
	 */
	private String commonditycheckid;
	/**
	 * 
	 */
	private String customerid;
	/**
	 * 
	 */
	private Date stockoutdata;
	/**
	 * 
	 */
	private String stockoutstate;

}
