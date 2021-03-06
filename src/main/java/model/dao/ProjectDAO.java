package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Project;
//import model.service.dto.ProjectDTO;
import util.JDBCUtil;

public class ProjectDAO {
	private JDBCUtil jdbcUtil = null;
	public ProjectDAO() {
		jdbcUtil = new JDBCUtil();
	}	

	public int create(Project project) {
		String insertQuery = "INSERT INTO PROJECT "
				+ "VALUES (seq_project.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		Object[] param = new Object[] {project.getEcoerId(), project.getTitle(), project.getImage(), project.getSimpleInfo(), project.getCategory(), 
				project.getHashTag(), project.getEcoTag(), project.getEcoScore(), project.getTargetPrice(), project.getCurrentPrice(), 
				new java.sql.Date(project.getStartDate().getTime()), new java.sql.Date(project.getEndDate().getTime()), 
				new java.sql.Date(project.getPaymentDate().getTime()), new java.sql.Date(project.getDeliveryDate().getTime()), 
				project.getDetailInfo(), project.getPlanInfo(), project.getExchangeInfo(), project.getProjectVideo(), project.getProjectFile()};
		jdbcUtil.setSqlAndParameters(insertQuery, param); // JDBCUtil 에 insert문과 매개변수 설정
		
		String key[] = {"project_id"};
		try {
			jdbcUtil.executeUpdate(key); // insert 문 실행
			ResultSet rs = jdbcUtil.getGeneratedKeys();
			if(rs.next()) {
		   		int generatedKey = rs.getInt(1); 
		   		project.setProjectId(generatedKey); 
		   		return generatedKey;
		   	}
		} catch (Exception ex) { 
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return 0;
	}
	
	// 기존의 프로젝트 정보를 수정.
	public int update(Project project) {
		String sql = "UPDATE project "
					+ "SET title = ?, image = ?, simple_info = ?, category = ?, hashtag = ?, ecotag = ?, eco_score = ?, "
					+ "target_price = ?, start_date = ?, end_date = ?, payment_date = ?, delivery_date = ?, "
					+ "detail_info = ?, plan_info = ?, exchange_info = ?, project_video = ?, project_file = ? "
					+ "WHERE project_id = ?";
		
		Object[] param = new Object[]{project.getTitle(), project.getImage(), project.getSimpleInfo(), 
				project.getCategory(), project.getHashTag(), project.getEcoTag(), project.getEcoScore(), 
				project.getTargetPrice(), new java.sql.Date(project.getStartDate().getTime()), 
				new java.sql.Date(project.getEndDate().getTime()), new java.sql.Date(project.getPaymentDate().getTime()), 
				new java.sql.Date(project.getDeliveryDate().getTime()), project.getDetailInfo(), 
				project.getPlanInfo(), project.getExchangeInfo(), project.getProjectVideo(), project.getProjectFile(), 
				project.getProjectId()};
		
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
	
	public int updatePriceProject(int projectId, int price) throws SQLException {
		String sql = "UPDATE PROJECT SET current_price = ? WHERE project_id = ?";
		
		Object[] param = new Object[] {price, projectId};
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

	//프로젝트 ID에 해당하는 프로젝트를 삭제.
	public int remove(int projectId) throws SQLException {
		String sql = "DELETE FROM PROJECT WHERE project_id=?";		
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
	public Project findProject(int projectId) throws SQLException {
		String sql = "SELECT * ";
        sql += "FROM PROJECT ";
        sql += "WHERE project_id=?";   
        
		jdbcUtil.setSqlAndParameters(sql, new Object[] {projectId});
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();	// query 실행
			if (rs.next()) {						// 학생 정보를 발견하면
				Project project = new Project(
						projectId,
						rs.getString("ecoer_id"),
						rs.getString("title"),
						rs.getString("image"),
						rs.getString("simple_info"),
						rs.getString("category"),
						rs.getString("hashTag"),
						rs.getString("ecoTag"),
						rs.getDouble("eco_score"),
						rs.getInt("target_price"),
						rs.getInt("current_price"),
						rs.getDate("start_date"),
						rs.getDate("end_date"),
						rs.getDate("payment_date"),
						rs.getDate("delivery_date"),
						rs.getString("detail_info"),
						rs.getString("plan_info"),
						rs.getString("exchange_info"), 
						rs.getString("project_video"),
						rs.getString("project_file"));
				
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
        String sql = "SELECT * FROM PROJECT";
        String[] cols = Project.columns; //미리 정의한 컬럼 배열 참조 
		jdbcUtil.setSqlAndParameters(sql, null);		// JDBCUtil에 query문 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();			// query 실행			
			List<Project> projectList = new ArrayList<Project>();	// Project들의 리스트 생성
			while (rs.next()) {
				Project project = new Project();		// Project 객체를 생성하여 정보를 저장
				for(int i = 0; i < Project.cols; i++) {
					project.setWithIndex(i, rs.getObject(cols[i]));
				}
				projectList.add(project);				// List에 Project 객체 저장
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
        String sql = "SELECT project_id";
        String[] cols = Project.columns; //미리 정의한 컬럼 배열 참조 
        for(int i = 1; i < Project.cols; i++) { //ecoerId부터 시작
        	sql += ", " + cols[i];
        }
        sql += " FROM PROJECT ";
        sql += "ORDER BY project_id"; //등록 순으로 정렬? id 순으로 정렬?
		jdbcUtil.setSqlAndParameters(sql, null,					// JDBCUtil에 query문 설정
				ResultSet.TYPE_SCROLL_INSENSITIVE,				// cursor scroll 가능
				ResultSet.CONCUR_READ_ONLY);						
		try {
			ResultSet rs = jdbcUtil.executeQuery();				// query 실행			
			int start = ((currentPage-1) * countPerPage) + 1;	// 출력을 시작할 행 번호 계산
			if ((start >= 0) && rs.absolute(start)) {			// 커서를 시작 행으로 이동
				List<Project> projectList = new ArrayList<Project>();	// User들의 리스트 생성
				do {
					Project project = new Project();		// Project 객체를 생성하여 정보를 저장
					for(int i = 0; i < Project.cols; i++) {
						project.setWithIndex(i, rs.getObject(cols[i]));
					}
					projectList.add(project);				// List에 Project 객체 저장
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

	public List<Project> findProjectList(String ecoer_id) throws SQLException {
        String sql = "SELECT project_id";
        String[] cols = Project.columns; //미리 정의한 컬럼 배열 참조 
        for(int i = 1; i < Project.cols; i++) { //ecoer_id부터 시작
        	sql += ", " + cols[i];
        }
        sql += " FROM PROJECT ";
        sql += "WHERE ecoer_id = ? ";
        sql += "ORDER BY project_id"; //등록 순으로 정렬
		jdbcUtil.setSqlAndParameters(sql, new Object[] {ecoer_id});
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();			// query 실행			
			List<Project> projectList = new ArrayList<Project>();	// Project들의 리스트 생성
			while (rs.next()) {
				Project project = new Project();		// Project 객체를 생성하여 정보를 저장
				for(int i = 0; i < Project.cols; i++) {
					project.setWithIndex(i, rs.getObject(cols[i]));
				}
				projectList.add(project);				// List에 Project 객체 저장
			}		
			return projectList;					

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
	
	// 검색 키워드를 포함하는 프로젝트들을 List에 저장 및 반환
	public List<Project> findProjectListByKeyword(String keyword) {
		String sql = "SELECT * FROM PROJECT WHERE title LIKE '%" + keyword + "%' ORDER BY project_id";
		String[] cols = Project.columns; // 미리 정의한 컬럼 배열 참조
		jdbcUtil.setSqlAndParameters(sql, null);

		try {
			ResultSet rs = jdbcUtil.executeQuery(); // query 실행
			List<Project> projectList = new ArrayList<Project>(); // Project들의 리스트 생성
			while (rs.next()) {
				Project project = new Project(); // Project 객체를 생성하여 정보를 저장
				for (int i = 0; i < Project.cols; i++) {
					project.setWithIndex(i, rs.getObject(cols[i]));
				}
				projectList.add(project); // List에 Project 객체 저장
			}
			return projectList;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	//특정 카테고리에 속한 프로젝트들을 검색하여 List에 저장 및 반환
	public List<Project> findProjectInCategory(String categoryName) throws SQLException {
		String sql = "SELECT project_id";
        String[] cols = Project.columns; //미리 정의한 컬럼 배열 참조 
        for(int i = 1; i < Project.cols; i++) { //ecoerId부터 시작
        	sql += ", " + cols[i];
        } 
        sql += " FROM PROJECT ";
        sql += "WHERE category LIKE ?"; //like로 검색?            
		jdbcUtil.setSqlAndParameters(sql, new Object[] {"%" + categoryName + "%"});

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			List<Project> projectList = new ArrayList<Project>();	// Project들의 리스트 생성
			while (rs.next()) {
				Project project = new Project();		// Project 객체를 생성하여 정보를 저장
				for(int i = 0; i < Project.cols; i++) {
					project.setWithIndex(i, rs.getObject(cols[i]));
				}
				projectList.add(project);				// List에 Project 객체 저장
			}		
			return projectList;					

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
	
	//특정 카테고리에 속한 프로젝트의 수를 count하여 반환
	public int getNumberOfProjectInCategory(String categoryName) {
		String sql = "SELECT COUNT(project_id) FROM PROJECT "
     				+ "WHERE category LIKE ?"; //like로 검색?              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {"%" + categoryName + "%"});

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
		String sql = "SELECT count(project_id) FROM PROJECT WHERE project_id=?";      
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
