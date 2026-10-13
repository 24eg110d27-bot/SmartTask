package com.smarttask.task;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;
@Entity @Table(name="tasks")
public class Task {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotBlank @Column(nullable=false) private String title;
 @Column(length=2000) private String description;
 @Column(nullable=false) private String priority="MEDIUM";
 private LocalDate dueDate;
 @Column(nullable=false) private boolean completed=false;
 public Long getId(){return id;} public void setId(Long id){this.id=id;}
 public String getTitle(){return title;} public void setTitle(String title){this.title=title;}
 public String getDescription(){return description;} public void setDescription(String description){this.description=description;}
 public String getPriority(){return priority;} public void setPriority(String priority){this.priority=priority;}
 public LocalDate getDueDate(){return dueDate;} public void setDueDate(LocalDate dueDate){this.dueDate=dueDate;}
 public boolean isCompleted(){return completed;} public void setCompleted(boolean completed){this.completed=completed;}
}