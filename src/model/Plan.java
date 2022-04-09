package model;

public class Plan{

    private int maintance;
    private int restauration;
    private int conservation;
    /**
     * 
     * @param maintance need be all
     * @param restauration need be all
     * @param conservation need be all
     */
    public Plan( int restauration, int conservation) {
        this.maintance = 0;
        this.restauration = restauration;
        this.conservation = conservation;
    }
    



    /**
     * @return int return the maintance
     */
    public int getMaintance() {
        return maintance;
    }

    /**
     * @param maintance the maintance to set
     */
    public void setMaintance(int maintance) {
        this.maintance = maintance;
    }

    /**
     * @return int return the restauration
     */
    public int getRestauration() {
        return restauration;
    }

    /**
     * @param restauration the restauration to set
     */
    public void setRestauration(int restauration) {
        this.restauration = restauration;
    }

    /**
     * @return int return the conservation
     */
    public int getConservation() {
        return conservation;
    }

    /**
     * @param conservation the conservation to set
     */
    public void setConservation(int conservation) {
        this.conservation = conservation;
    }

}