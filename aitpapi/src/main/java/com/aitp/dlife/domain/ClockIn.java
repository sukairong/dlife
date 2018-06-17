package com.aitp.dlife.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * 打卡信息
 */
@ApiModel(description = "打卡信息")
@Entity
@Table(name = "clock_in")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ClockIn implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 签到日记
     */
    @Size(max = 1024)
    @ApiModelProperty(value = "签到日记")
    @Column(name = "sign_note", length = 1024)
    private String signNote;

    /**
     * 打卡时间
     */
    @ApiModelProperty(value = "打卡时间")
    @Column(name = "punch_date_time")
    private Instant punchDateTime;

    @OneToMany(mappedBy = "clockIn")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Pics> pics = new HashSet<>();

    @ManyToOne
    private ActivityParticipation activityParticipation;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSignNote() {
        return signNote;
    }

    public ClockIn signNote(String signNote) {
        this.signNote = signNote;
        return this;
    }

    public void setSignNote(String signNote) {
        this.signNote = signNote;
    }

    public Instant getPunchDateTime() {
        return punchDateTime;
    }

    public ClockIn punchDateTime(Instant punchDateTime) {
        this.punchDateTime = punchDateTime;
        return this;
    }

    public void setPunchDateTime(Instant punchDateTime) {
        this.punchDateTime = punchDateTime;
    }

    public Set<Pics> getPics() {
        return pics;
    }

    public ClockIn pics(Set<Pics> pics) {
        this.pics = pics;
        return this;
    }

    public ClockIn addPics(Pics pics) {
        this.pics.add(pics);
        pics.setClockIn(this);
        return this;
    }

    public ClockIn removePics(Pics pics) {
        this.pics.remove(pics);
        pics.setClockIn(null);
        return this;
    }

    public void setPics(Set<Pics> pics) {
        this.pics = pics;
    }

    public ActivityParticipation getActivityParticipation() {
        return activityParticipation;
    }

    public ClockIn activityParticipation(ActivityParticipation activityParticipation) {
        this.activityParticipation = activityParticipation;
        return this;
    }

    public void setActivityParticipation(ActivityParticipation activityParticipation) {
        this.activityParticipation = activityParticipation;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ClockIn clockIn = (ClockIn) o;
        if (clockIn.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), clockIn.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ClockIn{" +
            "id=" + getId() +
            ", signNote='" + getSignNote() + "'" +
            ", punchDateTime='" + getPunchDateTime() + "'" +
            "}";
    }
}
