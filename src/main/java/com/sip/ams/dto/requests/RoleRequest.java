package com.sip.ams.dto.requests;

public class RoleRequest {
    String roleValue;

    public RoleRequest(String roleValue) {
        super();
        this.roleValue = roleValue;
    }

    public String getRoleValue() {
        return roleValue;
    }
    public void setRoleValue(String roleValue) {
        this.roleValue = roleValue;
    }


}