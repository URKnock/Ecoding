package model.dao;

import java.sql.SQLException;
import java.util.List;
import model.service.dto.ProjectNoticeDTO;

public interface ProjectNoticeDAO {

	public List<ProjectNoticeDTO> getProjectNoticeList(int projectId) throws SQLException;
	public int insertNotice(ProjectNoticeDTO notice, int projectId) throws SQLException;
	public int updateNotice(ProjectNoticeDTO notice) throws SQLException;
	public int deleteNotice(ProjectNoticeDTO notice) throws SQLException;
	
}
