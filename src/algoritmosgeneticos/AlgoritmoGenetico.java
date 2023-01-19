package algoritmosgeneticos;
import org.jgap.*;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.IntegerGene;
import org.jgap.impl.StringGene;
// @author Isaac Reyes
public class AlgoritmoGenetico {
    public static Integer[] iniciarGenetico(String format) {
        try {
            Configuration configuracion = new DefaultConfiguration();
            FitnessFunction myFunc = new FuncionAptitud(format);
            configuracion.setFitnessFunction(myFunc);
            Gene[] deckGenes = new Gene[10];

            deckGenes[0] = new IntegerGene(configuracion, 0, 999);
            deckGenes[1] = new IntegerGene(configuracion, 0, 999);
            deckGenes[2] = new IntegerGene(configuracion, 0, 999);
            deckGenes[3] = new IntegerGene(configuracion, 0, 999);
            deckGenes[4] = new IntegerGene(configuracion, 0, 999);
            deckGenes[5] = new IntegerGene(configuracion, 0, 999);
            deckGenes[6] = new IntegerGene(configuracion, 0, 999);
            deckGenes[7] = new IntegerGene(configuracion, 0, 999);
            deckGenes[8] = new IntegerGene(configuracion, 0, 999);
            deckGenes[9] = new IntegerGene(configuracion, 0, 999);

            Chromosome deckChromosome = new Chromosome(configuracion, deckGenes);

            configuracion.setSampleChromosome(deckChromosome);
            configuracion.setPopulationSize(10);

            Genotype population = Genotype.randomInitialGenotype(configuracion);

            Mostrar show = new Mostrar();

            // Entrenamiento

            // Se muestran los individuos
            for(int m = 0; m < 5; m++) { // 5 iteraciones, cada iteración será una generación
//                System.out.println("--------------------Inicio generación-------------------");
//                System.out.println("Iteracion #" + m);

//                show.mostrarTodosIndividuos(population.getChromosomes());

                population.evolve(200);


                IChromosome mejor_individuo = population.getFittestChromosome(); // Obtenemos el mejor individuo
//                show.mostrarIndividuo(mejor_individuo);
//                System.out.println("Valor de aptitud del mejor individuo: " + mejor_individuo.getFitnessValue());
//
//                System.out.println("--------------------Fin generacion-------------------");
            }

            System.out.println("Mejor individuo en general: ");
            IChromosome mejor_general = population.getFittestChromosome();
            show.mostrarIndividuo(mejor_general);
            System.out.println("Valor de aptitud del mejor individuo general: " + mejor_general.getFitnessValue());

            int c1 = (Integer) mejor_general.getGene(0).getAllele();
            int c2 = (Integer) mejor_general.getGene(1).getAllele();
            int c3 = (Integer) mejor_general.getGene(2).getAllele();
            int c4 = (Integer) mejor_general.getGene(3).getAllele();
            int c5 = (Integer) mejor_general.getGene(4).getAllele();
            int c6 = (Integer) mejor_general.getGene(5).getAllele();
            int c7 = (Integer) mejor_general.getGene(6).getAllele();
            int c8 = (Integer) mejor_general.getGene(7).getAllele();
            int c9 = (Integer) mejor_general.getGene(8).getAllele();
            int c10 = (Integer) mejor_general.getGene(9).getAllele();

            Integer[] mejor_indices = new Integer[] {
                    c1,
                    c2,
                    c3,
                    c4,
                    c5,
                    c6,
                    c7,
                    c8,
                    c9,
                    c10
            };

            return mejor_indices;

        } catch (InvalidConfigurationException ex) {
            System.out.println("No se pudo ejecutar el AG");
        }
        return null;
    }
}
