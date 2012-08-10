import java.util.Map;

import org.bukkit.Location;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.material.Openable;
import org.getspout.spoutapi.block.SpoutBlock;
import org.getspout.spoutapi.inventory.SpoutItemStack;
import org.getspout.spoutapi.material.CustomItem;
import org.getspout.spoutapi.material.Material;

import net.morematerials.MoreMaterials;
import net.morematerials.handlers.GenericHandler;


public class IDCardReader extends GenericHandler {
	
	private MoreMaterials plugin;
	
	@Override
	public void init(MoreMaterials plugin) {
		this.plugin = plugin;
	}


	@Override
	public void onActivation(Event event, Map<String, Object> config) 
	{
		// casting the event to have all necessary data
		PlayerInteractEvent castedEvent = (PlayerInteractEvent) event;
		
		// getting the block object of the card reader
		SpoutBlock cardReader = (SpoutBlock) castedEvent.getClickedBlock();
		
		Location loc = cardReader.getLocation();
		
		// getting the IDcard (in the hand of the player)
		SpoutItemStack inHandItem = (SpoutItemStack) castedEvent.getItem();
		
		// getting the identifier of the IDCard as it is set in the config
		Material idCard = this.plugin.getSmpManager().getMaterial((Integer) config.get("IDcardName"));

		// check if the item in hand is the card
		if (!(inHandItem instanceof CustomItem))
			return;
		// if the item is not the card, we stop there
		if(inHandItem != idCard)
			return;

		/**
		 * we now know that the player has the right item in his hand.
		 */

		String method = (String) config.get("openMethod");
		int delay = (int) config.get("delay");
		
		switch(method) // even tho there is only one method, we let the possibility to add more
		{
			case "door2door":
				openRec(loc.add(1, 0, 0), loc, delay);
				openRec(loc.add(-1, 0, 0), loc, delay);
				openRec(loc.add(0, 0, 1), loc, delay);
				openRec(loc.add(0, 0, -1), loc, delay);
				
				break;
				
			default : 
				break;
				
		}
		
		// the door(s) is(are) open and will close in 'delay'
		//     -> we have finished our work
		
		
	}

	
	private void openRec(Location loc, Location locFrom, long delay) 
	{
		// check if the block is an openable block (i.e. a door, a trapdoor, a gate, ...)
		if(loc.getBlock() instanceof Openable)
		{
			// first, open and schedule the closing
			final Openable door = (Openable) loc.getBlock();
			door.setOpen(true);
			this.plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
				  public void run() {
					  door.setOpen(false);
				  }
				}, 60L);
			
			if(!locFrom.equals(loc.add(1, 0, 0)))
				openRec(loc.add(1, 0, 0), loc, delay);
			
			if(!locFrom.equals(loc.add(-1, 0, 0)))		
				openRec(loc.add(-1, 0, 0), loc, delay);
			
			if(!locFrom.equals(loc.add(0, 0, 1)))
				openRec(loc.add(0, 0, 1), loc, delay);
			
			if(!locFrom.equals(loc.add(0, 0, -1)))
				openRec(loc.add(0, 0, -1), loc, delay);
		}
	}


	@Override
	public void shutdown() {
		// TODO Auto-generated method stub

	}
	
}
