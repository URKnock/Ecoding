package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.Reward;
import model.service.dto.RewardDTO;

public interface RewardDAO {

	public List<RewardDTO> getRewardList(int projectId) throws SQLException;
	public RewardDTO findRewardById(int rewardId) throws SQLException;
	public int insertReward(Reward reward);
	public int updateReward(RewardDTO reward) throws SQLException;
	public int deleteReward(RewardDTO reward) throws SQLException;
}
