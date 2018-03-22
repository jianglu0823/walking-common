package com.walking.common.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class FileUtil {

	/**
	 * copy file
	 * 
	 * @param sourceFile
	 * @param distFile
	 */
	public static void copyFile(String sourceFile, String distFile) {
		try {
			FileUtils.copyFile(new File(sourceFile), new File(distFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * copy directory
	 * 
	 * @param sourceDir
	 * @param distDir
	 */
	public static void copyDirectory(String sourceDir, String distDir) {
		try {
			FileUtils.copyDirectory(new File(sourceDir), new File(sourceDir));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 将目录copy到指定目录
	 * @param srcDir
	 * @param destDir
	 */
	public static void copyDirectoryToDirectory(String srcDir,String destDir){
		try {
			FileUtils.copyDirectoryToDirectory(new File(srcDir), new File(destDir));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * copy file from url
	 * 
	 * @param urlPath
	 * @param distFile
	 */
	public static void copyURLToFile(String urlPath, String distFilePath) {
		File distFile = new File(distFilePath);
		try {
			URL url = new URL(urlPath);
			if (!distFile.getParentFile().exists()) {
				distFile.getParentFile().mkdirs();
			}
			FileUtils.copyURLToFile(url, distFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * 
	 * @param content
	 * @param distFilePath
	 * @param encoding
	 */
	public static void saveFile(String content, String distFilePath, String encoding) {
		File distFile = new File(distFilePath);
		try {
			if (!distFile.getParentFile().exists()) {
				distFile.getParentFile().mkdirs();
			}
			FileUtils.writeStringToFile(distFile, content, encoding);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void copyFile(InputStream inputStream, OutputStream outputStream){
		try {
			IOUtils.copy(inputStream, outputStream);
		} catch (IOException e) {
			e.printStackTrace();
		//kenan 2016 03 15 关流
		}finally{
			if(inputStream != null){
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(outputStream != null){
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String args[]) {
		
		
	}
}
