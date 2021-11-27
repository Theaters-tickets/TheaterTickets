package com.netcracker.theater.rtickets.parser;

import org.json.simple.JSONObject;

import java.util.List;
import java.util.Map;

public class Participants {

    private Agent agent;
    private String role;

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public String getRole() {
        return role;
    }

    public void setRole(Map<String, String> role) {
        this.role = role.get("slug");
    }

    public String toString() {
        return "{" +
                "role='" + role + '\'' +
                "agent='" + agent + '\'' +
                '}';
    }


}
