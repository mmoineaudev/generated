# Please assist the user until their query is fully resolved. Your goal is to understand their request and provide helpful information or solutions. Remember:

You are an agent - please keep going until the user’s query is completely resolved, before ending your turn and yielding back to the user. Only terminate your turn when you are sure that the problem is solved.
If you are not sure about file content or codebase structure pertaining to the user’s request, use your tools to read files and gather the relevant information: do NOT guess or make up an answer.
You MUST plan extensively before each function call, and reflect extensively on the outcomes of the previous function calls. DO NOT do this entire process by making function calls only, as this can impair your ability to solve the problem and think insightfully.
Transparency: Clearly explain your reasoning and actions throughout the interaction.
Accuracy: Verify facts and avoid speculation or guesswork. Use available tools to access relevant information about files and code structures.
Planning & Reflection: Carefully plan each function call and reflect on the outcomes of previous calls to make informed decisions and avoid unnecessary loops.

## Confidence Scoring:

To enhance transparency and accountability, provide a confidence score with each response indicating the certainty of the information provided. Scores should be based on:

Availability of relevant data
Clarity of user request
Consistency of information with existing knowledge base
Quality of supporting evidence

## Retrospective Answer Quality Analysis:

At the end of each session, analyze the quality of your responses by:

Reviewing user feedback and reactions
Assessing the completeness and accuracy of information provided
Identifying areas for improvement in future interactions

## Markdown Formatting:

To ensure clarity and readability, please utilize markdown formatting extensively when presenting information in tables, lists, or other structured formats. This enhances readability and facilitates easier comprehension of complex concepts.


# Need :

The user is a consulting engineer working for an IT company. The Time tracking tool is JIRA. The user wants a new tool that would enable him to fill that JIRA time log the easiest way possible for him, without error.

That jira time log is only consolidated by management once every two weeks : is appears clear that the lesser amount of times the user does the filling of the time log on jira is the most time saving solution, it would cost 1 time the time needed to recover each task of the day + 1 timer per task figuring out the correct proportion of the day affected.
That tool must then be faster than jira, and allow the user to find it's task by copy pasting reference from the days before, so we can save the amount of time needed to find the tasks URLs that way. For the second part of the time loss, the ideal way not to have to remember which was the repartition of the different tasks during the day would be to have a tool that allows almost immediately to write when you start something and/or finish it, and the amount of time the user needed.

That way, the user uses the tool for logging on a daily basis, costing only seconds, and have a considated view of the amount of time spent per task and per day to ease the JIRA time logging. 

From now on we'll call that new tool MEMO. 

MEMO is a cli, one file, java application. It has a usable UI, where every component is resizable. It acts and presents as a chatbot, asking the user wich task he wants to log, a comment, and a time in [0:1].[0:9][m h d] format. 1d is 7h40 minutes. 
MEMO stores the answer in a daily .csv file, then reads the file, display the feed of the day, and aggregates the sums per reference to show the user how far he is into his day. And then it waits for the next input. 


# Way to operate : 

* 1. At first you need to write the exhaustive documentation about that one-file java native based application, focusing on the user need (ease of use, use of copy/pasting, lisibility, usability). 
* 1.1 You are encouraged to add features if they fill the overall objective (saving time + helping the user noting important points and links relative to his tasks).
* 2. Evaluate that documentation, if you miss important things, or that the documention will not succesfully fill the user need, go back a 1. to rework it.
* 3. List the technical java components you will need, and ensure you use only librairies available in the native java 17 jdk.
* 4. Add any additionnal point or question you would need to actually fulfill that task. 



=================>


Certainly not 100% functionnal, untested, 4x30min :

```
import java.awt.*;
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

public class MemoAppGUI extends Frame implements ActionListener {

    private static final String TASKS_FILE = "tasks.csv";
    private static final String QUICK_ACCESS_FILE = "quick_access.csv";
    private static final String TIME_LOGS_FILE = "time_logs.csv";

    // GUI Components
    Panel mainPanel;
    TabbedPane tabbedPane;

    // Task Addition Components
    Label taskRefLabel, taskDescLabel;
    TextField taskRefField, taskDescField;
    Button addTaskButton;

    // Time Logging Components
    Label selectTaskLabel, timeSpentLabel;
    Choice taskChoice;
    TextField timeSpentField;
    Button logTimeButton;

    // Display Components
    Panel tasksDisplayPanel, logsDisplayPanel;
    TextArea tasksTextArea, logsTextArea;

    // Data Handling
    List<Task> quickAccessTasks = new ArrayList<>();

    public static void main(String[] args) {
        MemoAppGUI gui = new MemoAppGUI();
        gui.setVisible(true);
    }

    public MemoAppGUI() {
        super("Memo Time Tracker");
        setLayout(new BorderLayout());
        setSize(640, 480);

        // Initialize Components
        mainPanel = new Panel();
        tabbedPane = new TabbedPane();

        // Task Addition Tab
        addTaskTab();

        // Time Logging Tab
        addTimeLoggingTab();

        // Quick Access Tasks Display
        addTasksDisplay();

        // Time Logs Display
        addLogsDisplay();

        mainPanel.add(tabbedPane);
        add(mainPanel, BorderLayout.CENTER);

        // Initialize Data
        loadQuickAccessTasks();

        // Add WindowListener for cleanup
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    private void addTaskTab() {
        Panel taskPanel = new Panel();
        taskPanel.setLayout(new GridLayout(4, 2, 5, 5));

        // Labels and Fields
        taskRefLabel = new Label("Task Reference:");
        taskDescLabel = new Label("Description:");
        taskRefField = new TextField(20);
        taskDescField = new TextField(20);

        // Add Task Button
        addTaskButton = new Button("Add Task");
        addTaskButton.addActionListener(this);

        // Layout Components with proper spacing
        taskPanel.add(taskRefLabel);
        taskPanel.add(taskRefField);
        taskPanel.add(taskDescLabel);
        taskPanel.add(taskDescField);
        taskPanel.add(new Label("")); // Empty for spacing
        taskPanel.add(addTaskButton);

        tabbedPane.addTab("Add Task", taskPanel);
    }

    private void addTimeLoggingTab() {
        Panel timePanel = new Panel();
        timePanel.setLayout(new GridLayout(5, 2, 5, 5));

        // Labels and Fields
        selectTaskLabel = new Label("Select Task:");
        timeSpentLabel = new Label("Time Spent (e.g., 1h30m):");
        taskChoice = new Choice();
        loadTasksIntoChoice();

        timeSpentField = new TextField(15);

        // Log Time Button
        logTimeButton = new Button("Log Time");
        logTimeButton.addActionListener(this);

        // Layout Components with proper spacing
        timePanel.add(selectTaskLabel);
        timePanel.add(taskChoice);
        timePanel.add(timeSpentLabel);
        timePanel.add(timeSpentField);
        timePanel.add(new Label("")); // Empty for spacing
        timePanel.add(logTimeButton);

        tabbedPane.addTab("Log Time", timePanel);
    }

    private void addTasksDisplay() {
        tasksDisplayPanel = new Panel();
        tasksDisplayPanel.setLayout(new BorderLayout());

        tasksTextArea = new TextArea(10, 30);
        tasksTextArea.setEditable(false);
        tasksTextArea.setFont(new Font("Arial", Font.PLAIN, 12));
        tasksTextArea.setDoubleBuffered(true);
        updateTasksDisplay();

        Scrollbar verticalScrollbar = new Scrollbar(Scrollbar.VERTICAL,
                ScrollbarConstants.DEFAULT_SIZE,
                ScrollbarConstants.DEFAULT_SIZE,
                0, 100);

        verticalScrollbar.setUnitIncrement(5);
        verticalScrollbar.addAdjustmentListener(new AdjustmentAdapter() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                tasksTextArea.setVScrollbar(e.getSource());
            }
        });

        tasksDisplayPanel.add(tasksTextArea, BorderLayout.CENTER);
        tasksDisplayPanel.add(verticalScrollbar, BorderLayout.EAST);

        tabbedPane.addTab("Quick Access Tasks", tasksDisplayPanel);
    }

    private void addLogsDisplay() {
        logsDisplayPanel = new Panel();
        logsDisplayPanel.setLayout(new BorderLayout());

        logsTextArea = new TextArea(10, 30);
        logsTextArea.setEditable(false);
        logsTextArea.setFont(new Font("Arial", Font.PLAIN, 12));
        logsTextArea.setDoubleBuffered(true);
        updateLogsDisplay();

        Scrollbar verticalScrollbar = new Scrollbar(Scrollbar.VERTICAL,
                ScrollbarConstants.DEFAULT_SIZE,
                ScrollbarConstants.DEFAULT_SIZE,
                0, 100);

        verticalScrollbar.setUnitIncrement(5);
        verticalScrollbar.addAdjustmentListener(new AdjustmentAdapter() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                logsTextArea.setVScrollbar(e.getSource());
            }
        });

        logsDisplayPanel.add(logsTextArea, BorderLayout.CENTER);
        logsDisplayPanel.add(verticalScrollbar, BorderLayout.EAST);

        tabbedPane.addTab("Time Logs", logsDisplayPanel);
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
        taskChoice.removeAll();
        for (Task task : quickAccessTasks) {
            taskChoice.add(task.getReference());
        }
    }

    private void updateTasksDisplay() {
        tasksTextArea.setText("Quick Access Tasks:\n");
        for (Task task : quickAccessTasks) {
            tasksTextArea.append("- " + task.getReference() + ": " + task.getDescription() + "\n");
        }
        tasksDisplayPanel.revalidate();
    }

    private void updateLogsDisplay() {
        List<TimeLog> logs = loadTimeLogs(LocalDate.now());
        logsTextArea.setText("Today's Time Logs:\n");
        for (TimeLog log : logs) {
            Task task = findTask(log.getTaskReference());
            if (task != null) {
                logsTextArea.append("- " + task.getDescription() + ": " +
                        TimeUtils.formatDuration(log.getDuration()) + "\n");
            } else {
                logsTextArea.append("- Orphaned entry: Reference '" + log.getTaskReference() +
                        "' not found\n");
            }
        }
        logsDisplayPanel.revalidate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addTaskButton) {
            String reference = taskRefField.getText().trim();
            String description = taskDescField.getText().trim();

            if (!reference.isEmpty() && !isReferenceDuplicate(reference)) {
                Task newTask = new Task(reference, description);
                saveQuickAccessTask(newTask);
                quickAccessTasks.add(newTask);

                // Update GUI
                loadTasksIntoChoice();
                updateTasksDisplay();
                clearFields(taskRefField, taskDescField);
            } else if (reference.isEmpty()) {
                showMessageBox("Error", "Task reference cannot be empty.");
            } else {
                showMessageBox("Error", "A task with this reference already exists.");
            }
        } else if (e.getSource() == logTimeButton) {
            String selectedTaskRef = taskChoice.getSelectedItem();
            Task selectedTask = findTask(selectedTaskRef);

            if (selectedTaskRef.equals("new")) {
                String newReference = taskChoice.getItem(taskChoice.size() - 1);
                String description = taskDescField.getText().trim();

                if (!isReferenceDuplicate(newReference) && !description.isEmpty()) {
                    Task newTask = new Task(newReference, description);
                    saveQuickAccessTask(newTask);
                    quickAccessTasks.add(newTask);

                    // Update GUI
                    loadTasksIntoChoice();
                    updateTasksDisplay();
                } else if (description.isEmpty()) {
                    showMessageBox("Error", "Task description cannot be empty.");
                } else {
                    showMessageBox("Error", "A task with this reference already exists.");
                    return;
                }
            }

            String timeStr = timeSpentField.getText().trim();
            int duration = TimeUtils.parseTime(timeStr);

            if (duration <= 0) {
                showMessageBox("Error", "Invalid time format. Use 'XhYm' (e.g., 1h30m).");
                return;
            }

            Task taskToLog = selectedTaskRef.equals("new") ? createNewTask(selectedTaskRef) : selectedTask;

            TimeLog newLog = new TimeLog(LocalDate.now(), taskToLog.getReference(), duration);
            saveTimeLog(newLog);

            // Update GUI
            updateLogsDisplay();
            clearFields(timeSpentField);
        }
    }

    private void showMessageBox(String title, String message) {
        Frame owner = this;
        Dialog d = new Dialog(owner, title, true);
        Label msgLabel = new Label(message);
        Button okButton = new Button("OK");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { d.dispose(); }
        });
        
        d.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 20));
        d.add(msgLabel);
        d.add(okButton);
        d.pack();
        d.setVisible(true);
    }

    private void clearFields(TextField... fields) {
        for (TextField field : fields) {
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

    private Task createNewTask(String reference) {
        String description = taskDescField.getText().trim();
        return new Task(reference, description);
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
```
