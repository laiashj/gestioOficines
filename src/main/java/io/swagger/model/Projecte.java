package io.swagger.model;

import java.util.Objects;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.CrossOrigin;

/*
 * Projecte
 */
@CrossOrigin
@Document(collection = "projecte")
public class Projecte {
    @Id
    private ObjectId _id = null;
    private String nom = null;
    private String descripcio = null;
    private String color = null;
    private String dataAlta = null;
    private String dataBaixa = "null";
    private String idProjecte = null;

    public Projecte() {

    }

    public Projecte(String idProjecte, String nom, String descripcio, String color, String dataAlta) {
	this._id = new ObjectId();
        this.idProjecte = idProjecte;
        this.nom = nom;
        this.descripcio = descripcio;
        this.color = color;
        this.dataAlta = dataAlta;
        this.dataBaixa = null;
    }

    public Projecte(String idProjecte, String nom, String descripcio, String color, String dataAlta,
            String dataBaixa) {
	this._id = new ObjectId();
        this.idProjecte = idProjecte;
        this.nom = nom;
        this.descripcio = descripcio;
        this.color = color;
        this.dataAlta = dataAlta;
        this.dataBaixa = dataBaixa;
    }

    public String getIdProjecte() {
        return idProjecte;
    }

    public void setIdProjecte(String idProjecte) {
        this.idProjecte = idProjecte;
    }

    public Projecte nom(String nom) {
        this.nom = nom;
        return this;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Projecte descripcio(String descripcio) {
        this.descripcio = descripcio;
        return this;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public Projecte color(String color) {
        this.color = color;
        return this;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Projecte dataAlta(String dataAlta) {
        this.dataAlta = dataAlta;
        return this;
    }

    public String getDataAlta() {
        return dataAlta;
    }

    public void setDataAlta(String dataAlta) {
        this.dataAlta = dataAlta;
    }

    public Projecte dataBaixa(String dataBaixa) {
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
        Projecte projecte = (Projecte) o;
        return Objects.equals(this.idProjecte, projecte.idProjecte) && Objects.equals(this.nom, projecte.nom)
                && Objects.equals(this.descripcio, projecte.descripcio) && Objects.equals(this.color, projecte.color)
                && Objects.equals(this.dataAlta, projecte.dataAlta)
                && Objects.equals(this.dataBaixa, projecte.dataBaixa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProjecte, nom, descripcio, color, dataAlta, dataBaixa);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Projecte {\n");

        sb.append("    idProjecte: ").append(toIndentedString(idProjecte)).append("\n");
        sb.append("    nom: ").append(toIndentedString(nom)).append("\n");
        sb.append("    descripcio: ").append(toIndentedString(descripcio)).append("\n");
        sb.append("    color: ").append(toIndentedString(color)).append("\n");
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