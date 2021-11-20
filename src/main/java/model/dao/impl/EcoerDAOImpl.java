package model.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.dao.EcoerDAO;
import model.service.dto.EcoerDTO;
import util.JDBCUtil;

public class EcoerDAOImpl implements EcoerDAO{
	private JDBCUtil jdbcUtil = null;
	
	public EcoerDAOImpl() {			
		jdbcUtil = new JDBCUtil();
	}

	public int insert(EcoerDTO ecoer) {
		String sql = "INSERT INTO ecoer VALUES (?, ?, ?, ?, ?, ?, ?)";
		Object[] param = new Object[]{};
		for(int i = 0; i < EcoerDTO.cols; i++) {
			param[i] = ecoer.getWithIndex(i);
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

	public int update(EcoerDTO ecoer) {
		String sql = "UPDATE ecoer SET password=?";
		for(int i = 2; i < EcoerDTO.cols; i++) {
			sql += ", " + EcoerDTO.columns[i] + "=?";
		}
		sql += " WHERE ecoer_id=?";
		
		Object[] param = new Object[]{};
		for(int i = 0; i < EcoerDTO.cols - 2; i++) { //param의 0에 password부터 채운다. (0번~7번)
			if(ecoer.getWithIndex(i + 1) != null) //여기서 자꾸 index 오류남
				param[i] = ecoer.getWithIndex(i + 1);
		}
		param[EcoerDTO.cols - 1] = ecoer.getEcoerId(); //마지막 where절에 id를 넣는다. (8번)
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
		String sql = "DELETE FROM ecoer WHERE ecoer_id=?";		
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

	public EcoerDTO findEcoer(String ecoerId) {
        String sql = "SELECT password";
        String[] cols = EcoerDTO.columns;
        for(int i = 2; i < EcoerDTO.cols; i++) {
        	sql += ", " + cols[i];
        }
        sql += " FROM ecoer ";
        sql += "WHERE ecoer_id=? ";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {ecoerId});
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			if (rs.next()) {
				EcoerDTO ecoer = new EcoerDTO();
				ecoer.setEcoerId(ecoerId);
				for(int i = 1; i < EcoerDTO.cols; i++) {
					ecoer.setWithIndex(i, rs.getObject(cols[i]));
				}
				return ecoer;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	public List<EcoerDTO> getEcoerList() {
        String sql = "SELECT * FROM ecoer ORDER BY ecoer_id";
        String[] cols = EcoerDTO.columns;
		jdbcUtil.setSqlAndParameters(sql, null);
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();		
			List<EcoerDTO> ecoerList = new ArrayList<EcoerDTO>();
			while (rs.next()) {
				EcoerDTO ecoer = new EcoerDTO();
				for(int i = 0; i < EcoerDTO.cols; i++) {
					ecoer.setWithIndex(i, rs.getObject(cols[i]));
				}
				ecoerList.add(ecoer);
			}		
			return ecoerList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	public boolean existingEcoer(String ecoerId) {
		String sql = "SELECT count(*) FROM ecoer WHERE ecoer_id=?";      
		try {
			jdbcUtil.setSqlAndParameters(sql, new Object[] {ecoerId});
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
