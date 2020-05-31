package question3;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2<T> implements PileI<T>{
    /** par délégation : utilisation de la class Stack */
    private Stack<T> stk;
    /** la capacité de la pile */
    private int capacite;

    /** Création d'une pile.
     * @param taille la "taille maximale" de la pile, doit être > 0
     */
    public Pile2(int taille){
        if (taille <= 0)taille = CAPACITE_PAR_DEFAUT;
        this.stk = new Stack<T>();
        this.capacite = taille;
    }

    public Pile2(){
        // � compléter
        this(0);
    }

    public void empiler(T o) throws PilePleineException{
        if (estPleine())throw new PilePleineException();
        this.stk.push(o);
    }

    public T depiler() throws PileVideException{
        if (estVide())throw new PileVideException();
        return this.stk.pop();
    }

    public T sommet() throws PileVideException{
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
        
        
        if (estVide())
            return "[]";
            String s = "[";
        Pile2 temp = new Pile2 (this.capacite());
        Object elementStk = new Object();
        
        while (!estVide()){
            try {
                elementStk = this.depiler();
                temp.empiler(elementStk);
            } catch (PileVideException videExc){}
              catch (PilePleineException pleineExc){}
              
            s += (elementStk == null)? "NULL":elementStk;
            if (!estVide())
                s += ", ";
        }
        
        
        return s + "]";
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
