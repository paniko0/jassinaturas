package sdk.jassinaturas.clients.attributes;

import java.util.List;

public class Customer {
    private Address address;
    private BillingInfo billingInfo;
    private Birthdate birthdate;
    private String code;
    private String cpf;
    private List<Customer> customers;
    private String email;
    private String fullname;
    private String message;
    private String phoneAreaCode;
    private String phoneNumber;

    private int birthdateDay;
    private int birthdateMonth;
    private int birthdateYear;

    public Address getAddress() {
        return address;
    }

    public BillingInfo getBillingInfo() {
        return billingInfo;
    }

    public Birthdate getBirthdate() {
        Birthdate birthdate = new Birthdate();
        birthdate.withDay(birthdateDay);
        birthdate.withMonth(Month.getMonth(birthdateMonth));
        birthdate.withYear(birthdateYear);
        return birthdate;
    }

    public String getCode() {
        return code;
    }

    public String getCpf() {
        return cpf;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public String getEmail() {
        return email;
    }

    public String getFullname() {
        return fullname;
    }

    public String getMessage() {
        return message;
    }

    public String getPhoneAreaCode() {
        return phoneAreaCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Customer withAddress(final Address address) {
        this.address = address;
        return this;
    }

    public Customer withBillingInfo(final BillingInfo billingInfo) {
        this.billingInfo = billingInfo;
        return this;
    }

    public Customer withBirthdate(final Birthdate birthdate) {
        this.birthdateDay = birthdate.getBirthdateDay();
        this.birthdateMonth = birthdate.getBirthdateMonth();
        this.birthdateYear = birthdate.getBirthdateYear();
        return this;
    }

    public Customer withCode(final String code) {
        this.code = code;
        return this;
    }

    public Customer withCpf(final String cpf) {
        this.cpf = cpf;
        return this;
    }

    public Customer withEmail(final String email) {
        this.email = email;
        return this;
    }

    public Customer withFullname(final String fullname) {
        this.fullname = fullname;
        return this;
    }

    public Customer withPhoneAreaCode(final String phoneAreaCode) {
        this.phoneAreaCode = phoneAreaCode;
        return this;
    }

    public Customer withPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    @Override
    public String toString() {
        return "Customer [address=" + address + ", billingInfo=" + billingInfo + ", birthdate=" + birthdate + ", code="
                + code + ", cpf=" + cpf + ", customers=" + customers + ", email=" + email + ", fullname=" + fullname
                + ", message=" + message + ", phoneAreaCode=" + phoneAreaCode + ", phoneNumber=" + phoneNumber
                + ", birthdateDay=" + birthdateDay + ", birthdateMonth=" + birthdateMonth + ", birthdateYear="
                + birthdateYear + "]";
    }

}
