package controller;

import java.util.HashMap;

public class ModelAndView {
	private String path;
	private boolean isRedirect = false;
	public HashMap<String, Object> map = new HashMap<String, Object>();
	
	public ModelAndView(String path, boolean isRedirect) {
		super();
		this.path = path;
		this.isRedirect = isRedirect;
	}
	public ModelAndView() {}
	public ModelAndView(String path) {
		this.path = path;
	}
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public void setObject(String str ,Object object) {
		map.put(str, object);
		
	}
	public HashMap<String,Object> getModelMap() {
		return map;
	}
	
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
}
