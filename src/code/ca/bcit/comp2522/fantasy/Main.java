package ca.bcit.comp2522.fantasy;

/**
 * Main class to run the program.
 *
 * @author Darrel Tapilaha & Manases
 * @version 1.0
 */

public class Main {

    /**
     * Drives the program
     * @param args = arguments
     */
    public static void main(String[] args) {

        final Date dobDrogol;
        final Creature drogol;

        dobDrogol   = new Date(1990, 11, 20);
        drogol      = new Dragon("Drogol", dobDrogol, 100, 98);

        final Date dobRagavan;
        final Creature ragavan;

        dobRagavan  = new Date(2021, 12, 22);
        ragavan     = new Elf("Ragavan", dobRagavan, 85, 20);

        final Date dobGoblin;
        final Creature goblin;

        dobGoblin   = new Date(2013, 4, 12);
        goblin      = new Orc("Goblin", dobGoblin, 64, 25);

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
            System.out.println("in here");
            Elf ragavanElf;
            ragavanElf = (Elf) ragavan;
            System.out.println(drogol.getDetails());
            System.out.println(ragavanElf.getDetails());
            ragavanElf.castSpell(drogol);
            System.out.println(ragavanElf.getDetails());
            System.out.println(drogol.getDetails());
        }

    }
}