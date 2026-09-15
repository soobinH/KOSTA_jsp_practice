package dao;

import java.util.Map;

public interface HeartDao {
	Integer selectHeart(Map<String, Object> param) throws Exception;
}
