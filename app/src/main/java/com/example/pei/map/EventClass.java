package com.example.pei.map;

public class EventClass implements Comparable<EventClass>{

    private String name;
    private String host;
    private String description;
    private Integer location;
    private Integer date;
    private Integer start;
    private Integer end;


    public EventClass(Integer id, String name, String host, String description,Integer location,
                      Integer date, Integer start, Integer end){
        this.name = name;
        this.host = host;
        this.description = description;
        this.location = location;
        this.date = date;
        this.start = start;
        this.end = end;

    }


    public void setName(String name) {
        this.name = name;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }


    public String getName() {
        return name;
    }

    public String getHost() {
        return host;
    }

    public String getDescription() {
        return description;
    }

    public Integer getLocation() {
        return location;
    }

    public Integer getDate() {
        return date;
    }

    public Integer getStart() {
        return start;
    }

    public Integer getEnd() {
        return end;
    }

    @Override
    public int compareTo(EventClass o) {
        //TO Auto-generated method stub
        int compare = date.compareTo(o.date);
        if (compare ==0){
            compare = start.compareTo(o.start);
        }
        return compare;
    }

    public String toString(){
        return "name: " + name + "; Location: " + location + "Start Time: " + start;

    }
}