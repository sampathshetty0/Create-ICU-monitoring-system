import java.util.ArrayList;
import java.util.Scanner;

class Patient {
    private String patientName;
    private int patientId;
    private int heartRate;
    private int systolicBP;
    private int diastolicBP;
    private int oxygenLevel;

    public Patient(String patientName, int patientId, int heartRate,
                   int systolicBP, int diastolicBP, int oxygenLevel) {
        this.patientName = patientName;
        this.patientId = patientId;
        this.heartRate = heartRate;
        this.systolicBP = systolicBP;
        this.diastolicBP = diastolicBP;
        this.oxygenLevel = oxygenLevel;
    }

    public void displayDetails() {
        System.out.println("\nPatient ID: " + patientId);
        System.out.println("Patient Name: " + patientName);
        System.out.println("Heart Rate: " + heartRate + " bpm");
        System.out.println("Blood Pressure: " + systolicBP + "/" + diastolicBP);
        System.out.println("Oxygen Level: " + oxygenLevel + "%");
    }

    public void checkAlerts() {
        System.out.println("\n--- Alert Status ---");

        if (heartRate < 60 || heartRate > 100)
            System.out.println("Alert: Abnormal Heart Rate!");

        if (systolicBP < 90 || systolicBP > 140 ||
            diastolicBP < 60 || diastolicBP > 90)
            System.out.println("Alert: Abnormal Blood Pressure!");

        if (oxygenLevel < 95)
            System.out.println("Alert: Low Oxygen Level!");
    }
}

public class ICUMonitoringSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Patient> patientList = new ArrayList<>();

        System.out.print("Enter number of patients: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Patient " + (i + 1));

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter ID: ");
            int id = sc.nextInt();

            System.out.print("Enter Heart Rate: ");
            int hr = sc.nextInt();

            System.out.print("Enter Systolic BP: ");
            int sbp = sc.nextInt();

            System.out.print("Enter Diastolic BP: ");
            int dbp = sc.nextInt();

            System.out.print("Enter Oxygen Level: ");
            int oxygen = sc.nextInt();
            sc.nextLine();

            Patient patient = new Patient(name, id, hr, sbp, dbp, oxygen);
            patientList.add(patient);
        }

        for (Patient p : patientList) {
            p.displayDetails();
            p.checkAlerts();
        }

        sc.close();
    }
}