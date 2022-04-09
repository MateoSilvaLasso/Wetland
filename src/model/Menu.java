package model;

public class Menu {
    
    private String type;
    
    private Wetland [] cantWetland;
  
    private int u;
    private static final int SIZE=80;

    /**
     * 
     * @param type need be full
     */

    public Menu(String type){
        this.cantWetland = new Wetland[SIZE];
        this.type=type;
        u=0;
        
    }
    /**
     * description: this metod to create and add a wetland in a position that is vaccum
     * @param name need be full
     * @param ubizone need be full
     * @param protec need be full
     * @param km2 need be full
     * @param foto need be full
     * @param type need be full
     * @param ubicationName need be full
     * @param maintancePlan need be full
     * @param maintance need be full
     */
    public void addWetland(String name, int ubizone, int protec, double km2, String foto, int type, String ubicationName, boolean maintancePlan, int maintance){

        int m=whatSpace();
        cantWetland[m]=new Wetland(name, ubizone,protec,km2, foto, type, ubicationName, maintancePlan, maintance);
       
    }

    /**
     * this metod add a specie in the wetland that I searched in the Main
     * @param ja need be full
     * @param name need be full
     * @param sciName need be full
     * @param migratory need be full
     * @param type need be full
     */

    public void addSpecieInWetland(int ja, String name, String sciName, boolean migratory, int type){
        Species p= new Species(name, sciName, migratory, type);
        cantWetland[ja].addSpecie(p);
    }
    public void addEventInWetland(int j, int type, String name, double value, String description){
        Event p= new Event(type, name, value, description);
        cantWetland[j].addEvent(p);
    }

    /**
     * description: this method call a method of the class wetland that search if in the wetland there are spaces for more Species
     * @param ja need be full
     * @return [] wetland need be full
     */
    public boolean hasSpaceInSpecie(int ja){
        return cantWetland[ja].hasSpace();
    }

    public boolean hasSpaceInEvent(int j){
        return cantWetland[j].hasSpace1();
    }

    public void setPlanInwetland(int maintance, int j){
        cantWetland[j].setPlan(maintance);
    }

    
    /**
     * description: Este metodo permite saber si en el arreglo hay espacios para añadir espacio
     * @return p  need be inicializated
     */
    public boolean hasSpace(){
        boolean p=false;

        for(int m=0; m<SIZE && !p; m++){
            if(cantWetland[m]==null){
                p=true;
            }
        }

        return p;
    }
    /**
     * description: este metodo es para saber que espacio esta desocupado en el caso que haya espacio
     * @return space need be inicializated
     */
    public int whatSpace(){
        boolean p=false;
        int space=0;
        for(int m=0; m<SIZE && !p; m++){
            if(cantWetland[m]==null){
                space=m;
                p=true;
            }
        }

        return space ;   
    }
    /**
     * description: este metodo es para saber mediante un identificador, si el humedal que el usuario ingresa existe
     * @param name need be inicializated
     * @return p
     */
    public boolean findWetland(String name){
        boolean p=false;
        for(int i=0; i<SIZE; i++){
            if(cantWetland[i]!=null && cantWetland[i].getName().equals(name)){
                p=true;
            }
        }
        return p;
    }
    /**
     * description: este metodo es para cuando ya encontre que ese humedal si existe y deseo saber cual es o retornarlo
     * @param name need be full
     * @return usuaryWetland
     */
    public Wetland findPosWetland(String name){
        Wetland usuaryWetland=null;
        
        for(int i=0; i<SIZE; i++){
            if(cantWetland[i]!=null && cantWetland[i].getName().equals(name)){
                usuaryWetland=cantWetland[i];
                break;
            }
        }

        return usuaryWetland;
    }
   
    /**
     * description: este metodo mustra la cantidad de mantenimientos para cada humedal
     * @return s
     */
    public String consulMaintance(){
        String s;
        boolean p;
        p=false;
        s="";
        for(int i=0; i<SIZE && !p; i++){

            if(hasSpace1()==80){
                s="In this moment does not exist wetlands in the System";
                break;
            }else{
                if(cantWetland[i]==null){
                    p=true;
                }else{
                    s+= "la cantidad de mantenimientos para el humedal llamado "+cantWetland[i].getName()+" es: "+cantWetland[i].getMaintance()+"\n";
                }
            }
            
           
        }

        return s;

    }
    /**
     * description: este metodo muestra el humedal con menos flora de todos los humedales que haya registrados
     * @return s
     */
    public String consultFlora(){
        String s="";
        int men=0;
        if(hasSpace1()==80){
            s="In this moment does not exist any wetland in the System";
        }else{
            if(thereAreSpecie()){
                if(existFlora()){
                    boolean p=false;
                    for(int l=0; l<SIZE && !p; l++){
                        if(cantWetland[l]==null){
                            p=true;
                        }else{
                            if(l==0){
                                men=cantWetland[l].toInt1();
                                s=cantWetland[l].getName();
                            } else if(cantWetland[l].toInt1()<men){
                                men=cantWetland[l].toInt1();
                                s=cantWetland[l].getName();
                            }
                        }
                       
                    }
                    s="El humedal con menos flora es: "+ s +" y tiene "+ men +" especies de Flora";
                }else{
                    s="in this moment doesnt exist species of flora";
                }
               
            }else{
                s="no hay especies registradas en el sistema";
               
            }
        }
        
        
            return s;
       

    }

    public boolean existFlora(){
        boolean out=false;
        for(int i=0; i<80;i++){
            if(cantWetland[i]!=null && cantWetland[i].existFlora()){
                out=true;
                break;
            }
        }
        return out;
    }

    public boolean existFauna(){
        boolean out=false;
        for(int i=0; i<80; i++){
            if(cantWetland[i]!=null || cantWetland[i].existFauna()){
                out=true;
                break;
            }
        }
        return out;
    }
    /**
     * description: este metodo me sirve para saber si cierto humedal contiene la especie ingresada por consola;
     * @param k need be full
     * @return g 
     */
    public String viewSpecie(String k){
       String g="";
       boolean p=false;
        for(int h=0; h<SIZE; h++){
            if(cantWetland[h]!=null && cantWetland[h].viewSpecie(k)==true){
                g+="El humedal llamado "+cantWetland[h].getName()+" tiene la especie\n";
                
            }
        }

       return g;
    }
    /**
     * descrption: this method return all information of the wetlands
     * @return g
     */
    public String information(){
        String g="";
        boolean p= false;
        for(int m=0; m<SIZE && !p; m++){
            if(cantWetland[m]==null){
                p=true;
            }else{
                g+=cantWetland[m].getName()+", "+cantWetland[m].getUbiZone()+", "+ cantWetland[m].getUbicationName()+", "+cantWetland[m].getType()+"\n"+cantWetland[m].information1();
            }
             
        }         
        
        if(hasSpace1()==80){
            return "in this moment doesnt exist any wetland in the system";
        }else{
            return g;
        }
        
    }   

    public boolean thereAreSpecie(){
        boolean p=false;
        for(int i=0; i<80; i++){
            if(cantWetland[i]!=null &&cantWetland[i].thereAreSpecie()){
                p=true;
                break;
            }
        }

        return p;
    }
    /**
     * decription: this method search the wetland with more fauna
     * @return p, this var be inicializated
     */
    public String moreFauna(){
        boolean p=false;
        int m=0, s=0;
        for(int h=0; h<SIZE && !p; h++){
            if(cantWetland[h]==null){
                p=true;
            }else{
                if(h==0){
                    m=cantWetland[h].seeflora();
                    s=h;
                } else if(cantWetland[h].seeflora()>m){
                    m=cantWetland[h].seeflora();
                    s=h;
                }
            }
        }
        if(hasSpace1()==80){
            return "in this moment there arent any wetland in the system";
        }else if(thereAreSpecie()==false){
            return "in this moment there arent any specie in the System";
        }else if(existFauna()==false){
            return "in this moment there arent any species of fauna in the system";
        }else{
            return "El humedal con mayor fauna es "+ cantWetland[s].getName()+" y tiene "+m+" especies de fauna"; 
        }
       
    }

    public String [] conocer(){
        String[] array1= new String[80];
        boolean p= false;
        for(int h=0; h<80 && !p;h++){

            if(cantWetland[h]==null){
                p=true;
            }else{
                array1[h]=cantWetland[h].getName();
            }
            
        }

        return array1;
    }
    /**
     * description: este metodo lo utilizo para cuando vaya añadir una especie, comprobar si existe por lo menos una wetland existente
     * @return k
     */
    public int hasSpace1(){
        int k=0;
        for(int i=0; i<SIZE; i++){
            if(cantWetland[i]==null){
                k++;
            }
        }
        
        return k;
    }

    /**
     * @return Wetland [] return the cantWetland
     */
    public Wetland [] getCantWetland() {
        return cantWetland;
    }

    /**
     * @param cantWetland the cantWetland to set
     */
    public void setCantWetland(Wetland [] cantWetland) {
        this.cantWetland = cantWetland;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    


}
