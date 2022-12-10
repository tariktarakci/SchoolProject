import java.util.Scanner;

public class Methods {

    static Scanner sc = new Scanner(System.in);
    public static void mainMenu() {


        do {
            System.out.println( "\n=============== Istanbul College =============== \n"
                            + "   =============== Main Menu ===============\n"
                            + "\n"
                            + "\t1- View School Information\n"
                            + "\t2- Instructor Menu\n"
                            + "\t3- Student Menu\n"
                            + "\tQ- Exit\n"
            );
            System.out.println("Please select an option from menu\n");
            Main.choice=sc.nextLine();

            switch (Main.choice){
                case "1":  // School Information
                    Methods.printSchoolInfo();
                    break ;
                case "2":  // Instructor Menu
                    Instructor.instructorMenu();
                    break;
                case "3":  // Student Menu
                    Student.studentMenu();
                    break;
                case "q":
                case "Q":
                    break;
                default:
                    System.out.println("Please enter a valid character");
            }

        }while (!Main.choice.equalsIgnoreCase("q"));



    }

    private static void printSchoolInfo()  {
        System.out.println("\n"+SchoolInfo.schoolName+"\n"
                          +"Address: "+SchoolInfo.address+"\n"
                          +"Telephon Number: "+SchoolInfo.telephonNumber
                          );
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static String fixLowercase(String str) { // this method makes first letters uppercase and other lowercase
        String[] strArr = str.toLowerCase().split("");
        str = strArr[0].toUpperCase();
        for (int i = 1; i < strArr.length ; i++) {
            str=str+strArr[i];
        }
        return str;
    }

    public static void exit() {
        System.out.println("You exited the application");
        System.exit(0);
    }
}
