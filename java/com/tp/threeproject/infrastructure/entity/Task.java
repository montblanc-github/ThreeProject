package com.tp.threeproject.infrastructure.entity;

import java.sql.Timestamp;

import lombok.Data;

/**
 * 
 * TaskテーブルのEntityクラス
 * 
 */

@Data
public class Task {

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
	private Timestamp createTimestamp;

	/** 登録者 */
	private String createdBy;

	/** 更新日時 */
	private Timestamp updateTimestamp;
	
	/** 更新者 */
	private String updatedBy;

}
