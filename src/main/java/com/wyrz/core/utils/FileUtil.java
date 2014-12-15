package com.wyrz.core.utils;

import java.io.File;
import java.io.IOException;

/**
 * 文件工具类
 * @author yanziqi
 * @date 2014年12月9日下午3:51:10
 */
public class FileUtil {
	/**
	 * 创建文件目录
	 * @author yanziqi
	 * @param file 需要创建目录的文件
	 * @throws IOException
	 * @date 2014年12月9日下午3:51:23
	 */
	public static void mkdirs(File file) throws IOException {
		if (file == null) {
			throw new NullPointerException("File must not be null");
		}
		if (file.isDirectory()) {
			throw new IOException("File '" + file + "' exists but is a directory");
		}
		File parentFile = file.getParentFile();
		if (parentFile != null) {
			if (!parentFile.mkdirs() && !parentFile.isDirectory()) {
				throw new IOException("File '" + parentFile + "' directory cannot be created");
			}
		}
		if (file.exists() && file.canWrite() == false) {
			throw new IOException("File '" + file + "' exists but is read-only");
		}
	}

}
