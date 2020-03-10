package eu.endercentral.crazyadvancements.api.advancement;

import eu.endercentral.crazyadvancements.implementation.NameKey;
import eu.endercentral.crazyadvancements.implementation.advancement.CrazyAdvancement;
import org.bukkit.Warning;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * @author sarhatabaot
 */
public interface Advancement /*extends Keyed*/ {
	/**
	 * @return JSON representation of current {@link Advancement} instance
	 */
	String getAdvancementJSON();

	/**
	 * @return The parent Advancement
	 */
	@Nullable
	Advancement getParent();

	void setCriteria(int criteria);

	/**
	 * @return Required Criteria Amount
	 */
	int getCriteria();

	/**
	 * Displays an Advancement Message to every Player saying Player has completed said advancement<br>
	 * Note that this doesn't grant the advancement
	 *
	 * @param player Player who has recieved the advancement
	 */
	void displayMessageToEverybody(Player player);

	/**
	 * Sends a Toast Message regardless if the Player has it in one of their Advancement Managers or not
	 * @param player Player who should see the Toast Message
	 */
	void displayToast(Player player);

	/**
	 * Sets the Reward for completing the Advancement
	 * @param reward
	 */
	void setReward(@Nullable AdvancementReward reward);

	/**
	 * @return Currently set Reward
	 */
	AdvancementReward getReward();

	/**
	 * @return Root {@link Advancement}
	 */
	Advancement getRootAdvancement();

	/**
	 * @return Unique Name of Advancement Tab
	 */
	NameKey getTab();

	/**
	 * @return All parents and children
	 */
	List<Advancement> getRow();

	/**
	 * @return All parents
	 */
	List<Advancement> getRowUntil();

	/**
	 * @return All children
	 */
	List<Advancement> getRowAfter();

	/**
	 * @param player Player to check
	 * @return true if advancement is granted
	 */
	boolean isGranted(Player player);

	/**
	 * @param player Player to check
	 * @return true if any parent is granted
	 */
	boolean isAnythingGrantedUntil(Player player);

	/**
	 * @param player Player to check
	 * @return true if any child is granted
	 */
	boolean isAnythingGrantedAfter(Player player);

	void saveHiddenStatus(Player player, boolean hidden);

	boolean getHiddenStatus(Player player);

	boolean isDone(Player player);

	boolean isDone(UUID uuid);

}
