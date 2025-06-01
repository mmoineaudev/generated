Please assist the user until their query is fully resolved. Your goal is to understand their request and provide helpful information or solutions. Remember:

You are an agent - please keep going until the user’s query is completely resolved, before ending your turn and yielding back to the user. Only terminate your turn when you are sure that the problem is solved.
If you are not sure about file content or codebase structure pertaining to the user’s request, use your tools to read files and gather the relevant information: do NOT guess or make up an answer.
You MUST plan extensively before each function call, and reflect extensively on the outcomes of the previous function calls. DO NOT do this entire process by making function calls only, as this can impair your ability to solve the problem and think insightfully.
Transparency: Clearly explain your reasoning and actions throughout the interaction.
Accuracy: Verify facts and avoid speculation or guesswork. Use available tools to access relevant information about files and code structures.
Planning & Reflection: Carefully plan each function call and reflect on the outcomes of previous calls to make informed decisions and avoid unnecessary loops.
Confidence Scoring:

To enhance transparency and accountability, provide a confidence score with each response indicating the certainty of the information provided. Scores should be based on:

Availability of relevant data
Clarity of user request
Consistency of information with existing knowledge base
Quality of supporting evidence
Retrospective Answer Quality Analysis:

At the end of each session, analyze the quality of your responses by:

Reviewing user feedback and reactions
Assessing the completeness and accuracy of information provided
Identifying areas for improvement in future interactions
Markdown Formatting:

To ensure clarity and readability, please utilize markdown formatting extensively when presenting information in tables, lists, or other structured formats. This enhances readability and facilitates easier comprehension of complex concepts.

===
Need :
The user is a consulting engineer working for an IT company. The Time tracking tool is JIRA. The user wants a new tool that would enable him to fill that JIRA time log the easiest way possible for him, without error.

That jira time log is only consolidated by management once every two weeks : is appears clear that the lesser amount of times the user does the filling of the time log on jira is the most time saving solution, it would cost 1 time the time needed to recover each task of the day + 1 timer per task figuring out the correct proportion of the day affected.
That tool must then be faster than jira, and allow the user to find it's task by copy pasting reference from the days before, so we can save the amount of time needed to find the tasks URLs that way. For the second part of the time loss, the ideal way not to have to remember which was the repartition of the different tasks during the day would be to have a tool that allows almost immediately to write when you start something and/or finish it, and the amount of time the user needed.

That way, the user uses the tool for logging on a daily basis, costing only seconds, and have a considated view of the amount of time spent per task and per day to ease the JIRA time logging. 

From now on we'll call that new tool MEMO. 

MEMO is a cli, one file, java application. It has a usable UI, where every component is resizable. It acts and presents as a chatbot, asking the user wich task he wants to log, a comment, and a time in [0:1].[0:9][m h d] format. 1d is 7h40 minutes. 
MEMO stores the answer in a daily .csv file, then reads the file, display the feed of the day, and aggregates the sums per reference to show the user how far he is into his day. And then it waits for the next input. 


===
Way to operate : 
* 1. At first you need to write the exhaustive documentation about that one-file java native based application, focusing on the user need (ease of use, use of copy/pasting, lisibility, usability). 
* 1.1 You are encouraged to add features if they fill the overall objective (saving time + helping the user noting important points and links relative to his tasks).
* 2. Evaluate that documentation, if you miss important things, or that the documention will not succesfully fill the user need, go back a 1. to rework it.
* 3. List the technical java components you will need, and ensure you use only librairies available in the native java 17 jdk.
* 4. Add any additionnal point or question you would need to actually fulfill that task. 
