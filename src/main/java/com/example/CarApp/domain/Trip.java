package com.example.CarApp.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;

@Entity
public class Trip {
	@Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private long tripid;
	  private String tripname;
	  

	   @ManyToMany(cascade = CascadeType.MERGE)
	      @JoinTable(name = "cars_trip", joinColumns = { @JoinColumn(name =
	       "carid") }, inverseJoinColumns = { @JoinColumn(name = "id") }) 
	      private Set<Car> cars = new HashSet<Car>(0); 
	   
	  public Trip() {}
	  
      public Trip(String tripname) {
		super();
		this.tripname = tripname;
	}

	public Trip(String tripname, Set<Car> cars) {
		super();
		this.tripname = tripname;
		this.cars = cars;
	}

      
	public long getTripid() {
		return tripid;
	}
	public void setTripid(long tripid) {
		this.tripid = tripid;
	}
	public String getTripname() {
		return tripname;
	}
	public void setTripname(String tripname) {
		this.tripname = tripname;
	}
	public Set<Car> getCars() {
        return cars;
      }

      public void setCars(Set<Car> cars) {
        this.cars = cars;
      }
      
      

}
