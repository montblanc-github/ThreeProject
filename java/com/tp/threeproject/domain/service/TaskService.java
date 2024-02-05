package com.tp.threeproject.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tp.threeproject.common.CommonConst;
import com.tp.threeproject.domain.dto.TaskDisplayDto;
import com.tp.threeproject.domain.form.TaskForm;
import com.tp.threeproject.domain.mapper.TaskListMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TaskService {

	@Autowired
	private final TaskListMapper mapper;
	
	public List<TaskDisplayDto> index(){
		List<TaskDisplayDto> list = mapper.selectAll();
		return list;
	}
	
	public TaskDisplayDto edit(Long id) {
		TaskDisplayDto task = mapper.selectByPk(id);
		return task;
	}

	public void add(TaskForm form) {
		mapper.add(form);
	}

	public void updateDetail(TaskForm form) {
		mapper.updateDetail(form);
	}

	public List<TaskDisplayDto> updateDoneFlg(Long id, String doneFlg){
		if(doneFlg.equals(CommonConst.NOT_DONE)) {
			mapper.updateDoneFlgOn(id);
		} else {
			mapper.updateDoneFlgOff(id);
		}
		List<TaskDisplayDto> list = mapper.selectAll();
		return list;
	}

	public void delete(Long id) {
		mapper.delete(id);
	}
}
