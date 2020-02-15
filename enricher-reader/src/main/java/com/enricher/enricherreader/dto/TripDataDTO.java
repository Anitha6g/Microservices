package com.enricher.enricherreader.dto;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Entity;



//import com.opencsv.bean.CsvBindByName;
@Entity
public class TripDataDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3752315103550511761L;
	@Id
	@GeneratedValue
    private int vedorId;
    private String tpepPickupDatetime;
    private String tpepDropoffDatetime;
    private int passengerCount;
    private double tripDistance;
    private int ratecodeID;
    private String storeFwdFlag;
    private int puLocationID;
    private int doLocationID;
    private int paymentType; 
    private double fareAmount;
    private double extra;
    private double mtaTax;
    private double tipAmount;
    private double tollsAmount;
    private double improvementSurcharge;
    private double totalAmount;
	
    private int LocationID;
    private String Borough;
    private String Zone;
    private String service_zone;
    
	public int getVedorId() {
		return vedorId;
	}
	public void setVedorId(int vedorId) {
		this.vedorId = vedorId;
	}
	public String getTpepPickupDatetime() {
		return tpepPickupDatetime;
	}
	public void setTpepPickupDatetime(String tpepPickupDatetime) {
		this.tpepPickupDatetime = tpepPickupDatetime;
	}
	public String getTpepDropoffDatetime() {
		return tpepDropoffDatetime;
	}
	public void setTpepDropoffDatetime(String tpepDropoffDatetime) {
		this.tpepDropoffDatetime = tpepDropoffDatetime;
	}
	public int getPassengerCount() {
		return passengerCount;
	}
	public void setPassengerCount(int passengerCount) {
		this.passengerCount = passengerCount;
	}
	public double getTripDistance() {
		return tripDistance;
	}
	public void setTripDistance(double tripDistance) {
		this.tripDistance = tripDistance;
	}
	public int getRatecodeID() {
		return ratecodeID;
	}
	public void setRatecodeID(int ratecodeID) {
		this.ratecodeID = ratecodeID;
	}
	public String getStoreFwdFlag() {
		return storeFwdFlag;
	}
	public void setStoreFwdFlag(String storeFwdFlag) {
		this.storeFwdFlag = storeFwdFlag;
	}
	public int getPuLocationID() {
		return puLocationID;
	}
	public void setPuLocationID(int puLocationID) {
		this.puLocationID = puLocationID;
	}
	public int getDoLocationID() {
		return doLocationID;
	}
	public void setDoLocationID(int doLocationID) {
		this.doLocationID = doLocationID;
	}
	public int getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(int paymentType) {
		this.paymentType = paymentType;
	}
	public double getFareAmount() {
		return fareAmount;
	}
	public void setFareAmount(double fareAmount) {
		this.fareAmount = fareAmount;
	}
	public double getExtra() {
		return extra;
	}
	public void setExtra(double extra) {
		this.extra = extra;
	}
	public double getMtaTax() {
		return mtaTax;
	}
	public void setMtaTax(double mtaTax) {
		this.mtaTax = mtaTax;
	}
	public double getTipAmount() {
		return tipAmount;
	}
	public void setTipAmount(double tipAmount) {
		this.tipAmount = tipAmount;
	}
	public double getTollsAmount() {
		return tollsAmount;
	}
	public void setTollsAmount(double tollsAmount) {
		this.tollsAmount = tollsAmount;
	}
	public double getImprovementSurcharge() {
		return improvementSurcharge;
	}
	public void setImprovementSurcharge(double improvementSurcharge) {
		this.improvementSurcharge = improvementSurcharge;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TripDataDTO [vedorId=").append(vedorId).append(", tpepPickupDatetime=")
				.append(tpepPickupDatetime).append(", tpepDropoffDatetime=").append(tpepDropoffDatetime)
				.append(", passengerCount=").append(passengerCount).append(", tripDistance=").append(tripDistance)
				.append(", ratecodeID=").append(ratecodeID).append(", storeFwdFlag=").append(storeFwdFlag)
				.append(", puLocationID=").append(puLocationID).append(", doLocationID=").append(doLocationID)
				.append(", paymentType=").append(paymentType).append(", fareAmount=").append(fareAmount)
				.append(", extra=").append(extra).append(", mtaTax=").append(mtaTax).append(", tipAmount=")
				.append(tipAmount).append(", tollsAmount=").append(tollsAmount).append(", improvementSurcharge=")
				.append(improvementSurcharge).append(", totalAmount=").append(totalAmount).append("]");
		return builder.toString();
	}
	public int getLocationID() {
		return LocationID;
	}
	public void setLocationID(int locationID) {
		LocationID = locationID;
	}
	public String getBorough() {
		return Borough;
	}
	public void setBorough(String borough) {
		Borough = borough;
	}
	public String getZone() {
		return Zone;
	}
	public void setZone(String zone) {
		Zone = zone;
	}
	public String getService_zone() {
		return service_zone;
	}
	public void setService_zone(String service_zone) {
		this.service_zone = service_zone;
	}
    
}