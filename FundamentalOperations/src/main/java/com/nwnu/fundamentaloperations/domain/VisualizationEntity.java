package com.nwnu.fundamentaloperations.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
/**
 * 可视化 的实体类， 该可视化用户保存每个用户每次测试的信息
 */
@Entity
@Table(name = "visualization", schema = "FundamentalOperations", catalog = "")
public class VisualizationEntity {
    private String id;
    private String username;
    private String score;
    private String frequency;

    @Override
    public String toString() {
        return "VisualizationEntity{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", score='" + score + '\'' +
                ", frequency='" + frequency + '\'' +
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
    @Column(name = "score")
    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Basic
    @Column(name = "frequency")
    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VisualizationEntity that = (VisualizationEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (score != null ? !score.equals(that.score) : that.score != null) return false;
        if (frequency != null ? !frequency.equals(that.frequency) : that.frequency != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (score != null ? score.hashCode() : 0);
        result = 31 * result + (frequency != null ? frequency.hashCode() : 0);
        return result;
    }
}
