/* https://javainspires.blogspot.com/2018/04/spring-boot-thymeleaf-data-table-java.html */
package edu.ucsb.cs56.ucsb_courses_search;

public class Tutor {

 public String name;
 private String email;
 private String labHours;

 /**
  *
  */
 public Tutor() {
  super();
 }

 /**
  * @param name
  * @param email
  * @param labHours
  */
 public Tutor(String name, String email, String labHours) {
  super();
  this.name = name;
  this.email = email;
  this.labHours = labHours;
 }



 /**
  * @return the name
  */
 public String getName() {
  return name;
 }

 /**
  * @param name
  *            the name to set
  */
 public void setName(String name) {
  this.name = name;
 }

 /**
  * @return the email
  */
 public String getEmail() {
  return email;
 }

 /**
  * @param email
  *            the id to set
  */
 public void setEmail(String email) {
  this.email = email;
 }

 /**
  * @return the labHours
  */
 public String getLabHours() {
  return labHours;
 }

 /**
  * @param labHours
  *            the labHours to set
  */
 public void setLabHours(String labHours) {
  this.labHours = labHours;
 }

}
