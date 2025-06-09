public class Shop {
	String[] pokemonSale;
	int[] prices;
	int[] health;
	int[] level;
	int[] damage;
	String[] types;

	public Shop(String[] pokemonSale, int[] prices, int[] health, int[] level, int[] damage, String[] types) {
		this.pokemonSale = pokemonSale;
		this.prices = prices;
		this.health = health;
		this.level = level;
		this.damage = damage;
		this.types = types;
	}

	public void sortPrice() {
		for (int i = 0; i < prices.length - 1; i++) {
			for (int j = 0; j < prices.length - i - 1; j++) {
				if (prices[j] > prices[j + 1]) {
					swap(j, j + 1);
				}
			}
		}
	}

	public void sortHealth() {
		for (int i = 0; i < health.length - 1; i++) {
			for (int j = 0; j < health.length - i - 1; j++) {
				if (health[j] > health[j + 1]) {
					swap(j, j + 1);
				}
			}
		}
	}

	public void sortLevel() {
		for (int i = 0; i < level.length - 1; i++) {
			for (int j = 0; j < level.length - i - 1; j++) {
				if (level[j] > level[j + 1]) {
					swap(j, j + 1);
				}
			}
		}
	}

	public void sortDamage() {
		for (int i = 0; i < damage.length - 1; i++) {
			for (int j = 0; j < damage.length - i - 1; j++) {
				if (damage[j] > damage[j + 1]) {
					swap(j, j + 1);
				}
			}
		}
	}
	//is this really needed if we only have 1 of each? TBD
	public void searchType(String searchType) {
		System.out.println("🔍 Pokémon of type: " + searchType);
		for (int i = 0; i < types.length; i++) {
			if (types[i].equalsIgnoreCase(searchType)) {
				System.out.println(pokemonSale[i] + " $" + prices[i] + " HP: " + health[i] + " LVL: " + level[i] + " DMG: " + damage[i]);
			}
		}
	}
	//shows what is sorted
	public void displayInventory() {
		System.out.println("🛒 Pokémon on Sale:");
		for (int i = 0; i < pokemonSale.length; i++) {
			System.out.println((i + 1) + ". " + pokemonSale[i] + " | $" + prices[i] +
				" HP: " + health[i] + " LVL: " + level[i] +
				" DMG: " + damage[i] + " Type: " + types[i]);
		}
	}



	//swap func'
	private void swap(int i, int j) {
		//name swap
		String tempName = pokemonSale[i];
		pokemonSale[i] = pokemonSale[j];
		pokemonSale[j] = tempName;

		// price swap
		int tempPrice = prices[i];
		prices[i] = prices[j];
		prices[j] = tempPrice;

		// hp swap
		int tempHealth = health[i];
		health[i] = health[j];
		health[j] = tempHealth;

		// level swap
		int tempLevel = level[i];
		level[i] = level[j];
		level[j] = tempLevel;

		// damage swap
		int tempDamage = damage[i];
		damage[i] = damage[j];
		damage[j] = tempDamage;

		// type swap
		String tempType = types[i];
		types[i] = types[j];
		types[j] = tempType;
	}
}
