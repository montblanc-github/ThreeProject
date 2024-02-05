package com.tp.threeproject.domain.repository;

import java.util.List;

import com.tp.threeproject.domain.dto.UpdateDoneFlgDto;
import com.tp.threeproject.infrastructure.entity.Task;

/**
 * 
 * Taskのリポジトリクラス
 * 
 */

public interface TaskRepository{

	/**
	 * タスク一覧取得
	 * 
	 * @param
	 * @return タスクリスト
	 * 
	 */
	List<Task> selectAll();
	
	Task selectByPk(Long id);

	/**
	 * タスク新規追加
	 * 
	 * @param form
	 * @return なし
	 */
	void insert(Task task);
	
	void updateDetail(Task task);

	void updateDoneFlg(UpdateDoneFlgDto flg);

	void delete(Long id);
}
