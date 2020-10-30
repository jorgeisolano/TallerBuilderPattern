
package co.unicauca.restaurant.app;

import co.unicauca.restaurant.services.DishDirector;
import co.unicauca.restaurant.domain.Dish;
import co.unicauca.restaurant.italian.ItalianDishBuilder;
import co.unicauca.restaurant.oriental.OrientalDishBuilder;
import co.unicauca.restaurant.services.DishBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Restaurant {


    public static void main(String[] args) throws IOException {
        int opcion=0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DishBuilder dishBuilder = null;
        while(opcion!=1 && opcion!=2){
            System.out.println("1. Restaurante Italiano");
            System.out.println("2. Restaurante Oriental");
            System.out.println("Por favor, elija su restaurante: ");
            opcion=Integer.parseInt(br.readLine());
        }
        switch (opcion){
            case 1: 
                dishBuilder = new ItalianDishBuilder();
                break;
            case 2: 
                dishBuilder = new OrientalDishBuilder();
                break;
        }
        DishDirector director = new DishDirector(dishBuilder);
        director.create();
        Dish myDish = director.getDish();
        System.out.println("El plato le cuesta: "+ myDish.getPrice());
  } 
}
