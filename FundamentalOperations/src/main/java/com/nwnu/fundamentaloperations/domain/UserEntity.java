package com.nwnu.fundamentaloperations.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "user", schema = "FundamentalOperations", catalog = "")
public class UserEntity {
    private String id;
    private String username;
    private String password;
    private String score;
    private String time;
    private String rightp;
    private String mistake;

    @Override
    public String toString() {
        return "UserEntity{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", score='" + score + '\'' +
                ", time='" + time + '\'' +
                ", rightp='" + rightp + '\'' +
                ", mistake='" + mistake + '\'' +
                '}';
    }

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy ="uuid")
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "score")
    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Basic
    @Column(name = "time")
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Basic
    @Column(name = "rightp")
    public String getRightp() {
        return rightp;
    }

    public void setRightp(String rightp) {
        this.rightp = rightp;
    }

    @Basic
    @Column(name = "mistake")
    public String getMistake() {
        return mistake;
    }

    public void setMistake(String mistake) {
        this.mistake = mistake;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (score != null ? !score.equals(that.score) : that.score != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (rightp != null ? !rightp.equals(that.rightp) : that.rightp != null) return false;
        if (mistake != null ? !mistake.equals(that.mistake) : that.mistake != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (score != null ? score.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (rightp != null ? rightp.hashCode() : 0);
        result = 31 * result + (mistake != null ? mistake.hashCode() : 0);
        return result;
    }
}
