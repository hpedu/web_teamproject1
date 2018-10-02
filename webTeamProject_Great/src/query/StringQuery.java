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
}
