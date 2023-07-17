package org.technosoft.model;

public class MultiClubMember extends Member {

    private final int membershipPoints;

    public MultiClubMember(String name, char memberType, double fees, int membershipPoints) {
        super(name, memberType, fees);
        this.membershipPoints = membershipPoints;
    }

    public MultiClubMember(int memberId, String name, char memberType, double fees, int membershipPoints) {
        super(memberId, name, memberType, fees);
        this.membershipPoints = membershipPoints;
    }

    @Override
    public String toString() {
        return super.toString() + " " + membershipPoints;
    }
}
