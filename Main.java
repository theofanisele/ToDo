import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Repository repo = new Repository() ;
        Menu menu = new Menu(repo);
        Scanner scanner = new Scanner(System.in); 
        Boolean flag = true;

        while(flag){
            System.out.println("");
            System.out.println("-----------------------------------");    
            System.out.println("1. View all todo lists");
            System.out.println("2. Choose a list to view tasks");
            System.out.println("3. Add tasks to a list");
            System.out.println("4. Remove a task");
            System.out.println("5. Add a to do list");
            System.out.println("6. Mark a task completed");
            System.out.println("7. Exit");
            System.out.println("-----------------------------------");
            System.out.println("");
            System.out.println("Please type in a choice");
            String input = scanner.next();/*Get what the User types*/
            switch(input){
                case "1":
                    menu.getAllEntityNames();                    
                    break;                
                case "2":
                    menu.showEntityByName();
                    break;
                case "3":            
                    menu.appendTaskToEntity();
                    break;
                case "4":
                    menu.removeTask();                
                    break;
                case "5":
                    menu.createEntity();
                    break;

                case "6":
                    menu.markDone();
                    break;    
                case "7":
                    scanner.close();
                    flag = false;
                    break;
                default:
                    System.out.println("Choice doesn't exist!");
            }                   
        }              
    }            
}   