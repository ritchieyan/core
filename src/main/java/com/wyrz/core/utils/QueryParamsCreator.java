package com.wyrz.core.utils;

import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

/**
 * 分页查询条件参数Map构建器
 * @author yanziqi
 * @date 2014年12月9日下午3:51:46
 */
@Component
public class QueryParamsCreator<T> {
	@Autowired
	private RowBoundsCreator rowBoundsCreator;

	/**
	 * 构建分页查询条件
	 * @author yanziqi
	 * @param query 查询条件
	 * @param pageable 分页对象
	 * @return
	 * @date 2014年12月9日下午3:51:56
	 */
	public Map<String, Object> create(T query, Pageable pageable) {
		Map<String, Object> params = BeanUtils.toMap(query, getRowBounds(pageable));
		if (pageable != null && pageable.getSort() != null) {
			String sorting = pageable.getSort().toString();
			params.put("sorting", sorting.replace(":", ""));
		}
		return params;
	}

	/**
	 * 获取查询结果范围限定对象
	 * @author yanziqi
	 * @param source
	 * @return
	 * @date 2014年12月9日下午3:52:30
	 */
	protected RowBounds getRowBounds(Pageable source) {
		return this.rowBoundsCreator.create(source);
	}

}
