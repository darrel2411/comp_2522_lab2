package ca.bcit.comp2522.fantasy;

/**
 * Main class to run the program.
 *
 * @author Darrel Tapilaha & Manases
 * @version 1.0
 */

public class CreatureTest {

    /**
     * Drives the program
     * @param args = arguments
     */
    public static void main(String[] args) {

        final Date dobDrogol;
        final Creature drogol;

        dobDrogol   = new Date(2020, 11, 20);
        drogol      = new Dragon("Drogol", dobDrogol,
                90, 98);

        final Date dobRagavan;
        final Creature ragavan;

        dobRagavan  = new Date(2021, 12, 22);
        ragavan     = new Elf("Ragavan", dobRagavan,
                85, 20);

        final Date dobGoblin;
        final Creature goblin;

        dobGoblin   = new Date(2013, 4, 12);
        goblin      = new Orc("Goblin", dobGoblin,
                64, 25);

        //Healer Creature(Bonus question)
        final Creature healer;
        final Date healerDob;

        healerDob = new Date(2020, 3, 14);
        healer = new CreatureHealer("Healer", healerDob,
                                   80);




////        the dragon
//        System.out.println(drogol instanceof Creature);
//        System.out.println(drogol.getDetails());
//        System.out.println(drogol.getClass());
//        System.out.println(drogol.getClass().getName());
//        System.out.println(drogol.getClass().getSimpleName());
//
//        System.out.println("\n");
//
////        the elf
//        System.out.println(ragavan instanceof Elf);
//        System.out.println(ragavan.getDetails());
//        System.out.println(ragavan.getClass());
//        System.out.println(ragavan.getClass().getName());
//        System.out.println(ragavan.getClass().getSimpleName());
//
//        System.out.println("\n");
//
////        the orc
//        System.out.println(goblin instanceof Creature);
//        System.out.println(goblin.getDetails());
//        System.out.println(goblin.getClass());
//        System.out.println(goblin.getClass().getName());
//        System.out.println(goblin.getClass().getSimpleName());


        if(ragavan instanceof Elf) {
            final Elf ragavanElf;
            ragavanElf = (Elf) ragavan;
            System.out.println("Elf Information");

            // Will get the details of the elf
            System.out.println(drogol.getDetails());
            // To avoid unchecked exceptions from crashing
            // the program
            try{
                ragavanElf.castSpell(drogol);
            }
            catch(LowManaException e){
                // Printing a friendly message instead
                System.out.println(e.getMessage());
            } catch (DamageException e){
                System.out.println(e.getMessage());
            }
            System.out.println();
        }

        if(goblin instanceof Orc) {
            final Orc goblinOrc;
            goblinOrc = (Orc) goblin;
            System.out.println("Orc Information");

            // to print the details of the orc
            System.out.println(goblinOrc.getDetails());

            // To avoid unchecked exceptions from crashing
            // the program
            try{
                goblinOrc.berserk(drogol);
            }
            catch(LowRageException e){
                // Printing a friendly message instead
                // If the rage is low
                System.out.println(e.getMessage());
            }
            catch (DamageException e){
                // If the target creature has died
                System.out.println(e.getMessage());
            }

            System.out.println();
        }

        if(drogol instanceof Dragon) {
            final Dragon drogolDragon;
            drogolDragon = (Dragon) drogol;
            System.out.println("Dragon Information");
            System.out.println(drogolDragon.getDetails());
            // To avoid unchecked exceptions from crashing
            // the program
            try {
                drogolDragon.breatheFire(goblin);
            }
            catch (LowFirePowerException e){
                // To avoid unchecked exceptions from crashing
                // the program
                System.out.println(e.getMessage());
            } catch (DamageException e){
                // If the target creature has died
                System.out.println(e.getMessage());
            }

            System.out.println();
        }

        if (healer instanceof CreatureHealer) {
            System.out.println("Healer creature");
            System.out.println(healer.getDetails());

            try
            {
                ((CreatureHealer) healer).healCreature(drogol);
            }
            catch (HealingException e){
                System.out.println(e.getMessage());
            }
        }



    }
}