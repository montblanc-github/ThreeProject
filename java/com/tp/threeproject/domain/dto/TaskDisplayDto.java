package com.tp.threeproject.domain.dto;

import java.sql.Timestamp;

import lombok.Data;

/**
 * 
 * タスク一覧Dtoクラス
 * 
 */

@Data
public class TaskDisplayDto {

	/** id */
	private long id;

	/** タイトル */
	private String title;

	/** メモ */
	private String memo;

	/** 完了フラグ */
	private String doneFlg;

	/** 期限 */
	private Timestamp timeLimit;

	/** 登録日時 */
	private String createTimestamp;

	/** 登録者 */
	private String createdBy;

	/** 更新日時 */
	private String updateTimestamp;
	
	/** 更新者 */
	private String updatedBy;
}
