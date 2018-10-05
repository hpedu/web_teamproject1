
package query;

import model.dao.CommonConstants;

public interface ShowQuery {
	// 조회수 순으로 내림차순 정렬후 상위 4개의 레서피를 검색합니다.
	// 조회수 순으로 내림차순 정렬후 상위 4개의 레서피를 검색합니다.
		String SELECT_SHOWHOTRECIPE = "SELECT num, name, img_urls ,main_ingredients ,sub_ingredients, writer, register_date, type,\r\n"
				+ "hits, descript, content, tip,recommend from \r\n"
				+ "(SELECT num, name, img_urls ,main_ingredients ,sub_ingredients, writer, register_date, type,\r\n"
				+ "hits, descript, content, tip,recommend from recipe order by hits desc)\r\n" + "where ROWNUM<=4";
		// 시퀀스 넘버에따른 제일 새로등록된 레서피 4개
		String SELECT_SHOWNEWRECIPE = "SELECT no, name, img_urls ,main_ingredients ,sub_ingredients, writer, register_date, type,\r\n"
				+ "hits, descript, content, tip,recommend from \r\n"
				+ "(SELECT no, name, img_urls ,main_ingredients ,sub_ingredients, writer, register_date, type,\r\n"
				+ "hits, descript, content, tip,recommend from recipe order by no desc)\r\n" + "where ROWNUM<=4";

		// 추천레서피 관리자가 지정해서 추천레서피 2개
		String SELECT_SHOWRECOMMENDRECIPE = "SELECT num, name, img_urls ,main_ingredients ,sub_ingredients, writer, register_date, type,\r\n"
				+ "hits, descript, content, tip, recommend from recipe where recommend='true' AND ROWNUM<=4";

		// 판매량 순 내림차순 정렬후 상위 4개 상품 검색
		String SELECT_SHOWHOTPRODUCT = "SELECT name, price ,origin ,img_urls, content, type,\r\n"
				+ "brand, sales_volume,recommend, amount from \r\n"
				+ "(SELECT name, price ,origin ,img_urls, content, type,\r\n"
				+ "brand, sales_volume,recommend, amount from product order by sales_volume desc)\r\n" + "WHERE ROWNUM<=3";

		// 추천 상품 관리자가 지정해서 추천 레서피 2개
		String SELECT_SHOWRECOMMENDPRODUCT = "SELECT name, price ,origin ,img_urls, content, type,\r\n"
				+ "brand, sales_volume,recommend, amount from product WHERE recommend='chu' AND ROWNUM<=2";

		// 레시피의 상품들 :: no번호 상품의 서브재료들의 상품을 전부 검색 하는 쿼리 ( 서브재료 등록시 , 로 구분해서 등록해야 하고 부재료 이름과 제품이름이 동일해야함.)
		String SELECT_SHOWINGREDIENTSPRODUCT = "SELECT * FROM product where name in(select distinct TRIM(REGEXP_SUBSTR(ORG_DATA, '[^,]+', 1, LEVEL)) AS SPLIT_DATA\r\n"
				+ "from (SELECT sub_ingredients AS ORG_DATA FROM recipe where no = ? )\r\n"
				+ "CONNECT BY  INSTR(ORG_DATA, ',', 1, LEVEL - 1) > 0)";
		
		// 관련 레시피 메소드 같은 타입인 레시피들이 나열된다.
		String SELECT_SHOWRELATEDRECIPE = "select*from recipe where type =(select type from recipe where no = ?)";
		
		String SELECT_SHOWRECIPE = "select*from recipe where num=?";
	
	String REVIEW = "SELECT no, writer, img_urls, register_date, content FROM review";
	
	String NOTICE = "SELECT no, writer, register_date, content FROM notice";
	
	String REVIEW_PAGE_LIST = "SELECT no, writer, img_urls,register_date, content" +
            "(SELECT no, writer, img_urls,register_date, content, ceil(rownum/"+CommonConstants.CONTENT_NUMBER_PER_PAGE+") AS page FROM" +
            "(SELECT no, writer, img_urls,to_char(time_posted, 'YYYY.MM.DD') register_date, content FROM board order by no desc)) where page=?";
	
	String NOTICE_PAGE_LIST = "SELECT no, writer, register_date, content" +
            "(SELECT no, writer, register_date, content, ceil(rownum/"+CommonConstants.CONTENT_NUMBER_PER_PAGE+") AS page FROM" +
            "(SELECT no, writer, to_char(time_posted, 'YYYY.MM.DD') register_date, content FROM board order by no desc)) where page=?";

	String REVIEW_TOTAL_COUNT = "select count(-1) from review";
	
	String NOTICE_TOTAL_COUNT = "select count(-1) from notice";
	
	String RECOMMEND_RECIPE = "SELECT no, title, writer, content, hits FROM "
			+ "(SELECT no, title, writer, content, hits, CEIL(rownum/5) as page FROM "
			+ "(SELECT no, title, writer, content, hits FROM board ORDER BY hits DESC)) "
			+ "WHERE page=1";
}

