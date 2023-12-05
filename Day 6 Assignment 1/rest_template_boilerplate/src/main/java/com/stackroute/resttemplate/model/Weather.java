package com.stackroute.resttemplate.model;

public class Weather {
   private Location location;
   private Current current;

   public Location getLocation() {
      return location;
   }

   public void setLocation(Location location) {
      this.location = location;
   }

   public Current getCurrent() {
      return current;
   }

   public void setCurrent(Current current) {
      this.current = current;
   }

   public Weather(Location location, Current current) {
      this.location = location;
      this.current = current;
   }

   public Weather() {
   }
}
