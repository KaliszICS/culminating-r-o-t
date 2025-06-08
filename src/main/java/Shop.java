public class Shop{
	String[] pokemonSale;
	int[] prices;
	int[] health;

	public Shop(String[] pokemonSale, int[] prices){
		this.pokemonSale = pokemonSale;
		this.prices = prices;
	}
	public void sortHealth(){
		for(int i = 0; i < health.length - 1; i++){
			for(int j = 0; j < health.length - i - 1; j++){
				if(health[j] > health[j + 1]){
					//swapping health
					int healthTemp = health[j];
					health[j] = health[j + 1];
					health[j + 1] = healthTemp;

					//Pokemon name swapping
					String nameTemp = pokemonSale[j];
					pokemonSale[j] = pokemonSale[j + 1];
					pokemonSale[j + 1] = nameTemp;
				}
			}
		}
	}

	public void sortPrice(){
		for(int i = 0; i < prices.length - 1; i++){
			for(int j = 0; j < prices.length - i - 1; j++){
				if(prices[j] > prices[j + 1]){
					//swapping prices
					int priceTemp = prices[j];
					prices[j] = prices[j + 1];
					prices[j + 1] = priceTemp;

					//Pokemon name swapping
					String nameTemp = pokemonSale[j];
					pokemonSale[j] = pokemonSale[j + 1];
					pokemonSale[j + 1] = nameTemp;
				}
			}
		}
	}

	//shows the list of pokemon on sale(use shop.sort___ then shop.displayinv to see sorted)
	public void displayInventory() {
		System.out.println("Pokeman on sale:");
		for(int i = 0; i < pokemonSale.length; i++){
			System.out.println((i + 1) + ". " + pokemonSale[i] + " - $" + prices[i]);
		}
		for(int i = 0; i < pokemonSale.length; i++){
			System.out.println((i + 1) + ". " + pokemonSale[i] + " - HP" + health[i]);
		}
	}
}