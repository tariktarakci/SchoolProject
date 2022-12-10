import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Student {

    static public Scanner sc = new Scanner(System.in);
    static Map<String,String> studentMap = new HashMap<>();

    public static void transferStudentList(){  // ("ID","name, surname, birth year, school number, grade, class")
        studentMap.put("123456789411","Erdem, Kara, 2008, 3569, 10, A");
        studentMap.put("123456789412","Laurence, Parker, 2008, 4671, 10, B");
        studentMap.put("123456789413","Chao, Wu, 2007, 3492, 11, A");
        studentMap.put("123456789414","Alessandro, DeVito, 2007, 3566, 11, B");
        studentMap.put("123456789415","Mehmet, Osman, 2007, 3321, 11, A");
    }

    public static void studentMenu(){

        do {
            System.out.println(
                    "\n=============== Istanbul College =============== \n\n"
                            +"1- View list of students\n"
                            +"2- Search a student with surname\n"
                            +"3- Search a student with grade \n"
                            +"4- Add a new student\n"
                            +"5- Delete a record with ID\n"
                            +"M- Main menu \n"
                            +"Q- Exit\n"
            );
            Main.choice = sc.next();

            switch (Main.choice){
                case "1":
                    displayStudents();
                    break;
                case "2":
                    findStudentWithSurname();
                    break;
                case "3":
                    findStudentWithGrade();
                    break;
                case "4":
                    addNewStudent();
                    break;
                case "5":
                    delStudent();
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

    private static void delStudent() {
        System.out.println("Enter the ID of student whom you want to delete ");
        String delID = sc.next();
        studentMap.remove(delID);
    }

    private static void addNewStudent() {  // ("ID","name, surname, birth year, school number, grade, class")
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
        System.out.println("School Number:");
        String schoolNum = sc.next();
        System.out.println("Grade:");
        String grade = sc.next();
        System.out.println("Class");
        String stuClass = sc.next();
        Methods.fixLowercase(stuClass);

        studentMap.put(id,name+", "+surname+", "+birthYear+", "+schoolNum+", "+grade+", "+stuClass);

    }

    private static void findStudentWithGrade() {

        Set<Map.Entry<String,String>> studentEntrySet = studentMap.entrySet();

        System.out.println("Enter the grade that you want to search");
        String wantedGrade = sc.next();

        int cnt = 0;

        System.out.println("=============== List of Students ===============");
        System.out.println("\nID\t\t\t\t\tName\t\t\t\tSurname\t\t\tBirth Year\t\tSchool Number\t\tGrade\t\t\tClass\n");


        for (Map.Entry<String,String> each:studentEntrySet) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();
            String[] eachValueArr = eachValue.split(", ");

            if (wantedGrade.equalsIgnoreCase(eachValueArr[4])){
                System.out.printf("%11s\t\t%-12s\t\t%-11s\t\t%-6s\t\t\t%-6s\t\t\t\t%-4s\t\t\t%s\n",eachKey,eachValueArr[0],eachValueArr[1],
                        eachValueArr[2],eachValueArr[3],eachValueArr[4],eachValueArr[5]);
                cnt++;
            }
            if (cnt==0){
                System.out.println("There is no student at "+wantedGrade+". grade");
            }

        }

    }

    private static void findStudentWithSurname() {

        Set<Map.Entry<String,String>> studentEntrySet = studentMap.entrySet();

        System.out.println("Enter the surname of the student whom you search");
        String wantedSurname = sc.next();


        int cnt=0;

        System.out.println("=============== List of Students ===============");
        System.out.println("\nID\t\t\t\t\tName\t\t\t\tSurname\t\t\tBirth Year\t\tSchool Number\t\tGrade\t\t\tClass\n");


        for (Map.Entry<String,String> each:studentEntrySet) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();
            String[] eachValueArr = eachValue.split(", ");

            if (wantedSurname.equalsIgnoreCase(eachValueArr[1])){
                System.out.printf("%11s\t\t%-12s\t\t%-11s\t\t%-6s\t\t\t%-6s\t\t\t\t%-4s\t\t\t%s\n",eachKey,eachValueArr[0],eachValueArr[1],
                        eachValueArr[2],eachValueArr[3],eachValueArr[4],eachValueArr[5]);
                cnt++;
            }
        }
        if (cnt==0){
            System.out.println("There is no student who has "+wantedSurname+" as surname");
        }

    }

    private static void displayStudents() {
        Set<Map.Entry<String,String>> studentEntrySet = studentMap.entrySet();

        System.out.println("=============== List of Students ===============");
        System.out.println("\nID\t\t\t\t\tName\t\t\t\tSurname\t\t\tBirth Year\t\tSchool Number\t\tGrade\t\t\tClass\n");


        for (Map.Entry<String,String> each:studentEntrySet) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();
            String[] eachValueArr = eachValue.split(", ");
            System.out.printf("%11s\t\t%-12s\t\t%-11s\t\t%-6s\t\t\t%-6s\t\t\t\t%-4s\t\t\t%s\n",eachKey,eachValueArr[0],eachValueArr[1],eachValueArr[2],eachValueArr[3],
                            eachValueArr[4],eachValueArr[5]);
        }
    }

}
