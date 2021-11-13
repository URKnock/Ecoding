package model.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Project;
import model.dao.JDBCUtil;
import model.dao.ProjectDAO;

public class ProjectDAOImpl implements ProjectDAO {
	private JDBCUtil jdbcUtil = null;
	public ProjectDAOImpl() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil 객체 생성
	}
		
	//비워도 되는 필드는 null 째로 insert ==> 별도의 처리가 필요할지? 
	//외래키는 어떻게 가져오는지?? ==> 다른 객체도 같이 매개변수로 받나? 
	public int create(Project project) throws SQLException {
		String sql = "INSERT INTO PROJECT VALUES (?, ?, ?, ?, ?, ?"
				+ "?, ?, ?, ?, ?, ?"
				+ "?, ?, ?, ?, ?, ?"
				+ "?, ?, ?)"; //21개의 컬럼
		Object[] param = new Object[] {project.getProjectId(), project.getCreatorId(), project.getRewardId(),
				project.getTitle(), project.getImage(), project.getSimpleInfo(),
				project.getCategory(), project.getHashTag(), project.getEcoTag(),
				project.getEcoScore(), project.getTargetPrice(), project.getCurrentPrice(),
				project.getStartDate(), project.getEndDate(), project.getPaymentDate(),
				project.getDeliveryDate(), project.getDetailInfo(), project.getPlanInfo(),
				project.getExchangeInfo(), project.getProjectVideo(), project.getProjectFile()};
		//별도의 null 처리 예시: (user.getCommId() != 0) ? user.getCommId() : null;				
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

	// 기존의 프로젝트 정보를 수정.
	// 일부만 수정하고 싶을 때는 어떻게 할까? ==> 교수님께 쪽지
	public int update(Project project) throws SQLException {
		String sql = "UPDATE PROJECT "
					+ "SET password=?, name=?, email=?, phone=?, commId=? "
					+ "WHERE project_id=?";
		Object[] param = new Object[] {user.getPassword(), user.getName(), 
					user.getEmail(), user.getPhone(), 
					(user.getCommId()!=0) ? user.getCommId() : null, 
					user.getUserId()};				
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

	//프로젝트 ID에 해당하는 프로젝트를 삭제.
	public int remove(String projectId) throws SQLException {
		String sql = "DELETE FROM PROJECT WHERE projectId=?";		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {projectId}); // JDBCUtil에 delete문과 매개 변수 설정
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

	// 주어진 projectId에 해당하는 프로젝트 정보를 데이터베이스에서 찾아 Project 도메인 클래스에 저장하여 반환.
	// 근데 이 필드 진짜 다 가져오는거??? ==> 쪽지로 여쭤보기
	public Project findProject(int projectId) throws SQLException {
        String sql = "SELECT creatorId, rewardID, title, image, simpleInfo "
        			+ "FROM PROJECT "
        			+ "WHERE Project=? ";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {projectId});	// JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();	// query 실행
			if (rs.next()) {						// 학생 정보를 발견하면
				Project project = new Project(		// Project 객체를 생성하여 학생 정보를 저장
					projectId,
					rs.getInt("creatorId"),
					rs.getInt("rewardID"),
					rs.getString("title"),
					rs.getString("image"),					
					rs.getString("simpleInfo"),
					null, null, null,
					0.0, 0, 0,
					null, null, null, null,
					"", "", "", "", "");
				return project;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}

	//전체 프로젝트 정보를 검색하여 List에 저장 및 반환
	public List<Project> findProjectList() throws SQLException {
        String sql = "SELECT userId, name, email, NVL(commId,0) AS commId, cName " 
        		   + "FROM PROJECT "
        		   + "ORDER BY projectId"; //등록 순으로 정렬? id 순으로 정렬?
		jdbcUtil.setSqlAndParameters(sql, null);		// JDBCUtil에 query문 설정
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();			// query 실행			
			List<Project> projectList = new ArrayList<Project>();	// User들의 리스트 생성
			while (rs.next()) {
				Project project = new Project(			// User 객체를 생성하여 현재 행의 정보를 저장
					rs.getString("userId"),
					null,
					rs.getString("name"),
					rs.getString("email"),
					null,
					rs.getInt("commId"),
					rs.getString("cName"));
				projectList.add(project);				// List에 User 객체 저장
			}		
			return projectList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
	
	//전체 프로젝트 정보를 검색한 후 현재 페이지와 페이지당 출력할 사용자 수를 이용하여, 해당하는 프로젝트만을 List에 저장하여 반환.
	public List<Project> findProjectList(int currentPage, int countPerPage) throws SQLException {
		String sql = "SELECT userId, name, email, NVL(commId, 0), cName " 
					+ "FROM PROJECT "
					+ "ORDER BY userId";
		jdbcUtil.setSqlAndParameters(sql, null,					// JDBCUtil에 query문 설정
				ResultSet.TYPE_SCROLL_INSENSITIVE,				// cursor scroll 가능
				ResultSet.CONCUR_READ_ONLY);						
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();				// query 실행			
			int start = ((currentPage-1) * countPerPage) + 1;	// 출력을 시작할 행 번호 계산
			if ((start >= 0) && rs.absolute(start)) {			// 커서를 시작 행으로 이동
				List<Project> projectList = new ArrayList<Project>();	// User들의 리스트 생성
				do {
					Project project = new Project(			// User 객체를 생성하여 현재 행의 정보를 저장
						rs.getString("userId"),
						null,
						rs.getString("name"),
						rs.getString("email"),
						null,
						rs.getInt("commId"),
						rs.getString("cName"));
					projectList.add(project);							// 리스트에 User 객체 저장
				} while ((rs.next()) && (--countPerPage > 0));		
				return projectList;							
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}


	//특정 카테고리에 속한 프로젝트들을 검색하여 List에 저장 및 반환  ==> 어떻게 검색할까?
	public List<Project> findProjectInCategory(String categoryName) throws SQLException {
        String sql = "SELECT userId, name, email, phone FROM PROJECT "
     				+ "WHERE category = ?"; //like로 검색??                      
		jdbcUtil.setSqlAndParameters(sql, new Object[] {categoryName});	// JDBCUtil에 query문과 매개 변수 설정
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			List<Project> projectList = new ArrayList<Project>();	// Project들의 리스트 생성
			while (rs.next()) {
				Project project = new Project(		// Project 객체를 생성하여 현재 행의 정보를 저장
					rs.getString("userId"),
					rs.getString("name"),
					rs.getString("email"),
					rs.getString("phone"));			
				projectList.add(project);			// List에 Project 객체 저장
			}		
			return projectList;					
				
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
	
	//특정 카테고리에 속한 프로젝트의 수를 count하여 반환 ==> 어떻게 검색할까?
	public int getNumberOfProjectInCategory(String categoryName) {
		String sql = "SELECT COUNT(projectId) FROM PROJECT "
     				+ "WHERE category = ?"; //like로 검색??               
		jdbcUtil.setSqlAndParameters(sql, new Object[] {categoryName});	// JDBCUtil에 query문과 매개 변수 설정
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			rs.next();										
			return rs.getInt(1);			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return 0;
	}
	
	//주어진 프로젝트 ID에 해당하는 프로젝트가 존재하는지 검사 
	public boolean existingProject(String projectId) throws SQLException {
		String sql = "SELECT count(*) FROM PROJECT WHERE projectId=?";      
		jdbcUtil.setSqlAndParameters(sql, new Object[] {projectId});

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			if (rs.next()) {
				int count = rs.getInt(1);
				return (count == 1 ? true : false); //count가 1이면 존재하는 것
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return false;
	}
}
