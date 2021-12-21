package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.service.dto.ProjectNoticeDTO;
import model.service.dto.SupportDTO;
import util.JDBCUtil;

public class ProjectNoticeDAO {

	private static JDBCUtil jdbcUtil = null;
	
	public ProjectNoticeDAO() {
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
						rs.getDate("notice_date"),
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
	public int insertNotice(ProjectNoticeDTO notice) throws SQLException {
		int result = 0;
		String insertQuery = "INSERT INTO project_notice (notice_id, project_id, notice_content) VALUES (seq_notice.nextval, ?, ?)";
		
		Object[] param = new Object[] {notice.getProjectId(), notice.getNoticeContent()};
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
	public int deleteNotice(int noticeId) throws SQLException {
		int result = 0;
		String insertQuery = "DELETE project_notice WHERE notice_id = ?";
		
		Object[] param = new Object[] { noticeId };
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
	
	public ProjectNoticeDTO findNotice(int noticeId) throws SQLException {
		String query = "SELECT notice_id, notice_date, notice_content "
				+ "FROM project_notice "
				+ "WHERE notice_id = ?";
		
		Object[] param = new Object[] { noticeId };
		jdbcUtil.setSqlAndParameters(query, param);
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			ProjectNoticeDTO dto = null;
			
			if (rs.next()) {
				dto = new ProjectNoticeDTO(
						rs.getInt("notice_id"),
						rs.getDate("notice_date"),
						rs.getString("notice_content"));
			}
			
			return dto;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		
		return null;
	}
	
}
