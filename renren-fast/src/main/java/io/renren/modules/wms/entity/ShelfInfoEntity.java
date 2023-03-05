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
@TableName("wms_shelf_info")
public class ShelfInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer shelfid;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private String state;
	/**
	 * 
	 */
	private String warehouseid;

}
