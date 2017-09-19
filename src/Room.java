import java.util.ArrayList;

public class Room {
	
	/**Counter for rooms*/
	private static int COUNTER = 0;
	
	/**Connection to next room*/
	private ArrayList<Room> doors;
	
	private String item;
	private final int ID;
	
	public Room(){
		doors = new ArrayList<>(4);
		ID = COUNTER++;
	}
	
	public void addDoor(Room ...doors){
		if(doors != null && doors.length > 0){
			for(Room  door:doors){
				this.doors.add(door);
			}
		}
	}
	
	public void populate(String item){
		if(item!=null)
			this.item = item;
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + ((doors == null) ? 0 : doors.hashCode());
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		if (ID != other.ID)
			return false;
		if (doors == null) {
			if (other.doors != null)
				return false;
		} else if (!doors.equals(other.doors))
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		return true;
	}

	public String toString(){
		StringBuilder roomNumbers = new StringBuilder("Doors: ");
		for(Room door: doors){
			roomNumbers.append("#");
			roomNumbers.append(door.ID);
			roomNumbers.append(" ");
		}
		
		return "Room ID " + ID + ", item in room " + item + ", connected to rooms " + roomNumbers;
	}
	
}
