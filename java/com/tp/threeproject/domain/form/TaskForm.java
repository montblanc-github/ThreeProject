package com.tp.threeproject.domain.form;

import java.sql.Timestamp;

import lombok.Data;

/*
 * 
 * タスク新規追加用のFormクラス
 * 
 */

@Data
public class TaskForm {

	/** id */
	private long id;
	
	/** タイトル */
	private String title;

	/** メモ */
	private String memo;

	/** 完了フラグ */
	private String doneFlg;

	/** 期限 */
	private String timeLimit;

	/** 登録日時 */
	private Timestamp createTimestamp;

	/** 登録者 */
	private String createdBy;

	/** 更新日時 */
	private Timestamp updateTimestamp;
	
	/** 更新者 */
	private String updatedBy;

}
