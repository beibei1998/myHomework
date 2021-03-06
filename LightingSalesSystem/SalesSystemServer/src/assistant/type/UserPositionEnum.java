package assistant.type;

import java.io.Serializable;
/**
 * @author zhangao 161250193
 * @version 2017.11.8
 * 用户职位的枚举类型
 */
public enum UserPositionEnum implements Serializable {
	MANAGER,//总经理
	WAREKEPPER,//库存管理人员
	FINANCE,//财务人员
	ADMIN,//管理员
	SALESMAN;//销售人员
	
	/**
	 * 返回职位名称(对应数据层文件夹名)。<br/>
	 * @return String 职位名称
	 */
	public String toString(){
		return this.name().toLowerCase();
	}
}
