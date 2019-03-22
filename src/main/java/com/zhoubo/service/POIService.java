/**
 * 
 */
package com.zhoubo.service;

import java.util.List;

/**
 * @author Administrator
 *
 */
public interface POIService {

	/**
	 * 
	 * @return 返回任意类型，由具体的实现类去实现。
	 */
	int read(List<String[]> strings);
}
