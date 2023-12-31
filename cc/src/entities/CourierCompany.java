package entities;

import java.util.List;

public class CourierCompany {
    private String companyName;
    private List<Courier> courierDetails;
    private List<Employee> employeeDetails;
    private List<Location> locationDetails;

    // Default Constructor
    public CourierCompany() {
    }

    // Parameterized Constructor
    public CourierCompany(String companyName, List<Courier> courierDetails, List<Employee> employeeDetails,
                          List<Location> locationDetails) {
        this.companyName = companyName;
        this.courierDetails = courierDetails;
        this.employeeDetails = employeeDetails;
        this.locationDetails = locationDetails;
    }

    // Getters and Setters
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<Courier> getCourierDetails() {
        return courierDetails;
    }

    public void setCourierDetails(List<Courier> courierDetails) {
        this.courierDetails = courierDetails;
    }

    public List<Employee> getEmployeeDetails() {
        return employeeDetails;
    }

    public void setEmployeeDetails(List<Employee> employeeDetails) {
        this.employeeDetails = employeeDetails;
    }

    public List<Location> getLocationDetails() {
        return locationDetails;
    }

    public void setLocationDetails(List<Location> locationDetails) {
        this.locationDetails = locationDetails;
    }

    // toString method
    @Override
    public String toString() {
        return "CourierCompany{" +
                "companyName='" + companyName + '\'' +
                ", courierDetails=" + courierDetails +
                ", employeeDetails=" + employeeDetails +
                ", locationDetails=" + locationDetails +
                '}';
    }
}
