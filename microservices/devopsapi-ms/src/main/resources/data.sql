DROP TABLE IF EXISTS jiratickets;

CREATE  TABLE jiratickets (

     id INT AUTO_INCREMENT PRIMARY KEY,
     ticket_number VARCHAR(240) NOT NULL,
     description VARCHAR(240) NOT NULL
);


INSERT INTO jiratickets (ticket_number, description) VALUES
    ('J1111', 'Complex Jira'),
    ('J222', ' Super Complex Jira'),
    ('J222', ' Super Complex Simple Jira');