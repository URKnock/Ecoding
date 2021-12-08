package model.service.dto;

import java.util.ArrayList;
import java.util.List;

public class ReactDTO {
	private List<Integer> like, report;
	
	public ReactDTO() {
		like = new ArrayList<>();
		report = new ArrayList<>();
	}

	public List<Integer> getLike() {
		return like;
	}

	public void setLike(List<Integer> like) {
		this.like = like;
	}

	public List<Integer> getReport() {
		return report;
	}

	public void setReport(List<Integer> report) {
		this.report = report;
	}
	
	public boolean inLike(int postId) {
		for(int i : like) {
			if(i == postId)
				return true;
		}
		return false;
	}

	public boolean inReport(int postId) {
		for(int i : report) {
			if(i == postId)
				return true;
		}
		return false;
	}

}
