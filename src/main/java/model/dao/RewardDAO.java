package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dao.JDBCUtil;
import model.service.dto.RewardDTO;

public class RewardDAO {

	private static JDBCUtil jdbcUtil = new JDBCUtil();
	
	public List<RewardDTO> getRewardList(int projectId) throws SQLException {
		
		String listQuery = "SELECT reward_id, project_id, name, reward_price, reward_info "
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
						rs.getInt("project_id"),
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
	
	public RewardDTO getRewardById(int rewardId) throws SQLException {
		String searchQuery = "SELECT reward_id, project_id, name, reward_price, reward_info " // 후에 next 적용
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
						rs.getInt("project_id"),
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
	
	public int insertReward(RewardDTO reward) throws SQLException {
		int result = 0;
		String insertQuery = "INSERT INTO project_notice VALUES (?, ?, ?, ?, ?)";
		
		Object[] param = new Object[] {
				reward.getRewardId(), reward.getProject_id(), reward.getName(),
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
	
	public int updateReward(RewardDTO reward) throws SQLException {
		int result = 0;
		String insertQuery = "UPDATE reward "
				+ "SET name = ?, reward_price = ?, reward_info = ? "
				+ "WHERE reward_id = ?";
		
		Object[] param = new Object[] {
				reward.getName(), reward.getRewardPrice(), reward.getRewardInfo(), reward.getProject_id() };
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
