package sdk.jassinaturas.clients;

import java.util.List;

import sdk.jassinaturas.clients.attributes.Customer;
import sdk.jassinaturas.communicators.CustomerCommunicator;

public class CustomerClient {

    private CustomerCommunicator customerCommunicator;

    public CustomerClient() {
    }

    public CustomerClient(final CustomerCommunicator customerCommunicator) {
        this.customerCommunicator = customerCommunicator;
    }

    public Customer create(final Customer toBeCreated) {

        if (shouldCreateVault(toBeCreated)) {
            Customer customer = customerCommunicator.createWithCreditCard(toBeCreated);
            return customer;
        } else {
            Customer customer = customerCommunicator.createWithoutCreditCard(toBeCreated);
            return customer;
        }

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

    public Customer update(final Customer toBeUpdated) {
        Customer customer = customerCommunicator.update(toBeUpdated.getCode(), toBeUpdated);
        return customer;
    }

    public Customer updateVault(final Customer toBeUpdated) {
        Customer customer = customerCommunicator.updateCreditCard(toBeUpdated.getCode(), toBeUpdated.getBillingInfo());
        return customer;
    }

}
