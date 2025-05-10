package com.thetestingacademy.ex_07_Payload_management.Tools;

import java.util.LinkedHashMap;
import java.util.Map;

public class Bookingdates {

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    private String checkin;
    private String checkout;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

}
