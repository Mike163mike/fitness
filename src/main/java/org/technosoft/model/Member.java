package org.technosoft.model;

public class Member {

    private final int memberId;
    private final String name;
    private final char memberType;
    private final double fees;


    public Member(String name, char memberType, double fees) {
        this.memberId = generateRandomInt();
        this.name = name;
        this.memberType = memberType;
        this.fees = fees;
    }

    public Member(int memberId, String name, char memberType, double fees) {
        this.memberId = memberId;
        this.name = name;
        this.memberType = memberType;
        this.fees = fees;
    }

    public int getMemberId() {
        return memberId;
    }

    @Override
    public String toString() {
        return memberId + " " + name + " " +
                memberType + " " + fees;
    }

    private int generateRandomInt() {
        return (int) (Math.random() * 1_000) + 1;
    }
}
