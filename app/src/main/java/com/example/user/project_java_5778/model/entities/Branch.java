package com.example.user.project_java_5778.model.entities;

/**
 * Created by user on 12/11/2017.
 */

public class Branch {

    public class Address {

        private String cityName;
        public void setCityName (String cityName){
            this.cityName = cityName;
        }
        public String getCityName () {
            return cityName;
        }

        private String streetName;
        public void setStreetName (String streetName){
            this.streetName = streetName;
        }
        public String getStreetName () {
            return streetName;
        }

        private int number;
        public void setNumber (int number){
            this.number = number;
        }
        public int getNumber () {
            return number;
        }

        @Override
        // for ContentValue...
        public String toString() {

            String string = null;

            for (Object temp:Address.class.getFields()) {

                string += temp.toString();
                string += " ";
            }

            return string.trim();
        }
    }

    private int numOfParkingSpace;
    public void setNumOfParkingSpac (int numOfParkingSpace){
        this.numOfParkingSpace = numOfParkingSpace;
    }
    public int getNumOfParkingSpace (){
        return numOfParkingSpace;
    }

    private int branchNumber;
    public void setNumOfParkingSpace (int branchNumber){
        this.branchNumber = branchNumber;
    }
    public int getBranchNumber (){
        return branchNumber;
    }

}
