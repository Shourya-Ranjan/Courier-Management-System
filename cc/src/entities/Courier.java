package entities;

public class Courier {
	
	public static  long SysTrackingNumber=(long) (Math.random() * 900000) + 100000;
    private int courierID;
    private String senderName;
    private String senderAddress;
    private String receiverName;
    private String receiverAddress;
    private double weight;
    private String status;
    private long trackingNumber;
    private String deliveryDate;
    private int userId;
    private int empid;
    

    // Default Constructor
    public Courier() {
    	SysTrackingNumber++;
    }

    // Parameterized Constructor
    

    // Getters and Setters
    public int getCourierID() {
        return courierID;
    }

    public Courier(int courierID, String senderName, String senderAddress, String receiverName, String receiverAddress,
			double weight, String status, long trackingNumber, String deliveryDate, int userId, int empid) {
		super();
		this.courierID = courierID;
		this.senderName = senderName;
		this.senderAddress = senderAddress;
		this.receiverName = receiverName;
		this.receiverAddress = receiverAddress;
		this.weight = weight;
		this.status = status;
		this.trackingNumber = trackingNumber;
		this.deliveryDate = deliveryDate;
		this.userId = userId;
		this.empid = empid;
	}

	public void setCourierID(int courierID) {
        this.courierID = courierID;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(long trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getEmpId() {
        return userId;
    }

    public void setEmpId(int userId) {
        this.userId = userId;
    }

    // toString method
    @Override
    public String toString() {
        return "Courier{" +
                "courierID=" + courierID +
                ", senderName='" + senderName + '\'' +
                ", senderAddress='" + senderAddress + '\'' +
                ", receiverName='" + receiverName + '\'' +
                ", receiverAddress='" + receiverAddress + '\'' +
                ", weight=" + weight +
                ", status='" + status + '\'' +
                ", trackingNumber='" + trackingNumber + '\'' +
                ", deliveryDate=" + deliveryDate +
                ", userId=" + userId +
                ", empid="+empid+
                '}';
        
    }
    
}
