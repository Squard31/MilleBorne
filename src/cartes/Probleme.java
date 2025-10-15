package cartes;

import java.util.Objects;

public abstract class Probleme extends Carte {
	
	private Type type;
	
	protected Probleme(Type type) {
		this.type = type;
	}
	
	public Type getType() {
		return type;
	}
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Probleme prob = (Probleme) obj;
        return type == prob.type;
    }
	
	@Override
	public int hashCode() {
		return Objects.hash(getClass(), type);
		
	}

}

