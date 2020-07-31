package com.ustb.shellchain.object;

/**
 * Created by lenovo on 2018/8/5.
 */
public class TransactionSubject extends TransactionRawDetail {
    String account;
    String name;
    String phone;
    String sex;
    String idCard;
    String birthDate;
    String currentAddress;
    String emergencyContact;
    String emergencyContactNumber;
    String emergencyContactAddress;
    String email;
    String note;
    String AccessID;
    String SeniorID;
    String Public_Key;
    String ECC_Secret_Key;
    String PassCodeHash;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getEmergencyContactNumber() {
        return emergencyContactNumber;
    }

    public void setEmergencyContactNumber(String emergencyContactNumber) {
        this.emergencyContactNumber = emergencyContactNumber;
    }

    public String getEmergencyContactAddress() {
        return emergencyContactAddress;
    }

    public void setEmergencyContactAddress(String emergencyContactAddress) {
        this.emergencyContactAddress = emergencyContactAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getAccessID() {
        return AccessID;
    }

    public void setAccessID(String accessID) {
        AccessID = accessID;
    }

    public String getSeniorID() {
        return SeniorID;
    }

    public void setSeniorID(String seniorID) {
        SeniorID = seniorID;
    }

    public String getPublic_Key() {
        return Public_Key;
    }

    public void setPublic_Key(String public_Key) {
        Public_Key = public_Key;
    }

    public String getECC_Secret_Key() {
        return ECC_Secret_Key;
    }

    public void setECC_Secret_Key(String ECC_Secret_Key) {
        this.ECC_Secret_Key = ECC_Secret_Key;
    }

    public String getPassCodeHash() {
        return PassCodeHash;
    }

    public void setPassCodeHash(String passCodeHash) {
        PassCodeHash = passCodeHash;
    }
}
