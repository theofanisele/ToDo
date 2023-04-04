
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Menu{
    private Repository repo = new Repository() ;
    private Scanner scanner = new Scanner(System.in);

    public Menu(Repository repo){

    }
    public void getAllEntityNames(){
        Set<String> nameList = repo.getEntityNames();
        Iterator<String> i = nameList.iterator();
        Integer count = 0;
        while (i.hasNext()) {
            count += 1;
            System.out.println("List " + count +": "+ i.next());
        }                
    }
    public String showEntityByName(){  
        String name;
        System.out.println("Please type the name of the list");
        name = scanner.next();            
        while(repo.getEntityNames().contains(name) != true){
            System.out.println("List name entered is not a match. Please try again!");
            name = scanner.next();
        }
        ArrayList <String> x = repo.getEntityByName(name);
        Iterator<String> i = x.iterator();
        Integer count = 0;
        while (i.hasNext()) {
            count += 1;
            System.out.println("Task " + count +": "+ i.next());
        }
        return name;
    }
    public void appendTaskToEntity(){
        String task;
        String name = showEntityByName();
        System.out.println("Please type the task to be added to list");
        task = scanner.next();
        repo.addTask(name,task);
        
    }
    public void removeTask(){
        getAllEntityNames();
        String entityName =  showEntityByName();
        Integer noftasks = repo.getNumberOfTasks(entityName);
        Integer option =3;
        Boolean flag = true;
        System.out.println("Please insert the number of the task to delete");
        while(flag) {
            try {
                option = Integer.parseInt(scanner.nextLine());
                if (option < 0 || option > noftasks){
                    flag = true;
                    System.out.println("Wrong number. Try again!");
                }else {
                    flag = false;
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please insert an Integer number!");
            }
        }
        repo.removeTask(entityName,option-1);
    }

    public void markDone(){
        Integer option =10;
        getAllEntityNames();
        String entityName =  showEntityByName();
        Integer noftasks = repo.getNumberOfTasks(entityName);
        Boolean flag = true;
        System.out.println("Please type the number of the task to mark complete");
        while(flag) {
            try {
                option = Integer.parseInt(scanner.nextLine());
                if (option < 0 || option > noftasks){
                    flag = true;
                    System.out.println("Wrong number. Try again!");
                }else {
                    flag = false;
                    break;
                } 
                } catch (NumberFormatException e) {
                    System.out.println("Please insert an Integer number!");
                }
        }
        repo.markCompleted(option -1,entityName);
    }
    public void createEntity (){
        Set<String> list = repo.getEntityNames();
        List<String> arr = new ArrayList<>();
        arr.addAll(list);
        System.out.println(arr);
        String name1 = "";
        Boolean flag = true;
        while(flag){
            System.out.println("Please type the name of the list");
            name1 = scanner.next();            
            for (int i = 0; i < arr.size();i++){               
                if(name1 == arr.get(i)){
                    System.out.println("List name already exists. Try another name!");
                    name1 = scanner.next();
                    break;
                    
                } else{
                    
                    flag = false;
                }
            }
        }
        System.out.println("Please type the task to be added");
        String task1 = scanner.next();
        repo.createNewEntity(name1,task1);
    }
}
