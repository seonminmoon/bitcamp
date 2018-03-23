package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.domain.Team;

public class TeamDao {

    Team[] teams = new Team[1000];
    int teamIndex = 0;
    
    public void insert(Team team) {
        this.teams[this.teamIndex++] = team;
    }
    
    public Team[] list() {
        Team[] arr = new Team[this.teamIndex];
        for(int i = 0; i < this.teamIndex; i++) 
            arr[i] = this.teams[i];
            return arr;
        }
    
    public void update(Team team) {
        int i = this.getTeamIndex(team.name);
        if (i != -1) 
            this.teams[i] = team;
    }
    public void delete(Team team) {
        int i = this.getTeamIndex(team.name);
        this.teams[i] = null;
    }
        
    public Team get (String name) {
        int i = this.getTeamIndex(name);
        if (i == -1) 
            return null;
        return this.teams[i];
    }
    private int getTeamIndex(String name) {
        for (int i = 0; i < teamIndex; i++) {
            if (teams[i] == null) continue;
            if (name.equals(teams[i].name.toLowerCase())) {
                return i;
            }
        }
        return -1;
    }
    
    
    
}
