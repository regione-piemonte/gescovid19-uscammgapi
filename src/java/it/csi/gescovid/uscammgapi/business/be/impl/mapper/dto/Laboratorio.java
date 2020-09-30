package it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto;

public class Laboratorio {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column laboratorio.id_laboratorio
	 * @mbg.generated
	 */
	private Long idLaboratorio;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column laboratorio.descrizione
	 * @mbg.generated
	 */
	private String descrizione;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column laboratorio.sigla_laboratorio
	 * @mbg.generated
	 */
	private String siglaLaboratorio;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column laboratorio.capacita_giornaliera
	 * @mbg.generated
	 */
	private Integer capacitaGiornaliera;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column laboratorio.id_laboratorio
	 * @return  the value of laboratorio.id_laboratorio
	 * @mbg.generated
	 */
	public Long getIdLaboratorio() {
		return idLaboratorio;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column laboratorio.id_laboratorio
	 * @param idLaboratorio  the value for laboratorio.id_laboratorio
	 * @mbg.generated
	 */
	public void setIdLaboratorio(Long idLaboratorio) {
		this.idLaboratorio = idLaboratorio;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column laboratorio.descrizione
	 * @return  the value of laboratorio.descrizione
	 * @mbg.generated
	 */
	public String getDescrizione() {
		return descrizione;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column laboratorio.descrizione
	 * @param descrizione  the value for laboratorio.descrizione
	 * @mbg.generated
	 */
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column laboratorio.sigla_laboratorio
	 * @return  the value of laboratorio.sigla_laboratorio
	 * @mbg.generated
	 */
	public String getSiglaLaboratorio() {
		return siglaLaboratorio;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column laboratorio.sigla_laboratorio
	 * @param siglaLaboratorio  the value for laboratorio.sigla_laboratorio
	 * @mbg.generated
	 */
	public void setSiglaLaboratorio(String siglaLaboratorio) {
		this.siglaLaboratorio = siglaLaboratorio;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column laboratorio.capacita_giornaliera
	 * @return  the value of laboratorio.capacita_giornaliera
	 * @mbg.generated
	 */
	public Integer getCapacitaGiornaliera() {
		return capacitaGiornaliera;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column laboratorio.capacita_giornaliera
	 * @param capacitaGiornaliera  the value for laboratorio.capacita_giornaliera
	 * @mbg.generated
	 */
	public void setCapacitaGiornaliera(Integer capacitaGiornaliera) {
		this.capacitaGiornaliera = capacitaGiornaliera;
	}
}