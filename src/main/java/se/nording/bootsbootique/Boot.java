package se.nording.bootsbootique;

import jakarta.persistence.*;

@Entity
@Table(name="boots")
public class Boot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private BootType type;

    private Float size;

    private Integer quantity;

    private String material;

    public Boot() {}

    public Integer getId() {
        return id;
    }

    public BootType getType() {
        return type;
    }

    public Float getSize() {
        return size;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getMaterial() {
        return material;
    }

    // Setters
    public void setId(Integer id) {
        this.id = id;
    }

    public void setType(BootType type) {
        this.type = type;
    }

    public void setSize(Float size) {
        this.size = size;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
