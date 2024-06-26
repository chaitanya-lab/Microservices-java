package com.lcwd.user.service.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="micro_users")
public class User {

	@Id
	@Column(name="ID")
	private String userId;
	@Column(name = "NAME")
	private String name;
	@Column(name = "EMAIL")
	private String email;
	@Column (name = "ABOUT")
	private String about;
	@Transient
	private List<Rating> ratings;
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public List<Rating> getRatings() {
		return ratings;
	}
	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
	public User(String userId, String name, String email, String about, List<Rating> ratings) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.about = about;
		this.ratings = ratings;
	}
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	 public static Builder builder() {
         return new Builder();
     }
	public static class Builder {
        private String userId;
        private String name;
        private String email;
        private String about;
        private List<Rating> ratings;

        // Private constructor
        private Builder() {
        }
        // Setter methods for optional parameters
        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder about(String about) {
            this.about = about;
            return this;
        }

        public Builder ratings(List<Rating> ratings) {
            this.ratings = ratings;
            return this;
        }

        public User build() {
            return new User(userId, name, email, about, ratings);
        }
	}


}
