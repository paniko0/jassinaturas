package sdk.jassinaturas.clients.attributes;

import java.util.Calendar;
import java.util.List;

import sdk.jassinaturas.communicators.CustomerCommunicator;

public class Customer {
    private Address address;
    private List<Alerts> alerts;
    private BillingInfo billingInfo;
    private int birthdateDay;
    private int birthdateMonth;
    private int birthdateYear;
    private String code;
    private String cpf;
    private CustomerCommunicator customerCommunicator;
    private List<Customer> customers;
    private String email;
    private String fullname;
    private String message;
    private String phoneAreaCode;
    private String phoneNumber;

    public Address getAddress() {
        return address;
    }

    public List<Alerts> getAlerts() {
        return alerts;
    }

    public BillingInfo getBillingInfo() {
        return billingInfo;
    }

    public int getBirthdateDay() {
        return birthdateDay;
    }

    public int getBirthdateMonth() {
        return birthdateMonth;
    }

    public int getBirthdateYear() {
        return birthdateYear;
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

    public boolean hasAlerts() {
        return alerts != null && alerts.size() > 0;
    }

    public Customer withAddress(final Address address) {
        this.address = address;
        return this;
    }

    public Customer withBillingInfo(final BillingInfo billingInfo) {
        this.billingInfo = billingInfo;
        return this;
    }

    public Customer withBirthdate(final Calendar birthdate) {
        this.birthdateDay = birthdate.get(Calendar.DAY_OF_MONTH);
        this.birthdateMonth = birthdate.get(Calendar.MONTH) + 1;
        this.birthdateYear = birthdate.get(Calendar.YEAR);
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
}
