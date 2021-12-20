package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Project;
import model.Support;
import model.service.dto.ProjectDTO;
import model.service.dto.SupportDTO;
import util.JDBCUtil;

public class SupportDAO {
	private JDBCUtil jdbcUtil = null;
	public SupportDAO() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil 객체 생성
	}
		
	//후원 정보 테이블에 새로운 후원 정보를 생성.
	public int create(SupportDTO support, int price) throws SQLException { //혹시 매개변수가 (Ecoer ecoer, Support support) ? 
		String sql = null;
		try {				
			sql = "INSERT INTO SUPPORT VALUES (seq_reward.nextval, ?, ?, ?, ?, ?, ?, null)";		
			Object[] param = new Object[] {support.getEcoerId(), support.getProjectId(),
					support.getRewardId(), support.getAmount(), support.getBank(), support.getCard()};
			jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil 에 insert문과 매개 변수 설정
			int result1 = jdbcUtil.executeUpdate();	// insert 문 실행
			
			sql = "UPDATE PROJECT SET current_price = ? WHERE project_id = ?";
			Object[] param2 = new Object[] {price, support.getProjectId()};
			jdbcUtil.setSqlAndParameters(sql, param2);
			int result2 = jdbcUtil.executeUpdate();
			
			if (result1 == 0 && result2 == 0) { throw new Exception(); }
			
			return result1 + result2;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;			
	}

	// 결제 정보 수정
	public int update(SupportDTO support) throws SQLException {
		String sql = "UPDATE SUPPORT SET bank = ?, card = ? WHERE support_id = ?";
		Object[] param = new Object[] {support.getBank(), support.getCard(), support.getSupportId()};				
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
	
	// 리워드 수정
	public int updateReward(SupportDTO support, Project project) throws SQLException {
		String sql = null;
		try {
			// 서포트 테이블 수정
			sql = "UPDATE SUPPORT SET reward_id = ?, amount = ? WHERE support_id = ?";
			Object[] param1 = new Object[] {support.getRewardId(), support.getAmount(), support.getSupportId()};
			jdbcUtil.setSqlAndParameters(sql, param1);	// JDBCUtil 에 insert문과 매개 변수 설정
			int result1 = jdbcUtil.executeUpdate();	// insert 문 실행
			
			sql = "UPDATE PROJECT SET current_price = ? WHERE project_id = ?";
			Object[] param2 = new Object[] {project.getCurrentPrice(), support.getProjectId()};
			jdbcUtil.setSqlAndParameters(sql, param2);
			int result2 = jdbcUtil.executeUpdate();
			
			if (result1 == 0 && result2 == 0) { throw new Exception(); }
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;
	}

	//supportID에 해당하는 후원을 삭제 ==> 후원 취소 기능으로 사용
	public int remove(int supportId, Project project) throws SQLException {
		String sql = null;
		try {
			// 서포트 테이블 삭제
			sql = "DELETE FROM SUPPORT WHERE support_id = ?";
			Object[] param1 = new Object[] { supportId };
			jdbcUtil.setSqlAndParameters(sql, param1);	// JDBCUtil 에 insert문과 매개 변수 설정
			int result1 = jdbcUtil.executeUpdate();	// insert 문 실행
			
			// project의 currentPrice 수정
			sql = "UPDATE PROJECT SET current_price = ? WHERE project_id = ?";
			Object[] param2 = new Object[] {project.getCurrentPrice(), project.getProjectId()};
			jdbcUtil.setSqlAndParameters(sql, param2);
			int result2 = jdbcUtil.executeUpdate();
			
			if (result1 == 0 && result2 == 0) { throw new Exception(); }
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;
	}

	public SupportDTO findSupport(String ecoerId, int projectId) throws SQLException {
		String sql = "SELECT support_id, ecoer_id, project_id, reward_id, amount, bank, card "
    			+ "FROM SUPPORT s "
    			+ "WHERE ecoer_id = ? AND project_id = ?";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {ecoerId, projectId});
	
		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {						// 주문 정보 발견
				SupportDTO support = new SupportDTO(		// Support 객체를 생성하여 주문 정보를 저장
					rs.getInt("support_id"),
					rs.getString("ecoer_id"),
					rs.getInt("project_id"),
					rs.getInt("reward_id"),
					rs.getInt("amount"),
					rs.getString("bank"),
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
	
	public SupportDTO findSupport(int supportId) throws SQLException {
		String sql = "SELECT support_id, ecoer_id, project_id, reward_id, amount, bank, card "
    			+ "FROM SUPPORT s "
    			+ "WHERE support_id = ?";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {supportId});
	
		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {						// 주문 정보 발견
				SupportDTO support = new SupportDTO(		// Support 객체를 생성하여 주문 정보를 저장
					rs.getInt("support_id"),
					rs.getString("ecoer_id"),
					rs.getInt("project_id"),
					rs.getInt("reward_id"),
					rs.getInt("amount"),
					rs.getString("bank"),
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
						rs.getString("bank"),
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
	
	public List<Project> getSupportProjectList(String ecoerId) {
		String sql = "SELECT p.project_id, p.title, p.image, p.simple_info, "
				+ "p.target_price, p.current_price ";
        sql += "FROM support i JOIN project p ON i.project_id = p.project_id ";
        sql += "WHERE i.ecoer_id=?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {ecoerId});
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<Project> projectList = new ArrayList<Project>();
			while (rs.next()) {				
				Project dto = new Project();
				dto.setProjectId(rs.getInt("project_id"));
				dto.setTitle(rs.getString("title"));
				dto.setImage(rs.getString("image"));
				dto.setSimpleInfo(rs.getString("simple_info"));
				dto.setTargetPrice(rs.getInt("target_price"));
				dto.setCurrentPrice(rs.getInt("current_price"));
				
				projectList.add(dto);
			}
			return projectList;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
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
	
	// 후원자수 카운팅
	public int countSupporter(int projectId) throws SQLException {
		String sql = "SELECT count(*) FROM SUPPORT WHERE project_id = ?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {projectId});
		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {
				int count = rs.getInt(1);
				return count;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return 0;
	}
	
	public boolean isSupportProject(SupportDTO supportDTO) throws SQLException {
		String sql = "SELECT count(*) FROM SUPPORT WHERE ecoer_id=? AND project_id=?";      
		try {
			jdbcUtil.setSqlAndParameters(sql, new Object[] {supportDTO.getEcoerId(), supportDTO.getProjectId()});
			ResultSet rs = jdbcUtil.executeQuery();
			if (rs.next()) {
				int count = rs.getInt(1);
				return (count >= 1 ? true : false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return false;
	}
}
