package service;

import java.util.ArrayList;

import dao.ShowDao;
import model.dao.PagingBean;
import model.vo.ProductVO;
import model.vo.RecipeVO;

public class RPService {
	private ShowDao dao;
	private static RPService service = new RPService();
	private RPService() {
		dao = ShowDao.getInstance();
	}
	public static RPService getInstance() {
		return service;
	}
	
	public PListVO showProduct(String pageNo) throws Exception {
		int pn =1;
		
        if(pageNo !=null) pn = Integer.parseInt(pageNo);
		
		ArrayList<ProductVO> list = dao.getProductList(pn);
		int total = dao.getTotalProductCount();
		PagingBean pb = new PagingBean(total,pn);
		
		return new PListVO(pb,list);
	}
	
	public RListVO showRecipe(String pageNo) throws Exception {
		int pn =1;
		
        if(pageNo !=null) pn = Integer.parseInt(pageNo);
		
		ArrayList<RecipeVO> list = dao.getRecipeList(pn);
		int total = dao.getTotalRecipeCount();
		PagingBean pb = new PagingBean(total,pn);
		
		return new RListVO(pb,list);
	}
}
