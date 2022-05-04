package world.location;

import java.util.List;
import java.util.Map;

import world.DatabaseObject;
import world.Room;

public interface LocationComp {

	Location compileWorld(List<DatabaseObject> databaseArray);

	Location compileWorld(Map<String, Room> roomSet);

}