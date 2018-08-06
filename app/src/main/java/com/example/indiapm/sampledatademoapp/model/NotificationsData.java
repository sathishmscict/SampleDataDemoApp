package com.example.indiapm.sampledatademoapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NotificationsData {

    @SerializedName("MemberNotifications")
    @Expose
    private List<MemberNotification> memberNotifications = null;
    @SerializedName("ResponseCode")
    @Expose
    private String responseCode;
    @SerializedName("ResponseText")
    @Expose
    private String responseText;

    public List<MemberNotification> getMemberNotifications() {
        return memberNotifications;
    }

    public void setMemberNotifications(List<MemberNotification> memberNotifications) {
        this.memberNotifications = memberNotifications;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseText() {
        return responseText;
    }

    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }
    public class MemberNotification {

        @SerializedName("SrNO")
        @Expose
        private Integer srNO;
        @SerializedName("MemberID")
        @Expose
        private Integer memberID;
        @SerializedName("ID")
        @Expose
        private Integer iD;
        @SerializedName("OnDateTime")
        @Expose
        private String onDateTime;
        @SerializedName("Description")
        @Expose
        private String description;
        @SerializedName("Type")
        @Expose
        private String type;
        @SerializedName("IsView")
        @Expose
        private String isView;

        public Integer getSrNO() {
            return srNO;
        }

        public void setSrNO(Integer srNO) {
            this.srNO = srNO;
        }

        public Integer getMemberID() {
            return memberID;
        }

        public void setMemberID(Integer memberID) {
            this.memberID = memberID;
        }

        public Integer getID() {
            return iD;
        }

        public void setID(Integer iD) {
            this.iD = iD;
        }

        public String getOnDateTime() {
            return onDateTime;
        }

        public void setOnDateTime(String onDateTime) {
            this.onDateTime = onDateTime;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getIsView() {
            return isView;
        }

        public void setIsView(String isView) {
            this.isView = isView;
        }

    }

}
