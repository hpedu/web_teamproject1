package query;

import model.dao.CommonConstants;

public interface StringQuery {

	String REVIEW = "SELECT no, writer, img_urls, register_date, content, category FROM notice WHERE category = ?";
	
	String PAGE_LIST = "SELECT no, writer, img_urls,register_date, content" +
            "(SELECT no, writer, img_urls,register_date, content, ceil(rownum/"+CommonConstants.CONTENT_NUMBER_PER_PAGE+") AS page FROM" +
            "(SELECT no, writer, img_urls,to_char(time_posted, 'YYYY.MM.DD') register_date, content FROM board order by no desc)) where page=?";

	String TOTAL_COUNT = "select count(-1) from board";
}
