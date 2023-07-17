package org.technosoft;

import org.technosoft.service.MembershipManagement;

import java.io.IOException;

public class JavaProject {

    public static void main(String[] args) throws IOException {

        MembershipManagement mm = new MembershipManagement();
        switch (mm.getChoice()) {
            case 1 -> mm.addMembers();
            case 2 -> mm.removeMember();
            case 3 -> mm.printMemberInfo();
            case 4 -> mm.printAllMemberInfo();
            case -1 -> System.exit(0);
        }
    }
}
