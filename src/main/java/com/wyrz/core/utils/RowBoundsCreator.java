package com.wyrz.core.utils;

import org.apache.ibatis.session.RowBounds;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

/**
 * 查询记录结果行范围限定条件构建器
 * @author yanziqi
 * @date 2014年12月9日下午3:36:37
 */
@Component
public class RowBoundsCreator {

	public RowBounds create(Pageable source) {
		RowBounds bounds = RowBounds.DEFAULT;
		if (null != source) {
			bounds = new RowBounds(source.getOffset(), source.getPageSize());
		}
		return bounds;
	}

}
