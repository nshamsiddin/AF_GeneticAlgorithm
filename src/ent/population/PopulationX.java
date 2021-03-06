package ent.population;

import java.util.ArrayList;

import ent.individual.IndividualX;
import factories.crossover.Crossover;
import strategies.mutation.BitInversion;
import strategies.select.Elitism;

/**
 * Concrete product for Factory Pattern for mass production The method of
 * creation of instance of concreate products are defined in Factory methods -
 * Crossover in this case; The concrete Factory is passed by
 * PopulationGeneration subclass while initiating an instance
 */
public class PopulationX extends Population {

    // Abstract Factory Interface
    Crossover crossover;

    public PopulationX(Crossover crossover) {
        setGeneration(0);
        this.crossover = crossover;
        /**
         * Strategies specific for current concrete product
         */
        this.mutation = new BitInversion();
        this.selection = new Elitism();
    }

    /**
     * @param size
     */
    @Override
    public void populate(Integer size) {
        System.out.println("Populating with X individuals...");
        individuals = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            individuals.add(new IndividualX());
        }
    }

    @Override
    public void crossover() {
        individuals = crossover.doCrossover(individuals);
    }

}
