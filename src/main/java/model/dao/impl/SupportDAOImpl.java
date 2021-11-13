package model.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Support;
import model.dao.JDBCUtil;
import model.dao.SupportDAO;

public class SupportDAOImpl implements SupportDAO { //DAO를 인터페이스로 바꿀 것
	private JDBCUtil jdbcUtil = null;
	public SupportDAOImpl() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil 객체 생성
	}
		
	//후원 정보 테이블에 새로운 후원 정보를 생성.
	public int create(Support support) throws SQLException { //혹시 매개변수가 (Ecoer ecoer, Support support) ? 
		String sql = "INSERT INTO SUPPORT VALUES (?, ?, ?, ?, ?, ?)";		
		Object[] param = new Object[] {support.getSupportId(), support.getEcoerId(), 
				support.getProjectId(), support.getRewardId(), support.getAmount(), 
				support.getCard()};	
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil 에 insert문과 매개 변수 설정
		
		try {				
			int result = jdbcUtil.executeUpdate();	// insert 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;			
	}

	//기존의 후원 정보를 수정 ==> 카드 정보 변경 외에는 변동 없을듯
	// ==> 금액 변경이 필요하다면 주문을 취소하고 새로 주문할 것 
	public int update(Support support) throws SQLException {
		String sql = "UPDATE SUPPORT "
					+ "SET card=? "
					+ "WHERE support_id=?";
		Object[] param = new Object[] {support.getCard(), support.getSupportId()};				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil에 update문과 매개 변수 설정
			
		try {				
			int result = jdbcUtil.executeUpdate();	// update 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;
	}

	//supportID에 해당하는 후원을 삭제 ==> 후원 취소 기능으로 사용
	public int remove(int supportId) throws SQLException {
		String sql = "DELETE FROM SUPPORT WHERE support_id=?";		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {supportId});	// JDBCUtil에 delete문과 매개 변수 설정

		try {				
			int result = jdbcUtil.executeUpdate();	// delete 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;
	}

	/*
	 * 주어진 supportId에 해당하는 주문 정보를 데이터베이스에서 찾아 Support 도메인 클래스에 
	 * 저장하여 반환. ==> 필요할까? supportId를 별도로 알아낼 수 있을까??
	 */
	public Support findSupport(int supportId) throws SQLException {
        String sql = "SELECT support_id, ecoer_id, project_id, reward_id, amount, card "
        			+ "FROM SUPPORT "
        			+ "WHERE support_id=? ";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {supportId});

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {						// 주문 정보 발견
				Support support = new Support(		// Support 객체를 생성하여 주문 정보를 저장
					supportId,
					rs.getInt("ecoer_id"),
					rs.getInt("project_id"),
					rs.getInt("reward_id"),
					rs.getInt("amount"),
					rs.getString("card"));
				return support;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}

	//전체 후원 정보를 검색하여 List에 저장 및 반환 ==> 사용자 페이지에서 한꺼번에 보여주기
	public List<Support> findSupportList() throws SQLException {
        String sql = "SELECT support_id, ecoer_id, project_id, reward_id, amount, card " 
        		   + "FROM SUPPORT "
        		   + "ORDER BY support_id"; //날짜 순으로 정렬하는 게 좋지 않을까? 
		jdbcUtil.setSqlAndParameters(sql, null); // JDBCUtil에 query문 설정
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();			// query 실행			
			List<Support> supportList = new ArrayList<Support>();	// User들의 리스트 생성
			while (rs.next()) {
				Support support = new Support(	// Support 객체를 생성하여 현재 행의 정보를 저장
						rs.getInt("support_id"),
						rs.getInt("ecoer_id"),
						rs.getInt("project_id"),
						rs.getInt("reward_id"),
						rs.getInt("amount"),
						rs.getString("card"));
				supportList.add(support);		// List에 Support 객체 저장
			}		
			return supportList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
	
	//주어진 supportID에 해당하는 후원이 존재하는지 검사 (필요한가?)
	public boolean existingSupport(String supportId) throws SQLException {
		String sql = "SELECT count(*) FROM SUPPORT WHERE support_id=?";      
		jdbcUtil.setSqlAndParameters(sql, new Object[] {supportId});
		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {
				int count = rs.getInt(1);
				return (count == 1 ? true : false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return false;
	}
}
