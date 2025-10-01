package cartes;

public class Parade extends Probleme {

	public Parade(Type type) {
		super(type);
	}
	
	@Override
	public String toString() {
		return getType().getParade();
	}

}

