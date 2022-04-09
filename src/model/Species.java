package model;

public class Species{

    private String name;
    private String ScienceName;
    private boolean migratory;
    private enumSpecie type;

    
    /**
     * 
     * @param name need be all
     * @param ScienceName need be all
     * @param migratory need be all
     * @param type need be all
    */
    public Species(String name, String ScienceName, boolean migratory, int type){
        this.name = name;
        this.ScienceName = ScienceName;
        this.migratory = migratory;
        switch(type){
            case 1:
                this.type=enumSpecie.FLORATERRESTRE;
                break;
            case 2:
                this.type=enumSpecie.FLORAACUATICA;
                break;
            case 3:
                this.type=enumSpecie.AVE;
                break;
            case 4:
                this.type=enumSpecie.MAMIFERO;
                break;
            case 5:
                this.type=enumSpecie.ACUATICO;
        }
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
    public void setName(String name){
        this.name = name;
    }

    /**
     * @return String return the ScienceName
     */
    public String getScienceName() {
        return ScienceName;
    }

    /**
     * @param ScienceName the ScienceName to set
     */
    public void setScienceName(String ScienceName) {
        this.ScienceName = ScienceName;
    }

    /**
     * @return boolean return the migratory
     */
    public boolean isMigratory() {
        return migratory;
    }

    /**
     * @param migratory the migratory to set
     */
    public void setMigratory(boolean migratory) {
        this.migratory = migratory;
    }

    public boolean getMigratory() {
        return this.migratory;
    }


    public enumSpecie getType() {
        return this.type;
    }

    public void setType(enumSpecie type) {
        this.type = type;
    }


}