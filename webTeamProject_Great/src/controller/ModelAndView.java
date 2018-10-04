package controller;

import java.util.HashMap;

public class ModelAndView {
	String viewName="";
	String view="";
	boolean redirect=false;
	public HashMap<String, Object> map = new HashMap<String, Object>();
	
	public void setObject(String str ,Object object) {
		map.put(str, object);
		
	}
	public void setViewName(String viewName) {
		this.viewName=viewName;
		this.view=viewName+".jsp";
	}
	
	public HashMap<String,Object> getModelMap() {
		return map;
	}
	
	public String getView() {
		return view;
	}
	public void isRedirect(boolean redirect) {
		this.redirect = redirect;
	}
	
	public boolean isRedirect() {
		return redirect;
	}
}
