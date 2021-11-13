package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.*;
import model.service.dto.ProjectNoticeDTO;
import model.dao.JDBCUtil;

public class ProjectNoticeDAO {

	private static JDBCUtil jdbcUtil = null;
	
	public ProjectNoticeDAO() {
		jdbcUtil = new JDBCUtil();
	}
	
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
						rs.getInt("project_id"),
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
	
	public int insertNotice(ProjectNoticeDTO notice) throws SQLException {
		int result = 0;
		String insertQuery = "INSERT INTO project_notice VALUES (?, ?, ?, ?)"; // 후에 next 적용
		
		Object[] param = new Object[] {
				notice.getNoticeId(), notice.getProjectId(), notice.getNoticeDate(), notice.getNoticeContent() };
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
	
	public int updateNotice(ProjectNoticeDTO notice) throws SQLException {
		int result = 0;
		String insertQuery = "UPDATE project_notice "
				+ "SET notice_date = ?, notice_content = ? "
				+ "WHERE project_id = ?";
		
		Object[] param = new Object[] {
				notice.getNoticeDate(), notice.getNoticeContent(), notice.getProjectId() };
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
