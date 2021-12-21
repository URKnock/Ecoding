package model.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.SQLException;
import java.time.LocalDate;

import model.Creator;
import model.DAOFactory;
import model.Ecoer;
import model.Project;
import model.Reward;
//import model.Support;
import model.dao.*;
import model.service.dto.CreatorDTO;
import model.service.dto.InterestProjectDTO;
import model.service.dto.ProjectDTO;
import model.service.dto.ProjectNoticeDTO;
import model.service.dto.RewardDTO;
import model.service.dto.SupportDTO;

public class ProjectManager {
	private static ProjectManager manager = new ProjectManager();
	
	private DAOFactory factory;
	
	private EcoerDAO ecoerDAO;
	private ProjectDAO projectDAO; //Impl 통해서 가져오기
	private CreatorDAO creatorDAO;
	private SupportDAO supportDAO;
	private ProjectNoticeDAO noticeDAO;
	private RewardDAO rewardDAO;
	private InterestProjectDAO interestDAO;
	
	private ProjectManager() {
		try {
			factory = new DAOFactory();
			ecoerDAO = factory.getEcoerDAO();
			projectDAO = factory.getProjectDAO();
			creatorDAO = factory.getCreatorDAO();
			supportDAO = factory.getSupportDAO();
			noticeDAO = factory.getNoticeDAO();
			rewardDAO = factory.getRewardDAO();
			interestDAO = factory.getInterestProjectDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ProjectManager getInstance() {
		return manager;
	}
	
	public int registerProject(Project project) {
		return projectDAO.create(project);
	}
	
	public void supportProject(SupportDTO support) throws SQLException {
		Project project = projectDAO.findProject(support.getProjectId()); // support의 projectId로 프로젝트 검색
		int price = project.getCurrentPrice() + support.getAmount(); // 프로젝트 현재 금액 + 후원 금액
		
		supportDAO.create(support, price);
		return;
	}

	public Project findProject(int projectId) throws SQLException {
		return projectDAO.findProject(projectId);
	}
	
	public List<Project> findProjectList() throws SQLException {
		return projectDAO.findProjectList();
	}
	
	public List<Project> findProjectListByKeyword(String keyword) throws SQLException, UserNotFoundException {
		List<Project> projectList = projectDAO.findProjectListByKeyword(keyword);
		
		if (projectList == null) {
			throw new UserNotFoundException(keyword + "로 검색된 프로젝트가 없습니다.");
		}
		return projectList;
	}
	
	public ProjectDTO findProjectInfo(Project project) throws SQLException {
		ProjectDTO dto = null;
		CreatorDTO creator = creatorDAO.findCreatorSimpleInfo(project.getEcoerId());
		Ecoer ecoer = ecoerDAO.findEcoerInfo(project.getEcoerId());
		
		int projectId = project.getProjectId();
		String title = project.getTitle();
		String image = project.getImage();
		String creatorImage = creator.getImage();
		String creatorName = creator.getNickName();
		String creatorEmail = ecoer.getEmail();
		
		double pricePercent = (double) project.getCurrentPrice() / project.getTargetPrice() * 100;

		Date now = java.sql.Date.valueOf(LocalDate.now());
		Date end = project.getEndDate();
		
		long remainTime = ((end.getTime() - now.getTime()) / 1000) / (24 * 60 * 60);
		
		int countSupporter = supportDAO.countSupporter(projectId);

		dto = new ProjectDTO(projectId, title, image,
				creatorImage, creatorName, creatorEmail,
				(int) pricePercent, remainTime, countSupporter);
		
		return dto;
	}
	
	public ProjectDTO findProjectSimpleInfo(int projectId) throws SQLException {
		ProjectDTO dto = null;
		Project project = findProject(projectId);
		CreatorDTO creator = creatorDAO.findCreatorSimpleInfo(project.getEcoerId());
		
		String title = project.getTitle();
		String image = project.getImage();
		String creatorImage = creator.getImage();
		String creatorName = creator.getNickName();
		Date paymentDate = project.getPaymentDate();

		dto = new ProjectDTO(projectId, title, image, creatorImage, creatorName, paymentDate);
		
		return dto;
	}

	public int createNotice(ProjectNoticeDTO notice) throws SQLException {
		// 창작자가 만든 프로젝트인지 확인, 관련 없는 유저/창작자이면 실패
		return noticeDAO.insertNotice(notice);
	}
	
	public int updateNotice(ProjectNoticeDTO notice) throws SQLException {
		// 창작자가 만든 프로젝트인지 확인, 관련 없는 유저/창작자이면 실패
		return noticeDAO.updateNotice(notice);
	}
	
	public int deleteNotice(int noticeId) throws SQLException {
		// 창작자가 만든 프로젝트인지 확인, 관련 없는 유저/창작자이면 실패
		return noticeDAO.deleteNotice(noticeId);
	}
	
	public ProjectNoticeDTO findNoticeById(int noticeId) throws SQLException {
		return noticeDAO.findNotice(noticeId);
	}
	
	public List<ProjectNoticeDTO> getNoticeList(int projectId) throws SQLException {
		return noticeDAO.getProjectNoticeList(projectId);
	}
	
	public void createReward(Reward[] reward) {
		for(int i = 0; i < reward.length; i++)
			rewardDAO.insertReward(reward[i]);
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
	
	public int removeProject(int projId) throws SQLException {
		return projectDAO.remove(projId);
	};
	
	public int insertInterestProject(InterestProjectDTO interestDTO) throws SQLException {
		return interestDAO.insert(interestDTO);
	}
	
	public boolean isInterestProject(InterestProjectDTO interestDTO) throws SQLException {
		return interestDAO.isInterestProject(interestDTO);
	}
	
	public int removeInterestProject(InterestProjectDTO interestDTO) throws SQLException {
		return interestDAO.delete(interestDTO);
	}
	
	public List<ProjectDTO> interestProjectInfoList(String ecoerId) throws SQLException {
		List<Project> projectList = interestDAO.getInterestProjectList(ecoerId);
		
		List<ProjectDTO> interestList = new ArrayList<ProjectDTO>();
		for (Project p : projectList) {
			double pricePercent = (double) p.getCurrentPrice() / p.getTargetPrice() * 100;
			ProjectDTO dto = new ProjectDTO (
					p.getProjectId(),
					p.getTitle(),
					p.getImage(),
					p.getSimpleInfo(),
					(int) pricePercent);
			interestList.add(dto);
					
		}
		
		return interestList;
	}
	
	public List<ProjectDTO> supportProjectInfoList(String ecoerId) throws SQLException {
		List<Project> projectList = supportDAO.getSupportProjectList(ecoerId);
		
		List<ProjectDTO> supportList = new ArrayList<ProjectDTO>();
		for (Project p : projectList) {
			double pricePercent = (double) p.getCurrentPrice() / p.getTargetPrice() * 100;
			ProjectDTO dto = new ProjectDTO (
					p.getProjectId(),
					p.getTitle(),
					p.getImage(),
					p.getSimpleInfo(),
					(int) pricePercent);
			supportList.add(dto);
					
		}
		
		return supportList;
	}
	
	public List<ProjectDTO> myProjectInfoList(String ecoerId) throws SQLException {
		List<Project> projectList = projectDAO.findProjectList(ecoerId);
		
		List<ProjectDTO> myProjectList = new ArrayList<ProjectDTO>();
		for (Project p : projectList) {
			double pricePercent = (double) p.getCurrentPrice() / p.getTargetPrice() * 100;
			ProjectDTO dto = new ProjectDTO (
					p.getProjectId(),
					p.getTitle(),
					p.getImage(),
					p.getSimpleInfo(),
					(int) pricePercent);
			myProjectList.add(dto);
					
		}
		
		return myProjectList;
	}
	public boolean isSupportProject(SupportDTO supportDTO) throws SQLException {
		return supportDAO.isSupportProject(supportDTO);
	}
	
	public SupportDTO findSupport(String ecoerId, int projectId) throws SQLException {
		return supportDAO.findSupport(ecoerId, projectId);
	}
	
	public int updateRewardSupport(SupportDTO support, int addPrice) throws SQLException {
		RewardDTO reward = rewardDAO.findRewardById(support.getRewardId());
		int amount = reward.getRewardPrice() + addPrice;
		support.setAmount(amount);
		
		Project project = projectDAO.findProject(support.getProjectId());
		SupportDTO originSupport = supportDAO.findSupport(support.getSupportId());
		int current = project.getCurrentPrice() - originSupport.getAmount() + amount;
		project.setCurrentPrice(current);
		
		return supportDAO.updateReward(support, project);
	}
	
	public int updateSupport(SupportDTO support) throws SQLException {
		return supportDAO.update(support);
	}
	
	public int deleteSupport(int supportId) throws SQLException {
		SupportDTO support = supportDAO.findSupport(supportId);
		int amount = support.getAmount();
		
		Project project = projectDAO.findProject(support.getProjectId());
		int current = project.getCurrentPrice() - amount;
		project.setCurrentPrice(current);
		
		return supportDAO.remove(supportId, project);
	}
	
	
}