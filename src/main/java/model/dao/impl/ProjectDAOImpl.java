package model.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Project;
import model.dao.ProjectDAO;
import util.JDBCUtil;
import model.service.dto.ProjectDTO;

public class ProjectDAOImpl implements ProjectDAO {
	private JDBCUtil jdbcUtil = null;
	public ProjectDAOImpl() {
		jdbcUtil = new JDBCUtil();
	}	

	public int create(Project project) {
		String insertQuery = "INSERT INTO PROJECT(project_id, title, simple_info, category, hashtag, ecotag, target_price, "
				+ "current_price, start_date, end_date, payment_date, delivery_date) "
				+ "VALUES (seq_project.nextval, ?, ?, ?, ?, ?, ?, 0, ?, ?, ?, ?)";
		
		Object[] param = new Object[] {project.getTitle(), project.getSimpleInfo(), project.getCategory(), 
				project.getHashTag(), project.getEcoTag(), project.getTargetPrice(), 
				new java.sql.Date(project.getStartDate().getTime()), new java.sql.Date(project.getEndDate().getTime()), 
				new java.sql.Date(project.getPaymentDate().getTime()), new java.sql.Date(project.getDeliveryDate().getTime())};
		jdbcUtil.setSqlAndParameters(insertQuery, param); // JDBCUtil 에 insert문과 매개변수 설정

		try {
			int result = jdbcUtil.executeUpdate(); // insert 문 실행
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

	// 기존의 프로젝트 정보를 수정.
	public int update(Project project) throws SQLException {
		String sql = "UPDATE PROJECT "
					+ "SET title=?"; //2번
		for(int i = 3; i < Project.cols; i++) { //0번(PK), 1번(FK), 2번(title) 제외
			sql += ", " + Project.columns[i] + "=?";
		}
		sql += " WHERE project_id=?";
		Object[] param = new Object[] {};
		for(int i = 2; i < Project.cols; i++) { //2번부터 일괄 수정
			param[i] = project.getWithIndex(i); 
		}
		param[Project.cols + 1] = project.getProjectId();
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
        String sql = "SELECT ecoer_id"; //project_id 제외 
        String[] cols = Project.columns; //미리 정의한 컬럼 배열 참조 
        for(int i = 2; i < Project.cols; i++) { //title부터 시작
        	sql += ", " + cols[i];
        }
        sql += " FROM PROJECT ";
        sql += "WHERE project_id=? ";   
		jdbcUtil.setSqlAndParameters(sql, new Object[] {projectId});	// JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();	// query 실행
			if (rs.next()) {						// 학생 정보를 발견하면
				Project project = new Project();		// Project 객체를 생성하여 정보를 저장
				project.setProjectId(projectId);	//i = 0은 제외
				for(int i = 1; i < Project.cols; i++) {
					project.setWithIndex(i, rs.getObject(cols[i]));
				}
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
        String sql = "SELECT project_id";
        String[] cols = Project.columns; //미리 정의한 컬럼 배열 참조 
        for(int i = 1; i < Project.cols; i++) { //ecoer_id부터 시작
        	sql += ", " + cols[i];
        }
        sql += " FROM PROJECT ";
        sql += "ORDER BY project_id"; //등록 순으로 정렬? id 순으로 정렬?
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


	//특정 카테고리에 속한 프로젝트들을 검색하여 List에 저장 및 반환  ==> 어떻게 검색할까?
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
	
	//특정 카테고리에 속한 프로젝트의 수를 count하여 반환 ==> 어떻게 검색할까?
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
