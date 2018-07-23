/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Customer;

/**
 *
 * @author User
 */
@Stateless
public class GymManager {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext
    EntityManager gm;

    public void addCustomer(Customer customer) {
        gm.persist(customer);
    }

    public List<Customer> getAllCustomers() {
        Query q = gm.createQuery("SELECT c FROM Customer c");
        return q.getResultList();
    }

    public Customer fetchCustomer(String id) {

        Customer customer = gm.find(Customer.class, id);
        return customer;
    }
    public void updatePN(String id, String personalNumber){
        Customer c=gm.find(Customer.class, id);
        c.setPersonalNumber(personalNumber);
        gm.persist(c);
            }
    public void updateFN(String id, String firstName){
        Customer c=gm.find(Customer.class, id);
        c.setFirstName(firstName);
        gm.persist(c);
            }
    public void updateLN(String id, String lastName){
        Customer c=gm.find(Customer.class, id);
        c.setLastName(lastName);
        gm.persist(c);
            }
    public void updateMT(String id, String membershiptype){
        Customer c=gm.find(Customer.class, id);
        c.setMembershiptype(membershiptype);
        gm.persist(c);
            }
    public void updateBranch(String id, String branch){
        Customer c=gm.find(Customer.class, id);
        c.setBranch(branch);
        gm.persist(c);
            }
    public void updateAddress(String id, String address){
        Customer c=gm.find(Customer.class, id);
        c.setAddress(address);
        gm.persist(c);
            }
    public void updatePhoneNumber(String id, int phoneNumber){
        Customer c=gm.find(Customer.class, id);
        c.setPhoneNumber(phoneNumber);
        gm.persist(c);
            }
    public void updateEmail(String id, String email){
        Customer c=gm.find(Customer.class, id);
        c.setEmail(email);
        gm.persist(c);
            }
//   public Customer findPersonalNumber(Long personalNumber){
//       Query q=gm.createQuery("SELECT c FROM Customer c WHERE c.PERSONALNUMBER=:personalNumber");
//       return (Customer) q.getSingleResult();
//       
//   }
//     public void searchCustomer(Customer cust){
//      gm.createQuery("SELECT c FROM Customer c WHERE c.personalNumber = cust.personalNumber");
//   }

    public void removeCustomer(String id) {
     Customer cust = gm.find(Customer.class, id);
       gm.remove(cust);
    }

    public Customer searchById(String id) {
        Customer customer = gm.find(Customer.class, id);

        return customer;
    }
//    public void nameUpdate(String personalNumber,String firstName){
//        Customer c1=gm.find(Customer.class), personalNumber);
//        c1.setFirstName(firstName);
//    }

}
