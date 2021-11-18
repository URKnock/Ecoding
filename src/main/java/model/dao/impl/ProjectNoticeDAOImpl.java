package model.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.util.JDBCUtil;
import model.dao.ProjectNoticeDAO;
import model.service.dto.ProjectNoticeDTO;

public class ProjectNoticeDAOImpl implements ProjectNoticeDAO {

	private static JDBCUtil jdbcUtil = null;
	
	public ProjectNoticeDAOImpl() {
		jdbcUtil = new JDBCUtil();
	}
	
	// projectId로 해당하는 공지 찾아서 리스트로 반환
	public List<ProjectNoticeDTO> getProjectNoticeList(int projectId) throws SQLException {
		
		String listQuery = "SELECT notice_id, notice_date, notice_content "
				+ "FROM project_notice "
				+ "WHERE project_id = ?";
		
		Object[] param = new Object[] { projectId };
		jdbcUtil.setSqlAndParameters(listQuery, param);
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<ProjectNoticeDTO> list = new ArrayList<ProjectNoticeDTO>();
			
			while (rs.next()) {
				ProjectNoticeDTO dto = new ProjectNoticeDTO(
						rs.getInt("notice_id"),
						rs.getString("notice_date"),
						rs.getString("notice_content"));
				list.add(dto);
			}
			
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		
		return null;
	}
	
	// noticeDTO객체와 projectId를 전달받아서 테이블에 삽입 -> 필요하다면 후에 DTO에 projectId를 추가하거나, 다른 생성자 생성
	public int insertNotice(ProjectNoticeDTO notice, int projectId) throws SQLException {
		int result = 0;
		String insertQuery = "INSERT INTO project_notice VALUES (?, ?, ?, ?)"; // 후에 next 적용
		
		Object[] param = new Object[] {
				notice.getNoticeId(), projectId, notice.getNoticeDate(), notice.getNoticeContent() };
		jdbcUtil.setSqlAndParameters(insertQuery, param);
		
		try {
			result = jdbcUtil.executeUpdate();
		} catch  (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return result;
	}
	
	// 공지 수정
	public int updateNotice(ProjectNoticeDTO notice) throws SQLException {
		int result = 0;
		String insertQuery = "UPDATE project_notice "
				+ "SET notice_date = ?, notice_content = ? "
				+ "WHERE notice_id = ?";
		
		Object[] param = new Object[] {
				notice.getNoticeDate(), notice.getNoticeContent(), notice.getNoticeId() };
		jdbcUtil.setSqlAndParameters(insertQuery, param);
		
		try {
			result = jdbcUtil.executeUpdate();
		} catch  (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return result;
	}
	
	// 공지 삭제
	public int deleteNotice(ProjectNoticeDTO notice) throws SQLException {
		int result = 0;
		String insertQuery = "DELETE project_notice WHERE notice_id = ?";
		
		Object[] param = new Object[] { notice.getNoticeId() };
		jdbcUtil.setSqlAndParameters(insertQuery, param);
		
		try {
			result = jdbcUtil.executeUpdate();
		} catch  (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return result;
	}
}
