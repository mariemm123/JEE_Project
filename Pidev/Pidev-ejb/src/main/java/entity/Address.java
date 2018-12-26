package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Addresses database table.
 * 
 */
@Entity
@Table(name="Addresses")
@NamedQuery(name="Address.findAll", query="SELECT a FROM Address a")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="AddressId", unique=true, nullable=false)
	private int addressId;

	@Column(nullable=false, length=50)
	private String city;

	@Column(nullable=false, length=50)
	private String country;

	@Column(name="Street", nullable=false, length=50)
	private String street;

	//bi-directional many-to-one association to AspNetUser
	@OneToMany(mappedBy="address")
	private List<AspNetUser> aspNetUsers;

	public Address() {
	}

	public int getAddressId() {
		return this.addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public List<AspNetUser> getAspNetUsers() {
		return this.aspNetUsers;
	}

	public void setAspNetUsers(List<AspNetUser> aspNetUsers) {
		this.aspNetUsers = aspNetUsers;
	}

	public AspNetUser addAspNetUser(AspNetUser aspNetUser) {
		getAspNetUsers().add(aspNetUser);
		aspNetUser.setAddress(this);

		return aspNetUser;
	}

	public AspNetUser removeAspNetUser(AspNetUser aspNetUser) {
		getAspNetUsers().remove(aspNetUser);
		aspNetUser.setAddress(null);

		return aspNetUser;
	}

}