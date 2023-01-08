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
@TableName("wms_stock_in_info")
public class StockInInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String stockinid;
	/**
	 * 
	 */
	private String employeeid;
	/**
	 * 
	 */
	private String commonditycherckid;
	/**
	 * 
	 */
	private Date stockindate;
	/**
	 * 
	 */
	private String stockinstate;

}
