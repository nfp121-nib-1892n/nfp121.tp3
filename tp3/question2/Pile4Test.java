package question2;


public class Pile4Test extends junit.framework.TestCase {
	// Définissez ici les variables d'instance nécessaires à vos engagements;
	// Vos pouvez également les saisir automatiquement du présentoir
	// à l'aide du menu contextuel "Présentoir --> Engagements".
	// Notez cependant que e dernier ne peut saisir les objets primitifs
	// du présentoir (les objets sans constructeur, comme int, float, etc.).

	/**
	 * Constructeur de la classe-test Pile2Test
	 */
	public Pile4Test() {
	}

	/**
	 * Met en place les engagements.
	 *
	 * Méthode appelée avant chaque appel de méthode de test.
	 */


	/**
	 * Supprime les engagements
	 *
	 * Méthode appelée après chaque appel de méthode de test.
	 */
	protected void tearDown() // throws java.lang.Exception
	{
		// Libérez ici les ressources engagées par setUp()
	}
    private PileI p1;
    private PileI p2;

    public void setUp() {
        p1 = new question2.Pile4();
        p2 = new question2.Pile4();
    }

    public void test_Pile_capacite() {
        assertEquals(PileI.CAPACITE_PAR_DEFAUT, p1.capacite());
    }

    public void test_Pile_estPleine() throws Exception {
        PileI p = new question2.Pile4(3);
        p.empiler(3);
        assertEquals(1, p.taille());
        p.empiler(2);
        assertEquals(2, p.taille());
        p.empiler(1);
        assertEquals(3, p.taille());

        assertEquals(true, p.estPleine());
        assertEquals(p.taille(), p.capacite());
        try {
            p.empiler(0);
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof question1.PilePleineException);
        }
    }

    public void test_Pile_sommet() throws Exception {
        PileI p = new question2.Pile4(3);
        assertEquals(true, p.estVide());

        p.empiler(new Integer(3));
        assertEquals(" sommet ?? ", new Integer(3), p.sommet());
        assertEquals(1, p.taille());
        assertEquals(" depiler ?? ", new Integer(3), p.depiler());
        assertEquals(0, p.taille());
    }

    public void test_Pile_estVide() throws Exception {
        PileI p = new question2.Pile4(3);
        assertEquals(true, p.estVide());
        try {
            Object r = p.depiler();
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof question1.PileVideException);
        }
    }

    public void test_Pile_toString() throws Exception {
        PileI pile1 = new question2.Pile4(3);
        assertEquals("toString incorrect ? ", "[]", pile1.toString());
        pile1.empiler(4);
        assertEquals("toString incorrect ? ", "[4]", pile1.toString());
        pile1.empiler(5);
        assertEquals("toString incorrect ? ", "[5, 4]", pile1.toString());
        pile1.empiler(3);
        assertEquals("toString incorrect ? ", "[3, 5, 4]", pile1.toString());

    }

    public void test_Pile_TailleNegative() {
        PileI p = new question2.Pile4(-3);
        assertEquals(p.CAPACITE_PAR_DEFAUT, p.capacite());

    }

    public void test_Pile_equals() throws Exception {

        p1.empiler(3);
        

        p2.empiler(3);
        

        assertTrue("égalité de deux piles ? ", p1.equals(p2));
        assertTrue("égalité de deux piles ? ", p2.equals(p1));
        assertTrue("égalité de deux piles ? ", p1.equals(p1));

        p2.empiler(1);
        assertFalse("égalité de deux piles ? ", p1.equals(p2));

    }

    public void test_Pile_HashCode() throws Exception {
        /**
         * Si deux piles sont �gaux selon la m�thode equals(),
         * alors leur code de hachage doit �tre le m�me.
         */

        p1.empiler(1);
        p1.empiler(2);
        p1.empiler(3);

        p2.empiler(1);
        p2.empiler(2);
        p2.empiler(3);

        assertEquals ("Hachages de p1 et p2 sont �gales ?", true,
            p1.hashCode() == p2.hashCode());
    }


}
