package com.zhoubo.service;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhoubo.dao.MenuMapper;
import com.zhoubo.pojo.CurrentUser;
import com.zhoubo.pojo.Menu;
import com.zhoubo.pojo.UITree;
import com.zhoubo.util.StringUtil;
@Service("MenuServiceImp")
public class MenuSerivceImp implements MenuService{
	
	private static Logger logger = LoggerFactory.getLogger(MenuSerivceImp.class);
	
	@Autowired
	MenuMapper menuMapper;
	
	@Override
	public List<UITree> getMenuTree(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession();
		CurrentUser cu = (CurrentUser) session.getAttribute("cu");
		int menuType = cu.getUserType();
		//查出所有的menu对象
		List<Menu> menuList = menuMapper.selectAll(menuType);
		//templateList 是用来存放parentid为0的一级目录，然后在一级目录下有多级子目录。
		if(null != menuList){
			UITree rootTree = new UITree();
			rootTree.setId(0);
			recursive(rootTree, menuList);
			List<UITree> treeList = rootTree.getChildren();
			return treeList;
		}else {
			return null;
		}
		
	}
	//递归获得数型结构:递归的本质是程序调用自身
	public UITree recursive(UITree subTree, List<Menu> menus){
		List<Menu> templateList = new ArrayList<Menu>();
		List<UITree> subTreeList = new ArrayList<UITree>();
		for(Menu menu:menus){
			if(menu.getMenuParentId() == subTree.getId()){
				templateList.add(menu);
			}
		}//将遍历结果父id为0的集合template删除
		menus.removeAll(templateList);
		logger.info(Integer.toString(templateList.size()));
		for(Menu menu:templateList){
			/*Attributes attributes = new Attributes();*/
			UITree uiTree = new UITree();
			uiTree.setId(menu.getId());
			uiTree.setText(StringUtil.nullToEmpty(menu.getMenuName()));
			/*attributes.setPageUrl(StringUtil.nullToEmpty(menu.getPageUrl()));*/
			/*uiTree.setAttributes(attributes);*/
			uiTree.setPageUrl(StringUtil.nullToEmpty(menu.getPageUrl()));
			recursive(uiTree, menus);
			subTreeList.add(uiTree);
		}
		subTree.setChildren(subTreeList);
		return subTree;
	}


	
}
