import java.util.Random;

public class Wumpus {
	
	/**Place holder for items in this room*/
	private static final String ITEMS[] = {"sword", "chest", "tree"};
	
	public static final Random rand = new Random();
	
	public static void main(String args[]){
		final int ROOM_COUNT = 5;
		Room[] rooms = new Room[ROOM_COUNT];
		
		for(int i=0; i < rooms.length; i++){
			rooms[i] = new Room();
			rooms[i].populate(ITEMS[rand.nextInt(ITEMS.length)]);
		}
		
		rooms[0].addDoor(rooms[1], rooms[3]);
		rooms[1].addDoor(rooms[0], rooms[4]);
		rooms[2].addDoor(rooms[3]);
		rooms[3].addDoor(rooms[0], rooms[2], rooms[4]);
		rooms[4].addDoor(rooms[1], rooms[3]);
		
		for(Room room:rooms)
			System.out.println(room);
		
	}

}
