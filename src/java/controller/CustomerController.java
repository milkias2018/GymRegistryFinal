/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.GymManager;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import model.Customer;
import org.primefaces.event.CellEditEvent;

import org.primefaces.event.RowEditEvent;

/**
 *
 * @author User
 */
@Named(value = "customerController")
@RequestScoped
public class CustomerController {

    /**
     * Creates a new instance of CustomerController
     */
    @Inject
    GymManager gm;

    private String personalNumber;
    private String firstName;
    private String lastName;
    private String membershiptype;
    private String branch;
    private String address;
    private int phoneNumber;
    private String email;
    private List<Customer> allCustomers;
    private String IdSearch;
    private Customer cs;

    public GymManager getGm() {
        return gm;
    }

    public void setGm(GymManager gm) {
        this.gm = gm;
    }

    public String getEmail() {
        return email;
    }

    @PostConstruct
    public void fillArray() {
        this.allCustomers = gm.getAllCustomers();

    }

    public void removeArray() {
        this.allCustomers = gm.getAllCustomers();
    }

    public Customer fetch() {

        this.cs = gm.fetchCustomer(IdSearch);
        return cs;

    }

    public void findCustomer() {
        Customer c = gm.fetchCustomer(IdSearch);

        String newPN = c.getPersonalNumber();
        setPersonalNumber(newPN);

        String newFN = c.getFirstName();
        setFirstName(newFN);

        String newLN = c.getLastName();
        setLastName(newLN);

        String newMT = c.getMembershiptype();
        setMembershiptype(newMT);

        String newBranch = c.getBranch();
        setBranch(newBranch);

        String newAddress = c.getAddress();
        setAddress(newAddress);

        int newPhoneNumber = c.getPhoneNumber();
        setPhoneNumber(newPhoneNumber);

        String newEmail = c.getEmail();
        setEmail(newEmail);
        this.cs = c;

    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void reset() {
        this.personalNumber = null;
        this.firstName = null;
        this.lastName = null;
        this.membershiptype = null;
        this.branch = null;
        this.address = null;
        this.phoneNumber = 0;
        this.email = null;
    }

    public List<Customer> getAllCustomers() {
        return allCustomers;
    }
//    public Customer getCustomer(){
//        return cust;
//    }

    public void setAllCustomers(List<Customer> allCustomers) {
        this.allCustomers = allCustomers;
    }

//    public Customer getCust() {
//        return cust;
//    }
//
//    public void setCust(Customer cust) {
//        this.cust = cust;
//    }
    public void setEmail(String email) {
        this.email = email;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMembershiptype() {
        return membershiptype;
    }

    public void setMembershiptype(String membershiptype) {
        this.membershiptype = membershiptype;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getIdSearch() {
        return IdSearch;
    }

    public void setIdSearch(String IdSearch) {
        this.IdSearch = IdSearch;
    }

    public Customer getCs() {
        return cs;
    }

    public void setCs(Customer cs) {
        this.cs = cs;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void submit() {
        Customer customer = new Customer(personalNumber, firstName, lastName, membershiptype, branch, address, phoneNumber, email);
        gm.addCustomer(customer);
        allCustomers = gm.getAllCustomers();

    }

    public void update() {

        gm.updatePN(IdSearch, personalNumber);
        gm.updateFN(IdSearch, firstName);
        gm.updateLN(IdSearch, lastName);
        gm.updateMT(IdSearch, membershiptype);
        gm.updateBranch(IdSearch, branch);
        gm.updateAddress(IdSearch, address);
        gm.updatePhoneNumber(IdSearch, phoneNumber);
        gm.updateEmail(IdSearch, email);

    }

//       public Customer findByPersonalNumber(){
//        Customer c = gm.findPersonalNumber(personalNumber);
//           return c;
//       }
    public void remove() {

        gm.removeCustomer(IdSearch);
    }

    public CustomerController() {
    }

    public Customer searchId() {

        Customer m = gm.searchById(IdSearch);
        return m;

    }

    public void onCellEdit(CellEditEvent event) {

        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if (newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
//public void update(){
//    gm.nameUpdate(cs);
//}

}
