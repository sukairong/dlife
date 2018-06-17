package com.aitp.dlife.service.dto;


import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A DTO for the Attendee entity.
 */
public class AttendeeDTO implements Serializable {

    private Long id;

    @Size(max = 128)
    private String wechatUserId;

    @Size(max = 128)
    private String nickName;

    @Size(max = 1024)
    private String avatar;

    private Instant participationTime;

    private Long pinFanActivityId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWechatUserId() {
        return wechatUserId;
    }

    public void setWechatUserId(String wechatUserId) {
        this.wechatUserId = wechatUserId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Instant getParticipationTime() {
        return participationTime;
    }

    public void setParticipationTime(Instant participationTime) {
        this.participationTime = participationTime;
    }

    public Long getPinFanActivityId() {
        return pinFanActivityId;
    }

    public void setPinFanActivityId(Long pinFanActivityId) {
        this.pinFanActivityId = pinFanActivityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AttendeeDTO attendeeDTO = (AttendeeDTO) o;
        if(attendeeDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), attendeeDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AttendeeDTO{" +
            "id=" + getId() +
            ", wechatUserId='" + getWechatUserId() + "'" +
            ", nickName='" + getNickName() + "'" +
            ", avatar='" + getAvatar() + "'" +
            ", participationTime='" + getParticipationTime() + "'" +
            "}";
    }
}
