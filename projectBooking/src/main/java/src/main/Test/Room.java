package src.main.Test;

import org.springframework.beans.factory.annotation.Autowired;

public class Room {
	@Autowired
    private Table table;
 
    public Room() {
    }
 
    public Room(Table table) {
        this.table = table;
    }
 
    public Table getTable() {
        return table;
    }
 
    public void setTable(Table table) {
        this.table = table;
    }
}
