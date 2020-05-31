package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2 implements PileI {
    /** par delegation : utilisation de la class Stack */
    private Stack<Object> stk;

    /** la capacite de la pile */
    private int capacite;

    /**
     * Creation d'une pile.
     *
     * @param taille
     *            la taille de la pile, la taille doit etre > 0
     */
    public Pile2(int taille) {
        if (taille <= 0)taille = CAPACITE_PAR_DEFAUT;
        this.stk = new Stack<Object>();
        this.capacite = taille;
    }

    // constructeur fourni
    public Pile2() {
        this(0);
    }

    public void empiler(Object o) throws PilePleineException {
        if (estPleine())throw new PilePleineException();
        this.stk.push(o);
    }

    public Object depiler() throws PileVideException {
        if (estVide())throw new PileVideException();
        return this.stk.pop();
    }

    public Object sommet() throws PileVideException {
        if (estVide())throw new PileVideException();
        return this.stk.peek();
    }

    /**
     * Effectue un test de l'etat de la pile.
     *
     * @return vrai si la pile est vide, faux autrement
     */
    public boolean estVide() {
        // a completer
         return this.taille()==0;
    }

    /**
     * Effectue un test de l'etat de la pile.
     *
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
         return this.taille() == this.capacite;
            }

    /**
     * Retourne une representation en String d'une pile, contenant la
     * representation en String de chaque element.
     *
     * @return une representation en String d'une pile
     */
    public String toString() {


        // if (estVide())
        //     return "[]";
        //     String s = "[";
        // Pile2 temp = new Pile2 (this.capacite());
        // Object elementStk = new Object();
        //
        // while (!estVide()){
        //     try {
        //         elementStk = this.depiler();
        //         temp.empiler(elementStk);
        //     } catch (PileVideException videExc){}
        //       catch (PilePleineException pleineExc){}
        //
        //     s += (elementStk == null)? "NULL":elementStk;
        //     if (!estVide())
        //         s += ", ";
        // }
        //
        //
        // return s + "]";
        StringBuffer sb = new StringBuffer("[");

  Stack<Object> st = new Stack<Object>();

  Stack<Object> st2 = new Stack<Object>();
  for (int i = stk.size() - 1; i >= 0; i--) {
      Object o = stk.pop();
      st.push(o);
      sb.append(o);
      if (i > 0)
          sb.append(", ");
  }
  for (int i = st.size() - 1; i >= 0; i--) {
      Object o2 = st.pop();
      st2.push(o2);
  }
  stk = st2;
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

    /**
     * Retourne le nombre d'element d'une pile.
     *
     * @return le nombre d'element
     */
    public int taille() {
        return this.stk.size();
    }

    /**
     * Retourne la capacite de cette pile.
     *
     * @return le nombre d'element
     */
    public int capacite() {
        return this.capacite;
    }

} // Pile2.java
