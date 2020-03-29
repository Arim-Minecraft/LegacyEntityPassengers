package space.arim.legacyentitypassengers;

import org.bukkit.entity.Entity;

/**
 * LegacyEntityPassengers class
 * 
 * @author A248
 *
 */
public final class LegacyEntityPassengers {

	private LegacyEntityPassengers() {}
	
	/**
	 * Invokes the method to get the primary passenger of the entity
	 * 
	 * @param entity the entity
	 * @return the passenger
	 */
	public static Entity invoke(Entity entity) {
		return entity.getPassenger();
	}
	
}
