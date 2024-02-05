package com.tp.threeproject.infrastructure.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tp.threeproject.domain.dto.UpdateDoneFlgDto;
import com.tp.threeproject.infrastructure.entity.Task;

/**
 * 
 * TaskテーブルのMapperクラス
 * 
 */

@Mapper
public interface TaskMapper {

	List<Task> selectAll();
	
	Task selectByPk(Long id);

	void insert(Task task);

	void updateDetail(Task task);

	void updateDoneFlg(UpdateDoneFlgDto flg);

	void deleteByPk(Long id);
}
