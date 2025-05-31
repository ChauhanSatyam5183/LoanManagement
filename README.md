Requirements
A basic loan management dashboard that supports:
Creating customers
Applying for loans
Fetching and updating loan statuses

###Tech Stack Used
Backend: Java, Spring Boot (REST APIs)
Frontend: HTML, CSS, JavaScript
Database: H2 / PostgreSql (configurable)

Tools: Live Server (for frontend testing), Postman (for API testing) ,Vscode ,IntellijIdea

Thought Process
1. Entity Relationship: Customer and Loans
Each Customer can have multiple Loans (One-to-Many relationship).
This was implemented using JPA/Hibernate annotations:

@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
private List<Loan> loans;
The Loan entity has a reference back to the Customer:

@ManyToOne
@JoinColumn(name = "customer_id")
private Customer customer;

2. Validation: Check if Customer Already Exists
When creating a new customer, we check the database for existing records based on email or phone number.
If a customer already exists, a suitable message is returned to avoid duplicate records.

3. API Design
/api/customers – Create new customers

/api/loans/apply – Apply for a loan for an existing customer

/api/loans – Fetch all loans

/api/loans/{id}/{status} – Update loan status (e.g., APPROVED, REJECTED)

4. Use @JsonIgnore Annotation to correctly fetch data of loans

   
 Possible Improvements
Add email notifications for loan status updates.
Implement loan eligibility checks based on income, credit score, etc.
Add authentication and role-based access (admin vs user).
Add unit & integration tests for all endpoints.

 Challenges Faced
CORS configuration: Ensuring the frontend (running on a different port) could communicate with the backend securely.

Backend validation: Managing error handling and feedback with pure java.

Entity design: Carefully designing relationships to prevent cascading issues and ensure proper foreign key mappings.

Duplicate customer check: Implementing a reliable way to prevent duplicate entries while maintaining flexibility for customer edits.
