
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
		if(command.equals("search.do")) {
			controller = new SearchController();
			System.out.println("SearchController ����...");
		}else if(command.equals("showmain.do")) {
			controller=  new ShowMainController();
			System.out.println("ShowMainController ����....");
		}else if(command.equals("showrecipedetail.do")) {
			controller=  new ShowRecipeController();
			System.out.println("ShowRecipeController ����....");
		}else if(command.equals("showproductdetail.do")) {
			controller= new SerchRecipeController();
		System.out.println("SerchRecipeController ����....");
		}else if(command.equals("insertrecipe.do")) {
			controller= new Write_RecipeController();
		System.out.println("WriteController ����....");
		}else if(command.equals("SerchRecipe.do")) {
			controller= new SerchRecipeController();
		System.out.println("SerchRecipeController ����....");
		}else if(command.equals("register.do")) {
			controller= new RegisterController();
			System.out.println("RegisterController ����....");
		}else if(command.equals("login.do")) {
			controller= new LoginController();
			System.out.println("LoginController ����....");
		}else if(command.equals("logout.do")) {
			controller = new LogoutController();
			System.out.println("LogoutController ����....");
		}else if(command.equals("idcheck.do")) {
			controller = new IdCheckController();
			System.out.println("IdCheckController ����....");
		}else if(command.equals("noticeList.do")) {
			controller = new NoticeListController();
			System.out.println("NoticeListController ����....");
		}else if(command.equals("deleterecipe.do")) {
			controller = new DeleteRecipeController();
			System.out.println("DeleteRecipeController ����....");
		}else if(command.equals("serchmyrecipe.do")) {
			controller = new SerchMyRecipeController();
			System.out.println("SerchMyRecipeController ����....");
		}else if(command.equals("showProductDetail.do")) {
	         controller = new ProductDetailController();
	         System.out.println("productDetail ����....");
	      }
		
		return controller;
	}
	
}
