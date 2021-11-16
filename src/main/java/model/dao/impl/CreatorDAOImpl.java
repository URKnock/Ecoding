package model.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dao.CreatorDAO;
import model.service.dto.CreatorDTO;
import model.service.dto.EcoerDTO;
import model.util.JDBCUtil;

public class CreatorDAOImpl implements CreatorDAO {
	private JDBCUtil jdbcUtil = null;
	
	public CreatorDAOImpl() {			
		jdbcUtil = new JDBCUtil();
	}

	public int insert(CreatorDTO creator) {
		String sql = "INSERT INTO creator VALUES (?, ?, ?, ?, ?)";
		Object[] param = new Object[]{};
		for(int i = 0; i < CreatorDTO.cols; i++) {
			param[i] = creator.getWithIndex(i);
		}				
		jdbcUtil.setSqlAndParameters(sql, param);

		try {				
			int result = jdbcUtil.executeUpdate();
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();
		}		
		return 0;			
	}

	public int update(CreatorDTO creator) {
		String sql = "UPDATE creator SET password=?";
		for(int i = 2; i < CreatorDTO.cols; i++) {
			sql += ", " + CreatorDTO.columns[i];
		}
		sql += "WHERE creator_id=?";
		
		Object[] param = new Object[]{};
		for(int i = 0; i < CreatorDTO.cols; i++) {
			param[i] = creator.getWithIndex(i);
		}
		jdbcUtil.setSqlAndParameters(sql, param);
			
		try {				
			int result = jdbcUtil.executeUpdate();
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}		
		return 0;
	}

	public int delete(String ecoerId) {
		String sql = "DELETE FROM creator WHERE ecoer_id=?";		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {ecoerId});

		try {				
			int result = jdbcUtil.executeUpdate();
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}		
		return 0;
	}

	public CreatorDTO findCreator(String ecoerId) {
        String sql = "SELECT * FROM creator JOIN ecoer USING(ecoer_id) WHERE ecoer_id=?";
        String[] cols1 = CreatorDTO.columns;
        String[] cols2 = EcoerDTO.columns;
        jdbcUtil.setSqlAndParameters(sql, new Object[] {ecoerId});
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			if (rs.next()) {
				CreatorDTO creator = new CreatorDTO();
				creator.setEcoerId(ecoerId);
				for(int i = 1; i < CreatorDTO.cols + EcoerDTO.cols; i++) {
					if(i < CreatorDTO.cols)
						creator.setWithIndex(i, rs.getObject(cols1[i]));
					else
						creator.setWithIndex(i, rs.getObject(cols2[i]));
				}
				return creator;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	public List<CreatorDTO> getCreatorList() {
        String sql = "SELECT * FROM creator JOIN ecoer USING(ecoer_id)";
        String[] cols1 = CreatorDTO.columns;
        String[] cols2 = EcoerDTO.columns;
		jdbcUtil.setSqlAndParameters(sql, null);
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();		
			List<CreatorDTO> creatorList = new ArrayList<CreatorDTO>();
			while (rs.next()) {
				CreatorDTO creator = new CreatorDTO();
				for(int i = 1; i < CreatorDTO.cols + EcoerDTO.cols; i++) {
					if(i < CreatorDTO.cols)
						creator.setWithIndex(i, rs.getObject(cols1[i]));
					else
						creator.setWithIndex(i, rs.getObject(cols2[i]));
				}
				creatorList.add(creator);
			}		
			return creatorList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	public boolean existingCreator(String creatorId) throws SQLException {
		String sql = "SELECT count(*) FROM creator WHERE ecoer_id=?";      
		jdbcUtil.setSqlAndParameters(sql, new Object[] {creatorId});

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			if (rs.next()) {
				int count = rs.getInt(1);
				return (count == 1 ? true : false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return false;
	}

}