package sdk.jassinaturas.clients;

import java.util.Calendar;
import java.util.List;

import sdk.jassinaturas.clients.attributes.Address;
import sdk.jassinaturas.clients.attributes.Alerts;
import sdk.jassinaturas.clients.attributes.BillingInfo;
import sdk.jassinaturas.clients.attributes.Errors;
import sdk.jassinaturas.communicators.CustomerCommunicator;
import sdk.jassinaturas.exceptions.ApiResponseErrorException;
import sdk.jassinaturas.serializers.GsonDeserializer;

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
    private List<Errors> errors;
    private String fullname;
    private String message;
    private String phoneAreaCode;

    private String phoneNumber;

    public Customer() {
    }

    public Customer(final CustomerCommunicator customerCommunicator) {
        this.customerCommunicator = customerCommunicator;
    }

    public Customer create(final Customer toBeCreated) {
        try {
            Customer customer = null;
            if (shouldCreateVault(toBeCreated)) {
                customer = customerCommunicator.createWithCreditCard(toBeCreated);
            } else {
                customer = customerCommunicator.createWithoutCreditCard(toBeCreated);
            }
            return customer;
        } catch (ApiResponseErrorException e) {
            GsonDeserializer gson = new GsonDeserializer();
            return gson.deserialize(e.getMessage(), Customer.class);
        }
    }

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

    public CustomerCommunicator getCustomerCommunicator() {
        return customerCommunicator;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public String getEmail() {
        return email;
    }

    public List<Errors> getErrors() {
        return errors;
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

    public boolean hasErrors() {
        return errors != null && errors.size() > 0;
    }

    public List<Customer> list() {
        Customer customers = customerCommunicator.list();
        return customers.getCustomers();
    }

    public boolean shouldCreateVault(final Customer toBeCreated) {
        if (toBeCreated.getBillingInfo() == null) {
            return false;
        }

        return true;
    }

    public Customer show(final Customer customer) {
        Customer updatedCustomer = customerCommunicator.show(customer.getCode());
        return updatedCustomer;
    }

    public Customer show(final String code) {
        Customer plan = customerCommunicator.show(code);
        return plan;
    }

    @Override
    public String toString() {
        return "Customer [address=" + address + ", alerts=" + alerts + ", billingInfo=" + billingInfo
                + ", birthdateDay=" + birthdateDay + ", birthdateMonth=" + birthdateMonth + ", birthdateYear="
                + birthdateYear + ", code=" + code + ", cpf=" + cpf + ", customerCommunicator=" + customerCommunicator
                + ", customers=" + customers + ", email=" + email + ", errors=" + errors + ", fullname=" + fullname
                + ", message=" + message + ", phoneAreaCode=" + phoneAreaCode + ", phoneNumber=" + phoneNumber + "]";
    }

    public Customer update(final Customer toBeUpdated) {
        Customer customer = customerCommunicator.update(toBeUpdated.getCode(), toBeUpdated);
        return customer;
    }

    public Customer updateVault(final Customer toBeUpdated) {
        Customer customer = customerCommunicator.updateCreditCard(toBeUpdated.getCode(), toBeUpdated.getBillingInfo());
        return customer;
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
