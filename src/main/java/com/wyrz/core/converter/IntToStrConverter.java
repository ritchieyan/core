package com.wyrz.core.converter;

import java.util.List;

import org.springframework.stereotype.Component;

import com.wyrz.core.exception.ICoreException;

/**
 * Integer转String
 * @author Ritchieyan
 * @date 2014年12月17日下午1:32:08
 */
@Component
public class IntToStrConverter {

	/**
	 * Integer列表转String列表
	 * 
	 * @author Ritchieyan
	 * @param sources
	 * @return
	 * @date 2014年12月17日下午1:45:19
	 */
	public List<String> convert(List<Integer> sources) {
		return new _Converter().convert(sources);
	}

	/**
	 * Integer转String
	 * 
	 * @author Ritchieyan
	 * @param source
	 * @return
	 * @date 2014年12月17日下午1:45:37
	 */
	public String convert(Integer source) {
		return new _Converter().convert(source);
	}

	private class _Converter extends ListConverterTemplate<Integer, String> {

		@Override
		public String convert(Integer source) throws ICoreException {
			return String.valueOf(source);
		}

	}

}
