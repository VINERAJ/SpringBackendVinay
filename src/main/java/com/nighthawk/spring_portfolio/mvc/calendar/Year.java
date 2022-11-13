package com.nighthawk.spring_portfolio.mvc.calendar;

// simple POJO for serializing JSON, this could be moved into an entity
class Year {
   private int year;
   private boolean isLeapYear;

   // zero argument constructor
   public Year() {} 

   /* year getter/setters */
   public int getYear() {
      return year;
   }
   public void setYear(int year) {
      this.year = year;
      this.setIsLeapYear(year);
   }

   /* isLeapYear getter/setters */
   public boolean getIsLeapYear(int year) {
      return APCalendar.isLeapYear(year);
   }
   private void setIsLeapYear(int year) {  // this is private to avoid tampering
      this.isLeapYear = APCalendar.isLeapYear(year);
   }

   /* toString formatted to map to JSON */
   public String toString(){
      return ( "{ \"year\": "  +this.year+  ", " + "\"isLeapYear\": "  +this.isLeapYear+ " }" );
   }	

   public static void main(String[] args) {
      Year year = new Year();
      year.setYear(2022);
      System.out.println(year);
   }
}