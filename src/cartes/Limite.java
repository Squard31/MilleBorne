package cartes;

public abstract class Limite extends Carte {
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		return getClass().hashCode();
	}

}

