package com.wyrz.core.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 文件判断工具类
 * @author yanziqi
 * @date 2014年12月9日下午3:49:18
 */
public class FileAssert {

	/**
	 * 断言文件存在、可读、且不是目录
	 * @author yanziqi
	 * @param file
	 * @throws IOException 如果文件是目录或者不可读
	 * @date 2014年12月9日下午3:49:53
	 */
	public static void canRead(File file) throws IOException {
		isFile(file);
		if (file.exists() && file.canRead() == false) {
			throw new IOException("The file '" + file + "' exists but can not read");
		}
	}

	/**
	 * 断言文件可写，存在切不是目录
	 * @author yanziqi
	 * @param file
	 * @throws IOException 如果文件是目录或者不可写
	 * @date 2014年12月9日下午3:50:23
	 */
	public static void canWrite(File file) throws IOException {
		isFile(file);
		if (file.exists() && file.canRead() == false) {
			throw new IOException("The file '" + file + "' exists but can not read");
		}
	}

	/**
	 * 断言文件存在且不是目录
	 * @author yanziqi
	 * @param file
	 * @throws IOException  如果文件是目录
	 * @date 2014年12月9日下午3:50:46
	 */
	public static void isFile(File file) throws IOException {
		if (file == null) {
			throw new NullPointerException("File must not be null");
		}
		if (file.exists() == false) {
			throw new FileNotFoundException("The file '" + file + "' does not exist");
		}
		if (file.isDirectory()) {
			throw new IOException("The file  '" + file + "' exists but is a directory");
		}
	}
}
