package query;

public interface ShowQuery {
	//조회수 순으로 내림차순 정렬후 상위 4개의 레서피를 검색합니다.
	String SELECT_SHOWHOTRECIPE = "SELECT no, name, img_urls ,main_ingredients ,sub_ingredients, writer, register_date, type,\r\n" + 
			"hits, descript, content, tip,recommend from \r\n" + 
			"(SELECT no, name, img_urls ,main_ingredients ,sub_ingredients, writer, register_date, type,\r\n" + 
			"hits, descript, content, tip,recommend from recipe order by hits desc)\r\n" + 
			"where ROWNUM<=4";
	//시퀀스 넘버에따른 제일 새로등록된 레서피 4개
	String SELECT_SHOWNEWRECIPE = "SELECT no, name, img_urls ,main_ingredients ,sub_ingredients, writer, register_date, type,\r\n" + 
			"hits, descript, content, tip,recommend from \r\n" + 
			"(SELECT no, name, img_urls ,main_ingredients ,sub_ingredients, writer, register_date, type,\r\n" + 
			"hits, descript, content, tip,recommend from recipe order by no desc)\r\n" + 
			"where ROWNUM<=4";
	
	//추천레서피 관리자가 지정해서 추천레서피 2개
	String SELECT_SHOWRECOMMENDRECIPE = "SELECT no, name, img_urls ,main_ingredients ,sub_ingredients, writer, register_date, type,\r\n" + 
			"hits, descript, content, tip,recommend from recipe where recommend='chu' AND ROWNUM<=2";
	
	//판매량 순 내림차순 정렬후 상위 4개 상품 검색
	String SELECT_SHOWHOTPRODUCT = "SELECT name, price ,origin ,img_urls, content, type,\r\n" + 
			"brand, sales_volume,recommend from \r\n" + 
			"(SELECT name, price ,origin ,img_urls, content, type,\r\n" + 
			"brand, sales_volume,recommend from product order by sales_volume desc)\r\n" + 
			"WHERE ROWNUM<=3";
	
	//추천 상품 관리자가 지정해서 추천 레서피 2개
	String SELECT_SHOWRECOMMENDPRODUCT = "SELECT name, price ,origin ,img_urls, content, type,\r\n" + 
			"brand, sales_volume,recommend from product WHERE recommend='chu' AND ROWNUM<=2";

}
