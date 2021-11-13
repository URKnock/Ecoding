package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Creator;

public class CreatorDAO {
	private JDBCUtil jdbcUtil = null;
	
	public CreatorDAO() {			
		jdbcUtil = new JDBCUtil();
	}

	public int create(Creator creator) throws SQLException {
		String sql = "INSERT INTO creator VALUES (?, ?, ?, ?, ?)";
		Object[] param = new Object[]{};
		for(int i = 0; i < Creator.cols; i++) {
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

	public int update(Creator creator) throws SQLException {
		String sql = "UPDATE creator SET password=?";
		for(int i = 2; i < Creator.cols; i++) {
			sql += ", " + Creator.columns[i];
		}
		sql += "WHERE creator_id=?";
		
		Object[] param = new Object[]{};
		for(int i = 0; i < Creator.cols; i++) {
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

	public int remove(String creatorId) throws SQLException {
		String sql = "DELETE FROM creator WHERE creator_id=?";		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {creatorId});

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

	public Creator findCreator(String creatorId) throws SQLException {
        String sql = "SELECT password";
        String[] cols = Creator.columns;
        for(int i = 2; i < Creator.cols; i++) {
        	sql += ", " + cols[i];
        }
        sql += " FROM creator ";
        sql += "WHERE creator_id=? ";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {creatorId});
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			if (rs.next()) {
				Creator creator = new Creator();
				creator.setEcoerId(creatorId);
				for(int i = 1; i < Creator.cols; i++) {
					creator.setWithIndex(i, rs.getObject(cols[i]));
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

	public List<Creator> findCreatorList() throws SQLException {
        String sql = "SELECT * FROM creator ORDER BY creator_id";
        String[] cols = Creator.columns;
		jdbcUtil.setSqlAndParameters(sql, null);
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();		
			List<Creator> creatorList = new ArrayList<Creator>();
			while (rs.next()) {
				Creator creator = new Creator();
				for(int i = 0; i < Creator.cols; i++) {
					creator.setWithIndex(i, rs.getObject(cols[i]));
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
		String sql = "SELECT count(*) FROM creator WHERE creator_id=?";      
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
