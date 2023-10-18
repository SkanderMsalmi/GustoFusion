package com.gustofusion.gestioncommentaires.persistance.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
@Table(name ="commentator")
public class Commentator implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="commentatorId")
	private long commentatorId;
	
	private String name;
	
	private String image;
	
	@OneToMany(mappedBy = "commentator")
	private Set<Comment> comments;
	
	@OneToMany(mappedBy = "commentator")
	private Set<Reply> replies;

}
