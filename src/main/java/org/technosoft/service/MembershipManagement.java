package org.technosoft.service;

import org.technosoft.model.Member;
import org.technosoft.model.MultiClubMember;
import org.technosoft.model.SingleClubMember;
import org.technosoft.repository.FileHandler;

import java.io.IOException;
import java.util.Scanner;

public class MembershipManagement {

    private Scanner reader;

    private final FileHandler fileHandler = new FileHandler();

    private final Calculator calculator = new CalculatorImpl();

    public MembershipManagement() {
    }

    public int getIntInput() {
        int intValue;
        reader = new Scanner(System.in);
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

    public int printClubOptions() {
        int clubChoice = -10;
        System.out.print("""              
                1) Club Mercury
                2) Club Neptune
                3) Club Jupiter
                4) Multi Clubs
                        """);

        boolean flagChoice = true;
        while (flagChoice) {
            clubChoice = getIntInput();
            if (clubChoice == 1 || clubChoice == 2 || clubChoice == 3 || clubChoice == 4) {
                flagChoice = false;
            } else {
                System.out.println("Input correct data.");
            }
        }
        return clubChoice;
    }

    public int getChoice() {
        int choice = -10;
        System.out.print("""
                                
                WELCOME TO OZONE FITNESS CENTER
                ================================
                1) Add Member
                2) Remove Member
                3) Display Member Information
                4) Display All Member Information
                Please select an option (or Enter -1 to quit):
                """);
        boolean flag = true;
        while (flag) {
            choice = getIntInput();
            if (choice == -1 || choice == 1 || choice == 2 || choice == 3 || choice == 4) {
                flag = false;
            } else {
                System.out.println("Input correct data.");
            }
        }
        return choice;
    }

    public void addMembers() {
        System.out.println("Input your name.");
        reader = new Scanner(System.in);
        String name = "";
        boolean flagName = true;
        while (flagName) {
            name = reader.nextLine();
            if (name == null || name.isBlank()) {
                System.out.println("Name should be set not null or blank. Try again.");
            } else {
                flagName = false;
            }
        }
        System.out.println("Choice club.");
        int club = printClubOptions();
        double fees = (club < 4) ? calculator.calculateFees(club) : 0.0;
        char memberType = (club < 4) ? 'S' : 'M';
        var newMember = switch (memberType) {
            case 'S' -> new SingleClubMember(name, memberType, fees, club);
            case 'M' -> new MultiClubMember(name, memberType, fees, club);
            default -> throw new IllegalStateException("Unexpected value: " + memberType);
        };
        System.out.printf("You register new member:\n%s", printMember(newMember.toString()));
        fileHandler.setMembers(newMember);
        fileHandler.appendFile(newMember.toString());
    }

    public void removeMember() throws IOException {
        int memberId;
        System.out.println("Input ID of member you want to be deleted: ");
        memberId = getIntInput();
        fileHandler.overWriteFile(memberId);
        System.out.printf("Member with ID %s deleted successfully.", memberId);
    }

    public void printAllMemberInfo() throws IOException {
        System.out.println("All members of us fitness center: \n");
        for (Member member : fileHandler.readFile()) {
            System.out.println((printMember(member.toString())));
        }
    }

    public void printMemberInfo() throws IOException {
        System.out.print("Insert member ID for information: \n");
        var memberId = getIntInput();
        boolean flag = true;
        for (Member member : fileHandler.readFile()) {
            if (member.getMemberId() == memberId) {
                System.out.println("\n" + printMember(member.toString()));
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.printf("Member with ID %s contains not in system.\n", memberId);
        }
    }


    public String printMember(String member) {
        var memberArr = member.split(" ");
        return """
                name: %s;
                ID: %s;
                member Type: %s;
                fees: %s;
                club: %s.
                """.formatted(memberArr[1], memberArr[0], memberArr[2], memberArr[3], memberArr[4]);
    }
}
