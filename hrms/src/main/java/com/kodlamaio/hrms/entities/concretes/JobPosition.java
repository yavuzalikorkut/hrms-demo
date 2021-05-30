package com.kodlamaio.hrms.entities.concretes;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_positions")
@NoArgsConstructor
@AllArgsConstructor


public class JobPosition {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	
	@Column(name="id")
	private int id;
	
    @Column(name="uid")
    private String uid;

    @Column(name="title")
    private String title;

    @Column(name="created_date")
    private LocalDateTime createdDate= LocalDateTime.now();

    @Column(name="updated_date")
    private LocalDateTime updatedDate;

    @Column(name= "is_deleted")
    private boolean isDeleted;

    @Column(name="is_activated")
    private boolean isActivated;
}
