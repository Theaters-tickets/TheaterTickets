package com.netcracker.theater.rtickets.parser;

import java.util.Map;

public class Participants {

    private Map<String, Object> agent;
    private Map<String, Object> role;

    public Map<String, Object> getAgent() {
        return agent;
    }

    public void setAgent(Map<String, Object> agent) {
        this.agent = agent;
    }

    public Map<String, Object> getRole() {
        return role;
    }

    public void setRole(Map<String, Object> role) {
        this.role = role;
    }

}
