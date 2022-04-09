package ui;
import model.*;
public class Main {
    
     public static void main(String[] args) {
         
     Wetland wetland1=new  Wetland("Humedalsito", "cali", "pantanoso");
     Menu aplication= new Menu(wetland1); 
     aplication.addWetland(wetland1);
     Wetland wetland2= new Wetland("Ernesto","cali", "perruno");
     aplication.addWetland(wetland2);
     Species specie1= new Species("caiman de anteojo", "caiman cocodrilus", false, "reptil");
     wetland1.addSpecie(specie1);
     Species specie2= new Species("perro", "perrius", false, "mamifero");
     wetland1.addSpecie(specie2);
     Species specie3=new Species("gato", "gatilus", false, "mamifero");
     wetland2.addSpecie(specie3);
     Species specie4=new Species("Alga", "alguilus parti", false, "flora acuatica");
     wetland2.addSpecie(specie4);
     Plan plan1= new Plan(23,23,23);
     Plan plan2=new Plan(44,56,1);
     wetland1.setMaintancePlan(plan1);
     wetland2.setMaintancePlan(plan2);
     System.out.print(aplication.consulMaintance());
     System.out.println(aplication.consultFlora());

    }
}
