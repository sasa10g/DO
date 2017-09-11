package strategy;

public class ContextStrategy {

	private Strategy strategy;

	
	public void saveContext(){
		strategy.save();
	}
	
	public void LoadContext(){
		strategy.load();
	}
	
	public Strategy getStrategy() {
		return strategy;
	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}


}
