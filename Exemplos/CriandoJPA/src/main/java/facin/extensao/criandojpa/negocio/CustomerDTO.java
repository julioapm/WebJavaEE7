package facin.extensao.criandojpa.negocio;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author Julio
 */
public class CustomerDTO implements Serializable {

    private Integer customerId;
    private String name;
    private String fullAddress;
    private String phone;
    private String fax;
    private String email;
    private Integer creditLimit;
    private BigDecimal discount;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Integer creditLimit) {
        this.creditLimit = creditLimit;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public CustomerDTO(Integer customerId, String name, String fullAddress, String phone, String fax, String email, Integer creditLimit, BigDecimal discount) {
        this.customerId = customerId;
        this.name = name;
        this.fullAddress = fullAddress;
        this.phone = phone;
        this.fax = fax;
        this.email = email;
        this.creditLimit = creditLimit;
        this.discount = discount;
    }
}
