import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MemoAppGUI extends JFrame implements ActionListener {

    private static final String TASKS_FILE = "tasks.csv";
    private static final String QUICK_ACCESS_FILE = "quick_access.csv";
    private static final String TIME_LOGS_FILE = "time_logs.csv";

    // GUI Components
    private JFrame frame;
    private JTabbedPane tabbedPane;

    // Task Addition Panel
    private JPanel taskPanel;
    private JLabel taskRefLabel, taskDescLabel;
    private JTextField taskRefField, taskDescField;
    private JButton addTaskButton;

    // Time Logging Panel
    private JPanel timePanel;
    private JLabel selectTaskLabel, timeSpentLabel;
    private JComboBox<String> taskChoice;
    private JTextField timeSpentField;
    private JButton logTimeButton;

    // Display Panels
    private JPanel tasksDisplayPanel, logsDisplayPanel;
    private JTextArea tasksTextArea, logsTextArea;
    private JScrollPane jScrollPane1, jScrollPane2;

    // Data Handling
    private List<Task> quickAccessTasks = new ArrayList<>();

    public static void main(String[] args) {
        MemoAppGUI gui = new MemoAppGUI();
        gui.setVisible(true);
    }

    public MemoAppGUI() {
        super("Memo Time Tracker");
        setLayout(new BorderLayout());
        setSize(600, 400);

        // Initialize Components
        frame = this;
        tabbedPane = new JTabbedPane();

        // Task Addition Tab
        taskPanel = createTaskPanel();
        tabbedPane.addTab("Add Task", taskPanel);

        // Time Logging Tab
        timePanel = createTimeLoggingPanel();
        tabbedPane.addTab("Log Time", timePanel);

        // Quick Access Tasks Display
        tasksDisplayPanel = new JPanel();
        tasksDisplayPanel.setLayout(new BorderLayout());
        tasksTextArea = new JTextArea(10, 30);
        jScrollPane1 = new JScrollPane(tasksTextArea);
        tasksDisplayPanel.add(jScrollPane1, BorderLayout.CENTER);
        tabbedPane.addTab("Quick Access", tasksDisplayPanel);

        // Time Logs Display
        logsDisplayPanel = new JPanel();
        logsDisplayPanel.setLayout(new BorderLayout());
        logsTextArea = new JTextArea(10, 30);
        jScrollPane2 = new JScrollPane(logsTextArea);
        logsDisplayPanel.add(jScrollPane2, BorderLayout.CENTER);
        tabbedPane.addTab("Time Logs", logsDisplayPanel);

        add(tabbedPane, BorderLayout.CENTER);

        // Initialize Data
        loadQuickAccessTasks();

        // Add WindowListener for cleanup
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    private JPanel createTaskPanel() {
        taskPanel = new JPanel();
        taskPanel.setLayout(new GridLayout(4, 2));

        // Labels and Fields
        taskRefLabel = new JLabel("Task Reference:");
        taskDescLabel = new JLabel("Description:");
        taskRefField = new JTextField(15);
        taskDescField = new JTextField(30);

        addTaskButton = new JButton("Add Task");
        addTaskButton.addActionListener(this);

        // Add Components
        taskPanel.add(taskRefLabel);
        taskPanel.add(taskRefField);
        taskPanel.add(taskDescLabel);
        taskPanel.add(taskDescField);
        taskPanel.add(addTaskButton);
        taskPanel.add(new JLabel()); // Empty for spacing

        return taskPanel;
    }

    private JPanel createTimeLoggingPanel() {
        timePanel = new JPanel();
        timePanel.setLayout(new GridLayout(4, 2));

        // Labels and Fields
        selectTaskLabel = new JLabel("Select Task:");
        timeSpentLabel = new JLabel("Time Spent (e.g., 1h30m):");
        taskChoice = new JComboBox<>();
        loadTasksIntoChoice();
        timeSpentField = new JTextField(15);

        logTimeButton = new JButton("Log Time");
        logTimeButton.addActionListener(this);

        // Add Components
        timePanel.add(selectTaskLabel);
        timePanel.add(taskChoice);
        timePanel.add(timeSpentLabel);
        timePanel.add(timeSpentField);
        timePanel.add(logTimeButton);
        timePanel.add(new JLabel()); // Empty for spacing

        return timePanel;
    }

    private void loadQuickAccessTasks() {
        try (BufferedReader br = new BufferedReader(new FileReader(QUICK_ACCESS_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    quickAccessTasks.add(new Task(parts[0], parts[1]));
                }
            }
        } catch (IOException e) {
            // Ignore if file doesn't exist
        }
    }

    private void loadTasksIntoChoice() {
        taskChoice.removeAllItems();
        for (Task task : quickAccessTasks) {
            taskChoice.addItem(task.getReference());
        }
        taskChoice.insertItemAt("new", 0);
    }

    private void updateDisplay(boolean showTasks, boolean showLogs) {
        if (showTasks) {
            tasksTextArea.setText(getTasksDisplayText());
        }
        if (showLogs) {
            logsTextArea.setText(getLogsDisplayText());
        }
    }

    private String getTasksDisplayText() {
        StringBuilder sb = new StringBuilder("Quick Access Tasks:\n");
        for (Task task : quickAccessTasks) {
            sb.append("- ").append(task.getReference()).append(": ").append(task.getDescription()).append("\n");
        }
        return sb.toString();
    }

    private String getLogsDisplayText() {
        List<TimeLog> logs = loadTimeLogs(LocalDate.now());
        StringBuilder sb = new StringBuilder("Today's Time Logs:\n");
        for (TimeLog log : logs) {
            Task task = findTask(log.getTaskReference());
            if (task != null) {
                sb.append("- ").append(task.getDescription()).append(": ").append(TimeUtils.formatDuration(log.getDuration())).append("\n");
            } else {
                sb.append("- Orphaned entry: Reference '").append(log.getTaskReference()).append("' not found\n");
            }
        }
        return sb.toString();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addTaskButton) {
            String reference = taskRefField.getText().trim();
            String description = taskDescField.getText().trim();

            if (!isReferenceDuplicate(reference)) {
                Task newTask = new Task(reference, description);
                saveQuickAccessTask(newTask);
                quickAccessTasks.add(newTask);

                loadTasksIntoChoice();
                updateDisplay(true, false);
                clearFields(taskRefField, taskDescField);
            } else {
                showMessageBox("Error", "A task with this reference already exists.");
            }
        } else if (e.getSource() == logTimeButton) {
            String selectedTaskRef = taskChoice.getSelectedItem().toString();
            Task selectedTask = findTask(selectedTaskRef);

            if (selectedTaskRef.equals("new")) {
                String newReference = JOptionPane.showInputDialog(frame, "Enter new task reference:");
                String newDescription = JOptionPane.showInputDialog(frame, "Enter new task description:");
                
                if (!isReferenceDuplicate(newReference)) {
                    Task newTask = new Task(newReference, newDescription);
                    saveQuickAccessTask(newTask);
                    quickAccessTasks.add(newTask);

                    loadTasksIntoChoice();
                    updateDisplay(true, false);
                } else {
                    showMessageBox("Error", "A task with this reference already exists.");
                    return;
                }
            }

            if (selectedTask == null) {
                showMessageBox("Error", "Please select a valid task or create a new one.");
                return;
            }

            String timeStr = timeSpentField.getText().trim();
            int duration = TimeUtils.parseTime(timeStr);

            if (duration <= 0) {
                showMessageBox("Error", "Invalid time format. Use 'XhYm' (e.g., 1h30m).");
                return;
            }

            TimeLog newLog = new TimeLog(LocalDate.now(), selectedTask.getReference(), duration);
            saveTimeLog(newLog);

            updateDisplay(false, true);
            clearFields(timeSpentField);
        }
    }

    private void showMessageBox(String title, String message) {
        JOptionPane.showMessageDialog(frame, message, title, JOptionPane.ERROR_MESSAGE);
    }

    private void clearFields(JTextField... fields) {
        for (JTextField field : fields) {
            field.setText("");
        }
    }

    private boolean isReferenceDuplicate(String reference) {
        for (Task task : quickAccessTasks) {
            if (task.getReference().equals(reference)) {
                return true;
            }
        }
        return false;
    }

    private void saveQuickAccessTask(Task task) {
        try (FileWriter fw = new FileWriter(QUICK_ACCESS_FILE, true)) {
            fw.write(task.getReference() + "," + task.getDescription() + "\n");
        } catch (IOException e) {
            showMessageBox("Error", "Failed to save task: " + e.getMessage());
        }
    }

    private List<TimeLog> loadTimeLogs(LocalDate date) {
        List<TimeLog> logs = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(TIME_LOGS_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    LocalDate logDate = LocalDate.parse(parts[0]);
                    if (logDate.equals(date)) {
                        int duration = Integer.parseInt(parts[2]);
                        logs.add(new TimeLog(logDate, parts[1], duration));
                    }
                }
            }
        } catch (IOException e) {
            // Ignore if file doesn't exist
        }
        return logs;
    }

    private void saveTimeLog(TimeLog log) {
        try (FileWriter fw = new FileWriter(TIME_LOGS_FILE, true)) {
            fw.write(log.getDate() + "," +
                    log.getTaskReference() + "," +
                    log.getDuration() + "\n");
        } catch (IOException e) {
            showMessageBox("Error", "Failed to save time log: " + e.getMessage());
        }
    }

    private Task findTask(String reference) {
        for (Task task : quickAccessTasks) {
            if (task.getReference().equals(reference)) {
                return task;
            }
        }
        return null;
    }

    // Inner classes
    static class Task {
        String reference;
        String description;

        public Task(String reference, String description) {
            this.reference = reference;
            this.description = description;
        }

        public String getReference() { return reference; }
        public String getDescription() { return description; }
    }

    static class TimeLog {
        LocalDate date;
        String taskReference;
        int duration;

        public TimeLog(LocalDate date, String taskReference, int duration) {
            this.date = date;
            this.taskReference = taskReference;
            this.duration = duration;
        }

        public LocalDate getDate() { return date; }
        public String getTaskReference() { return taskReference; }
        public int getDuration() { return duration; }
    }

    static class TimeUtils {
        public static int parseTime(String timeStr) {
            try {
                String[] parts = timeStr.split("h");
                int hours = Integer.parseInt(parts[0]);
                if (parts.length > 1) {
                    String minutesPart = parts[1].replace("m", "");
                    int minutes = minutesPart.isEmpty() ? 0 : Integer.parseInt(minutesPart);
                    return hours * 60 + minutes;
                } else {
                    return hours * 60;
                }
            } catch (NumberFormatException e) {
                return -1;
            }
        }

        public static String formatDuration(int minutes) {
            int hours = minutes / 60;
            int remainingMinutes = minutes % 60;
            if (hours > 0 && remainingMinutes > 0) {
                return hours + "h" + remainingMinutes + "m";
            } else if (hours > 0) {
                return hours + "h";
            } else {
                return remainingMinutes + "m";
            }
        }
    }

}
