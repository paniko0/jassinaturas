package sdk.jassinaturas.clients.attributes;

public class Address {

    private String city;
    private String complement;
    private Country country;
    private String district;
    private String number;
    private State state;
    private String street;
    private String zipcode;

    public String getCity() {
        return city;
    }

    public String getComplement() {
        return complement;
    }

    public Country getCountry() {
        return country;
    }

    public String getDistrict() {
        return district;
    }

    public String getNumber() {
        return number;
    }

    public State getState() {
        return state;
    }

    public String getStreet() {
        return street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public Address withCity(final String city) {
        this.city = city;
        return this;
    }

    public Address withComplement(final String complement) {
        this.complement = complement;
        return this;
    }

    public Address withCountry(final Country country) {
        this.country = country;
        return this;
    }

    public Address withDistrict(final String district) {
        this.district = district;
        return this;
    }

    public Address withNumber(final String number) {
        this.number = number;
        return this;
    }

    public Address withState(final State state) {
        this.state = state;
        return this;
    }

    public Address withStreet(final String street) {
        this.street = street;
        return this;
    }

    public Address withZipcode(final String zipcode) {
        this.zipcode = zipcode;
        return this;
    }

    @Override
    public String toString() {
        return "Address [city=" + city + ", complement=" + complement + ", country=" + country + ", district="
                + district + ", number=" + number + ", state=" + state + ", street=" + street + ", zipcode=" + zipcode
                + "]";
    }

}
