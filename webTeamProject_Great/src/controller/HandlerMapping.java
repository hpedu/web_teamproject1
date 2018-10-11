
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
		System.out.println(command);
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
		}else if(command.equals("insertrecipe.do")) {
			controller= new Write_RecipeController();
		System.out.println("WriteController 持失....");
		}else if(command.equals("SerchRecipe")) {
			controller= new SerchRecipeController();
		System.out.println("SerchRecipeController 持失....");
		}else if(command.equals("register")) {
			controller= new RegisterController();
			System.out.println("RegisterController 持失....");
		}else if(command.equals("login")) {
			controller= new LoginController();
			System.out.println("LoginController 持失....");
		}else if(command.equals("logout")) {
			controller = new LogoutController();
			System.out.println("LogoutController 持失....");
		}else if(command.equals("idcheck")) {
			controller = new IdCheckController();
			System.out.println("IdCheckController 持失....");
		}
		
		return controller;
	}
	
}
