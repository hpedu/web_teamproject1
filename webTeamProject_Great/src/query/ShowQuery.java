package query;

public interface ShowQuery {
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
