package com.cos.blog.model;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_incerement
	private int id;
	
	@Column(nullable=false, length=100)
	private String title;
	
	@Lob //대용량 데이터
	private String content; // 섬머노트 라이브러리 <html>태그가 섞여서 디자인됨

	@ColumnDefault("0")
	private int count; // 조회수
	
	
	@ManyToOne(fetch = FetchType.EAGER) // Many == Board, User == One
	@JoinColumn(name="userId")
	private BlogUser blogUser; //DB는 오브젝트를 저장할 수 없다. FK, 자바는 오브젝트를 저장할 수 있다.
	
	
	@OneToMany(mappedBy="board", fetch=FetchType.EAGER)
	private List<Reply> reply;
	
	
	
	@CreationTimestamp
	private Timestamp createDate;
	
	
	
	
	
}
