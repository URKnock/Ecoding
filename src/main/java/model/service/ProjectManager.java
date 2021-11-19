package model.service;

import java.util.Date;
import java.util.List;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import model.DAOFactory;
import model.Project;
import model.Reward;
import model.Support;
import model.dao.*;
import model.service.dto.CreatorDTO;
import model.service.dto.ProjectDTO;
import model.service.dto.ProjectNoticeDTO;
import model.service.dto.RewardDTO;

public class ProjectManager {
	private static ProjectManager manager = new ProjectManager();
	private DAOFactory factory;
	private ProjectDAO projectDAO; //Impl 통해서 가져오기
	private CreatorDAO creatorDAO;
	private SupportDAO supportDAO;
	private ProjectNoticeDAO noticeDAO;
	private RewardDAO rewardDAO;
	
	private ProjectManager() {
		try {
			factory = new DAOFactory();
			projectDAO = factory.getProjectDAO();
			creatorDAO = factory.getCreatorDAO();
			supportDAO = factory.getSupportDAO();
			noticeDAO = factory.getNoticeDAO();
			rewardDAO = factory.getRewardDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ProjectManager getInstance() {
		return manager;
	}
	
	public Project registerProject(Project project) {
		return projectDAO.create(project);
	}
	
	public int updateProjectForm(Project project) {
		return projectDAO.updateProjectForm(project);
	}
	
	public void supportProject(Support support) throws SQLException {
		// 후원 테이블 추가
		supportDAO.create(support);
		// 프로젝트 정보 변경 -> 현재 금액에 후원 금액 추가 -> DAO?Manager?그대로? -> 트랙잭션으로 묶기?
		Project project = projectDAO.findProject(support.getProjectId()); // support의 projectId로 프로젝트 검색
		project.setCurrentPrice(project.getCurrentPrice() + support.getAmount());
		
		return;
	}

	public Project findProject(int projectId) throws SQLException {
		return projectDAO.findProject(projectId);
	}
	
	public ProjectDTO findProjectInfo(Project project) throws SQLException {
		ProjectDTO dto = null;
		CreatorDTO creator = creatorDAO.findCreator(project.getEcoerId());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		
		int projectId = project.getProjectId();
		String title = project.getTitle();
		String image = project.getImage();
		String creatorImage = creator.getImage();
		String creatorName = creator.getNickName();
		int pricePercent = project.getCurrentPrice() / project.getTargetPrice() * 100;
		long remainTime = project.getStartDate().getTime() - project.getEndDate().getTime();
		int countSupporter = supportDAO.countSupporter(projectId);

		dto = new ProjectDTO(projectId, title, image, creatorImage, creatorName,
				pricePercent, remainTime, countSupporter);
		
		return dto;
	}
	
	public ProjectDTO findProjectSimpleInfo(int projectId) throws SQLException {
		ProjectDTO dto = null;
		Project project = findProject(projectId);
		CreatorDTO creator = creatorDAO.findCreator(project.getEcoerId());
		
		String title = project.getTitle();
		String image = project.getImage();
		String creatorImage = creator.getImage();
		String creatorName = creator.getNickName();
		Date paymentDate = project.getPaymentDate();

		//dto = new ProjectDTO(projectId, title, image, creatorImage, creatorName, paymentDate);
		
		return dto;
	}
	
	public int createNotice(ProjectNoticeDTO notice, int projectId) throws SQLException {
		// 창작자가 만든 프로젝트인지 확인, 관련 없는 유저/창작자이면 실패
		return noticeDAO.insertNotice(notice, projectId);
	}
	
	public int updateNotice(ProjectNoticeDTO notice) throws SQLException {
		// 창작자가 만든 프로젝트인지 확인, 관련 없는 유저/창작자이면 실패
		return noticeDAO.updateNotice(notice);
	}
	
	public int deleteNotice(ProjectNoticeDTO notice) throws SQLException {
		// 창작자가 만든 프로젝트인지 확인, 관련 없는 유저/창작자이면 실패
		return noticeDAO.deleteNotice(notice);
	}
	
	public List<ProjectNoticeDTO> getNoticeList(int projectId) throws SQLException {
		return noticeDAO.getProjectNoticeList(projectId);
	}
	
	public int createReward(Reward reward) {
		return rewardDAO.insertReward(reward);
	}
	
	public int updateReward(RewardDTO reward) throws SQLException {
		return rewardDAO.updateReward(reward);
	}
	
	public int daleteReward(RewardDTO reward) throws SQLException {
		return rewardDAO.deleteReward(reward);
	}
	
	public RewardDTO findReward(int rewardId) throws SQLException {
		return rewardDAO.findRewardById(rewardId);
	}
	
	public List<RewardDTO> getRewardList(int projectId) throws SQLException {
		return rewardDAO.getRewardList(projectId);
	}
	
	public int updateProject(Project proj) {
		return projectDAO.update(proj);
	}
	
	public int removeProject(String projId) throws SQLException {
		return projectDAO.remove(projId);
	};
}
