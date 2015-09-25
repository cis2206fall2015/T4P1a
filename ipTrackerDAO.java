package ipTracker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Your Name Here
 */
public class ipTrackerDAO {

    private final String fileName;
    protected final List<ipTracker> myList;

    public ipTrackerDAO() {
        this("ipdata.txt");
    }

    public ipTrackerDAO(String fileName) {
        this.fileName = fileName;
        this.myList = new ArrayList<>();
        try {
            Files.createFile(Paths.get(fileName));
        } catch (FileAlreadyExistsException fae) {
            
        } catch (IOException ioe) {
            System.out.println("Create file error with " + ioe.getMessage());
        }
        readList();
    }

    public void createRecord(ipTracker ip) {
        myList.add(ip);
        writeList();
    }

    public ipTracker retrieveRecord(int id) {
        for (ipTracker ipTracker : myList) {
            if (ipTracker.getEmpId() == id) {
                return ipTracker;
            }
        }
        return null;
    }

    public void updateRecord(ipTracker updatedIpTracker) {
        for (ipTracker ipTracker : myList) {
            if (ipTracker.getEmpId() == updatedIpTracker.getEmpId()) {
                ipTracker.setIpAddress(updatedIpTracker.getIpAddress());
                ipTracker.setDateEntered(updatedIpTracker.getDateEntered());
                break;
            }
        }
        writeList();
    }

    public void deleteRecord(int id) {
        for (ipTracker ipTracker : myList) {
            if (ipTracker.getEmpId() == id) {
                myList.remove(ipTracker);
                break;
            }
        }
        writeList();
    }

    public void deleteRecord(ipTracker ipTracker) {
        myList.remove(ipTracker);
        writeList();
    }

    protected void readList() {
        Path path = Paths.get(fileName);
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String address = data[1];
                String date = data[2];
                int retrieved = Integer.parseInt(data[3]);
                ipTracker ipTracker = new ipTracker(id, address, date, retrieved++);
                myList.add(ipTracker);
            }
        } catch (IOException ioe) {
            System.out.println("Read file error with " + ioe.getMessage());
        }
    }

    protected void writeList() {
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            for (ipTracker ipTracker : myList) {
                writer.write(String.format("%d,%s,%s,%d\n",
                        ipTracker.getEmpId(),
                        ipTracker.getIpAddress(),
                        ipTracker.getDateEntered(),
                        ipTracker.getTimesRetrieved()));
            }
        } catch (IOException ioe) {
            System.out.println("Write file error with " + ioe.getMessage());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        myList.stream().forEach((ipTracker) -> {
            sb.append(String.format("%5d : %s, %s,d\n", ipTracker.getEmpId(),
                    ipTracker.getIpAddress(), ipTracker.getDateEntered(), ipTracker.getTimesRetrieved()
                    ));
        });

        return sb.toString();
    }
}

