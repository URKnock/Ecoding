package model.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;
import model.dao.RewardDAO;
import model.service.dto.RewardDTO;

public class RewardDAOImpl implements RewardDAO {

	private static JDBCUtil jdbcUtil = null;
	
	public RewardDAOImpl() {
		jdbcUtil = new JDBCUtil();
	}
	
	// projectId를 통해 리워드 검색 후 리스트 반환
	public List<RewardDTO> getRewardList(int projectId) throws SQLException {
		
		String listQuery = "SELECT reward_id, name, reward_price, reward_info "
				+ "FROM reward "
				+ "WHERE project_id = ?";
		
		Object[] param = new Object[] { projectId };
		jdbcUtil.setSqlAndParameters(listQuery, param);
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<RewardDTO> list = new ArrayList<RewardDTO>();
			
			while (rs.next()) {
				RewardDTO dto = new RewardDTO(
						rs.getInt("reward_id"),
						rs.getString("name"),
						rs.getInt("reward_price"),
						rs.getString("reward_info"));
				list.add(dto);
			}
			
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		
		return null;
	}
	
	// 리워드ID를 통해 리워드 반환
	public RewardDTO findRewardById(int rewardId) throws SQLException {
		String searchQuery = "SELECT reward_id, name, reward_price, reward_info " // 후에 next 적용
				+ "FROM reward "
				+ "WHERE reward_id = ?";
		
		Object[] param = new Object[] { rewardId };
		jdbcUtil.setSqlAndParameters(searchQuery, param);
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			RewardDTO dto = null;
			
			if (rs.next()) {
				dto = new RewardDTO(
						rs.getInt("reward_id"),
						rs.getString("name"),
						rs.getInt("reward_price"),
						rs.getString("reward_info"));
			}
			
			return dto;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		
		return null;
	}
	
	// 리워드DTO와 프로젝트ID를 받아서 해당 프로젝트ID에 리워드 삽입
	public int insertReward(RewardDTO reward, int projectId) throws SQLException {
		int result = 0;
		String insertQuery = "INSERT INTO project_notice VALUES (?, ?, ?, ?, ?)";
		
		Object[] param = new Object[] {
				reward.getRewardId(), projectId, reward.getName(),
				reward.getRewardPrice(), reward.getRewardInfo() };
		jdbcUtil.setSqlAndParameters(insertQuery, param);
		
		try {
			result = jdbcUtil.executeUpdate();
		} catch  (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return result;
	}
	
	// 리워드 수정
	public int updateReward(RewardDTO reward) throws SQLException {
		int result = 0;
		String insertQuery = "UPDATE reward "
				+ "SET name = ?, reward_price = ?, reward_info = ? "
				+ "WHERE reward_id = ?";
		
		Object[] param = new Object[] {
				reward.getName(), reward.getRewardPrice(), reward.getRewardInfo(), reward.getRewardId() };
		jdbcUtil.setSqlAndParameters(insertQuery, param);
		
		try {
			result = jdbcUtil.executeUpdate();
		} catch  (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return result;
	}
	
	// 리워드 삭제
	public int deleteReward(RewardDTO reward) throws SQLException {
		int result = 0;
		String insertQuery = "DELETE reward WHERE reward_id = ?";
		
		Object[] param = new Object[] { reward.getRewardId() };
		jdbcUtil.setSqlAndParameters(insertQuery, param);
		
		try {
			result = jdbcUtil.executeUpdate();
		} catch  (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return result;
	}
}
