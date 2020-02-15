package com.filereader.service.filereader.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class TripDataDTO implements Serializable {
	private static final long serialVersionUID = -3752315103550511761L;
    private int VendorID;
    private String tpep_pickup_datetime;
    private String tpep_dropoff_datetime;
    private int passenger_count;
    private double trip_distance;
    private int RatecodeID;
    private String store_and_fwd_flag;
    private int PULocationID;
    private int DOLocationID;
    private int payment_type;    
    private double fare_amount;
    private double extra;
    private double mta_tax;
    private double tip_amount;
    private double tolls_amount;
    private double improvement_surcharge;
    private double total_amount;
	public int getVendorID() {
		return VendorID;
	}
	public void setVendorID(int vendorID) {
		VendorID = vendorID;
	}
	public String getTpep_pickup_datetime() {
		return tpep_pickup_datetime;
	}
	public void setTpep_pickup_datetime(String tpep_pickup_datetime) {
		this.tpep_pickup_datetime = tpep_pickup_datetime;
	}
	public String getTpep_dropoff_datetime() {
		return tpep_dropoff_datetime;
	}
	public void setTpep_dropoff_datetime(String tpep_dropoff_datetime) {
		this.tpep_dropoff_datetime = tpep_dropoff_datetime;
	}
	public int getPassenger_count() {
		return passenger_count;
	}
	public void setPassenger_count(int passenger_count) {
		this.passenger_count = passenger_count;
	}
	public double getTrip_distance() {
		return trip_distance;
	}
	public void setTrip_distance(double trip_distance) {
		this.trip_distance = trip_distance;
	}
	public int getRatecodeID() {
		return RatecodeID;
	}
	public void setRatecodeID(int ratecodeID) {
		RatecodeID = ratecodeID;
	}
	public String getStore_and_fwd_flag() {
		return store_and_fwd_flag;
	}
	public void setStore_and_fwd_flag(String store_and_fwd_flag) {
		this.store_and_fwd_flag = store_and_fwd_flag;
	}
	public int getPULocationID() {
		return PULocationID;
	}
	public void setPULocationID(int pULocationID) {
		PULocationID = pULocationID;
	}
	public int getDOLocationID() {
		return DOLocationID;
	}
	public void setDOLocationID(int dOLocationID) {
		DOLocationID = dOLocationID;
	}
	public int getPayment_type() {
		return payment_type;
	}
	public void setPayment_type(int payment_type) {
		this.payment_type = payment_type;
	}
	public double getFare_amount() {
		return fare_amount;
	}
	public void setFare_amount(double fare_amount) {
		this.fare_amount = fare_amount;
	}
	public double getExtra() {
		return extra;
	}
	public void setExtra(double extra) {
		this.extra = extra;
	}
	public double getMta_tax() {
		return mta_tax;
	}
	public void setMta_tax(double mta_tax) {
		this.mta_tax = mta_tax;
	}
	public double getTip_amount() {
		return tip_amount;
	}
	public void setTip_amount(double tip_amount) {
		this.tip_amount = tip_amount;
	}
	public double getTolls_amount() {
		return tolls_amount;
	}
	public void setTolls_amount(double tolls_amount) {
		this.tolls_amount = tolls_amount;
	}
	public double getImprovement_surcharge() {
		return improvement_surcharge;
	}
	public void setImprovement_surcharge(double improvement_surcharge) {
		this.improvement_surcharge = improvement_surcharge;
	}
	public double getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TripDataDTO [VendorID=").append(VendorID).append(", tpep_pickup_datetime=")
				.append(tpep_pickup_datetime).append(", tpep_dropoff_datetime=").append(tpep_dropoff_datetime)
				.append(", passenger_count=").append(passenger_count).append(", trip_distance=").append(trip_distance)
				.append(", RatecodeID=").append(RatecodeID).append(", store_and_fwd_flag=").append(store_and_fwd_flag)
				.append(", PULocationID=").append(PULocationID).append(", DOLocationID=").append(DOLocationID)
				.append(", payment_type=").append(payment_type).append(", fare_amount=").append(fare_amount)
				.append(", extra=").append(extra).append(", mta_tax=").append(mta_tax).append(", tip_amount=")
				.append(tip_amount).append(", tolls_amount=").append(tolls_amount).append(", improvement_surcharge=")
				.append(improvement_surcharge).append(", total_amount=").append(total_amount).append("]");
		return builder.toString();
	}
    
}