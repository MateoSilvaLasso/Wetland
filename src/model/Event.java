package model;
import java.util.Date;
public class Event{

    private Date eventDate;
    private EnumEvent type;
    private String whoEvent;
    private double value;
    private String description;

    /**
     * 
     * descripción: este metodo es el constructor y llena las variables por primera vez
     * 
     * @param type this value need be all
     * @param whoEvent this value need be all
     * @param value this value need be all
     * @param description this value need be all
     */ 
    public Event(int type, String whoEvent, double value, String description) {
       switch(type){
           case 1:
            this.type = EnumEvent.MAINTANCE;
            break;
           case 2: 
            this.type= EnumEvent.SCHOOL;
            break;
           case 3: 
            this.type= EnumEvent.MEJORAMIENTO;
            break;
           case 4: 
            this.type= EnumEvent.CELEBRATIONS;
       }
        this.whoEvent = whoEvent;
        this.value = value;
        this.description = description;
    }

   


    /**
     * @return String return the whoEvent
     */
    public String getWhoEvent() {
        return whoEvent;
    }

    /**
     * @param whoEvent the whoEvent to set
     */
    public void setWhoEvent(String whoEvent) {
        this.whoEvent = whoEvent;
    }

    /**
     * @return double return the value
     */
    public double getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * @return String return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEventDate() {
        return this.eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public EnumEvent getType() {
        return this.type;
    }

    public void setType(EnumEvent type) {
        this.type = type;
    }


}