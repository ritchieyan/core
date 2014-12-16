package com.wyrz.core.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 序列化和反序列化对象，要求被序列化的对象扩展接口:{@link java.io.Serializable}
 * 
 * @author Ritchieyan
 * @date 2014年12月16日下午10:16:20
 */
public class SerializeUtil {
	private static Logger log = LoggerFactory.getLogger(SerializeUtil.class);

	/**
	 * 序列化对象，若序列化对象失败将返回null
	 * 
	 * @author Ritchieyan
	 * @param object
	 * @return
	 * @date 2014年12月16日下午10:16:34
	 */
	public static byte[] serialize(Object object) {
		ObjectOutputStream oos = null;
		ByteArrayOutputStream baos = null;
		try {
			// 序列化
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(object);
			oos.flush();
			return baos.toByteArray();
		} catch (Exception e) {
			log.error("序列化对象失败!", e);
		}
		return null;
	}

	/**
	 * 反序列化对象，若反序列化对象失败将返回null
	 * 
	 * @author Ritchieyan
	 * @param bytes
	 * @return
	 * @date 2014年12月16日下午10:16:45
	 */
	public static Object deserialize(byte[] bytes) {
		ByteArrayInputStream bais = null;
		try {
			// 反序列化
			bais = new ByteArrayInputStream(bytes);
			ObjectInputStream ois = new ObjectInputStream(bais);
			return ois.readObject();
		} catch (Exception e) {
			log.error("反序列化对象失败!", e);
		}
		return null;
	}
}
