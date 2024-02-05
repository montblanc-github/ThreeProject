package com.tp.threeproject.infrastructure.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tp.threeproject.domain.dto.UpdateDoneFlgDto;
import com.tp.threeproject.domain.repository.TaskRepository;
import com.tp.threeproject.infrastructure.entity.Task;
import com.tp.threeproject.infrastructure.mapper.TaskMapper;

import lombok.RequiredArgsConstructor;

/**
 * 
 * Taskリポジトリの実装クラス
 * 
 */
@RequiredArgsConstructor
@Repository
public class TaskRepositoryImpl implements TaskRepository {

	@Autowired
	private final TaskMapper mapper;

	@Override
	public List<Task> selectAll() {
		List<Task> list = mapper.selectAll();
		return list;
	}

	@Override
	public Task selectByPk(Long id) {
		Task task = mapper.selectByPk(id);
		return task;
	}

	@Override
	public void insert(Task task) {
		mapper.insert(task);
	}
	
	@Override
	public void updateDetail(Task task) {
		mapper.updateDetail(task);
	}

	@Override
	public void updateDoneFlg(UpdateDoneFlgDto flg) {
		mapper.updateDoneFlg(flg);
	}

	@Override
	public void delete(Long id) {
		mapper.deleteByPk(id);
	}
}
