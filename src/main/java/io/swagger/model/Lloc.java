package io.swagger.model;

import java.util.Objects;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * Lloc
 */
@CrossOrigin
@Document(collection = "lloc")
public class Lloc {
    @Id
    private ObjectId _id = null;
    private Integer idLloc = null;
    private Integer toma = null;
    private Boolean habilitat = true;
    private String dataAlta = null;
    private String dataBaixa = "null";

    public Lloc() {

    }

    public Lloc(Integer idLloc, Integer toma, Boolean habilitat, String dataAlta) {
	ObjectId _id = new ObjectId();
	this.idLloc = idLloc;
	this.toma = toma;
	this.habilitat = habilitat;
	this.dataAlta = dataAlta;
    }

    public Lloc idLloc(Integer idLloc) {
	this.idLloc = idLloc;
	return this;
    }

    public Integer getIdLloc() {
	return idLloc;
    }

    public void setIdLloc(Integer idLloc) {
	this.idLloc = idLloc;
    }

    public Lloc toma(Integer toma) {
	this.toma = toma;
	return this;
    }

    public Integer getToma() {
	return toma;
    }

    public void setToma(Integer toma) {
	this.toma = toma;
    }

    public Lloc habilitat(Boolean habilitat) {
	this.habilitat = habilitat;
	return this;
    }

    public Boolean isHabilitat() {
	return habilitat;
    }

    public void setHabilitat(Boolean habilitat) {
	this.habilitat = habilitat;
    }

    public Lloc dataAlta(String dataAlta) {
	this.dataAlta = dataAlta;
	return this;
    }

    public String getDataAlta() {
	return dataAlta;
    }

    public void setDataAlta(String dataAlta) {
	this.dataAlta = dataAlta;
    }

    public Lloc dataBaixa(String dataBaixa) {
	this.dataBaixa = dataBaixa;
	return this;
    }

    public String getDataBaixa() {
	return dataBaixa;
    }

    public void setDataBaixa(String dataBaixa) {
	this.dataBaixa = dataBaixa;
    }

    @Override
    public boolean equals(java.lang.Object o) {
	if (this == o) {
	    return true;
	}
	if (o == null || getClass() != o.getClass()) {
	    return false;
	}
	Lloc lloc = (Lloc) o;
	return Objects.equals(this.idLloc, lloc.idLloc) && Objects.equals(this.toma, lloc.toma)
		&& Objects.equals(this.habilitat, lloc.habilitat) && Objects.equals(this.dataAlta, lloc.dataAlta)
		&& Objects.equals(this.dataBaixa, lloc.dataBaixa);
    }

    @Override
    public int hashCode() {
	return Objects.hash(idLloc, toma, habilitat, dataAlta, dataBaixa);
    }

    @Override
    public String toString() {
	StringBuilder sb = new StringBuilder();
	sb.append("class Lloc {\n");

	sb.append("    idLloc: ").append(toIndentedString(idLloc)).append("\n");
	sb.append("    toma: ").append(toIndentedString(toma)).append("\n");
	sb.append("    habilitat: ").append(toIndentedString(habilitat)).append("\n");
	sb.append("    dataAlta: ").append(toIndentedString(dataAlta)).append("\n");
	sb.append("    dataBaixa: ").append(toIndentedString(dataBaixa)).append("\n");
	sb.append("}");
	return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
	if (o == null) {
	    return "null";
	}
	return o.toString().replace("\n", "\n    ");
    }
}
