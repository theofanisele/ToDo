import java.util.ArrayList;
public class Entity {
    private String name;
    private ArrayList<String> list = new ArrayList<String>() ;

    public Entity(){
    }
    public Entity(String newName, ArrayList<String> newList){
        this.name = newName;
        this.list = newList;
    }
    
    public void setName (String name){
        this.name = name;
    }
    public String getName (){
        return this.name;
    }
    public void appendTask(String y){
        this.list.add(y);   
    }
    public ArrayList<String> getList(){
        return this.list;
    }
    public String getTask(Integer index){
        String element = this.list.get(index);
        return element;
    }
}








 
