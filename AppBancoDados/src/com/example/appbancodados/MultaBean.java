package com.example.appbancodados;

public class MultaBean {
	
	private Integer id;
	private Double latitude,longitude;
	private String placa,motivo,policial,pathimagem;
	private String dataNotificacao;
	
	public String getDataNotificacao() {
		return dataNotificacao;
	}
	public void setDataNotificacao(String dataNotificacao) {
		this.dataNotificacao = dataNotificacao;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public String getPolicial() {
		return policial;
	}
	public void setPolicial(String policial) {
		this.policial = policial;
	}
	public String getPathimagem() {
		return pathimagem;
	}
	public void setPathimagem(String pathimagem) {
		this.pathimagem = pathimagem;
	}
	public String toString(){
		return getId()+ " " +getPlaca() +" " +getMotivo()+" "+getDataNotificacao()+" "+getLatitude()+" "+getLongitude()+" "+getPathimagem()+" "+getPolicial();
	}

}
