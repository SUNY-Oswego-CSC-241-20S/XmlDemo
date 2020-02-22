package csc241;

public class Holiday {
    // Instance variables
    private String month;
    private int day;
    private String name;
    private boolean federal;
    private boolean oswego;

    // Constructor
    public Holiday(String month, int day, String name){
        this.month = month;
        this.day = day;
        this.name = name;
    }

    // Set the federal value
    public void setFederal(){
        federal = true;
    }

    // Set the oswego value
    public void setOswego() {
        oswego = true;
    }

    // Return string containing values
    public String values(){
        return month + ":" + day + ":" + name + ":" + federal + ":" + oswego;
    }
}
