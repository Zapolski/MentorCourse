package by.zapolski.week06.service;

import java.util.List;
import java.util.Map;

public interface FilterService {
	List<Map<String, Object>> queryForBooks(String[] author, String[] genre, Integer from, Integer to);
}
