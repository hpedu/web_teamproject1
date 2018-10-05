package controller;

public class HandlerMapping {
	private static HandlerMapping handler = new HandlerMapping();
	private HandlerMapping() {}
	public static HandlerMapping getInstance() {
		return handler;		
	}
	
	public Controller createController(String command) {
		Controller controller = null;
		if(command.equals("showrecipedetail")) {
			controller=  new ShowRecipeController();
			System.out.println("ShowRecipeController ����....");
		}else if(command.equals("showmainviw")) {
			/*controller= new ShowHotRecipeController();
			System.out.println("ShowHotRecipeController ����...");
			controller= new ShowHotProductController();
			controller= new ShowNewRecipeController();
			controller= new ShowRecommendProductController();
			controller= new ShowRecommendRecipeController();*/
			controller= new ShowMainController();
			System.out.println("ShowRecommendRecipeController ����...");
			
		}
		return controller;
	}
	
}






