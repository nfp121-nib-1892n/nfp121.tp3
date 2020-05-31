package question2;

import question1.PilePleineException;
import question1.PileVideException;

/**
 * A remplacer en partie par votre classe Pile de la question 1.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile implements PileI {

    private Object[] zone;
    private int ptr;
    public int cap = CAPACITE_PAR_DEFAUT;

    public Pile(int taille) {
        if (taille <= 0)taille = cap;
        this.zone = new Object[taille];
        this.ptr = 0;
    }

    public Pile() {
        this(CAPACITE_PAR_DEFAUT);
    }

    public void empiler(Object o) throws PilePleineException {
        if (estPleine())throw new PilePleineException();
        this.zone[this.ptr] = o;
        this.ptr++;
    }

    public Object depiler() throws PileVideException {
        if (estVide())throw new PileVideException();
        this.ptr--;
        return this.zone[ptr];
        //return null;
    }

    public Object sommet() throws PileVideException {
        if (estVide())throw new PileVideException();
        return this.zone[this.ptr - 1];
    }

    public int capacite() {
        return this.zone.length;
    }

    public int taille() {
        return this.ptr;

    }

    public boolean estVide() {
        return ptr == 0;

    }

    public boolean estPleine() {
        return ptr == zone.length;
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

        //return zone.equals(o);
    }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        if (estVide())
            return "[]";
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i = ptr - 1; i >= 0; i--) {
            sb.append((zone[i] == null)? "NULL":zone[i].toString());
            if (i > 0)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
