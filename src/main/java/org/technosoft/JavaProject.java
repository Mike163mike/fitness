package org.technosoft.fitness_v3;

import java.util.LinkedList;

public class JavaProject {

    public static void main(String[] args) {

        String mem;
//        MembershipManagement mm;
//        FileHandler fh;
        LinkedList<Member> members;
        int choice;

        var singleMemb = new SingleClubMember(1, "Mike", 'c', 10.0, 1);
        var multMemb = new MultiClubMember(1, "Mike", 'c', 10.0, 4);
        System.out.println(singleMemb + "\n" + multMemb);

        var menage = new MembershipManagement();
        menage.printClubOptions();
        menage.getIntInput();




    }
}
