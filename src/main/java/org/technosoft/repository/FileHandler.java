package org.technosoft.repository;

import org.technosoft.model.Member;
import org.technosoft.model.MultiClubMember;
import org.technosoft.model.SingleClubMember;

import java.io.*;
import java.util.LinkedList;

public class FileHandler {

    private static File membersFile = new File("src/main/resources/members.csv");
    private static LinkedList<Member> members = new LinkedList<>();

    public void setMembers(Member member) {
        members.add(member);
    }

    public LinkedList<Member> getMembers() {
        return members;
    }

    private boolean deleteFile(File file) {
        return file.delete();
    }

    private boolean createFile(File file) throws IOException {
        return file.createNewFile();
    }

    private boolean renameFile(File fileFrom, File fileTo) {
        return fileFrom.renameTo(fileTo);
    }


    public LinkedList<Member> readFile() throws IOException {
        String[] stringsMem = getStringsFromCsv();
        for (var str : stringsMem) {
            var member = stringParser(str.split(" "));
            members.add(member);
        }
        return members;
    }

    public String[] getStringsFromCsv() throws IOException {
        String[] stringsMem = new String[0];
        if (!membersFile.exists()) {
            createFile(membersFile);
        }
        try (var bufferedReader = new BufferedReader(new FileReader(membersFile))) {
            String row;
            while ((row = bufferedReader.readLine()) != null) {
                stringsMem = row.split(", ");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return stringsMem;
    }

    private Member stringParser(String[] tempStrArr) {
        return switch (tempStrArr[2].charAt(0)) {
            case 'S' -> new SingleClubMember(Integer.parseInt(tempStrArr[0]), tempStrArr[1], tempStrArr[2].charAt(0),
                    Double.parseDouble(tempStrArr[3]), Integer.parseInt(tempStrArr[4]));
            case 'M' -> new MultiClubMember(Integer.parseInt(tempStrArr[0]), tempStrArr[1], tempStrArr[2].charAt(0),
                    Double.parseDouble(tempStrArr[3]), Integer.parseInt(tempStrArr[4]));
            default -> throw new IllegalStateException("Unexpected value: " + tempStrArr[2].charAt(0));
        };
    }

    public void appendFile(String mem) {
        try (var bufferedWriter = new BufferedWriter(new FileWriter(membersFile, true))) {
            bufferedWriter.write(mem + ", ");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void overWriteFile(int memberId) throws IOException {
        Member memberForDelete = null;
        members = readFile();
        var startSize = members.size();
        for (Member member : members) {
            if (member.getMemberId() == memberId) {
                memberForDelete = member;
                members.remove(member);
                break;
            }
        }
        var finishSize = members.size();
        if (finishSize != startSize) {
            assert memberForDelete != null;
            createFile(new File("src/main/resources/temp_members.csv"));
            membersFile = new File("src/main/resources/temp_members.csv");
            appendFile(members.toString().substring(1, members.toString().length() - 1));
            deleteFile(new File("src/main/resources/members.csv"));
            renameFile(new File("src/main/resources/temp_members.csv"),
                    new File("src/main/resources/members.csv"));
        } else {
            System.out.println("Something goes wrong.");
        }
    }
}
