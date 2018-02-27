package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Projecte
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-02-26T14:49:25.168Z")

public class Projecte   {
  @JsonProperty("idProjecte")
  private Integer idProjecte = null;

  @JsonProperty("nom")
  private String nom = null;

  @JsonProperty("descripcio")
  private String descripcio = null;

  @JsonProperty("color")
  private String color = null;

  @JsonProperty("dataAlta")
  private String dataAlta = null;

  @JsonProperty("dataBaixa")
  private String dataBaixa = "null";

  public Projecte idProjecte(Integer idProjecte) {
    this.idProjecte = idProjecte;
    return this;
  }

   /**
   * Get idProjecte
   * @return idProjecte
  **/
  @ApiModelProperty(example = "11", required = true, value = "")
  @NotNull


  public Integer getIdProjecte() {
    return idProjecte;
  }

  public void setIdProjecte(Integer idProjecte) {
    this.idProjecte = idProjecte;
  }

  public Projecte nom(String nom) {
    this.nom = nom;
    return this;
  }

   /**
   * Get nom
   * @return nom
  **/
  @ApiModelProperty(example = "Balearia", required = true, value = "")
  @NotNull


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

   /**
   * Get descripcio
   * @return descripcio
  **/
  @ApiModelProperty(example = "Projecte Balearia", required = true, value = "")
  @NotNull


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

   /**
   * Get color
   * @return color
  **/
  @ApiModelProperty(example = "#42f4ce", required = true, value = "")
  @NotNull


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

   /**
   * Get dataAlta
   * @return dataAlta
  **/
  @ApiModelProperty(example = "2016-08-29T09:12:33.001Z", required = true, value = "")
  @NotNull


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

   /**
   * Get dataBaixa
   * @return dataBaixa
  **/
  @ApiModelProperty(example = "2016-08-29T09:12:33.001Z", value = "")


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
    return Objects.equals(this.idProjecte, projecte.idProjecte) &&
        Objects.equals(this.nom, projecte.nom) &&
        Objects.equals(this.descripcio, projecte.descripcio) &&
        Objects.equals(this.color, projecte.color) &&
        Objects.equals(this.dataAlta, projecte.dataAlta) &&
        Objects.equals(this.dataBaixa, projecte.dataBaixa);
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

