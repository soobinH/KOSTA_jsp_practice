package dao;

import java.util.List;
import java.util.Map;

import dto.Facility;

public interface FacilityDao {
	Integer insertFacility(Facility facility) throws Exception;
	Facility selectFacility(Integer num) throws Exception;
	void updateFacility(Facility facility) throws Exception;
	List<Facility> selectFacilityList(Integer row) throws Exception;
	Integer selectFacilityCnt(Map<String,Object> param) throws Exception;
	void deleteFacility(Integer num) throws Exception;
	Map<String, Object> selectFacilityWithMember(Integer num) throws Exception;
	List<Map<String,Object>> selectFacilityWithMemberList(Map<String,Object> param) throws Exception; 
	Integer selectFacilityWithMemberCnt(Map<String, Object> param) throws Exception;
}
