import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Instructor {

    static Scanner sc = new Scanner(System.in);
    static Map<String,String> instructorsMap = new HashMap<>();


    public static void transferInstructorList() {
        instructorsMap.put("12345678910","Chris, Lakeman, 1991, Math");
        instructorsMap.put("12345678911","Ali, Can, 1985, Chemistry");
        instructorsMap.put("12345678912","Mark, Verhoeven, 1992, Coding");
        instructorsMap.put("12345678913","Selim, Aslan, 1986, Biology");
        instructorsMap.put("12345678914","Meryem, Aslan, 1991, English");
    }

    public static void instructorMenu() {


        do {
            System.out.println(
                    "\n=============== Istanbul College =============== \n\n"
                    +"1- View list of instructors\n"
                    +"2- Search an instructor using surname\n"
                    +"3- Search an instructor using branch\n"
                    +"4- Add a new instructor\n"
                    +"5- Delete a record using ID\n"
                    +"M- Main menu \n"
                    +"Q- Exit\n"
            );
            Main.choice = sc.next();

            switch (Main.choice){
                case "1":
                    displayInstructors();
                    break;
                case "2":
                    findInstSurname();
                    break;
                case "3":
                    findInstBranch();
                    break;
                case "4":
                    addNewInst();
                    break;
                case "5":
                    delIns();
                    break;
                case "m":
                case "M":
                    Methods.mainMenu();
                    break;
                case "q":
                case "Q":
                    break;
                default:
                    System.out.println("Please enter a valid character");
            }

        }while (!Main.choice.equalsIgnoreCase("q"));

    }

    public static void delIns() {
        System.out.println("Enter the ID of instructor whom you want to delete ");
        String delID = sc.next();
        instructorsMap.remove(delID);
    }

    public static void addNewInst() { //"12345678914","Meryem, Aslan, 1991, English"
        System.out.println("ID:");
        String id = sc.next();
        System.out.println("Name:");
        String name = sc.next();
        Methods.fixLowercase(name);
        System.out.println("Surname:");
        String surname = sc.next();
        Methods.fixLowercase(surname);
        System.out.println("Birth year:");
        String birthYear = sc.next();
        System.out.println("Branch");
        String branch = sc.next();
        Methods.fixLowercase(branch);

        instructorsMap.put(id,name+", "+surname+", "+birthYear+", "+branch);
    }



    public static void findInstBranch() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the branch of wanted instructor");
        String wantedBranch = scan.nextLine();

        Set<Map.Entry<String,String>> instructorEntrySet = instructorsMap.entrySet();

        System.out.println("=============== List of Instructors ===============");
        System.out.println("\nID\t\t\t\tName\t\tSurname\t\t\tBirth Year\tBranch\n");

        int ct =0;  // this variable will hold how many times the program print wanted instructor so if ct equals 0 after printing, it means there is
                    // no person who has wanted attributes

        for (Map.Entry<String,String> each:instructorEntrySet) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();
            String[] eachValueArr = eachValue.split(", ");

            if (wantedBranch.equalsIgnoreCase(eachValueArr[3])){
                System.out.printf("%11s\t\t%-7s\t\t%-9s\t\t%4s\t\t%s\n",eachKey,eachValueArr[0],eachValueArr[1],eachValueArr[2],eachValueArr[3]);
                ct++;
            }
            if (ct==0)
                System.out.println("There is no "+wantedBranch+" instructor");


        }

    }

    public static void findInstSurname() {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the surname of wanted instructor");
        String wantedSurname = scan.nextLine();

        Set<Map.Entry<String,String>> instructorEntrySet = instructorsMap.entrySet();

        System.out.println("=============== List of Instructors ===============");
        System.out.println("\nID\t\t\t\tName\t\tSurname\t\t\tBirth Year\tBranch\n");

        int ct =0;  // this variable will hold how many times the program print wanted instructor so if ct equals 0 after printing, it means there is
                    // no person who has wanted attributes

        for (Map.Entry<String,String> each:instructorEntrySet) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();
            String[] eachValueArr = eachValue.split(", ");

            if (wantedSurname.equalsIgnoreCase(eachValueArr[1])){
                System.out.printf("%11s\t\t%-7s\t\t%-9s\t\t%4s\t\t%s\n",eachKey,eachValueArr[0],eachValueArr[1],eachValueArr[2],eachValueArr[3]);
                ct++;
            }
            if (ct==0)
                System.out.println("There is no instructor who has "+wantedSurname+" as surname");

        }


    }

    public static void displayInstructors() {

        Set<Map.Entry<String,String>> instructorEntrySet = instructorsMap.entrySet();

        System.out.println("=============== List of Instructors ===============");
        System.out.println("\nID\t\t\t\tName\t\tSurname\t\t\tBirth Year\tBranch\n");


        for (Map.Entry<String,String> each:instructorEntrySet) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();
            String[] eachValueArr = eachValue.split(", ");
            System.out.printf("%11s\t\t%-7s\t\t%-9s\t\t%4s\t\t%s\n",eachKey,eachValueArr[0],eachValueArr[1],eachValueArr[2],eachValueArr[3]);
        }
    }
}
