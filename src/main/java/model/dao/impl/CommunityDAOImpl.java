package model.dao.impl;

import java.sql.ResultSet;
import model.dao.CommunityDAO;
import model.util.JDBCUtil;
import model.service.dto.CommunityDTO;

public class CommunityDAOImpl implements CommunityDAO{
	private JDBCUtil jdbcUtil = null;
	
	private static String query = "SELECT COMMUNITY.community_id AS community_id, COMMUNITY.name AS community_name";
		
	public CommunityDAOImpl() {
		jdbcUtil = new JDBCUtil();
	}	

	public int insertCommunity(CommunityDTO comm) {
		int result = 0;
		String insertQuery = "INSERT INTO COMMUNITY VALUES (seq_community.nextval, ?) ";
		
		Object[] param = new Object[] {comm.getName()};
		jdbcUtil.setSqlAndParameters(insertQuery, param); // JDBCUtil 에 insert문과 매개변수 설정
		
		try {
			result = jdbcUtil.executeUpdate(); // insert 문 실행
		} catch (Exception ex) { 
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return result;
	}

	public int updateCommunity(CommunityDTO comm) {
		int result = 0;
		String updateQuery = "UPDATE COMMUNITY SET name = ? WHERE community_id = ?";
		
		Object[] param = new Object[] {comm.getCommunityId(), comm.getName()};
		jdbcUtil.setSqlAndParameters(updateQuery, param); // JDBCUtil 에 update문과 매개변수 설정
		
		try {
			result = jdbcUtil.executeUpdate(); // update 문 실행
		} catch (Exception ex) { 
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return result;
	}

	public int deleteCommunity(int commCode) {
		int result = 0;
		String deleteQuery = "DELETE FROM COMMUNITY WHERE community_id = ?";
		
		Object[] param = new Object[] {commCode};
		jdbcUtil.setSqlAndParameters(deleteQuery, param); // JDBCUtil 에 update문과 매개변수 설정
		
		try {
			result = jdbcUtil.executeUpdate(); // update 문 실행
		} catch (Exception ex) { 
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return result;
	}

	public CommunityDTO getCommunity(int commCode) {
		String searchQuery = query + "FROM COMMUNITY WHERE COMMUNITY.community_id = ?";
		Object[] param = new Object[] {commCode};
		jdbcUtil.setSqlAndParameters(searchQuery, param); 
		
		jdbcUtil.setSql(searchQuery);
		jdbcUtil.setParameters(param);
	
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			CommunityDTO dto = null;
			if (rs.next()) {
				dto = new CommunityDTO();
				dto.setCommunityId(rs.getInt("community_id"));
				dto.setName(rs.getString("community_name"));
			}
			return dto;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}
}
