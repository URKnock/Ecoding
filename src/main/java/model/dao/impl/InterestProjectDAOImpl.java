package model.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dao.InterestProjectDAO;
import model.service.dto.InterestProjectDTO;
import model.util.JDBCUtil;

public class InterestProjectDAOImpl implements InterestProjectDAO {
	private JDBCUtil jdbcUtil = null;
	
	public InterestProjectDAOImpl() {			
		jdbcUtil = new JDBCUtil();
	}

	public int insert(InterestProjectDTO interest_project) {
		String sql = "INSERT INTO interest_project VALUES (?, ?)";
		Object[] param = new Object[]{};
		for(int i = 0; i < InterestProjectDTO.cols; i++) {
			param[i] = interest_project.getWithIndex(i);
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

	public int update(InterestProjectDTO interest_project) {
		String sql = "UPDATE interest_project SET project_id=?";
		sql += "WHERE ecoer_id=?";
		
		Object[] param = new Object[]{};
		for(int i = 0; i < InterestProjectDTO.cols; i++) {
			param[i] = interest_project.getWithIndex(i);
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
		String sql = "DELETE FROM interest_project WHERE ecoer_id=?";		
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

	public InterestProjectDTO findInterestProject(String ecoerId) {
        String sql = "SELECT *";
        sql += " FROM interest_project ";
        sql += "WHERE ecoer_id=?";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {ecoerId});
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			if (rs.next()) {
				InterestProjectDTO interest_project = new InterestProjectDTO();
				interest_project.setEcoerId(ecoerId);
				interest_project.setProjectId(rs.getInt("project_id"));
				return interest_project;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	public List<InterestProjectDTO> getInterestProjectList() {
        String sql = "SELECT * FROM interest_project ORDER BY ecoer_id";
        String[] cols = InterestProjectDTO.columns;
		jdbcUtil.setSqlAndParameters(sql, null);
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();		
			List<InterestProjectDTO> interest_projectList = new ArrayList<InterestProjectDTO>();
			while (rs.next()) {
				InterestProjectDTO interest_project = new InterestProjectDTO();
				for(int i = 0; i < InterestProjectDTO.cols; i++) {
					interest_project.setWithIndex(i, rs.getObject(cols[i]));
				}
				interest_projectList.add(interest_project);
			}		
			return interest_projectList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	public boolean existingInterestProject(String interest_projectId) throws SQLException {
		String sql = "SELECT count(*) FROM interest_project WHERE ecoer_id=?";      
		jdbcUtil.setSqlAndParameters(sql, new Object[] {interest_projectId});

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
