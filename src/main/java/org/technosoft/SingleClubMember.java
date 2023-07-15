package org.technosoft.fitness_v3;

public class SingleClubMember extends Member{

    private int club;

    public SingleClubMember(int memberID, String name, char memberType, double fees, int club) {
        super(memberID, name, memberType, fees);
        this.club = club;
    }

    public int getClub() {
        return club;
    }

    public void setClub(int club) {
        this.club = club;
    }

    @Override
    public String toString() {
        return "SingleClubMember{" + super.toString() + ", " + "club=" + club + '}';
    }
}
