/**
 * 
 */
package com.zhoubo.service;

import java.util.List;

import com.zhoubo.basic.Result;

/**
 * @author Administrator
 *
 */
public interface POIService {

	/**
	 * 
	 * @return 返回任意类型，由具体的实现类去实现。
	 */
	Result read(List<String[]> strings);
}
