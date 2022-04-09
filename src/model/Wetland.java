package model;

public class Wetland {
    
    private String name;
    private String ubicationName;
    private EnumUbication ubiZone;
    private enumProtec protec;
    private double km2;
    private String fotoUrl;
    private EnumType type;
    private int j;
    private boolean maintancePlan;
    private int maintance;
    private int u;

    private Species [] contSpecies;
    private Event [] events;
    
    
    /**
     * 
     * @param name need be full
     * @param ubiZone need be full
     * @param protec need be full
     * @param km2 need be full
     * @param fotoUrl need be full
     * @param type need be full
     * @param ubicationName need be full
     * @param maintancePlan need be full
     * @param maintance need be full
     */

    public Wetland(String name, int ubiZone, int protec,  double km2, String fotoUrl, int type, String ubicationName, boolean maintancePlan, int maintance) {
        this.name = name;
        this.ubicationName= ubicationName;
        if(ubiZone==1){
            this.ubiZone=EnumUbication.RURAL;
        }else{
            this.ubiZone=EnumUbication.URBANA;
        }
        
        if(protec==1){
            this.protec=enumProtec.PROTECTED;
        }else{
            this.protec=enumProtec.NO_PROTECTED;
        }
        this.km2=km2;
        this.fotoUrl=fotoUrl;
        if(type==1){
            this.type=EnumType.PUBLIC;
        } else{
            this.type=EnumType.PRIVATE;
        }

        this.maintancePlan=maintancePlan;
        if(maintancePlan){
            this.maintance=maintance;
        }else{
            this.maintance=0;
        }
        this.contSpecies = new Species[10000];
        this.events= new Event[10000];
        j=0;
        u=0;
    }
    /**
     * description: this method add one in one position in species array one specie
     * pre: j need be inicializated
     * @param p this var need be full
     */
    public void addSpecie(Species p){
        contSpecies[j]=p;
        j++;
    }
    /**
     * description: this metod to add a event in a position that is vaccum
     * @param p need be full
     */
    public void addEvent(Event p){
        events[u]=p;
        u++;

    }

    public void setPlan(int maintance){
        this.maintance= maintance;
    }

    /**
     * description: this method search in the species´s array and return his name
     * @return s, this var need be inicializated
     */
    public String consulSpecie(){
        String s;
        boolean p=false;
        s="";
        for(int i=0; i<contSpecies.length && !p; i++){

            if(contSpecies[i]==null){
                p=true;
            } else{
                s+= contSpecies[i].getName()+"\n";
            }
            
           
        }
        return s;
    }
    public int getMaintance(){
        return maintance;
    }
    /**
     * description: this method  search in species´s array and if this find types of flora plus one in the cont
     * @return h; thsi var need be inicializated
     */
    public int toInt1(){
        boolean p;
        int h;
        p=false;
        h=0;
        for(int i=0; i<10000 && !p; i++){

            if(contSpecies[i]==null){
                p=true;
            }else{
                if(contSpecies[i].getType()==enumSpecie.FLORATERRESTRE || contSpecies[i].getType()==enumSpecie.FLORAACUATICA){
                    h++;
                }
            }
           
        }
        return h;
    }
    /**
     * description: this method search a name introduce of consola and if is equal to other name in the array return true
     * @param k this need come full
     * @return need be inicializated
     */
    public boolean viewSpecie(String k){
        boolean g=false;
        boolean p=false;
        for(int l=0; l<contSpecies.length && !p; l++){

            if(contSpecies[l]==null){
                p=true;
            }else{
                if(contSpecies[l].getName().equalsIgnoreCase(k)){
                    g=true;
                }
            }
            
        }

        return g;
    }
     /**
      * description: this method busca all species in the wetland and return his name
      * @return s, this var need be inicializated
      */

    public String information1(){
        String s="";
        boolean p=false;
        for(int l=0; l<contSpecies.length && !p; l++){
            if(contSpecies[l]==null){
                p=true;
            } else{
                s+= " "+contSpecies[l].getName()+"\n";
            }
        }
        return s;
    }
    /**
     * description: this method search a species´s type and if its equal so up the index
     * @return m, this var need be inicializated
     */
    public int seeflora(){
        int m=0;
        boolean p=false;
        for(int h=0; h<10000 && !p; h++){
            if(contSpecies[h]==null){
                p=true;
            }else{
                if(contSpecies[h].getType()==enumSpecie.AVE ||contSpecies[h].getType()==enumSpecie.MAMIFERO|| contSpecies[h].getType()==enumSpecie.ACUATICO){
                    m++;
                }
            }
           
        }

        return m;
    }
    /**
     * description: this method search spaces in the species´s array and return one boolean that say if there are space
     * @return p, this var need be inicializated
     */
    public boolean hasSpace(){
        boolean p=false;
        for(int i=0; i<contSpecies.length && !p; i++){
            if(contSpecies[i]==null){
                p=true;
            }
        }

        return p;
    }
    public boolean hasSpace1(){
        boolean p= false;
        for(int i=0; i<10000; i++){
            if(events[i]==null){
                p=true;
                break;
            }
        }
        return p;
    }
    /**
     * description: this method search the vacuum space and return his index
     * @return out, this var need be inicializated 
     */
    public int whatSpace(){
        boolean p=false;
        int out=0;
        for(int i=0; i<contSpecies.length && !p; i++){
            if(contSpecies[i]==null){
                out=i;
                p=true;
            }
        }

        return out;
    }
    /**
     * description: this method search if there are at least a space full
     * @return p, this var need be inicializated
     */
    public boolean thereAreSpecie(){
        boolean p= false;
        for(int i=0; i<10000; i++){
            if(contSpecies[i]!=null){
                p=true;
                break;
            }
        }
        return p;
    }
    /**
     * description: this method search if exist species of flora
     * @return p; this var need be inicializated
     */
    public boolean existFlora(){
        boolean p=false;
        for(int i=0; i<10000; i++){
            if(contSpecies[i]!=null && (contSpecies[i].getType()==enumSpecie.FLORAACUATICA || contSpecies[i].getType()==enumSpecie.FLORATERRESTRE)){
                p=true;
                break;
            }
        }
        return p;
    }

    public boolean existFauna(){
        boolean p=false;
        for(int i=0; i<10000; i++){
            if(contSpecies!=null &&(contSpecies[i].getType().equals(enumSpecie.MAMIFERO) || contSpecies[i].getType().equals(enumSpecie.AVE) || contSpecies[i].getType().equals(enumSpecie.ACUATICO))){
                p=true;
                break;
            }
        }
        return p;
    }


    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }


    public Species[] getContSpecies() {
        return this.contSpecies;
    }

    public void setContSpecies(Species[] contSpecies) {
        this.contSpecies = contSpecies;
    }


    public double getKm2() {
        return this.km2;
    }

    public void setKm2(double km2) {
        this.km2 = km2;
    }

    public String getFotoUrl() {
        return this.fotoUrl;
    }

    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }

    public EnumUbication getUbiZone() {
        return this.ubiZone;
    }

    public void setUbiZone(EnumUbication ubiZone) {
        this.ubiZone = ubiZone;
    }

    public Event[] getEvents() {
        return this.events;
    }

    public void setEvents(Event[] events) {
        this.events = events;
    }


    public enumProtec getProtec() {
        return this.protec;
    }

    public void setProtec(enumProtec protec) {
        this.protec = protec;
    }


    public EnumType getType() {
        return this.type;
    }

    public void setType(EnumType type) {
        this.type = type;
    }


    public String getUbicationName() {
        return ubicationName;
    }

    public void setUbicationName(String ubicationName) {
        this.ubicationName = ubicationName;
    }

    public boolean isMaintancePlan() {
        return this.maintancePlan;
    }

    public boolean getMaintancePlan() {
        return this.maintancePlan;
    }

    public void setMaintancePlan(boolean maintancePlan) {
        this.maintancePlan = maintancePlan;
    }
    public void setMaintance(int maintance) {
        this.maintance = maintance;
    }

   





}
