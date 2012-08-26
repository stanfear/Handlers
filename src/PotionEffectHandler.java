import java.util.Map;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;
import org.getspout.spoutapi.particle.Particle;
import org.getspout.spoutapi.particle.Particle.ParticleType;

import net.morematerials.MoreMaterials;
import net.morematerials.handlers.GenericHandler;

/**
 * @version 1.0
 * @author tristan Roche (Stan_fear)
 * 
 * for MoreMaterials 1.8 and later
 */
public class PotionEffectHandler extends GenericHandler {

	@Override
	public void init(MoreMaterials arg0) {
		//TODO
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onActivation(Event event, Map<String, Object> config) {
		
		
		if(!(event instanceof PlayerInteractEvent))
			return;
		
		// casting the event to have all necessary data
		PlayerInteractEvent castedEvent = (PlayerInteractEvent) event;
		
		// getting the player
		Player caster = castedEvent.getPlayer();
		
		// getting the setting of the handler
		String potionType = (String) config.get("potionType");
		int amplifier = (int) config.get("amplifier");
		int duration = (int) config.get("duration");
	
		// selecting the potion effect
		PotionEffectType effect;
		switch(potionType){
		
			case "blindness":
				effect = PotionEffectType.BLINDNESS;
				break;
				
			case "confusion":
				effect = PotionEffectType.CONFUSION;
				break;
				
			case "damage_resistance":
				effect = PotionEffectType.DAMAGE_RESISTANCE;
				break;
				
			case "fast_digging":
				effect = PotionEffectType.FAST_DIGGING;
				break;
				
			case "harm":
				effect = PotionEffectType.HARM;
				break;
				
			case "heal":
				effect = PotionEffectType.HEAL;
				break;
				
			case "hunger":
				effect = PotionEffectType.HUNGER;
				break;
				
			case "increase_damage":
				effect = PotionEffectType.INCREASE_DAMAGE;
				break;
				
			case "invisibility":
				effect = PotionEffectType.INVISIBILITY;
				break;
				
			case "jump":
				effect = PotionEffectType.JUMP;
				break;
				
			case "night_vision":
				effect = PotionEffectType.NIGHT_VISION;
				break;
				
			case "poison":
				effect = PotionEffectType.POISON;
				break;
				
			case "regeneration":
				effect = PotionEffectType.REGENERATION;
				break;
				
			case "slow":
				effect = PotionEffectType.SLOW;
				break;
				
			case "slow_digging":
				effect = PotionEffectType.SLOW_DIGGING;
				break;
				
			case "speed":
				effect = PotionEffectType.SPEED;
				break;
				
			case "water_breathing":
				effect = PotionEffectType.WATER_BREATHING;
				break;
				
			case "weakness":
				effect = PotionEffectType.WEAKNESS;
				break;
				
			default: 
				effect = null;
				break;
		}
		
		
		caster.addPotionEffect(new PotionEffect(effect, duration, amplifier), true);
	
		
		// Selecting the particle type
		String particleType = (String) config.get("particleType");
		ParticleType particle;
		switch(particleType){

		case "Bubble":
			particle = ParticleType.BUBBLE;
			break;
			
		case "Cloud":
			particle = ParticleType.CLOUD;
			break;
			
		case "Crit":
			particle = ParticleType.CRIT;
			break;
			
		case "DepthSuspend":
			particle = ParticleType.DEPTHSUSPEND;
			break;
			
		case "DripLava":
			particle = ParticleType.DRIPLAVA;
			break;
			
		case "DripWater":
			particle = ParticleType.DRIPWATER;
			break;
			
		case "EnchantmentTable":
			particle = ParticleType.ENCHANTMENTTABLE;
			break;			
			
		case "Explode":
			particle = ParticleType.EXPLODE;
			break;
			
		case "Flame":
			particle = ParticleType.FLAME;
			break;
			
		case "FootStep":
			particle = ParticleType.FOOTSTEP;
			break;
			
		case "Heart":
			particle = ParticleType.HEART;
			break;
			
		case "LargeSmoke":
			particle = ParticleType.LARGESMOKE;
			break;
			
		case "Lava":
			particle = ParticleType.LAVA;
			break;
			
		case "MagicCrit":
			particle = ParticleType.MAGICCRIT;
			break;
			
		case "MobSpell":
			particle = ParticleType.MOBSPELL;
			break;
			
		case "Note":
			particle = ParticleType.NOTE;
			break;
			
		case "Portal":
			particle = ParticleType.PORTAL;
			break;
			
		case "RedDust":
			particle = ParticleType.REDDUST;
			break;
			
		case "Slime":
			particle = ParticleType.SLIME;
			break;
			
		case "Smoke":
			particle = ParticleType.SMOKE;
			break;
			
		case "SnowBallPoof":
			particle = ParticleType.SNOWBALLPOOF;
			break;
			
		case "SnowShovel":
			particle = ParticleType.SNOWSHOVEL;	
			break;		
			
		case "Spell":
			particle = ParticleType.SPELL;
			break;
			
		case "Splash":
			particle = ParticleType.SPLASH;
			break;
			
		case "Suspended":
			particle = ParticleType.SUSPENDED;
			break;
			
		case "TownAura":
			particle = ParticleType.TOWNAURA;
			break;
			
		case "Unknown":
		default :
			particle = ParticleType.UNKNOWN;
			break;
	
		}
		
		
		Particle particleEntity = new Particle(particle, caster.getLocation(), new Vector(0.5D, 3.0D, 0.5D));

		// Selecting the particle color
		String particleColor = (String) config.get("particleColor");
		switch(particleColor){
		
		case "White":
	  		particleEntity.setParticleBlue(1.0F).setParticleGreen(1.0F).setParticleRed(1.0F);
			break;

		case "Black":
	  		particleEntity.setParticleBlue(0.0F).setParticleGreen(0.0F).setParticleRed(0.0F);
			break;

		case "Blue":
	  		particleEntity.setParticleBlue(1.0F).setParticleGreen(0.0F).setParticleRed(0.0F);
			break;

		case "Green":
	  		particleEntity.setParticleBlue(0.0F).setParticleGreen(1.0F).setParticleRed(0.0F);
			break;

		case "Red":
	  		particleEntity.setParticleBlue(0.0F).setParticleGreen(0.0F).setParticleRed(1.0F);
			break;

		case "Cyan":
	  		particleEntity.setParticleBlue(1.0F).setParticleGreen(1.0F).setParticleRed(0.0F);
			break;

		case "Yellow":
	  		particleEntity.setParticleBlue(0.0F).setParticleGreen(1.0F).setParticleRed(1.0F);
			break;

		case "Magenta":
	  		particleEntity.setParticleBlue(1.0F).setParticleGreen(0.0F).setParticleRed(1.0F);
			break;
		}

  		particleEntity.setMaxAge(40).setAmount(15).setGravity(0.9F);
  		particleEntity.spawn();
		
		// now we're over !
	}

	@Override
	public void shutdown() {
		//TODO
	}

}
