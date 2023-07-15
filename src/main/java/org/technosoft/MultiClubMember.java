package org.technosoft.fitness_v3;

public class MultiClubMember extends Member {

    private int membershipPoints;

    public MultiClubMember(int memberID, String name, char memberType, double fees, int membershipPoints) {
        super(memberID, name, memberType, fees);
        this.membershipPoints = membershipPoints;
    }

    public int getMembershipPoints() {
        return membershipPoints;
    }

    public void setMembershipPoints(int membershipPoints) {
        this.membershipPoints = membershipPoints;
    }

    @Override
    public String toString() {
        return "MultiClubMember{" + super.toString() + ", " + "membershipPoints=" + membershipPoints + '}';
    }
}
