package com.company;

import java.util.ArrayList;

public class MobilePhone {

    private ArrayList<Contact>myContact;
    private String myNumber;

    public MobilePhone(ArrayList<Contact> myContact, String myNumber) {
        this.myContact = myContact;
        this.myNumber = myNumber;
    }
    private int findContact(Contact contact){
         return myContact.indexOf(contact);
    }
    private int findContact(String contactName){
        for (int i = 0;i< myContact.size();i++){
             Contact contact = myContact.get(i);
             if (contact.getName().equals(contactName)){
                 return i;
             }
        }
        return -1;
    }
    public boolean addContact(Contact contact){
        if (findContact(contact.getName())>=0){
            System.out.println("Contact is already on file ");
            return false;
        }
        myContact.add(contact);
        return true;
    }
    public boolean upDateContact(Contact oldContact,Contact newContact){
         int foundPosition = findContact(oldContact);

         if (foundPosition < 0){
             System.out.println(oldContact.getName() + " is not on the list");
             return false;
         }else if (findContact(newContact.getName()) != -1){
             System.out.println("Contact with name " + newContact.getName() + " already exists ");
             return false;
         }
         this.myContact.set(foundPosition,newContact);
        System.out.println(oldContact.getName() + " was replaced with " + newContact.getName());
        return true;
    }
    public boolean removeContact(Contact contact){
        int foundPosition = findContact(contact);

        if (foundPosition < 0){
            System.out.println(contact.getName() + " is not on the list");
            return false;
        }
        this.myContact.remove(foundPosition);
        System.out.println(contact.getName() + " has been removed");
        return true;
    }
    public Contact queryContact(String name){
        int position = findContact(name);
        if (position >= 0){
            return this.myContact.get(position);
        }
        return null;
    }
    public void printContacts(){      // for printing out the contacts
        System.out.println("Contact List");
        for (int i = 0; i <this.myContact.size(); i++){
            System.out.println((i + 1) + ". " + this.myContact.get(i).getName() +
                    " -> " + this.myContact.get(i).getPhoneNumber());
        }
    }

}
