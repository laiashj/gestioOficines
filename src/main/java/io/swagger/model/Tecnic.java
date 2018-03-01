package io.swagger.model;

import java.util.Objects;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Tecnic
 */

@Document(collection = "tecnic")
public class Tecnic {
    @Id
    private ObjectId idTecnic = null;
    private String nomCognom = null;
    private String estat = "noAssignat";
    private String dataAlta = null;
    private String dataBaixa = "null";
    private String projecte = null;
    private String lloc = null;

    public Tecnic() {

    }

    public Tecnic(ObjectId idTecnic, String nomCognom, String estat, String dataAlta, String dataBaixa, String projecte,
            String lloc) {
        super();
        this.idTecnic = idTecnic;
        this.nomCognom = nomCognom;
        this.estat = estat;
        this.dataAlta = dataAlta;
        this.dataBaixa = dataBaixa;
        this.projecte = projecte;
        this.lloc = lloc;
    }

    public Tecnic idTecnic(ObjectId idTecnic) {
        this.idTecnic = idTecnic;
        return this;
    }

    public ObjectId getIdTecnic() {
        return idTecnic;
    }

    public void setIdTecnic(ObjectId idTecnic) {
        this.idTecnic = idTecnic;
    }

    public Tecnic nomCognom(String nomCognom) {
        this.nomCognom = nomCognom;
        return this;
    }

    public String getNomCognom() {
        return nomCognom;
    }

    public void setNomCognom(String nomCognom) {
        this.nomCognom = nomCognom;
    }

    public Tecnic estat(String estat) {
        this.estat = estat;
        return this;
    }

    public String getEstat() {
        return estat;
    }

    public void setEstat(String estat) {
        this.estat = estat;
    }

    public Tecnic dataAlta(String dataAlta) {
        this.dataAlta = dataAlta;
        return this;
    }

    public String getDataAlta() {
        return dataAlta;
    }

    public void setDataAlta(String dataAlta) {
        this.dataAlta = dataAlta;
    }

    public Tecnic dataBaixa(String dataBaixa) {
        this.dataBaixa = dataBaixa;
        return this;
    }

    public String getDataBaixa() {
        return dataBaixa;
    }

    public void setDataBaixa(String dataBaixa) {
        this.dataBaixa = dataBaixa;
    }

    public Tecnic projecte(String projecte) {
        this.projecte = projecte;
        return this;
    }

    public String getProjecte() {
        return projecte;
    }

    public void setProjecte(String projecte) {
        this.projecte = projecte;
    }

    public Tecnic lloc(String lloc) {
        this.lloc = lloc;
        return this;
    }

    public String getLloc() {
        return lloc;
    }

    public void setLloc(String lloc) {
        this.lloc = lloc;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Tecnic tecnic = (Tecnic) o;
        return Objects.equals(this.idTecnic, tecnic.idTecnic) && Objects.equals(this.nomCognom, tecnic.nomCognom)
                && Objects.equals(this.estat, tecnic.estat) && Objects.equals(this.dataAlta, tecnic.dataAlta)
                && Objects.equals(this.dataBaixa, tecnic.dataBaixa) && Objects.equals(this.projecte, tecnic.projecte)
                && Objects.equals(this.lloc, tecnic.lloc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTecnic, nomCognom, estat, dataAlta, dataBaixa, projecte, lloc);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Tecnic {\n");

        sb.append("    idTecnic: ").append(toIndentedString(idTecnic)).append("\n");
        sb.append("    nomCognom: ").append(toIndentedString(nomCognom)).append("\n");
        sb.append("    estat: ").append(toIndentedString(estat)).append("\n");
        sb.append("    dataAlta: ").append(toIndentedString(dataAlta)).append("\n");
        sb.append("    dataBaixa: ").append(toIndentedString(dataBaixa)).append("\n");
        sb.append("    projecte: ").append(toIndentedString(projecte)).append("\n");
        sb.append("    lloc: ").append(toIndentedString(lloc)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
