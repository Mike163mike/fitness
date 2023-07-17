package org.technosoft.model;

public class SingleClubMember extends Member {

    private final int club;

    public SingleClubMember(String name, char memberType, double fees, int club) {
        super(name, memberType, fees);
        this.club = club;
    }

    public SingleClubMember(int memberId, String name, char memberType, double fees, int club) {
        super(memberId, name, memberType, fees);
        this.club = club;
    }

    @Override
    public String toString() {
        return super.toString() + " " + club;
    }
}
