<<<<<<< HEAD
package controller;

public class HandlerMapping {
	private static HandlerMapping factory = new HandlerMapping();
	private HandlerMapping() {}
	
	public static HandlerMapping getInstance() {
		return factory;
	}
	
	public Controller createFactory(String command) {
		Controller controller= null;
		
		if(command.equals("search")) {
			controller = new SearchController();
			System.out.println("SearchController ����...");
		}else if(command.equals("showrecipedetail")) {
			controller=  new ShowRecipeController();
			System.out.println("ShowRecipeController ����....");
		}
		
		return controller;
	}
	
}


