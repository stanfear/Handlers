/**
 * @version 1.0
 * @author tristan Roche (Stan_fear)
 * 
 * for MoreMaterials 1.8 and later
 */

import java.util.Map;

import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

import net.morematerials.MoreMaterials;
import net.morematerials.handlers.GenericHandler;


public class LaserDrillHandler extends GenericHandler {

	@Override
	public void init(MoreMaterials arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onActivation(Event event, Map<String, Object> config) {
		
		if(!(event instanceof PlayerInteractEvent))
			return;
		
		// casting the event to have all necessary data
		PlayerInteractEvent castedEvent = (PlayerInteractEvent) event;
		
		// getting the player (to set the origin of the laser drill and the direction)
		Player shooter = castedEvent.getPlayer();
		
		// getting the direction the player is looking at
		Vector playerLookingat = shooter.getEyeLocation().getDirection();
		
		// creating the laser beam (actually, it's a fire ball, but shhhhh !) (and launching it ?)
		Fireball fireball = (Fireball) shooter.getWorld().spawn(
				shooter.getLocation(), Fireball.class);

		fireball.setBounce(false);
		fireball.setDirection(playerLookingat);
		fireball.setShooter(shooter);
		fireball.setYield(1.0F); // the radius of the explosion
		fireball.setIsIncendiary(false); // if the explosion must create fire
		fireball.setVelocity(new Vector(10,10,10));
		
	}

	@Override
	public void shutdown() {
		// TODO Auto-generated method stub

	}

}
