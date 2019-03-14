package com.zhoubo.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhoubo.pojo.Category;
import com.zhoubo.pojo.UIComboBox;
import com.zhoubo.service.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {

	private static Logger log = LoggerFactory.getLogger(CategoryController.class);
	
	
	@Autowired
	@Qualifier("csi")
	CategoryService csi;
	
	@RequestMapping("/product")
	@ResponseBody
	public List<UIComboBox> getCategorys(){
		log.info("商品分类请求");
		List<Category> categories = new ArrayList<Category>();
		categories = csi.getCategoryS();
		log.info("categorys", categories);
		List<UIComboBox> uiComboBoxs = new ArrayList<UIComboBox>();
		int i = 0;
		
		for(Category category : categories) {
			if(i == 0) {
				UIComboBox uiComboBox = new UIComboBox();
				uiComboBox.setId("0");
				uiComboBox.setText("全部分类");
				uiComboBox.setSelected(true);
				uiComboBoxs.add(uiComboBox);
				
			}
			UIComboBox uiComboBox = new UIComboBox();
			uiComboBox.setId(Integer.toString(category.getCategoryId()));
			uiComboBox.setText(category.getCategoryName());
			uiComboBox.setSelected(true);
			uiComboBoxs.add(uiComboBox);
			i++;
		}
		log.info("uicomboboxs", uiComboBoxs);
		return uiComboBoxs;
		
	}
}
