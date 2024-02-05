package com.tp.threeproject.domain.mapper;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tp.threeproject.common.CommonConst;
import com.tp.threeproject.domain.dto.TaskDisplayDto;
import com.tp.threeproject.domain.dto.UpdateDoneFlgDto;
import com.tp.threeproject.domain.form.TaskForm;
import com.tp.threeproject.domain.repository.TaskRepository;
import com.tp.threeproject.infrastructure.entity.Task;

import lombok.RequiredArgsConstructor;

/**
 * 
 * タスク一覧のMapperクラス
 * 
 */

@RequiredArgsConstructor
@Component
public class TaskListMapper {

	@Autowired
	private final TaskRepository repository;
	
	public List<TaskDisplayDto> selectAll() {
		List<Task> tasks = repository.selectAll();
		List<TaskDisplayDto> list = new ArrayList<TaskDisplayDto>();
		
		for(Task task : tasks) {
			TaskDisplayDto item = new TaskDisplayDto();
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
			
			item.setId(task.getId());
			item.setTitle(task.getTitle());
			item.setMemo(task.getMemo());
			item.setDoneFlg(task.getDoneFlg());
			item.setTimeLimit(task.getTimeLimit());
			item.setCreateTimestamp(sdf.format(task.getCreateTimestamp()));
			item.setCreatedBy(task.getCreatedBy());
			item.setUpdateTimestamp(sdf.format(task.getUpdateTimestamp()));
			item.setUpdatedBy(task.getUpdatedBy());
			
			list.add(item);
		}
		 
		return list;
	}

	public TaskDisplayDto selectByPk(Long id) {
		Task task = repository.selectByPk(id);
		
		TaskDisplayDto item = new TaskDisplayDto();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		
		item.setId(task.getId());
		item.setTitle(task.getTitle());
		item.setMemo(task.getMemo());
		item.setDoneFlg(task.getDoneFlg());
		item.setTimeLimit(task.getTimeLimit());
		item.setCreateTimestamp(sdf.format(task.getCreateTimestamp()));
		item.setCreatedBy(task.getCreatedBy());
		item.setUpdateTimestamp(sdf.format(task.getUpdateTimestamp()));
		item.setUpdatedBy(task.getUpdatedBy());
		
		return item;
	}

	public void add(TaskForm form) {
		Task task = new Task();

		task.setTitle(form.getTitle());
		task.setMemo(form.getMemo());
		task.setDoneFlg(CommonConst.NOT_DONE);

		if(form.getTimeLimit() != null && !form.getTimeLimit().isEmpty()) {
			LocalDateTime timeLimit = LocalDateTime.parse(form.getTimeLimit(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
			task.setTimeLimit(Timestamp.valueOf(timeLimit));
		} else {
			task.setTimeLimit(null);
		}

		repository.insert(task);
	}

	public void updateDetail(TaskForm form) {
		Task task = new Task();

		task.setId(form.getId());
		task.setTitle(form.getTitle());
		task.setMemo(form.getMemo());
		task.setDoneFlg(CommonConst.NOT_DONE);

		if(form.getTimeLimit() != null && !form.getTimeLimit().isEmpty()) {
			LocalDateTime timeLimit = LocalDateTime.parse(form.getTimeLimit(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
			task.setTimeLimit(Timestamp.valueOf(timeLimit));
		} else {
			task.setTimeLimit(null);
		}

		repository.updateDetail(task);
	}

	public void updateDoneFlgOn(Long id) {
		UpdateDoneFlgDto flg = new UpdateDoneFlgDto();
		flg.setId(id);
		flg.setDoneFlg(CommonConst.DONE);
		repository.updateDoneFlg(flg) ;
	}

	public void updateDoneFlgOff(Long id) {
		UpdateDoneFlgDto flg = new UpdateDoneFlgDto();
		flg.setId(id);
		flg.setDoneFlg(CommonConst.NOT_DONE);
		repository.updateDoneFlg(flg) ;
	}

	public void delete(Long id) {
		repository.delete(id);
	}
}
