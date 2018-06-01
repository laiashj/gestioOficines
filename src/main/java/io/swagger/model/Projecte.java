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
    private ObjectId _id;
    private String nom;
    private String descripcio;
    private String color;
    private String dataAlta;
    private String dataBaixa;

    public Projecte() {

    }

    public Projecte(ObjectId id, String nom, String descripcio, String color, String dataAlta) {
        this._id = id;
        this.nom = nom;
        this.descripcio = descripcio;
        this.color = color;
        this.dataAlta = dataAlta;
        this.dataBaixa = "alta";
    }

    public Projecte(String nom, String descripcio, String color, String dataAlta) {
        this._id = new ObjectId();
        this.nom = nom;
        this.descripcio = descripcio;
        this.color = color;
        this.dataAlta = dataAlta;
        this.dataBaixa = "alta";
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

    public String get_id() {
        return this._id.toString();
    }

    public void set_id(ObjectId id) {
        this._id = id;
    }

    public ObjectId getObjectId() {
        return this._id;
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
        return Objects.equals(this._id, projecte._id) && Objects.equals(this.nom, projecte.nom)
                && Objects.equals(this.descripcio, projecte.descripcio) && Objects.equals(this.color, projecte.color)
                && Objects.equals(this.dataAlta, projecte.dataAlta)
                && Objects.equals(this.dataBaixa, projecte.dataBaixa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, descripcio, color, dataAlta, dataBaixa);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Projecte {\n");

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