package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile4 implements PileI, Cloneable {
    /** la liste des Maillons/Elements */
    private Maillon stk;
    /** la capacité de la pile */
    private int capacite;
    /** le nombre */
    private int nombre;

    /**
     * Classe interne "statique" contenant chaque élément de la chaine c'est une
     * proposition, vous pouvez l'ignorer !
     */
    private static class Maillon implements Cloneable {
        private Object element;
        private Maillon suivant;

        public Maillon(Object element, Maillon suivant) {
            this.element = element;
            this.suivant = suivant;
        }

        public Maillon suivant() {
            return this.suivant;
        }

        public Object element() {
            return this.element;
        }

        public Object clone() throws CloneNotSupportedException {
            Maillon m = (Maillon) super.clone();
            m.element = element;
            return m;
        }
    }



    public Pile4(int taille) {
        if (taille <= 0)taille = CAPACITE_PAR_DEFAUT;
        this.stk = null;
        this.nombre = 0;
        this.capacite = taille;

    }

    public Pile4() {
        this(PileI.CAPACITE_PAR_DEFAUT);
    }

    public void empiler(Object o) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
            Maillon m = new Maillon(o, stk);
            stk = m;
            nombre ++;
    }

    public Object depiler() throws PileVideException {
        if (estVide())
        throw new PileVideException();
        // à compléter
        Object element = stk.element();
        stk = stk.suivant();
        nombre --;
        return element;
    }

    public Object sommet() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        return this.stk.element(); // à compléter
    }


    public boolean estVide() {
        return this.stk == null; // à compléter
    }

    /**
     * Effectue un test de l'état de la pile.
     *
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
        return this.capacite == this.nombre; // à compléter
    }

    /**
     * Retourne une représentation en String d'une pile, contenant la
     * représentation en String de chaque élément.
     *
     * @return une représentation en String d'une pile
     */
    public String toString() {

       // if (estVide())return "[]";
         // if (stk == null)return "[]";
         //      String toReturn="[" + stk.toString() + "]";
         // return  toReturn;

       String s = "[";

      Maillon x1 = null;

        try {
            x1 = (Maillon) stk.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        while (x1 != null) {
            s += x1.element() + (x1.suivant() != null ? ", " : "");
            x1 = x1.suivant;
        }
        s = s + "]";
        System.out.println(s);
        return s;
    }

    public boolean equals(Object o) {
    /*    if (o instanceof Pile4) {
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
            }
        return false;
        */
       if (o instanceof Pile4) {
           
           Pile4 pile = (Pile4) o;

            if (stk == o)
                return true;

            if (stk == null || o == null)
                return false;

            if (this.capacite() != pile.capacite())
                return false;

            while (stk != null) {
                Object x = stk.element();
                Object x1 = pile.stk.element();

                if (!x.equals(x1))
                    return false;
                stk = stk.suivant();
                pile.stk = pile.stk.suivant();
            }
            return true;
        }
        return false;
    }

    public int capacite() {
        return this.capacite;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public int taille() {
        return nombre;
    }
}
