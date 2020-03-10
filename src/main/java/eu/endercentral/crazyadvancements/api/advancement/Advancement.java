package eu.endercentral.crazyadvancements.api.advancement;

import org.bukkit.Keyed;
import org.jetbrains.annotations.Nullable;


/**
 * @author sarhatabaot
 */
public interface Advancement extends Keyed {
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
}
