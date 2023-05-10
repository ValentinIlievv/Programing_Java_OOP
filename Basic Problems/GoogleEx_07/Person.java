package GoogleEx_07;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private Car car;
    private List<Child> children;
    private  Company company;
    private List<Parent> parents;
    private  List<Pokemon> pokemonCollection;

public  Person(){
    this.children = new ArrayList<>();
    this.parents = new ArrayList<>();
    this.pokemonCollection = new ArrayList<>();
}
    public Person(Car car, List<Child> children, Company company, List<Parent> parents, List<Pokemon> pokemonCollection) {
        this.car = car;
        this.children = children;
        this.company = company;
        this.parents = parents;
        this.pokemonCollection = pokemonCollection;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public List<Pokemon> getPokemonCollection() {
        return pokemonCollection;
    }
    @Override
    public  String toString(){
      StringBuilder sb = new StringBuilder();
      sb.append("Company:").append(System.lineSeparator());
      if (company != null){
          sb.append(company).append(System.lineSeparator());
      }
      sb.append("Car:").append(System.lineSeparator());
      if (car != null){
          sb.append(car).append(System.lineSeparator());
      }
      sb.append("Pokemon:").append(System.lineSeparator());
      if (pokemonCollection != null){
          for (Pokemon pokemon : pokemonCollection) {
              sb.append(pokemon).append(System.lineSeparator());
          }
      }
      sb.append("Parents:").append(System.lineSeparator());
      if (parents != null){
          for (Parent parent : parents){
              sb.append(parent).append(System.lineSeparator());
          }
      }
      sb.append("Children:").append(System.lineSeparator());
      if (children != null){
          for (Child child : children){
              sb.append(child).append(System.lineSeparator());
          }
      }
      return sb.toString();
    }
}
