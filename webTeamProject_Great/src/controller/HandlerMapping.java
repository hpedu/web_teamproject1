<<<<<<< HEAD
<<<<<<< HEAD
package controller;

public class HandlerMapping {
	private static HandlerMapping handler = new HandlerMapping();
	private HandlerMapping() {}
	public static HandlerMapping getInstance() {
		return handler;		
	}
	
	public Controller createController(String command) {
		Controller controller = null;
		
		return controller;
	}
}

//updateView
//updatePosting












=======
<<<<<<< HEAD
=======
>>>>>>> branch 'master' of https://github.com/hpedu/web_teamproject1.git
package controller;

public class HandlerMapping {
	private static HandlerMapping factory = new HandlerMapping();
	private HandlerMapping() {}
	
	public static HandlerMapping getInstance() {
		return factory;
	}
	
	//showproductdetail
	public Controller createFactory(String command) {
		Controller controller= null;
		
		if(command.equals("search")) {
			controller = new SearchController();
			System.out.println("SearchController 持失...");
		}else if(command.equals("showmain")) {
			controller=  new ShowMainController();
			System.out.println("ShowMainController 持失....");
		}else if(command.equals("showrecipedetail")) {
			controller=  new ShowRecipeController();
			System.out.println("ShowRecipeController 持失....");
		}else if(command.equals("showproductdetail")) {
			controller= new SerchRecipeController();
		System.out.println("SerchRecipeController 持失....");
		}else if(command.equals("reciperegist")) {
			controller= new Write_RecipeController();
		System.out.println("WriteController 持失....");
		}else if(command.equals("SerchRecipe")) {
			controller= new SerchRecipeController();
		System.out.println("SerchRecipeController 持失....");
		}
		
		return controller;
	}
	
}


>>>>>>> refs/remotes/origin/master
