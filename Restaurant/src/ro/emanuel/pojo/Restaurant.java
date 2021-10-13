package ro.emanuel.pojo;

public class Restaurant {

	private int id;
	private String nume, telefon, adresa;
	private double rating;
	private String imagine;
	
	public Restaurant(int id, String nume, String telefon, String adresa, double rating, String imagine) {
		super();
		this.id = id;
		this.nume = nume;
		this.telefon = telefon;
		this.adresa = adresa;
		this.rating = rating;
		this.imagine = imagine;
	}
	
	public Restaurant() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getImagine() {
		return imagine;
	}

	public void setImagine(String imagine) {
		this.imagine = imagine;
	}
	
}
