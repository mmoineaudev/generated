
Here's a **comprehensive guide** for creating Splunk queries and dashboards tailored to your use case (network monitoring for a smart gateway). I'll break it down into **Splunk Querying** and **Dashboard Creation**, with examples and best practices.

---

## **I. Splunk Querying: Best Practices & Examples**

### **1. Counting Data**
**Purpose**: Count the number of events, unique users, or specific log types.

#### **SQL-Like Equivalent**:
```sql
SELECT COUNT(*) FROM logs;
```

#### **Splunk Query (SPL)**:
```spl
| stats count() as total_events
```

#### **Example: Count Unique Users**
```spl
| stats count(distinct user_id) as unique_users
```

#### **Example: Count by Status Code**
```spl
| stats count by status_code
```

#### **Pitfalls**:
- Use `count()` for total events, `count(distinct)` for unique values.
- Avoid using `stats` on large datasets without filtering (e.g., `where status_code = 200`).

---

### **2. Measuring TPS (Transactions Per Second)**
**Purpose**: Track the rate of network transactions (e.g., API calls, data transfers).

#### **SQL-Like Equivalent**:
```sql
SELECT COUNT(*) / 60 AS tps FROM logs WHERE timestamp BETWEEN 'start' AND 'end';
```

#### **Splunk Query (SPL)**:
```spl
| timechart span=1m useother=false sum(transaction_count) as tps
```

#### **Example: TPS for HTTP Requests**
```spl
| search sourcetype="http_logs" 
| timechart span=1m useother=false sum(transaction_count) as tps
```

#### **Pitfalls**:
- Use `timechart` for time-based aggregation.
- Ensure your data includes a `timestamp` field and a `transaction_count` field (or derive it from `transaction_id`).

---

### **3. Grouping by Field Value**
**Purpose**: Categorize data by fields like API name, IP address, or error type.

#### **SQL-Like Equivalent**:
```sql
SELECT api_name, COUNT(*) AS count FROM logs GROUP BY api_name;
```

#### **Splunk Query (SPL)**:
```spl
| stats count by api_name
```

#### **Example: Group by IP Address**
```spl
| stats count by source_ip
```

#### **Example: Group by Error Type**
```spl
| search error_type IN ("timeout", "404", "500")
| stats count by error_type
```

#### **Pitfalls**:
- Use `by` to group, not `where` (for filtering).
- Filter first if you need to group a subset of data.

---

### **4. Common Splunk Requests**
#### **A. Filtering Data**
```spl
| search sourcetype="network_logs" AND status_code="404"
```

#### **B. Joining Data (Similar to SQL JOINs)**
```spl
| join type=left source_ip [ search sourcetype="ip_blacklist" ]
```

#### **C. Calculating Ratios**
```spl
| stats count as total, count(eval(status_code="200")) as success, count(eval(status_code!="200")) as failure
| eval success_rate = round(success / total * 100, 2)
```

#### **D. Time Range Analysis**
```spl
| search _time >= relative_time("5m@m") AND _time <= relative_time("now")
```

#### **E. Redacting Sensitive Fields**
```spl
| eval email=if(match(email, ".*@.*"), "*****@*****", email)
```

---

## **II. Splunk Dashboard Creation: Best Practices & Examples**

### **1. Dashboard Structure**
- **Panels**: Individual visualizations (charts, tables, maps).
- **Layout**: Use a **grid layout** for multiple panels.
- **Time Range**: Set default time range (e.g., last 24h).

### **2. Common Panel Types**
| Panel Type | Use Case | Example |
|------------|----------|---------|
| **Timechart** | TPS, error rates | TPS over time |
| **Bar Chart** | Grouped metrics | API call counts |
| **Table** | Raw data | Log details |
| **Map** | Geolocation of IPs | Source IP locations |
| **Pie Chart** | Distribution of errors | Error type percentages |

---

### **3. Example Dashboard: Network Activity Monitoring**
#### **Panel 1: TPS Over Time**
```spl
| search sourcetype="network_logs"
| timechart span=1m useother=false sum(transaction_count) as tps
```

#### **Panel 2: API Call Distribution**
```spl
| search sourcetype="network_logs"
| stats count by api_name
```

#### **Panel 3: Error Type Breakdown**
```spl
| search sourcetype="network_logs" AND status_code!="200"
| stats count by status_code
| eval error_type = if(status_code="404", "Not Found", "Other")
| stats count by error_type
```

#### **Panel 4: Geolocation Map**
```spl
| search sourcetype="network_logs"
| geoip source_ip
| stats count by src_geoip
| geostats lat_long=src_geoip count as count
```

---

### **4. Dashboard Configuration**
#### **Time Range**:
- Set default to **last 24h** or **last week**.
- Use `relative_time("5m@m")` for dynamic ranges.

#### **Permissions**:
- Restrict access to sensitive data (e.g., IP addresses) using **role-based access control**.

#### **Exporting Dashboards**:
- Use the **"Export as PDF"** or **"Export to CSV"** feature for compliance reporting.

---

## **III. Best Practices for Splunk & Compliance (EU)**
1. **Data Redaction**:
   - Use the **Splunk Data Masking App** to mask PII (e.g., emails, IPs).
   - Example: Replace `email` with `*****@*****`.

2. **Compliance**:
   - Ensure all logs are anonymized or redacted before exporting (GDPR, DPO requirements).
   - Store data in **Splunk Cloud** (if allowed) to avoid local data storage.

3. **Performance**:
   - Use `fields` to limit data returned (e.g., `fields + _time, api_name`).
   - Avoid `stats` on large datasets without filtering.

4. **Security**:
   - Use **Splunk SOAR** for automated incident response.
   - Enable **field-level encryption** for sensitive data.

---

## **IV. Summary Table**
| Task | Splunk Query | Dashboard Panel |
|------|--------------|------------------|
| Count events | `| stats count()` | Timechart |
| TPS | `| timechart span=1m sum(transaction_count)` | Timechart |
| Group by field | `| stats count by field` | Bar Chart |
| Redact data | `| eval field=if(match(field, ".*@.*"), "*****@*****", field)` | Table |
| Error distribution | `| stats count by error_type` | Pie Chart |

---

## **V. Final Tips**
1. **Test Queries**: Use `| head 10` to preview results before running full searches.
2. **Use Splunk's UI**: For quick analysis, leverage the **Search & Reporting** interface.
3. **Leverage Splunk's Power**: Combine `stats`, `timechart`, and `eval` for complex analysis.
4. **Document Everything**: Track query logic and dashboard configurations for compliance.

Let me know if you need help with **specific queries** or **dashboard templates**! 🚀
