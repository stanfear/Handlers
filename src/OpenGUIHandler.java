/**
 * @version 1.0
 * @author tristan Roche (Stan_fear)
 * 
 * for MoreMaterials 1.8 and later
 */

import java.util.Map;

import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerInteractEvent;
import org.getspout.spoutapi.gui.ScreenType;
import org.getspout.spoutapi.player.SpoutPlayer;

import net.morematerials.MoreMaterials;
import net.morematerials.handlers.GenericHandler;


public class OpenGUIHandler extends GenericHandler {

	@Override
	public void init(MoreMaterials arg0) {
	}

	@Override
	public void onActivation(Event event, Map<String, Object> config) {

		// check if the handler (event part) is well configured
		if(!(event instanceof PlayerInteractEvent))
			return; // if any player is not involve, to whom shall we open the GUI ?
		
		// casting the event to have all necessary data
		PlayerInteractEvent castedEvent = (PlayerInteractEvent) event;
		
		// getting the player
		SpoutPlayer player = (SpoutPlayer) castedEvent.getPlayer();
		
		String guiType = (String) config.get("GUIType");
		
		switch(guiType)
		{
		case "AddWaypoint":
			player.openScreen(ScreenType.ADD_WAYPOINT);
			break;
		case "GameOver":
			player.openScreen(ScreenType.GAME_OVER_SCREEN);
			break;
		case "EnchantmentTable":
			player.openScreen(ScreenType.ENCHANTMENT_INVENTORY);
			break;
		case "CreativeInv":
			player.openScreen(ScreenType.PLAYER_INVENTORY_CREATIVE);
			break;
		case "GameFinished":
			player.openScreen(ScreenType.WIN_GAME);
			break;
		case "Workbench":
			player.openScreen(ScreenType.WORKBENCH_INVENTORY);
			break;
		default : 
			break;
				
		}
		
		

	}

	@Override
	public void shutdown() {
	}

}
