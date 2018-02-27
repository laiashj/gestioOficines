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
 * Lloc
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-02-26T14:49:25.168Z")

public class Lloc   {
  @JsonProperty("idLloc")
  private Integer idLloc = null;

  @JsonProperty("toma")
  private Integer toma = null;

  @JsonProperty("habilitat")
  private Boolean habilitat = true;

  @JsonProperty("dataAlta")
  private String dataAlta = null;

  @JsonProperty("dataBaixa")
  private String dataBaixa = "null";

  public Lloc idLloc(Integer idLloc) {
    this.idLloc = idLloc;
    return this;
  }

   /**
   * Get idLloc
   * @return idLloc
  **/
  @ApiModelProperty(example = "222", required = true, value = "")
  @NotNull


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

   /**
   * Get toma
   * @return toma
  **/
  @ApiModelProperty(example = "92", required = true, value = "")
  @NotNull


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

   /**
   * Get habilitat
   * @return habilitat
  **/
  @ApiModelProperty(example = "true", value = "")


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

  public Lloc dataBaixa(String dataBaixa) {
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
    Lloc lloc = (Lloc) o;
    return Objects.equals(this.idLloc, lloc.idLloc) &&
        Objects.equals(this.toma, lloc.toma) &&
        Objects.equals(this.habilitat, lloc.habilitat) &&
        Objects.equals(this.dataAlta, lloc.dataAlta) &&
        Objects.equals(this.dataBaixa, lloc.dataBaixa);
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

