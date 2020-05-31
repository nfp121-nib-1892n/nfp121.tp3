package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Vector;

/**
 * Décrivez votre classe PileVector ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile3 implements PileI {

	private Vector<Object> v;

	public Pile3() {
		this(0);
	}

	public Pile3(int taille) {
	if (taille <= 0)taille = CAPACITE_PAR_DEFAUT;
        this.v = new Vector<Object>(taille);
	}

	public void empiler(Object o) throws PilePleineException {
	if (estPleine()) throw new PilePleineException();
        this.v.addElement(o);
	}

	public Object depiler() throws PileVideException {
		if (estVide())throw new PileVideException();
        return this.v.remove(this.taille() -1);
	}

	public Object sommet() throws PileVideException {
		if (estVide())throw new PileVideException();
        return this.v.lastElement();
	}

	public int taille() {
		return this.v.size();
	}

	public int capacite() {
		return this.v.capacity();
	}

	public boolean estVide() {
		return this.taille() == 0; 
		      }

	public boolean estPleine() {
		return this.taille() == this.capacite();
	}

	public String toString() {
	if (estVide())
        return "[]";
        StringBuffer sb = new StringBuffer("["); 
        for (int i = this.taille() - 1; i >= 0; i--) {
            sb.append(this.v.get(i));
            if (i > 0)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
	}

	public boolean equals(Object o) {
		PileI other = (PileI)o;
        if (o == null)
               return false;
        if (!(o instanceof PileI))
               return false;       
        if (this.taille() != other.taille())
               return false;
         if (this.capacite() != other.capacite())
               return false; 
         
         if (this == other)
               return true;
         
               
         if (other.taille() == 0)
               return true;
         if(this.toString().equals(other.toString())) 
               return true;
         
        return false;
	}

	// fonction fournie
	public int hashCode() {
		return toString().hashCode();
	}

}
