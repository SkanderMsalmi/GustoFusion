package com.gustofusion.gestioncommentaires.persistance.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "comment")
public class Comment implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "commentId")
	private long commentId;
	
	private String text;
	
	//@Column(nullable = false)
	@Min(1)
	@Max(5)
	private int rating;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;
	
	private int likes;
	
	@OneToMany(mappedBy = "comment" ,cascade = CascadeType.ALL)
	private Set<Reply> replies;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Commentator commentator;

}
