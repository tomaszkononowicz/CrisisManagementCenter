/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kononowicz.cmc.entities;

import java.util.Date;

/**
 *
 * @author Tomasz
 */
public class Message implements Comparable{
    private Integer id;
    private String region;
    private Integer priority;
    private Date date;
    private String shortText;
    private String text;

    public Message(Integer id, String region, Integer priority, Date date, String shortText, String text) {
        this.id = id;
        this.region = region;
        this.priority = priority;
        this.date = date;
        this.shortText = shortText;
        this.text = text;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setRegion(String region) {
        this.region = region;
    }
    
    public String getRegion() {
        return region;
    }
    
    public void setPriority(Integer priority) {
        this.priority = priority;
    }
    
    public Integer getPriority() {
        return priority;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    
    public Date getDate() {
        return date;
    }
    
    public void setShortText(String shortText) {
        this.shortText = shortText;
    }
    
    public String getShortText() {
        return shortText;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    public String getText() {
        return text;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Message) 
            if (this.date.compareTo(((Message)o).date) > 0) return -1;
        return 0;
    }

}
