package com.paris.backend.model;

/**
 * Created by achen on 2017/7/15 0015.
 */
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
@Table(name = "camera")
public class Camera {

    @Id
    @Digits(integer=10, fraction=0)

    @Column(name="cameraid")
    private int id;

    @NotEmpty(message = "*Please provide an camera name")
    @Column(name="cameraName")
    private String cameraName;

    @NotEmpty(message = "*Please provide an Url")
    @Column(name="url")
    private String url;

    @NotEmpty(message = "*Please provide an serialNumber")
    @Column(name="serialNumber")
    private String serialNumber;

    @NotEmpty(message = "*Please provide an model")
    @Column(name="model")
    private String model;

    @NotEmpty(message = "*Please provide an manufacturer")
    @Column(name="manufacturer")
    private String manufacturer;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCameraName() {
        return cameraName;
    }

    public void setCameraName(String cameraName) {
        this.cameraName = cameraName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append(url);
        return sb.toString();
    }
}
