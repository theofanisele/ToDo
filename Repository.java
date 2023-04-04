import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

public class Repository extends Entity {    
    private TreeMap<String,Entity> alltodoLists= new TreeMap<String,Entity>();

    public Repository(){
        Entity todo1 = new Entity();
        Entity todo2 = new Entity();
        
        todo1.setName("Study");
        todo1.appendTask("Programming");
        todo1.appendTask("History");
        todo1.appendTask("Geography");

        todo2.setName("House");
        todo2.appendTask("Cook");
        todo2.appendTask("Clean");
        todo2.appendTask("Tidy up room");
        this.alltodoLists.put(todo1.getName(),todo1);
        this.alltodoLists.put(todo2.getName(),todo2);       
    }
    public TreeMap<String,Entity> getAlltodoLists() {
        return this.alltodoLists;
    }
    public ArrayList<String> getEntityByName(String name){
        ArrayList<String> x = this.alltodoLists.get(name).getList();
        return x;
    }
    public Set<String> getEntityNames(){
        Set<String> nameList = getAlltodoLists().keySet();             
        return nameList;
    }
    public void addTask(String name,String name2){        
        Entity x = this.alltodoLists.get(name);
        x.appendTask(name2);        
    } 
    public void removeTask(String name,Integer option){        
        ArrayList<String> x = this.alltodoLists.get(name).getList();
        String elementToDelete = x.get(option);
        x.remove(elementToDelete);        
    }
    public void createNewEntity(String name, String task){        
        Entity instance= new Entity();
        instance.setName(name);
        instance.appendTask(task);
        getAlltodoLists().put(instance.getName(),instance);       
    }
    public Integer getNumberOfTasks(String name){
        Integer x = getAlltodoLists().get(name).getList().size();
        return x;
    }
    public void markCompleted(Integer option, String name){
        Entity x = this.alltodoLists.get(name);
        ArrayList <String> list = x.getList();
        String element = list.get(option);
        list.set(option, element + " !Done!");       
    }
}
