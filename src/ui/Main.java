package ui;
import java.util.Scanner;
import model.Menu;
public class Main {
    public static Scanner read= new Scanner(System.in);
    private Menu m;

    public Main(){
        m= new Menu("bueno");
    }
     public static void main(String[] args){
        Main prin= new Main();
        int option=0;

        do{
            option=prin.showMenu();
            prin.doOperation(option);
        }while(option!=9);

    }
    /**
     * description: this method show the menu and return the option
     * @return p, this var need be inicializated
     */
    public int showMenu(){
        int option=0;
        System.out.println("1: create Wetland \n" +
                           "2: register new Specie \n"+
                           "3: register new event \n"+
                           "4: maintances \n"+
                           "5: know the wetland with minus flora \n"+
                           "6: consult Specie \n"+
                           "7: information \n"+
                           "8: wetland with more animals \n"+
                           "9: out");
        option= read.nextInt();
        read.nextLine();
        return option;

    }
    /**
     * description: this method call the diferents options 
     * @param option this need is full
     */
    public void doOperation(int option){
        switch(option){
            case 1:
                createWet();
                break;

            case 2:
                registerSpecie();
                break;
            case 3:
                registerEvent();
                break;
            case 4:
                System.out.println(m.consulMaintance());
                break;
            case 5:
                System.out.println(m.consultFlora());
                break;
            case 6:
                findEspecie();
                break;
            case 7:
               System.out.println(m.information()); 
            case 8:
                System.out.println(m.moreFauna());
                break;
            case 9:
                System.out.println("Bye uwu");
                break;



        }
    }

    public void createWet(){

        if(m.hasSpace()){
            System.out.println("type the name of the Wetland");
            String name;
            name= read.nextLine();
            System.out.println("type the ubication zone, 1: rural or 2: urban");
            int zone;
            zone= read.nextInt();
            while(zone!=1 && zone!=2){
                System.out.println("type the ubicationZone again, 1: rural or 2: urban");
                zone= read.nextInt();
            }
            System.out.println("write the type, 1: protected or 2: no protected");
            int type;
            type=read.nextInt();
            while(type!=1 && type!=2){
                System.out.println("type if is protected zone again, 1: protected or 2: no protected");
                type= read.nextInt();
            }

            System.out.println("type km2");
            double km2= read.nextDouble();
            System.out.println("type the urlPhoto");
            String foto= read.nextLine();
            read.nextLine();
            System.out.println("write the type of the wetland, 1: public or 2: private");
            int type1= read.nextInt();
            while(type1!=1 && type1!=2){
                System.out.println("type the type again, 1: protected or 2: no protected");
                type1= read.nextInt();
            }
            if(zone==1){
                System.out.println("type the name of corregimiento");
            }else{
                System.out.println("type the name of the neightboor");
            }
            String ubicationName= read.nextLine();
            read.next();
            System.out.println("this wetland has a maintance plan? si/no");
            boolean p=false;
            String maintance= read.nextLine();
            if(maintance.equalsIgnoreCase("si")){
                p=true;
            }else{
                p=false;
            }
            int maintance1;
            if(p){
                System.out.println("type the cantintad de mantenimientos en un año");
                 maintance1= read.nextInt();
            }else{
                maintance1=0;
            }
            m.addWetland(name,zone,type,km2, foto, type1, ubicationName,p,maintance1);   
        }else{
            System.out.println("you can not add more wetlands");
        }
       
        
    }
    
    public void registerSpecie(){
        if(m.hasSpace1()==80){
            System.out.println("in this moment does not exist any Wetland in the system");
        }else{
            System.out.println("what wetland do you want add Specie?, type the name");
            String n;
            int ja=-1;
            String [] array1= m.conocer();
            n= read.nextLine();
            boolean p=false;
            for(int i=0; i<80 && !p; i++){
               if(array1[i]!=null && array1[i].equalsIgnoreCase(n)){
                    ja=i;
                    p=true;
               }
            }
    
            if(ja==-1){
                System.out.println("this wetland does not exist");
            }else{
                if(m.hasSpaceInSpecie(ja)){
                    System.out.println("Type the name");
                    String name;
                    name= read.nextLine();
                    System.out.println("type de Sciense-name");
                    String sciName;
                    sciName= read.nextLine();
                    System.out.println("This specie is migratory? si/no");
                    String mi;
                    boolean h;
                    mi= read.next();
                    if(mi.equalsIgnoreCase("si")){
                        h=true;
                    }else{
                        h=false;
                    }
                    System.out.println("write the type 1: flora  terrestre, 2: flora acuatica, 3: Ave, 4: mamifero, 5: acuático");
                    int ty=read.nextInt();
                    while(ty!=1 && ty!=2 && ty!=3 && ty!=4 && ty!=5){
                        System.out.println("write the type again 1: flora  terrestre, 2: flora acuatica, 3: Ave, 4: mamifero, 5: acuático");
                    }
                    m.addSpecieInWetland(ja, name,sciName,h,ty);
                } else{
                    System.out.println("In this wetland you do not add Species");
                }
                
            }
        }
        
       
        
    }
    
    public void registerEvent(){
        int k=1;
       if(m.hasSpace1()==80){
            System.out.println("In this moment doesnt exist any wetland in the system;");
       }else{
           System.out.println("what wetland do you add event");
           String name= read.nextLine();
           int j=-1;
           String [] array1= m.conocer();
           boolean p= false;
           for(int i=0; i<80 && !p; i++){
             if(array1[i].equalsIgnoreCase(name)){
                j=i;
                p=true;
             }
           }

           if(j==-1){
               System.out.println("this wetland doesnt exist");
           }else{
               if(m.hasSpaceInEvent(j)){
                 System.out.println("write the type of event, 1: Maintance 2: school visit 3: mejoramiento 4: celebration");
                 int type= read.nextInt();
                 System.out.println("type the of the person that make the event");
                 String organizateName= read.nextLine();
                 System.out.println("type the vaue");
                 double value= read.nextDouble();
                 System.out.println("type the description");
                 String description= read.nextLine();
                 m.addEventInWetland(j, type, organizateName, value, description);
                 if(type==1){
                    m.setPlanInwetland(k, j);
                    k++;
                 }
                
               }else{
                   System.out.println("you dont need add more events");
               }
           }
       }

    }

    

    public void findEspecie(){
        if(m.hasSpace1()==80){
            System.out.println("In this moment doesnt exist any wetland in the system;");
       }else{
            
        if(m.thereAreSpecie()){
           
            System.out.println("type the name of the Specie");
            String name= read.nextLine();
            if(m.viewSpecie(name).equals("")){
                System.out.println("this specie does not exist");
            }else{
                System.out.println(m.viewSpecie(name)); 
            }
        }else{
            System.out.println("In this moment doesnt exist any Specie in the system");
       }
        }
        
       
      
        
    }
}
