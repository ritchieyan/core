package com.wyrz.core.constants;

/**
 * Mybatis Sql脚本的ID名称
 * @author yanziqi
 * @date 2014年12月9日下午4:09:24
 */
public interface SqlId {
	// 系统标准SQL名
	public String SQL_SELECT_COUNT = "selectCount";
	public String SQL_SELECT = "select";
	public String SQL_SELECT_BY_ID = "selectById";
	public String SQL_SELECT_ALL_ID = "selectAllId";
	public String SQL_SELECT_ID_LIST = "selectIdList";
	public String SQL_UPDATE_BY_ID = "updateById";
	public String SQL_UPDATE_BY_ID_SELECTIVE = "updateByIdSelective";
	public String SQL_DELETE = "delete";
	public String SQL_DELETE_BY_ID = "deleteById";
	public String SQL_INSERT = "insert";
	public String SQL_SELECT_EXISTS_ID_LIST = "selectExistsIdList";
	public String SQL_SELECT_BY_ID_LIST = "selectByIdList";

}
