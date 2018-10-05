package controller;

public class HandlerMapping {
	private static HandlerMapping factory = new HandlerMapping();
	private HandlerMapping() {}
	
	public static HandlerMapping getInstance() {
		return factory;
	}
	
	public Controller createFactory(String command) {
		
		Controller controller= null;
		if(command.equals("itemlist.do")) {
			
		}
		
		return controller;
	}
	
}
