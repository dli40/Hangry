package com.example.hangry;

import java.util.List;

public class BusinessLocation
{

        private String address1;

        private String address2;

        private String address3;

        private String city;

        private String zip_code;

        private String country;

        private String state;

        private List<String> display_address;

        private String cross_streets;

        public void setAddress1(String address1){
            this.address1 = address1;
        }
        public String getAddress1(){
            return this.address1;
        }
        public void setAddress2(String address2){
            this.address2 = address2;
        }
        public String getAddress2(){
            return this.address2;
        }
        public void setAddress3(String address3){
            this.address3 = address3;
        }
        public String getAddress3(){
            return this.address3;
        }
        public void setCity(String city){
            this.city = city;
        }
        public String getCity(){
            return this.city;
        }
        public void setZip_code(String zip_code){
            this.zip_code = zip_code;
        }
        public String getZip_code(){
            return this.zip_code;
        }
        public void setCountry(String country){
            this.country = country;
        }
        public String getCountry(){
            return this.country;
        }
        public void setState(String state){
            this.state = state;
        }
        public String getState(){
            return this.state;
        }
        public void setDisplay_address(List<String> display_address){
            this.display_address = display_address;
        }
        public List<String> getDisplay_address(){
            return this.display_address;
        }
        public void setCross_streets(String cross_streets){
            this.cross_streets = cross_streets;
        }
        public String getCross_streets(){
            return this.cross_streets;
        }

}
