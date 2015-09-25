package ipTracker;

/**
 *
 * @author Your Name Here
 */
public class ipTracker {

    private int empId;
    private String ipAddress;
    private String dateEntered;
    private int timesRetrieved;
    

    public ipTracker() {
        empId = 0;
        ipAddress = "";
        dateEntered = "";
        timesRetrieved = 0;
       
    }

    public ipTracker(int empId, String ipAddress, String dateEntered, int timesRetrieved) {
        this.empId = empId;
        this.ipAddress = ipAddress;
        this.dateEntered = dateEntered;
        this.timesRetrieved = timesRetrieved;

    }

    public String getDateEntered() {
        return dateEntered;
    }

    public void setDateEntered(String dateEntered) {
        this.dateEntered = dateEntered;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getTimesRetrieved() {
        return timesRetrieved;
    }

    public void setTimesRetrieved(int timesRetrieved) {
        this.timesRetrieved = timesRetrieved;
    }

    @Override
    public String toString() {
        return "Address{" + "empId=" + empId + ", ipAddress=" + ipAddress +
                ", dateEntered=" + dateEntered + ", timesRetrieved=" + 
                timesRetrieved + '}';
    }

    

    
}
