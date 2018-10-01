package service;

import java.util.ArrayList;

import model.dao.PagingBean;
import model.vo.BoardVO;

public class ListVO {
	private PagingBean pagingBean;
	ArrayList<BoardVO> list;
	public ListVO(PagingBean pagingBean, ArrayList<BoardVO> list) {
		super();
		this.pagingBean = pagingBean;
		this.list = list;
	}
	public ListVO() {
		super();
	}
	
	@Override
	public String toString() {
		return "ListVO [pagingBean=" + pagingBean + ", list=" + list + "]";
	}
	public PagingBean getPagingBean() {
		return pagingBean;
	}
	public void setPagingBean(PagingBean pagingBean) {
		this.pagingBean = pagingBean;
	}
	public ArrayList<BoardVO> getList() {
		return list;
	}
	public void setList(ArrayList<BoardVO> list) {
		this.list = list;
	}
	
	
}
