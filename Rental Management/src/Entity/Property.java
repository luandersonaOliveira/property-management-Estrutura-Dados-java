package Entity;
// Imovel

import java.util.List;

import Enum.PropertyOccupation;
import Enum.PropertyType;

public class Property {
    private static int nextId = 0;

    // ATRIBUTOS
    private int id;
    private String address;
    private double rentalValue;
    private PropertyType type;
    private PropertyOccupation occupation;
    private Landlord landlord;
    private List<Tenant> tenant;

    // CONSTRUCTOR

    public Property(String address, double rentalValue, PropertyType type, PropertyOccupation occupation) {
        this.address = address;
        this.rentalValue = rentalValue;
        this.type = type;
        this.occupation = occupation;
        this.setId(nextId++);
    }

    // METODOS ESPECIAS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getaddress() {
        return address;
    }

    public void setaddress(String address) {
        this.address = address;
    }

    public double getRentalValue() {
        return rentalValue;
    }

    public void setRentalValue(double rentalValue) {
        this.rentalValue = rentalValue;
    }

    public PropertyType getType() {
        return type;
    }

    public void setType(PropertyType type) {
        this.type = type;
    }

    public PropertyOccupation getOccupation() {
        return occupation;
    }

    public void setOccupation(PropertyOccupation occupation) {
        this.occupation = occupation;
    }

    public Landlord getLandlord() {
        return landlord;
    }

    public void setLandlord(Landlord landlord) {
        this.landlord = landlord;
    }

    public List<Tenant> getTenant() {
        return tenant;
    }

    public void setTenant(List<Tenant> tenant) {
        this.tenant = tenant;
    }

    // METODOS PERSONALIZADOS
}
