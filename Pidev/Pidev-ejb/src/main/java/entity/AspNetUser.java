package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the AspNetUsers database table.
 * 
 */
@Entity
@Table(name="AspNetUsers")
@NamedQuery(name="AspNetUser.findAll", query="SELECT a FROM AspNetUser a")
public class AspNetUser implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id", unique=true, nullable=false)
	private int Id;
	@Column(name="AccessFailedCount", nullable=false)
	private int AccessFailedCount;

	@Column(name="Discriminator", nullable=false, length=128)
	private String Discriminator;

	@Column(name="Email", length=256)
	private String Email;

	@Column(name="EmailConfirmed", nullable=false)
	private boolean EmailConfirmed;

	@Column(nullable=false, length=50)
	private String firstName;

	@Column(nullable=false, length=50)
	private String lastName;

	@Column(name="LockoutEnabled", nullable=false)
	private boolean LockoutEnabled;

	@Column(name="LockoutEndDateUtc")
	private Timestamp LockoutEndDateUtc;

	@Column(name="PasswordHash", length=2147483647)
	private String PasswordHash;

	@Column(name="PhoneNumber", length=50)
	private String PhoneNumber;

	@Column(name="PhoneNumberConfirmed", nullable=false)
	private boolean PhoneNumberConfirmed;

	@Column(name="SecurityStamp", length=2147483647)
	private String SecurityStamp;

	@Column(name="TwoFactorEnabled", nullable=false)
	private boolean twoFactorEnabled;

	@Column(name="UserName", nullable=false, length=256)
	private String userName;

	//bi-directional many-to-one association to Appointment
	@OneToMany(mappedBy="aspNetUser1")
	private List<Appointment> appointments1;

	//bi-directional many-to-one association to Appointment
	@OneToMany(mappedBy="aspNetUser2")
	private List<Appointment> appointments2;

	//bi-directional many-to-one association to Appointment
	@OneToMany(mappedBy="aspNetUser3")
	private List<Appointment> appointments3;

	//bi-directional many-to-one association to AspNetUserClaim
	@OneToMany(mappedBy="aspNetUser")
	private List<AspNetUserClaim> aspNetUserClaims;

	//bi-directional many-to-one association to AspNetUserLogin
	@OneToMany(mappedBy="aspNetUser")
	private List<AspNetUserLogin> aspNetUserLogins;

	//bi-directional many-to-one association to Address
	@ManyToOne
	@JoinColumn(name="address_AddressId", nullable=false)
	private Address address;

	//bi-directional many-to-many association to AspNetRole
	@ManyToMany
	@JoinTable(
		name="AspNetUserRoles"
		, joinColumns={
			@JoinColumn(name="UserId", referencedColumnName="Id", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="RoleId", nullable=false)
			}
		)
	private List<AspNetRole> aspNetRoles;

	//bi-directional many-to-one association to Speciality
	@ManyToOne
	@JoinColumn(name="SpecialityId")
	private Speciality speciality;

	//bi-directional many-to-one association to Chat
	@OneToMany(mappedBy="aspNetUser1")
	private List<Chat> chats1;

	//bi-directional many-to-one association to Chat
	@OneToMany(mappedBy="aspNetUser2")
	private List<Chat> chats2;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="aspNetUser")
	private List<Comment> comments;

	//bi-directional many-to-one association to Disponibility
	@OneToMany(mappedBy="aspNetUser")
	private List<Disponibility> disponibilities;

	//bi-directional many-to-one association to Fora
	@OneToMany(mappedBy="aspNetUser")
	private List<Fora> foras;

	//bi-directional many-to-one association to MedicalPath
	@OneToMany(mappedBy="AspNetUser1")
	private List<MedicalPath> medicalPaths1;

	//bi-directional many-to-one association to MedicalPath
	@OneToMany(mappedBy="AspNetUser2")
	private List<MedicalPath> medicalPaths2;

	//bi-directional many-to-one association to Post
	@OneToMany(mappedBy="aspNetUser")
	private List<Post> posts;

	//bi-directional many-to-one association to Treatement
	@OneToMany(mappedBy="aspNetUser")
	private List<Treatement> treatements;

	public AspNetUser() {
	}


	


	public int getAccessFailedCount() {
		return AccessFailedCount;
	}


	public void setAccessFailedCount(int accessFailedCount) {
		AccessFailedCount = accessFailedCount;
	}


	public String getDiscriminator() {
		return this.Discriminator;
	}

	public void setDiscriminator(String discriminator) {
		this.Discriminator = discriminator;
	}

	public String getEmail() {
		return this.Email;
	}

	public void setEmail(String email) {
		this.Email = email;
	}

	public boolean getEmailConfirmed() {
		return this.EmailConfirmed;
	}

	public void setEmailConfirmed(boolean emailConfirmed) {
		this.EmailConfirmed = emailConfirmed;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean getLockoutEnabled() {
		return this.LockoutEnabled;
	}

	public void setLockoutEnabled(boolean lockoutEnabled) {
		this.LockoutEnabled = lockoutEnabled;
	}

	public Timestamp getLockoutEndDateUtc() {
		return this.LockoutEndDateUtc;
	}

	public void setLockoutEndDateUtc(Timestamp lockoutEndDateUtc) {
		this.LockoutEndDateUtc = lockoutEndDateUtc;
	}

	public String getPasswordHash() {
		return this.PasswordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.PasswordHash = passwordHash;
	}

	public String getPhoneNumber() {
		return this.PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.PhoneNumber = phoneNumber;
	}

	public boolean getPhoneNumberConfirmed() {
		return this.PhoneNumberConfirmed;
	}

	public void setPhoneNumberConfirmed(boolean phoneNumberConfirmed) {
		this.PhoneNumberConfirmed = phoneNumberConfirmed;
	}

	public String getSecurityStamp() {
		return this.SecurityStamp;
	}

	public void setSecurityStamp(String securityStamp) {
		this.SecurityStamp = securityStamp;
	}

	public boolean getTwoFactorEnabled() {
		return this.twoFactorEnabled;
	}

	public void setTwoFactorEnabled(boolean twoFactorEnabled) {
		this.twoFactorEnabled = twoFactorEnabled;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Appointment> getAppointments1() {
		return this.appointments1;
	}

	public void setAppointments1(List<Appointment> appointments1) {
		this.appointments1 = appointments1;
	}

	public Appointment addAppointments1(Appointment appointments1) {
		getAppointments1().add(appointments1);
		appointments1.setAspNetUser1(this);

		return appointments1;
	}

	public Appointment removeAppointments1(Appointment appointments1) {
		getAppointments1().remove(appointments1);
		appointments1.setAspNetUser1(null);

		return appointments1;
	}

	public List<Appointment> getAppointments2() {
		return this.appointments2;
	}

	public void setAppointments2(List<Appointment> appointments2) {
		this.appointments2 = appointments2;
	}

	public Appointment addAppointments2(Appointment appointments2) {
		getAppointments2().add(appointments2);
		appointments2.setAspNetUser2(this);

		return appointments2;
	}

	public Appointment removeAppointments2(Appointment appointments2) {
		getAppointments2().remove(appointments2);
		appointments2.setAspNetUser2(null);

		return appointments2;
	}

	public List<Appointment> getAppointments3() {
		return this.appointments3;
	}

	public void setAppointments3(List<Appointment> appointments3) {
		this.appointments3 = appointments3;
	}

	public Appointment addAppointments3(Appointment appointments3) {
		getAppointments3().add(appointments3);
		appointments3.setAspNetUser3(this);

		return appointments3;
	}

	public Appointment removeAppointments3(Appointment appointments3) {
		getAppointments3().remove(appointments3);
		appointments3.setAspNetUser3(null);

		return appointments3;
	}

	public List<AspNetUserClaim> getAspNetUserClaims() {
		return this.aspNetUserClaims;
	}

	public void setAspNetUserClaims(List<AspNetUserClaim> aspNetUserClaims) {
		this.aspNetUserClaims = aspNetUserClaims;
	}

	public AspNetUserClaim addAspNetUserClaim(AspNetUserClaim aspNetUserClaim) {
		getAspNetUserClaims().add(aspNetUserClaim);
		aspNetUserClaim.setAspNetUser(this);

		return aspNetUserClaim;
	}

	public AspNetUserClaim removeAspNetUserClaim(AspNetUserClaim aspNetUserClaim) {
		getAspNetUserClaims().remove(aspNetUserClaim);
		aspNetUserClaim.setAspNetUser(null);

		return aspNetUserClaim;
	}

	public List<AspNetUserLogin> getAspNetUserLogins() {
		return this.aspNetUserLogins;
	}

	public void setAspNetUserLogins(List<AspNetUserLogin> aspNetUserLogins) {
		this.aspNetUserLogins = aspNetUserLogins;
	}

	public AspNetUserLogin addAspNetUserLogin(AspNetUserLogin aspNetUserLogin) {
		getAspNetUserLogins().add(aspNetUserLogin);
		aspNetUserLogin.setAspNetUser(this);

		return aspNetUserLogin;
	}

	public AspNetUserLogin removeAspNetUserLogin(AspNetUserLogin aspNetUserLogin) {
		getAspNetUserLogins().remove(aspNetUserLogin);
		aspNetUserLogin.setAspNetUser(null);

		return aspNetUserLogin;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<AspNetRole> getAspNetRoles() {
		return this.aspNetRoles;
	}

	public void setAspNetRoles(List<AspNetRole> aspNetRoles) {
		this.aspNetRoles = aspNetRoles;
	}

	public Speciality getSpeciality() {
		return this.speciality;
	}

	public void setSpeciality(Speciality speciality) {
		this.speciality = speciality;
	}

	public List<Chat> getChats1() {
		return this.chats1;
	}

	public void setChats1(List<Chat> chats1) {
		this.chats1 = chats1;
	}

	public Chat addChats1(Chat chats1) {
		getChats1().add(chats1);
		chats1.setAspNetUser1(this);

		return chats1;
	}

	public Chat removeChats1(Chat chats1) {
		getChats1().remove(chats1);
		chats1.setAspNetUser1(null);

		return chats1;
	}

	public List<Chat> getChats2() {
		return this.chats2;
	}

	public void setChats2(List<Chat> chats2) {
		this.chats2 = chats2;
	}

	public Chat addChats2(Chat chats2) {
		getChats2().add(chats2);
		chats2.setAspNetUser2(this);

		return chats2;
	}

	public Chat removeChats2(Chat chats2) {
		getChats2().remove(chats2);
		chats2.setAspNetUser2(null);

		return chats2;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setAspNetUser(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setAspNetUser(null);

		return comment;
	}

	public List<Disponibility> getDisponibilities() {
		return this.disponibilities;
	}

	public void setDisponibilities(List<Disponibility> disponibilities) {
		this.disponibilities = disponibilities;
	}

	public Disponibility addDisponibility(Disponibility disponibility) {
		getDisponibilities().add(disponibility);
		disponibility.setAspNetUser(this);

		return disponibility;
	}

	public Disponibility removeDisponibility(Disponibility disponibility) {
		getDisponibilities().remove(disponibility);
		disponibility.setAspNetUser(null);

		return disponibility;
	}

	public List<Fora> getForas() {
		return this.foras;
	}

	public void setForas(List<Fora> foras) {
		this.foras = foras;
	}

	public Fora addFora(Fora fora) {
		getForas().add(fora);
		fora.setAspNetUser(this);

		return fora;
	}

	public Fora removeFora(Fora fora) {
		getForas().remove(fora);
		fora.setAspNetUser(null);

		return fora;
	}

	public List<MedicalPath> getMedicalPaths1() {
		return this.medicalPaths1;
	}

	public void setMedicalPaths1(List<MedicalPath> medicalPaths1) {
		this.medicalPaths1 = medicalPaths1;
	}

	public MedicalPath addMedicalPaths1(MedicalPath medicalPaths1) {
		getMedicalPaths1().add(medicalPaths1);
		medicalPaths1.setAspNetUser1(this);

		return medicalPaths1;
	}

	public MedicalPath removeMedicalPaths1(MedicalPath medicalPaths1) {
		getMedicalPaths1().remove(medicalPaths1);
		medicalPaths1.setAspNetUser1(null);

		return medicalPaths1;
	}

	public List<MedicalPath> getMedicalPaths2() {
		return this.medicalPaths2;
	}

	public void setMedicalPaths2(List<MedicalPath> medicalPaths2) {
		this.medicalPaths2 = medicalPaths2;
	}

	public MedicalPath addMedicalPaths2(MedicalPath medicalPaths2) {
		getMedicalPaths2().add(medicalPaths2);
		medicalPaths2.setAspNetUser2(this);

		return medicalPaths2;
	}

	public MedicalPath removeMedicalPaths2(MedicalPath medicalPaths2) {
		getMedicalPaths2().remove(medicalPaths2);
		medicalPaths2.setAspNetUser2(null);

		return medicalPaths2;
	}

	public List<Post> getPosts() {
		return this.posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public Post addPost(Post post) {
		getPosts().add(post);
		post.setAspNetUser(this);

		return post;
	}

	public Post removePost(Post post) {
		getPosts().remove(post);
		post.setAspNetUser(null);

		return post;
	}

	public List<Treatement> getTreatements() {
		return this.treatements;
	}

	public void setTreatements(List<Treatement> treatements) {
		this.treatements = treatements;
	}

	public Treatement addTreatement(Treatement treatement) {
		getTreatements().add(treatement);
		treatement.setAspNetUser(this);

		return treatement;
	}

	public Treatement removeTreatement(Treatement treatement) {
		getTreatements().remove(treatement);
		treatement.setAspNetUser(null);

		return treatement;
	}
	@Override
	public String toString() {
		return "AspNetUser [Id=" + Id + ", AccessFailedCount=" + AccessFailedCount + ", Discriminator=" + Discriminator
				+ ", Email=" + Email + ", EmailConfirmed=" + EmailConfirmed + ", FirstName=" + firstName + ", LastName="
				+ lastName + ", LockoutEnabled=" + LockoutEnabled + ", LockoutEndDateUtc=" + LockoutEndDateUtc
				+ ", PasswordHash=" + PasswordHash + ", PhoneNumber=" + PhoneNumber + ", PhoneNumberConfirmed="
				+ PhoneNumberConfirmed + ", SecurityStamp=" + SecurityStamp + ", twoFactorEnabled=" + twoFactorEnabled
				+ ", userName=" + userName + ", appointments1=" + appointments1 + ", appointments2=" + appointments2
				+ ", appointments3=" + appointments3 + ", aspNetUserClaims=" + aspNetUserClaims + ", aspNetUserLogins="
				+ aspNetUserLogins + ", address=" + address + ", aspNetRoles=" + aspNetRoles + ", speciality="
				+ speciality + ", chats1=" + chats1 + ", chats2=" + chats2 + ", comments=" + comments
				+ ", disponibilities=" + disponibilities + ", foras=" + foras + ", medicalPaths1=" + medicalPaths1
				+ ", medicalPaths2=" + medicalPaths2 + ", posts=" + posts + ", treatements=" + treatements + "]";
	}

}