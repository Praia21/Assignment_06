package org.example;

import lombok.*;

@NoArgsConstructor
@Setter
@Getter
public class Address {
    private int streetNo;
    private String street;
    private String city;
    private String province;
    private String postalCode;
    private String country;

    public Address(int streetNo, String street, String city, String province, String postalCode, String country) {
        if (isPostalCodeValid(postalCode)) {
            this.streetNo = streetNo;
            this.street = street;
            this.city = city;
            this.province = province;
            this.postalCode = postalCode.toUpperCase();
            this.country = country;
        } else {
            this.streetNo = 0;
            this.street = null;
            this.city = null;
            this.province = null;
            this.postalCode = null;
            this.country = null;
        }
    }

    /**
     * Validates the postal code
     * @param postalCode the postal code to be validated
     * @return true if the postal code is valid or false
     */
    public static boolean isPostalCodeValid(String postalCode) {
        if (postalCode == null) {
            return false;
        }
        postalCode = postalCode.toUpperCase();
        if (postalCode.length() == 6 && postalCode.matches("[A-Z][0-9][A-Z][0-9][A-Z][0-9]")) {
            return true;
        } else if (postalCode.length() == 7 && postalCode.matches("[A-Z][0-9][A-Z] [0-9][A-Z][0-9]")) {
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return streetNo + " " + street + ", " + city + ", " + province + ", " + postalCode + ", " + country;
    }

    /**
     * compares this address to another object for equality.
     * @param obj the object to compare to
     * @return true if the objects are equal, false if there are not
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Address address = (Address) obj;
        return streetNo == address.streetNo && street.equals(address.street) && city.equals(address.city) &&
                province.equals(address.province) && postalCode.equals(address.postalCode) && country.equals(address.country);
    }
}
