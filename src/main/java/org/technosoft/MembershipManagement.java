package org.technosoft.fitness_v3;

import java.util.LinkedList;
import java.util.Scanner;

public class MembershipManagement {

    final private Scanner reader = new Scanner(System.in);
    ;

    public int getIntInput() {
        int intValue;
        while (true) {
            if (reader.hasNextInt()) {
                intValue = reader.nextInt();
                System.out.println("You input " + intValue + ".");
                break;
            } else {
                System.out.println("This is incorrect data. Try again.");
                reader.next();
            }
        }
        return intValue;
    }

    public void printClubOptions() {
        System.out.println("""
                              
                1) Club Mercury
                2) Club Neptune
                3) Club Jupiter
                4) Multi Clubs
                    
                        """);
    }

    public int getChoice() {
        int choice;
        System.out.println("""
                                
                WELCOME TO OZONE FITNESS CENTER
                ================================
                1) Add Member
                2) Remove Member
                3) Display Member Information
                Please select an option (or Enter -1 to quit):
                                
                """);
        choice = getIntInput();
        return choice;
    }

//    public String addMembers(LinkedList<Member> m) {
//        String name;
//        int club;
//        String mem;
//        double fees;
//        int memberID;
//        Member mbr;
//        Calculator<Integer> cal;
//
//        var newMember = new Member()
//
//        return null;
//    }

    public void removeMember(LinkedList<Member> m) {
        int memberID;
        System.out.print("Input ID of member you want to delete: ");
        memberID = getIntInput();


    }

    public void printMemberInfo(LinkedList<Member> m) {
        int memberId = getIntInput();
        var member = m.

    }

}
