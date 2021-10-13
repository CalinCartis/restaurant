package ro.emanuel.pojo;

public class Comanda {

	private int id, idClient, idRestaurant;
	private String produsComandat;
	private int cantitate;
	private double pret;
	
	public Comanda(int id, int idClient, int idRestaurant, String produsComandat, int cantitate, double pret) {
		super();
		this.id = id;
		this.idClient = idClient;
		this.idRestaurant = idRestaurant;
		this.produsComandat = produsComandat;
		this.cantitate = cantitate;
		this.pret = pret;
	}
	
	public Comanda() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public int getIdRestaurant() {
		return idRestaurant;
	}

	public void setIdRestaurant(int idRestaurant) {
		this.idRestaurant = idRestaurant;
	}

	public String getProdusComandat() {
		return produsComandat;
	}

	public void setProdusComandat(String produsComandat) {
		this.produsComandat = produsComandat;
	}

	public int getCantitate() {
		return cantitate;
	}

	public void setCantitate(int cantitate) {
		this.cantitate = cantitate;
	}

	public double getPret() {
		return pret;
	}

	public void setPret(double pret) {
		this.pret = pret;
	}
	
}
