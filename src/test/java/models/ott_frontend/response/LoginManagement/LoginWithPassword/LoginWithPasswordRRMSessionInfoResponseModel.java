package models.ott_frontend.response.LoginManagement.LoginWithPassword;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginWithPasswordRRMSessionInfoResponseModel {

@SerializedName("sessionId")
@Expose
private String sessionId;
@SerializedName("sessionTicket")
@Expose
private String sessionTicket;
@SerializedName("ticket")
@Expose
private String ticket;
@SerializedName("nonce")
@Expose
private String nonce;
@SerializedName("expiryTime")
@Expose
private Long expiryTime;
@SerializedName("heartbeatInterval")
@Expose
private Integer heartbeatInterval;
@SerializedName("maxMissedHeartbeats")
@Expose
private Integer maxMissedHeartbeats;

public String getSessionId() {
return sessionId;
}

public void setSessionId(String sessionId) {
this.sessionId = sessionId;
}

public String getSessionTicket() {
return sessionTicket;
}

public void setSessionTicket(String sessionTicket) {
this.sessionTicket = sessionTicket;
}

public String getTicket() {
return ticket;
}

public void setTicket(String ticket) {
this.ticket = ticket;
}

public String getNonce() {
return nonce;
}

public void setNonce(String nonce) {
this.nonce = nonce;
}

public Long getExpiryTime() {
return expiryTime;
}

public void setExpiryTime(Long expiryTime) {
this.expiryTime = expiryTime;
}

public Integer getHeartbeatInterval() {
return heartbeatInterval;
}

public void setHeartbeatInterval(Integer heartbeatInterval) {
this.heartbeatInterval = heartbeatInterval;
}

public Integer getMaxMissedHeartbeats() {
return maxMissedHeartbeats;
}

public void setMaxMissedHeartbeats(Integer maxMissedHeartbeats) {
this.maxMissedHeartbeats = maxMissedHeartbeats;
}

}
