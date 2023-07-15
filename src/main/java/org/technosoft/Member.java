package org.technosoft.fitness_v3;

public class Member {

    private int memberID;
    private String name;
    private char memberType;
    private double fees;

    public Member(int memberID, String name, char memberType, double fees) {
        this.memberID = memberID;
        this.name = name;
        this.memberType = memberType;
        this.fees = fees;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getMemberType() {
        return memberType;
    }

    public void setMemberType(char memberType) {
        this.memberType = memberType;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    @Override
    public String toString() {
        return "memberID=" + memberID +
                ", name='" + name + '\'' +
                ", memberType=" + memberType +
                ", fees=" + fees;
    }
}
