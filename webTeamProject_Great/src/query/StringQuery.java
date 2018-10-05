package query;

import model.dao.CommonConstants;

public interface StringQuery {

	String NOTICE = "SELECT no, writer, img_urls, register_date, content FROM notice";
	
	String PAGE_LIST = "SELECT no, writer, img_urls,register_date, content" +
            "(SELECT no, writer, img_urls,register_date, content, ceil(rownum/"+CommonConstants.CONTENT_NUMBER_PER_PAGE+") AS page FROM" +
            "(SELECT no, writer, img_urls,to_char(time_posted, 'YYYY.MM.DD') register_date, content FROM board order by no desc)) where page=?";

	String TOTAL_COUNT = "select count(-1) from board";
	
	//��ȸ�� ������ �������� ������ ���� 4���� �����Ǹ� �˻��մϴ�.
	String SELECT_SHOWHOTRECIPE = "SELECT no, name, img_urls ,main_ingredients ,sub_ingredients, writer, register_date, type,\r\n" + 
				"hits, descript, content, tip,recommend from \r\n" + 
				"(SELECT no, name, img_urls ,main_ingredients ,sub_ingredients, writer, register_date, type,\r\n" + 
				"hits, descript, content, tip,recommend from recipe order by hits desc)\r\n" + 
				"where ROWNUM<=4";
	//������ �ѹ������� ���� ���ε�ϵ� ������ 4��
	String SELECT_SHOWNEWRECIPE = "SELECT no, name, img_urls ,main_ingredients ,sub_ingredients, writer, register_date, type,\r\n" + 
				"hits, descript, content, tip,recommend from \r\n" + 
				"(SELECT no, name, img_urls ,main_ingredients ,sub_ingredients, writer, register_date, type,\r\n" + 
				"hits, descript, content, tip,recommend from recipe order by no desc)\r\n" + 
				"where ROWNUM<=4";
		
	//��õ������ �����ڰ� �����ؼ� ��õ������ 2��
	String SELECT_SHOWRECOMMENDRECIPE = "SELECT no, name, img_urls ,main_ingredients ,sub_ingredients, writer, register_date, type,\r\n" + 
				"hits, descript, content, tip,recommend from recipe where recommend='chu' AND ROWNUM<=2";
		
	//�Ǹŷ� �� �������� ������ ���� 4�� ��ǰ �˻�
	String SELECT_SHOWHOTPRODUCT = "SELECT name, price ,origin ,img_urls, content, type,\r\n" + 
				"brand, sales_volume,recommend from \r\n" + 
				"(SELECT name, price ,origin ,img_urls, content, type,\r\n" + 
				"brand, sales_volume,recommend from product order by sales_volume desc)\r\n" + 
				"WHERE ROWNUM<=3";
		
	//��õ ��ǰ �����ڰ� �����ؼ� ��õ ������ 2��
	String SELECT_SHOWRECOMMENDPRODUCT = "SELECT name, price ,origin ,img_urls, content, type,\r\n" + 
				"brand, sales_volume,recommend from product WHERE recommend='chu' AND ROWNUM<=2";
		
		
	String INSERT_RECIPE = 
				"INSERT INTO RECIPE (no ,name ,img_urls ,main_ingredients ,sub_ingredients ,writer ,register_date ,type ,hits ,descript ,content ,tip)"
				+ " VALUES(?,?, ?, ?, ?, ?, sysdate, ?, ?, ?, ?, ? )";
		
	String INSERT_REVIEW = 
				"INSERT INTO REVIEW (no ,writer ,img_urls ,register_date ,content)"
				+ " VALUES(?, ?, ?, sysdate, ?)";
		
	String INSERT_PRODUCT = 
				"INSERT INTO PRODUCT (name ,price ,origin ,imgurls ,content ,type ,brand, sales_volume , recommend )"
				+ " VALUES(?, ?, ?, ?, ?, ?, ?,?,?)";
		
	
	String DELETE_RECIPE="DELETE FROM recipe WHERE no=?";
		
	String DELETE_REVIEW="DELETE FROM review WHERE no=?";
	
	String DELETE_PRODUCT="DELETE FROM product WHERE name=?";
	
	String UPDATE_RECIPE="UPDATE recipe SET name=?, img_urls=? , main_ingredients=?, sub_ingredients=?, writer=?, type=?, hits=?, descript=?, content=?, tip=? WHERE no=?";
	
	String UPDATE_REVIEW="UPDATE review SET writer=? , img_urls=?, content=? WHERE no=?";
		
	String UPDATE_PRODUCT="UPDATE product SET price=? , origin=?, imgurls=?, content=?, type=?, brand=? ,recommend=? ,sales_volume=? WHERE name=?";
		
		
	String INSERT_MEMBER = "INSERT INTO member(id,password,name,email,birthday,address) "
		            + "VALUES(?,?,?,?,?,?)";

	String SELECT_CHECK_ID = "SELECT count(-1) FROM member "
		              + "WHERE id=?";
	String SELECT_SEARCH_ID = "SELECT id FROM member "
		              + "WHERE name=? AND ssn=?";

	String SELECT_SEARCH_PASSWORD = "SELECT password FROM member "
		                     + "WHERE id=? AND name=? AND ssn=?";

	String UPDATE_MEMBER = "UPDATE member SET password=?, name=?, nickname=? WHERE id=?";

	String LOGIN_MEMBER = "SELECT id, password, name FROM member "
		           + "WHERE id=? AND password=?";

	String SEARCH_MEMBER = "SELECT id, password FROM member WHERE id=?";
		
}
