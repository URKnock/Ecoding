package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Ecoer;

public class EcoerDAO {
	private JDBCUtil jdbcUtil = null;
	
	public EcoerDAO() {			
		jdbcUtil = new JDBCUtil();
	}

	public int create(Ecoer ecoer) throws SQLException {
		String sql = "INSERT INTO ecoer VALUES (?, ?, ?, ?, ?, ?, ?)";
		Object[] param = new Object[]{};
		for(int i = 0; i < Ecoer.cols; i++) {
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

	public int update(Ecoer ecoer) throws SQLException {
		String sql = "UPDATE ecoer SET password=?";
		for(int i = 2; i < Ecoer.cols; i++) {
			sql += ", " + Ecoer.columns[i];
		}
		sql += "WHERE ecoer_id=?";
		
		Object[] param = new Object[]{};
		for(int i = 0; i < Ecoer.cols; i++) {
			param[i] = ecoer.getWithIndex(i);
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

	public int remove(String ecoerId) throws SQLException {
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

	public Ecoer findEcoer(String ecoerId) throws SQLException {
        String sql = "SELECT password";
        String[] cols = Ecoer.columns;
        for(int i = 2; i < Ecoer.cols; i++) {
        	sql += ", " + cols[i];
        }
        sql += " FROM ecoer ";
        sql += "WHERE ecoer_id=? ";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {ecoerId});
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			if (rs.next()) {
				Ecoer ecoer = new Ecoer();
				ecoer.setEcoerId(ecoerId);
				for(int i = 1; i < Ecoer.cols; i++) {
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

	public List<Ecoer> findEcoerList() throws SQLException {
        String sql = "SELECT * FROM ecoer ORDER BY ecoer_id";
        String[] cols = Ecoer.columns;
		jdbcUtil.setSqlAndParameters(sql, null);
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();		
			List<Ecoer> ecoerList = new ArrayList<Ecoer>();
			while (rs.next()) {
				Ecoer ecoer = new Ecoer();
				for(int i = 0; i < Ecoer.cols; i++) {
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

	public boolean existingEcoer(String ecoerId) throws SQLException {
		String sql = "SELECT count(*) FROM ecoer WHERE ecoer_id=?";      
		jdbcUtil.setSqlAndParameters(sql, new Object[] {ecoerId});

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
